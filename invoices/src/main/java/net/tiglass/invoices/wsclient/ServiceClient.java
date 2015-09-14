package net.tiglass.invoices.wsclient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceException;
import mx.bigdata.sat.cfdi.CFDI;
import mx.bigdata.sat.cfdi.CFDIFactory;
import mx.bigdata.sat.cfdi.CFDv32;
import mx.bigdata.sat.cfdi.TFDv1;
import mx.bigdata.sat.cfdi.TFDv1c32;
import mx.bigdata.sat.cfdi.v32.schema.Comprobante;
import mx.bigdata.sat.cfdi.v32.schema.Comprobante.Complemento;
import mx.bigdata.sat.common.ComprobanteBase;
import mx.bigdata.sat.security.KeyLoaderEnumeration;
import mx.bigdata.sat.security.factory.KeyLoaderFactory;
import net.tiglass.invoices.data.Invoice;
import net.tiglass.invoices.webservices.client.*;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.commons.httpclient.protocol.Protocol;

public class ServiceClient {

    public String generarCFDI(String xml) {
        String result = "";

        try {
            SocketFactory fabrica = new SocketFactory();//esta la debemos tener ya lista
            fabrica.createSocket("pruebas2.interfactura.com", 443);
            Protocol proto = new Protocol("https", fabrica, 443);

            TsunamiServiceStub cliente = new TsunamiServiceStub("https://pruebas2.interfactura.com/Tsunami/TsunamiService.asmx");
//            Options options = cliente._getServiceClient().getOptions();
//            options.setProperty(org.apache.axis2.transport.http.HTTPConstants.HTTP_PROTOCOL_VERSION, org.apache.axis2.transport.http.HTTPConstants.HEADER_PROTOCOL_V10);
            TsunamiServiceStub.GenerarCFDI request = new TsunamiServiceStub.GenerarCFDI();
            request.setBatchCFDI(xml);

            //El protocolo tiene el nombre, la fabrica de sockets, y el puerto default a donde deben conectarse
            cliente._getServiceClient().getOptions().setProperty(HTTPConstants.CUSTOM_PROTOCOL_HANDLER, proto);

            //TestSocketFactory tsf = new TestSocketFactory();
            //tsf.abrirConexionHttps();
            TsunamiServiceStub.GenerarCFDIResponse response = null;
            response = cliente.generarCFDI(request);
            //tsf.cerrarConexionHttps();
            result = response.getGenerarCFDIResult();
        } catch (Exception e) {

        }

        return result;
    }

    public String generarCFDIi(String xml) {
        String resulti = "";

        try {
            TestSocketFactory tsf = new TestSocketFactory();
            tsf.abrirConexionHttps();
        } catch (Exception e) {
        }

        return resulti;
    }

    public String generarCFDICD(String user, String pass, String xml, String targetEndpoint, String storePath, int invoiceId, String certPacPath) throws IOException {
        String result = "";

        try { // Call Web Service Operation
            String wsdl = targetEndpoint + "?WSDL";
            URL wsdlUrl = new URL(wsdl);
            net.tiglass.invoices.swcd.TimbrarV3 service = new net.tiglass.invoices.swcd.TimbrarV3(wsdlUrl);
            net.tiglass.invoices.swcd.TimbrarV3Soap port = service.getTimbrarV3Soap12();
            // TODO initialize WS operation arguments here
            java.lang.String usuario = user;
            java.lang.String pwd = pass;
            byte[] cfdiXmlIn = xml.getBytes();
            javax.xml.ws.Holder<Integer> codigo = new javax.xml.ws.Holder<Integer>();
            javax.xml.ws.Holder<java.lang.String> mensaje = new javax.xml.ws.Holder<java.lang.String>();
            javax.xml.ws.Holder<byte[]> xmlTimbrado = new javax.xml.ws.Holder<byte[]>();
            port.getTimbreCFDI(usuario, pwd, cfdiXmlIn, codigo, mensaje, xmlTimbrado);
            //String strXmlTimbrado = new String(xmlTimbrado.value, StandardCharsets.UTF_8);

            //Se guarda el xml timbrado
            FileOutputStream fosTimbrado = new FileOutputStream(storePath);
            fosTimbrado.write(xmlTimbrado.value);
            fosTimbrado.close();

            //Se insertan los valores principales de la factura a la base de datos auxiliar
            FileInputStream fis = new FileInputStream(storePath);
            CFDv32 cfd = new CFDv32(fis, "net.tiglass.invoices");
            ComprobanteBase compBase = cfd.getComprobante();
            Comprobante comp = (Comprobante) cfd.getComprobante().getComprobante();
            mx.bigdata.sat.cfdi.v32.schema.TimbreFiscalDigital tfd = getTimbreFiscalDigital(compBase);
            
            // Testing
            CFDI cfdi = CFDIFactory.load(new File(storePath));
            X509Certificate certPac = KeyLoaderFactory.createInstance(
              KeyLoaderEnumeration.PUBLIC_KEY_LOADER,
              new FileInputStream(new File(certPacPath))).getKey();
            TFDv1c32 tfdi = new TFDv1c32(cfdi,certPac);
            //String cadOrigTfd = tfdi.getCadenaOriginal();
            //
            
            String uuid = tfd.getUUID();
            String cert = comp.getCertificado();
            Date date = comp.getFecha();
            String selloCfd = tfd.getSelloCFD();
            String selloSat = tfd.getSelloSAT();
            String cadOrig = tfdi.getCadenaOriginal();
            String certSat = tfd.getNoCertificadoSAT();
            Date certDate = tfd.getFechaTimbrado();
            String expPlace = comp.getLugarExpedicion();
            Invoice inv = new Invoice();
            inv.saveInvoice(invoiceId, uuid, cert, date, selloCfd, selloSat, cadOrig, certSat, certDate, expPlace);

            result = mensaje.value;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            throw new IOException(ex.getMessage());
        }

        return result;
    }

    public Object getWebServiceCD(String wsdlLocation) {
        try {
            QName qname = new QName("http://localhost/Timbrar/", "TimbrarV3");
            URL url = new URL(wsdlLocation);
            net.tiglass.invoices.swcd.TimbrarV3 service = new net.tiglass.invoices.swcd.TimbrarV3(url, qname);
            return null;
        } catch (MalformedURLException ex) {
            return ex;
        } catch (WebServiceException ws) {
            return ws;
        }
    }

    public boolean existeConexionCD(String url) {
        int i = 0;
        boolean respuesta = false;
        while (i < 3) {
            Object obj = getWebServiceCD(url);
            if (obj == null) {
                return true;
            }
            if ((obj instanceof WebServiceException)) {
                respuesta = false;
            }
            i++;
        }
        return respuesta;
    }

    private KeyStore cargarCertificadoCA() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        KeyStore ks = KeyStore.getInstance("JKS");
        char[] password = "changeit".toCharArray();
        FileInputStream fis
                = new FileInputStream("C:\\Program Files\\Java\\jdk1.8.0_45\\jre\\lib\\security\\cacerts");
        ks.load(fis, password);
        fis.close();
        return ks;
    }

    private KeyStore cargarMiCertificado()
            throws KeyStoreException, NoSuchAlgorithmException,
            CertificateException, IOException {
        KeyStore ks = KeyStore.getInstance("JKS");
        char[] password = "Interfactura1".toCharArray();
        FileInputStream fis
                = new java.io.FileInputStream("C:\\Trans\\Certificados\\PruebaIF\\VidriosMartePruebas.jks");
        // "/certificados/clientews.p12");
        ks.load(fis, password);
        fis.close();
        return ks;
    }

    private mx.bigdata.sat.cfdi.v32.schema.TimbreFiscalDigital getTimbreFiscalDigital(ComprobanteBase document) throws Exception {
        Iterator i$;
        if (document.hasComplemento()) {
            List list = document.getComplementoGetAny();
            for (i$ = list.iterator(); i$.hasNext();) {
                Object o = i$.next();
                System.out.println(o.getClass());
                if ((o instanceof mx.bigdata.sat.cfdi.v32.schema.TimbreFiscalDigital)) {
                    //System.out.println("HOLA");
                    return (mx.bigdata.sat.cfdi.v32.schema.TimbreFiscalDigital) o;
                }
            }
        }
        return null;

        /*if (document.hasComplemento()) {
         List<Object> list = document.getComplementoGetAny();
         for (Object o : list) {
         if (o instanceof TimbreFiscalDigital) {
         System.out.println("TIMBRE");
         return (TimbreFiscalDigital) o;
         }
         }
         }
         System.out.println("NO ENOCNTRE");
         return;*/
    }
}
