package net.tiglass.invoices.wsclient;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.SecureProtocolSocketFactory;

public class SocketFactory implements SecureProtocolSocketFactory {

    public SocketFactory() {
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException,
            UnknownHostException {
        // Generacion de logs
        //Logger logger = CCLogger.getLogger(this.getClass());

        SSLContext ssl = null;
        try {
            
//            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
            KeyStore miCAdeConfianza = this.cargarCertificadoCA();
            tmf.init(miCAdeConfianza);
            // Ya que tenemos el KeyStore, necesitamos crear una KeyManagerFactory con el mismo
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            KeyStore miIdentidad = this.cargarMiCertificado();
            kmf.init(miIdentidad, "pruebas".toCharArray());
            // ya que tenemos el KeyManagerFactory, debemos crear un SSLContext que es con el que vamos a crear
            // los sockets que necesita el web service para enviar y recibir datos
            ssl = SSLContext.getInstance("TLS");

            ssl.init(kmf.getKeyManagers(), null, null);
        } catch (Exception e) {
            //logger.error("Error", e);
            throw new IOException(e.getMessage());
        }
        //return ssl.getSocketFactory().createSocket(host, port);
        Socket socketConn = new Socket();
        socketConn.connect(new InetSocketAddress(host, port),10000);
        //mSocket = sc.getSocketFactory().createSocket(socketConn, hostname, port, true);
        
        return ssl.getSocketFactory().createSocket(socketConn, host, port, true); //ssl.getSocketFactory().createSocket(host, port);
    }
    
    private KeyStore cargarCertificadoCA() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        KeyStore ks = KeyStore.getInstance("JKS");
        char[] password = "changeit".toCharArray();
        FileInputStream fis = new FileInputStream("C:\\Program Files\\Java\\jdk1.8.0_45\\jre\\lib\\security\\cacerts");
        ks.load(fis, password);
        fis.close();
        return ks;
    }
    
    private KeyStore cargarMiCertificado() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        KeyStore ks = KeyStore.getInstance("PKCS12");
        char[] password = "pruebas".toCharArray();
        FileInputStream fis = new java.io.FileInputStream("C:\\Interfactura\\TestTsunamiService\\Certificados vidriosMarte\\VidriosMartePruebas.pfx");
                        // "/certificados/clientews.p12");
        ks.load(fis, password);
        fis.close();
        return ks;
    }

    @Override
    public Socket createSocket(Socket socket, String string, int i, boolean bln) throws IOException, java.net.UnknownHostException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Socket createSocket(String string, int i, InetAddress ia, int i1, HttpConnectionParams hcp) throws IOException, java.net.UnknownHostException, ConnectTimeoutException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Socket createSocket(String string, int i, InetAddress ia, int i1) throws IOException, java.net.UnknownHostException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
