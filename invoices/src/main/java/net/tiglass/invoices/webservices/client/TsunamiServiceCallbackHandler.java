/**
 * TsunamiServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package net.tiglass.invoices.webservices.client;


/**
 *  TsunamiServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class TsunamiServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public TsunamiServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public TsunamiServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for consultaEstatusCancelacion method
     * override this method for handling normal response from consultaEstatusCancelacion operation
     */
    public void receiveResultconsultaEstatusCancelacion(
        net.tiglass.invoices.webservices.client.TsunamiServiceStub.ConsultaEstatusCancelacionResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from consultaEstatusCancelacion operation
     */
    public void receiveErrorconsultaEstatusCancelacion(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for generarCFDIAPartirDeCFD22 method
     * override this method for handling normal response from generarCFDIAPartirDeCFD22 operation
     */
    public void receiveResultgenerarCFDIAPartirDeCFD22(
        net.tiglass.invoices.webservices.client.TsunamiServiceStub.GenerarCFDIAPartirDeCFD22Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from generarCFDIAPartirDeCFD22 operation
     */
    public void receiveErrorgenerarCFDIAPartirDeCFD22(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for cancelaTimbre method
     * override this method for handling normal response from cancelaTimbre operation
     */
    public void receiveResultcancelaTimbre(
        net.tiglass.invoices.webservices.client.TsunamiServiceStub.CancelaTimbreResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from cancelaTimbre operation
     */
    public void receiveErrorcancelaTimbre(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for generarReporteTFD method
     * override this method for handling normal response from generarReporteTFD operation
     */
    public void receiveResultgenerarReporteTFD(
        net.tiglass.invoices.webservices.client.TsunamiServiceStub.GenerarReporteTFDResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from generarReporteTFD operation
     */
    public void receiveErrorgenerarReporteTFD(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for firmarTimbararCFDI method
     * override this method for handling normal response from firmarTimbararCFDI operation
     */
    public void receiveResultfirmarTimbararCFDI(
        net.tiglass.invoices.webservices.client.TsunamiServiceStub.FirmarTimbararCFDIResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from firmarTimbararCFDI operation
     */
    public void receiveErrorfirmarTimbararCFDI(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for generarCFDI method
     * override this method for handling normal response from generarCFDI operation
     */
    public void receiveResultgenerarCFDI(
        net.tiglass.invoices.webservices.client.TsunamiServiceStub.GenerarCFDIResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from generarCFDI operation
     */
    public void receiveErrorgenerarCFDI(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for generarPDF method
     * override this method for handling normal response from generarPDF operation
     */
    public void receiveResultgenerarPDF(
        net.tiglass.invoices.webservices.client.TsunamiServiceStub.GenerarPDFResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from generarPDF operation
     */
    public void receiveErrorgenerarPDF(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for consultarCFDI method
     * override this method for handling normal response from consultarCFDI operation
     */
    public void receiveResultconsultarCFDI(
        net.tiglass.invoices.webservices.client.TsunamiServiceStub.ConsultarCFDIResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from consultarCFDI operation
     */
    public void receiveErrorconsultarCFDI(java.lang.Exception e) {
    }
}
