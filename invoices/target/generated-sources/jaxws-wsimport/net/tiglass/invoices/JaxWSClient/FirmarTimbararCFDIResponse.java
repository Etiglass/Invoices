
package net.tiglass.invoices.JaxWSClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
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
 *         &lt;element name="FirmarTimbararCFDIResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "firmarTimbararCFDIResult"
})
@XmlRootElement(name = "FirmarTimbararCFDIResponse")
public class FirmarTimbararCFDIResponse {

    @XmlElementRef(name = "FirmarTimbararCFDIResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> firmarTimbararCFDIResult;

    /**
     * Obtiene el valor de la propiedad firmarTimbararCFDIResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFirmarTimbararCFDIResult() {
        return firmarTimbararCFDIResult;
    }

    /**
     * Define el valor de la propiedad firmarTimbararCFDIResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFirmarTimbararCFDIResult(JAXBElement<String> value) {
        this.firmarTimbararCFDIResult = value;
    }

}
