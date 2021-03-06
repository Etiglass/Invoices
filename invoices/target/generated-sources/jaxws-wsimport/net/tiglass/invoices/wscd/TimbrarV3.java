
package net.tiglass.invoices.wscd;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "TimbrarV3", targetNamespace = "http://localhost/Timbrar/", wsdlLocation = "file:/C:/GitHub/Invoices/invoices/src/main/resources/wsdl/TimbrarV3.wsdl")
public class TimbrarV3
    extends Service
{

    private final static URL TIMBRARV3_WSDL_LOCATION;
    private final static WebServiceException TIMBRARV3_EXCEPTION;
    private final static QName TIMBRARV3_QNAME = new QName("http://localhost/Timbrar/", "TimbrarV3");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/GitHub/Invoices/invoices/src/main/resources/wsdl/TimbrarV3.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TIMBRARV3_WSDL_LOCATION = url;
        TIMBRARV3_EXCEPTION = e;
    }

    public TimbrarV3() {
        super(__getWsdlLocation(), TIMBRARV3_QNAME);
    }

    public TimbrarV3(WebServiceFeature... features) {
        super(__getWsdlLocation(), TIMBRARV3_QNAME, features);
    }

    public TimbrarV3(URL wsdlLocation) {
        super(wsdlLocation, TIMBRARV3_QNAME);
    }

    public TimbrarV3(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TIMBRARV3_QNAME, features);
    }

    public TimbrarV3(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TimbrarV3(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns TimbrarV3Soap
     */
    @WebEndpoint(name = "TimbrarV3Soap")
    public TimbrarV3Soap getTimbrarV3Soap() {
        return super.getPort(new QName("http://localhost/Timbrar/", "TimbrarV3Soap"), TimbrarV3Soap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TimbrarV3Soap
     */
    @WebEndpoint(name = "TimbrarV3Soap")
    public TimbrarV3Soap getTimbrarV3Soap(WebServiceFeature... features) {
        return super.getPort(new QName("http://localhost/Timbrar/", "TimbrarV3Soap"), TimbrarV3Soap.class, features);
    }

    /**
     * 
     * @return
     *     returns TimbrarV3Soap
     */
    @WebEndpoint(name = "TimbrarV3Soap12")
    public TimbrarV3Soap getTimbrarV3Soap12() {
        return super.getPort(new QName("http://localhost/Timbrar/", "TimbrarV3Soap12"), TimbrarV3Soap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TimbrarV3Soap
     */
    @WebEndpoint(name = "TimbrarV3Soap12")
    public TimbrarV3Soap getTimbrarV3Soap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://localhost/Timbrar/", "TimbrarV3Soap12"), TimbrarV3Soap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TIMBRARV3_EXCEPTION!= null) {
            throw TIMBRARV3_EXCEPTION;
        }
        return TIMBRARV3_WSDL_LOCATION;
    }

}
