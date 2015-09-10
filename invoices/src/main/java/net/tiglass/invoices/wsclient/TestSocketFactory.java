package net.tiglass.invoices.wsclient;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class TestSocketFactory {
    
    public void abrirConexionHttps() throws IOException {
        URL url = new URL("https://pruebas2.interfactura.com/Tsunami/TsunamiService.svc?wsdl");
        HttpsURLConnection conexion = (HttpsURLConnection) url.openConnection();
        //SSLSocketFactory tsl = this.crearTLSSocket();
        //conexion.setSSLSocketFactory(tsl);
        //this.imprimir_certificado(conexion);
        this.imprimir_contenido(conexion);
        conexion.disconnect();
    }

    private SSLSocketFactory crearTLSSocket() {
        SSLSocketFactory ssl = null;
        try {
            KeyStore miCAdeConfianza = this.cargarCertificadoCA();
            KeyStore miIdentidad = this.cargarMiCertificado();

            // Inicializa gestor de confianzas
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(miCAdeConfianza);

            // Inicializa gestor de identidades
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(miIdentidad, "Interfactura1".toCharArray());

            // Prepara la connexion TLS
            SSLContext ctx = SSLContext.getInstance("TLSv1");
            ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
            ssl = ctx.getSocketFactory();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ssl;
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
        KeyStore ks = KeyStore.getInstance("PKCS12");
        char[] password = "Interfactura1".toCharArray();
        FileInputStream fis
                = new java.io.FileInputStream("C:\\Trans\\Certificados\\PruebaIF\\VidriosMartePruebas.pfx");
        // "/certificados/clientews.p12");
        ks.load(fis, password);
        fis.close();
        return ks;
    }

    private void imprimir_contenido(HttpsURLConnection con) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String linea;
            // intentamos leer toda la respuesta siempre
            while ((linea = in.readLine()) != null) {
                System.out.println(linea);
            }
            in.close();
        } catch (IOException e) {
            // Si error, hay que leer la respuesta de error. 
            try {
                BufferedReader error = new BufferedReader(
                        new InputStreamReader(con.getErrorStream()));
                while (error.readLine() != null);
                error.close();
            } catch (IOException ex) {
                //Intenta si puedes algo mas
            }
        }
    }
}
