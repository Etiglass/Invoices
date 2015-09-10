
package net.tiglass.invoices.JaxWSClient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ITsunamiService", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ITsunamiService {


    /**
     * 
     * @param batchCFDI
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GenerarCFDI", action = "http://tempuri.org/ITsunamiService/GenerarCFDI")
    @WebResult(name = "GenerarCFDIResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GenerarCFDI", targetNamespace = "http://tempuri.org/", className = "net.tiglass.invoices.JaxWSClient.GenerarCFDI")
    @ResponseWrapper(localName = "GenerarCFDIResponse", targetNamespace = "http://tempuri.org/", className = "net.tiglass.invoices.JaxWSClient.GenerarCFDIResponse")
    public String generarCFDI(
        @WebParam(name = "batchCFDI", targetNamespace = "http://tempuri.org/")
        String batchCFDI);

    /**
     * 
     * @param batchCFDI
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "FirmarTimbararCFDI", action = "http://tempuri.org/ITsunamiService/FirmarTimbararCFDI")
    @WebResult(name = "FirmarTimbararCFDIResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "FirmarTimbararCFDI", targetNamespace = "http://tempuri.org/", className = "net.tiglass.invoices.JaxWSClient.FirmarTimbararCFDI")
    @ResponseWrapper(localName = "FirmarTimbararCFDIResponse", targetNamespace = "http://tempuri.org/", className = "net.tiglass.invoices.JaxWSClient.FirmarTimbararCFDIResponse")
    public String firmarTimbararCFDI(
        @WebParam(name = "batchCFDI", targetNamespace = "http://tempuri.org/")
        String batchCFDI);

    /**
     * 
     * @param batchCFD22
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GenerarCFDIAPartirDeCFD22", action = "http://tempuri.org/ITsunamiService/GenerarCFDIAPartirDeCFD22")
    @WebResult(name = "GenerarCFDIAPartirDeCFD22Result", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GenerarCFDIAPartirDeCFD22", targetNamespace = "http://tempuri.org/", className = "net.tiglass.invoices.JaxWSClient.GenerarCFDIAPartirDeCFD22")
    @ResponseWrapper(localName = "GenerarCFDIAPartirDeCFD22Response", targetNamespace = "http://tempuri.org/", className = "net.tiglass.invoices.JaxWSClient.GenerarCFDIAPartirDeCFD22Response")
    public String generarCFDIAPartirDeCFD22(
        @WebParam(name = "batchCFD22", targetNamespace = "http://tempuri.org/")
        String batchCFD22);

    /**
     * 
     * @param xmlSolicitud
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "CancelaTimbre", action = "http://tempuri.org/ITsunamiService/CancelaTimbre")
    @WebResult(name = "CancelaTimbreResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "CancelaTimbre", targetNamespace = "http://tempuri.org/", className = "net.tiglass.invoices.JaxWSClient.CancelaTimbre")
    @ResponseWrapper(localName = "CancelaTimbreResponse", targetNamespace = "http://tempuri.org/", className = "net.tiglass.invoices.JaxWSClient.CancelaTimbreResponse")
    public String cancelaTimbre(
        @WebParam(name = "xmlSolicitud", targetNamespace = "http://tempuri.org/")
        String xmlSolicitud);

    /**
     * 
     * @param xmlSolicitud
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "ConsultaEstatusCancelacion", action = "http://tempuri.org/ITsunamiService/ConsultaEstatusCancelacion")
    @WebResult(name = "ConsultaEstatusCancelacionResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "ConsultaEstatusCancelacion", targetNamespace = "http://tempuri.org/", className = "net.tiglass.invoices.JaxWSClient.ConsultaEstatusCancelacion")
    @ResponseWrapper(localName = "ConsultaEstatusCancelacionResponse", targetNamespace = "http://tempuri.org/", className = "net.tiglass.invoices.JaxWSClient.ConsultaEstatusCancelacionResponse")
    public String consultaEstatusCancelacion(
        @WebParam(name = "xmlSolicitud", targetNamespace = "http://tempuri.org/")
        String xmlSolicitud);

    /**
     * 
     * @param cfdi
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GenerarPDF", action = "http://tempuri.org/ITsunamiService/GenerarPDF")
    @WebResult(name = "GenerarPDFResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GenerarPDF", targetNamespace = "http://tempuri.org/", className = "net.tiglass.invoices.JaxWSClient.GenerarPDF")
    @ResponseWrapper(localName = "GenerarPDFResponse", targetNamespace = "http://tempuri.org/", className = "net.tiglass.invoices.JaxWSClient.GenerarPDFResponse")
    public String generarPDF(
        @WebParam(name = "cfdi", targetNamespace = "http://tempuri.org/")
        String cfdi);

    /**
     * 
     * @param xml
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GenerarReporteTFD", action = "http://tempuri.org/ITsunamiService/GenerarReporteTFD")
    @WebResult(name = "GenerarReporteTFDResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GenerarReporteTFD", targetNamespace = "http://tempuri.org/", className = "net.tiglass.invoices.JaxWSClient.GenerarReporteTFD")
    @ResponseWrapper(localName = "GenerarReporteTFDResponse", targetNamespace = "http://tempuri.org/", className = "net.tiglass.invoices.JaxWSClient.GenerarReporteTFDResponse")
    public String generarReporteTFD(
        @WebParam(name = "xml", targetNamespace = "http://tempuri.org/")
        String xml);

    /**
     * 
     * @param xmlParametros
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "ConsultarCFDI", action = "http://tempuri.org/ITsunamiService/ConsultarCFDI")
    @WebResult(name = "ConsultarCFDIResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "ConsultarCFDI", targetNamespace = "http://tempuri.org/", className = "net.tiglass.invoices.JaxWSClient.ConsultarCFDI")
    @ResponseWrapper(localName = "ConsultarCFDIResponse", targetNamespace = "http://tempuri.org/", className = "net.tiglass.invoices.JaxWSClient.ConsultarCFDIResponse")
    public String consultarCFDI(
        @WebParam(name = "xmlParametros", targetNamespace = "http://tempuri.org/")
        String xmlParametros);

}