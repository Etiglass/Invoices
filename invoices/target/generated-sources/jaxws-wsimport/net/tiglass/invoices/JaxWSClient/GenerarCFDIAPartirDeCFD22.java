
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
 *         &lt;element name="batchCFD22" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "batchCFD22"
})
@XmlRootElement(name = "GenerarCFDIAPartirDeCFD22")
public class GenerarCFDIAPartirDeCFD22 {

    @XmlElementRef(name = "batchCFD22", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> batchCFD22;

    /**
     * Obtiene el valor de la propiedad batchCFD22.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBatchCFD22() {
        return batchCFD22;
    }

    /**
     * Define el valor de la propiedad batchCFD22.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBatchCFD22(JAXBElement<String> value) {
        this.batchCFD22 = value;
    }

}
