
package net.tiglass.invoices.wscd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="mensaje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="num_ok" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="num_error" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="zip_out" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="respuesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "codigo",
    "mensaje",
    "numOk",
    "numError",
    "zipOut",
    "respuesta"
})
@XmlRootElement(name = "getTimbresZIPResponse")
public class GetTimbresZIPResponse {

    protected int codigo;
    protected String mensaje;
    @XmlElement(name = "num_ok")
    protected int numOk;
    @XmlElement(name = "num_error")
    protected int numError;
    @XmlElement(name = "zip_out")
    protected byte[] zipOut;
    protected String respuesta;

    /**
     * Obtiene el valor de la propiedad codigo.
     * 
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Define el valor de la propiedad codigo.
     * 
     */
    public void setCodigo(int value) {
        this.codigo = value;
    }

    /**
     * Obtiene el valor de la propiedad mensaje.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Define el valor de la propiedad mensaje.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensaje(String value) {
        this.mensaje = value;
    }

    /**
     * Obtiene el valor de la propiedad numOk.
     * 
     */
    public int getNumOk() {
        return numOk;
    }

    /**
     * Define el valor de la propiedad numOk.
     * 
     */
    public void setNumOk(int value) {
        this.numOk = value;
    }

    /**
     * Obtiene el valor de la propiedad numError.
     * 
     */
    public int getNumError() {
        return numError;
    }

    /**
     * Define el valor de la propiedad numError.
     * 
     */
    public void setNumError(int value) {
        this.numError = value;
    }

    /**
     * Obtiene el valor de la propiedad zipOut.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getZipOut() {
        return zipOut;
    }

    /**
     * Define el valor de la propiedad zipOut.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setZipOut(byte[] value) {
        this.zipOut = value;
    }

    /**
     * Obtiene el valor de la propiedad respuesta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRespuesta() {
        return respuesta;
    }

    /**
     * Define el valor de la propiedad respuesta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRespuesta(String value) {
        this.respuesta = value;
    }

}
