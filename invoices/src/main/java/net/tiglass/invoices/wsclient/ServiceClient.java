package net.tiglass.invoices.wsclient;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceException;
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

    public String generarCFDICD(String user, String pass, String xml, String targetEndpoint, String storePath) throws IOException {
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
}
