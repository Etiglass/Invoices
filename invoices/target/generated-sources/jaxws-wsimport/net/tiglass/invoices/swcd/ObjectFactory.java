
package net.tiglass.invoices.swcd;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.tiglass.invoices.swcd package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.tiglass.invoices.swcd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetTimbre }
     * 
     */
    public GetTimbre createGetTimbre() {
        return new GetTimbre();
    }

    /**
     * Create an instance of {@link GetTimbreCFDI }
     * 
     */
    public GetTimbreCFDI createGetTimbreCFDI() {
        return new GetTimbreCFDI();
    }

    /**
     * Create an instance of {@link GetTimbresZIP }
     * 
     */
    public GetTimbresZIP createGetTimbresZIP() {
        return new GetTimbresZIP();
    }

    /**
     * Create an instance of {@link GetTimbresZIPResponse }
     * 
     */
    public GetTimbresZIPResponse createGetTimbresZIPResponse() {
        return new GetTimbresZIPResponse();
    }

    /**
     * Create an instance of {@link GetTimbreCFDIResponse }
     * 
     */
    public GetTimbreCFDIResponse createGetTimbreCFDIResponse() {
        return new GetTimbreCFDIResponse();
    }

    /**
     * Create an instance of {@link GetTimbreResponse }
     * 
     */
    public GetTimbreResponse createGetTimbreResponse() {
        return new GetTimbreResponse();
    }

}
