package net.tiglass.invoices.wsclient;

import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.xml.soap.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public class SOAPWSClient {

    public static void main(String args[]) {
        // Service URL ,Remove "?wsdl" from the WSDL URL.
        String https_url = "https://pruebas2.interfactura.com/Tsunami/TsunamiService.asmx";

        URL url;

        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            url = new URL(https_url);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            //Use below (2 lines) if Host name verification needs to turned off
//            MyHostnameVerifier HostVerifier = new MyHostnameVerifier();
//            con.setHostnameVerifier(HostVerifier);
            TestSocketFactory tsf = new TestSocketFactory();
//            SSLSocketFactory tsl = tsf.crearTLSSocket();
//            con.setSSLSocketFactory(tsl);
            con.connect();

            SOAPMessage response = soapConnection.call(createRequest(), url);

            // Print the  SOAP Response
            printResponse(response);

            soapConnection.close();
        } catch (Exception e) {
            System.err
                    .println("Error occurred while sending SOAP Request to Server");
            e.printStackTrace();
        }
    }

    private static SOAPMessage createRequest() throws Exception {
        // SOAP 1.1 Services
        MessageFactory messageFactory = MessageFactory.newInstance();
        // For SOAP 1.2 services
        // MessageFactory messageFactory =
        // MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);

        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        // String serverURI = "myhost";
        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();

        envelope.addNamespaceDeclaration("ns1",
                "https://pruebas2.interfactura.com/Tsunami");

        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement(
                "GenerarCFDI", "ns1");

        SOAPElement soapBodyElem1 = soapBodyElem
                .addChildElement("batchCFDI");

        soapBodyElem1.addTextNode("1");

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction",
                "http://tempuri.org/GenerarCFDI");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        System.out.println();
        return soapMessage;
    }

    /**
     * Method used to print the SOAP Response
     */
    private static void printResponse(SOAPMessage soapResponse)
            throws Exception {
        TransformerFactory transformerFactory = TransformerFactory
                .newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        Source sourceContent = soapResponse.getSOAPPart().getContent();
        System.out.print("\nResponse SOAP Message = ");
        StreamResult result = new StreamResult(System.out);
        transformer.transform(sourceContent, result);
    }

}
//  This code is used when the server certificate 's CN is different than host name or IP.

class MyHostnameVerifier implements HostnameVerifier {

    public boolean verify(String hostname, SSLSession session) {
        if (hostname.equals("pruebas2.interfactura.com")) {
            return true;
        } else {
            return false;
        }
    }
}
