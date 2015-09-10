
package net.tiglass.invoices.swcd;

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
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pwd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="num_cfdi" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="zip_in" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
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
    "usuario",
    "pwd",
    "numCfdi",
    "zipIn"
})
@XmlRootElement(name = "getTimbresZIP")
public class GetTimbresZIP {

    protected String usuario;
    protected String pwd;
    @XmlElement(name = "num_cfdi")
    protected int numCfdi;
    @XmlElement(name = "zip_in")
    protected byte[] zipIn;

    /**
     * Obtiene el valor de la propiedad usuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Define el valor de la propiedad usuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

    /**
     * Obtiene el valor de la propiedad pwd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * Define el valor de la propiedad pwd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPwd(String value) {
        this.pwd = value;
    }

    /**
     * Obtiene el valor de la propiedad numCfdi.
     * 
     */
    public int getNumCfdi() {
        return numCfdi;
    }

    /**
     * Define el valor de la propiedad numCfdi.
     * 
     */
    public void setNumCfdi(int value) {
        this.numCfdi = value;
    }

    /**
     * Obtiene el valor de la propiedad zipIn.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getZipIn() {
        return zipIn;
    }

    /**
     * Define el valor de la propiedad zipIn.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setZipIn(byte[] value) {
        this.zipIn = value;
    }

}
