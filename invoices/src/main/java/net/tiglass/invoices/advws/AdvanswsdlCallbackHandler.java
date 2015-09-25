/**
 * AdvanswsdlCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package net.tiglass.invoices.advws;


/**
 *  AdvanswsdlCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class AdvanswsdlCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public AdvanswsdlCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public AdvanswsdlCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for consultar_hora method
     * override this method for handling normal response from consultar_hora operation
     */
    public void receiveResultconsultar_hora(
        net.tiglass.invoices.advws.AdvanswsdlStub.Consultar_horaResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from consultar_hora operation
     */
    public void receiveErrorconsultar_hora(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for timbrar method
     * override this method for handling normal response from timbrar operation
     */
    public void receiveResulttimbrar(
        net.tiglass.invoices.advws.AdvanswsdlStub.TimbrarResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from timbrar operation
     */
    public void receiveErrortimbrar(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for consultar method
     * override this method for handling normal response from consultar operation
     */
    public void receiveResultconsultar(
        net.tiglass.invoices.advws.AdvanswsdlStub.ConsultarResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from consultar operation
     */
    public void receiveErrorconsultar(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for cancelar method
     * override this method for handling normal response from cancelar operation
     */
    public void receiveResultcancelar(
        net.tiglass.invoices.advws.AdvanswsdlStub.CancelarResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from cancelar operation
     */
    public void receiveErrorcancelar(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for timbrarRetencion2 method
     * override this method for handling normal response from timbrarRetencion2 operation
     */
    public void receiveResulttimbrarRetencion2(
        net.tiglass.invoices.advws.AdvanswsdlStub.TimbrarRetencion2Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from timbrarRetencion2 operation
     */
    public void receiveErrortimbrarRetencion2(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for cancelarPFXSync method
     * override this method for handling normal response from cancelarPFXSync operation
     */
    public void receiveResultcancelarPFXSync(
        net.tiglass.invoices.advws.AdvanswsdlStub.CancelarPFXSyncResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from cancelarPFXSync operation
     */
    public void receiveErrorcancelarPFXSync(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for timbrarRetencion method
     * override this method for handling normal response from timbrarRetencion operation
     */
    public void receiveResulttimbrarRetencion(
        net.tiglass.invoices.advws.AdvanswsdlStub.TimbrarRetencionResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from timbrarRetencion operation
     */
    public void receiveErrortimbrarRetencion(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for consultar_cfdi method
     * override this method for handling normal response from consultar_cfdi operation
     */
    public void receiveResultconsultar_cfdi(
        net.tiglass.invoices.advws.AdvanswsdlStub.Consultar_cfdiResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from consultar_cfdi operation
     */
    public void receiveErrorconsultar_cfdi(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for timbrar3 method
     * override this method for handling normal response from timbrar3 operation
     */
    public void receiveResulttimbrar3(
        net.tiglass.invoices.advws.AdvanswsdlStub.Timbrar3Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from timbrar3 operation
     */
    public void receiveErrortimbrar3(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for cancelarRetencion method
     * override this method for handling normal response from cancelarRetencion operation
     */
    public void receiveResultcancelarRetencion(
        net.tiglass.invoices.advws.AdvanswsdlStub.CancelarRetencionResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from cancelarRetencion operation
     */
    public void receiveErrorcancelarRetencion(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for timbrar2 method
     * override this method for handling normal response from timbrar2 operation
     */
    public void receiveResulttimbrar2(
        net.tiglass.invoices.advws.AdvanswsdlStub.Timbrar2Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from timbrar2 operation
     */
    public void receiveErrortimbrar2(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for validar_certificado method
     * override this method for handling normal response from validar_certificado operation
     */
    public void receiveResultvalidar_certificado(
        net.tiglass.invoices.advws.AdvanswsdlStub.Validar_certificadoResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from validar_certificado operation
     */
    public void receiveErrorvalidar_certificado(java.lang.Exception e) {
    }
}
