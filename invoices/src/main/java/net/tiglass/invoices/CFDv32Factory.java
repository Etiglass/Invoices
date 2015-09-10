package net.tiglass.invoices;

import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import mx.bigdata.sat.cfdi.v32.schema.Comprobante;
import mx.bigdata.sat.cfdi.v32.schema.Comprobante.Addenda;
import mx.bigdata.sat.cfdi.v32.schema.Comprobante.Complemento;
import mx.bigdata.sat.cfdi.v32.schema.Comprobante.Conceptos;
import mx.bigdata.sat.cfdi.v32.schema.Comprobante.Conceptos.Concepto;
import mx.bigdata.sat.cfdi.v32.schema.Comprobante.Emisor;
import mx.bigdata.sat.cfdi.v32.schema.Comprobante.Emisor.RegimenFiscal;
import mx.bigdata.sat.cfdi.v32.schema.Comprobante.Impuestos;
import mx.bigdata.sat.cfdi.v32.schema.Comprobante.Impuestos.Traslados;
import mx.bigdata.sat.cfdi.v32.schema.Comprobante.Impuestos.Traslados.Traslado;
import mx.bigdata.sat.cfdi.v32.schema.Comprobante.Receptor;
import mx.bigdata.sat.cfdi.v32.schema.ObjectFactory;
import mx.bigdata.sat.cfdi.v32.schema.TUbicacion;
import mx.bigdata.sat.cfdi.v32.schema.TUbicacionFiscal;
import net.tiglass.invoices.data.Order;
import net.tiglass.invoices.properties.AppProperties;

public final class CFDv32Factory {
    
    private static Order order = new Order();
    private static AppProperties properties = new AppProperties();

    public static Comprobante createComprobante(int orderId) throws Exception {
        ObjectFactory of = new ObjectFactory();
        Comprobante comp = of.createComprobante();
        ResultSet rs = order.getOrderHeader(orderId);

        if (rs.next()){
            comp.setVersion("3.2");
            //Date date = new GregorianCalendar(2012, 1, 6, 20, 38, 12).getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = formatter.parse(rs.getString("FECHA_FACTURA"));
            comp.setFecha(date);
            
            String formaDePago = rs.getString("FORMA_PAGO");
            if (formaDePago.length() > 0) {
                comp.setFormaDePago(formaDePago);
            }
            
            String condicionesDePago = rs.getString("CONDICION_PAGO");
            if (condicionesDePago.length() > 0) {
                comp.setCondicionesDePago(condicionesDePago);
            }
            
            String subTotal = rs.getString("SUBTOTAL");
            if (subTotal.length() > 0) {
                comp.setSubTotal(new BigDecimal(subTotal));
            }
            
            String tipoCambio = rs.getString("TIPO_CAMBIO");
            if (tipoCambio.length() > 0) {
               comp.setTipoCambio(tipoCambio); 
            }
            
            String moneda = rs.getString("MONEDA");
            if (moneda.length() > 0) {
                comp.setMoneda(moneda);
            }
            
            String total = rs.getString("TOTAL");
            if (total.length() > 0) {
                comp.setTotal(new BigDecimal(total));
            }
            
            String tipoDeComprobante = rs.getString("TIPO_COMPROBANTE");
            if (tipoDeComprobante.length() > 0) {
                comp.setTipoDeComprobante(tipoDeComprobante);
            }
            
            String metodoDePago = rs.getString("METODO_PAGO");
            if (metodoDePago.length() > 0) {
                comp.setMetodoDePago(metodoDePago);
            }
            
            String lugarExpedicion = rs.getString("LUGAR_EXPEDICION");
            if (lugarExpedicion.length() > 0) {
                comp.setLugarExpedicion(lugarExpedicion);
            }
            
            comp.setEmisor(createEmisor(of, orderId));
            comp.setReceptor(createReceptor(of, orderId));
            comp.setConceptos(createConceptos(of, orderId));
            comp.setImpuestos(createImpuestos(of, orderId));
            //comp.setAddenda(createAddenda(of));
            comp.setComplemento(createComplemento(of));
        }
        return comp;
    }

    private static Complemento createComplemento(ObjectFactory of) {
        Complemento complemento = new Complemento();

        return complemento;
    }

    private static Emisor createEmisor(ObjectFactory of, int orderId) throws Exception {
        Emisor emisor = of.createComprobanteEmisor();
        ResultSet rs = order.getOrderHeader(orderId);

        if (rs.next()){
            String rfc = rs.getString("E_RFC");
            if (rfc.length() > 0) {
                emisor.setRfc(rfc);
            }
            
            String nombre = rs.getString("E_NOMBRE");
            if (nombre.length() > 0) {
                emisor.setNombre(nombre);
            }
            
            TUbicacionFiscal uf = of.createTUbicacionFiscal();
            String calle = rs.getString("E_CALLE");
            if (calle.length() > 0) {
                uf.setCalle(calle);
            }
            
            String noExterior = rs.getString("E_NUMERO_EXTERIOR");
            if (noExterior.length() > 0) {
                uf.setNoExterior(noExterior);
            }
            
            //uf.setNoInterior(rs.getString("E_NUMERO_INTERIOR"));
            
            String colonia = rs.getString("E_COLONIA");
            if (colonia.length() > 0) {
                uf.setColonia(colonia);
            }
            
            //uf.setLocalidad("Merida"); //ciudad. pendiente
            
            String municipio = rs.getString("E_MUNICIPIO");
            if (municipio.length() > 0) {
                uf.setMunicipio(municipio);//municipio o delegacion
            }
            
            String estado = rs.getString("E_ESTADO");
            if (estado.length() > 0) {
                uf.setEstado(estado);
            }
            
            String pais = rs.getString("E_PAIS");
            if (pais.length() > 0) {
                uf.setPais(pais);
            }
            
            String codigoPostal = rs.getString("E_CODIGO_POSTAL");
            if (codigoPostal.length() > 0) {
                uf.setCodigoPostal(codigoPostal);
            }
            
            emisor.setDomicilioFiscal(uf);
            
//        TUbicacion u = of.createTUbicacion();
//        u.setCalle(rs.getString("E_CALLE"));
//        u.setNoExterior(rs.getString("E_NUMERO_EXTERIOR"));
//        u.setNoInterior(rs.getString("E_NUMERO_INTERIOR"));
//        u.setColonia(rs.getString("E_COLONIA"));
//        u.setLocalidad("Ciudad de Mexico"); //pendiente
//        u.setMunicipio(rs.getString("E_MUNICIPIO"));
//        u.setEstado(rs.getString("E_ESTADO"));
//        u.setPais(rs.getString("E_PAIS"));
//        u.setCodigoPostal(rs.getString("E_CODIGO_POSTAL"));
//        emisor.setExpedidoEn(u);
            RegimenFiscal rf = of.createComprobanteEmisorRegimenFiscal();
            
            String regimenFiscal = properties.getProperty("regimen");
            if (regimenFiscal.length() > 0) {
                rf.setRegimen(regimenFiscal);
            }
            
            emisor.getRegimenFiscal().add(rf);
        }
        return emisor;
    }

    private static Receptor createReceptor(ObjectFactory of, int orderId) throws Exception {
        Receptor receptor = of.createComprobanteReceptor();
        ResultSet rs = order.getOrderHeader(orderId);

        if (rs.next()){
            String rfc = rs.getString("R_RFC");
            if (rfc.length() > 0) {
                receptor.setRfc(rfc);
            }
            
            String nombre = rs.getString("R_NOMBRE");
            if (nombre.length() > 0) {
                receptor.setNombre(nombre);
            }
            
            TUbicacion uf = of.createTUbicacion();
            String calle = rs.getString("R_CALLE");
            if (calle.length() > 0) {
                uf.setCalle(calle);
            }
            
            String noExterior = rs.getString("R_NUMERO_EXTERIOR");
            if (noExterior.length() > 0) {
                uf.setNoExterior(noExterior);
            }
            
            String noInterior = rs.getString("R_NUMERO_INTERIOR");
            if (noInterior.length() > 0) {
                uf.setNoInterior(noInterior);
            }
            
            String colonia = rs.getString("R_COLONIA");
            if (colonia.length() > 0) {
                uf.setColonia(colonia);
            }
            
            //uf.setLocalidad(""); //pendiente
            
            String municipio = rs.getString("R_MUNICIPIO");
            if (municipio.length() > 0) {
                uf.setMunicipio(municipio);
            }
            
            String estado = rs.getString("R_ESTADO");
            if (estado.length() > 0) {
                uf.setEstado(estado);
            }
            
            String pais = rs.getString("R_PAIS");
            if (pais.length() > 0) {
                uf.setPais(pais);
            }
            
            String codigoPostal = rs.getString("R_CODIGO_POSTAL");
            if (codigoPostal.length() > 0) {
                uf.setCodigoPostal(codigoPostal);
            }
            
            receptor.setDomicilio(uf);
        }
        return receptor;
    }

    private static Conceptos createConceptos(ObjectFactory of, int orderId) throws Exception {
        Conceptos cps = of.createComprobanteConceptos();
        List<Concepto> list = cps.getConcepto();
        ResultSet rs = order.getOrderItems(orderId);
        String sAtribReq = "";

        while (rs.next()){
            Concepto c1 = of.createComprobanteConceptosConcepto();
            String cantidad = rs.getString("CANTIDAD");
            if (cantidad.length() > 0) {
                c1.setCantidad(new BigDecimal(cantidad));
            } else {
                sAtribReq += "cantidad|";
            }
            
            String unidad = rs.getString("UNIDAD_MEDIDA");
            if (unidad.length() > 0) {
                if (unidad.equals("m²")) {
                    unidad = "Pza";
                }
                c1.setUnidad(unidad);
            } else {
                sAtribReq += "unidad|";
            }
            
            //c1.setNoIdentificacion("id_prod");
            
            String descripcion = rs.getString("DESCRIPCION");
            if (descripcion.length() > 0) {
                c1.setDescripcion(descripcion);
            } else {
                sAtribReq += "descripcion|";
            }
            
            String valorUnitario = rs.getString("VALOR_UNITARIO");
            if (valorUnitario.length() > 0) {
                c1.setValorUnitario(new BigDecimal(valorUnitario));
            } else {
                sAtribReq += "valorUnitario";
            }
            
            String importe = rs.getString("IMPORTE");
            if (importe.length() > 0) {
                c1.setImporte(new BigDecimal(importe));
            } else {
                sAtribReq += "importe|";
            }
            
            list.add(c1);
        }
        return cps;
    }

    private static Impuestos createImpuestos(ObjectFactory of, int orderId) throws Exception {
        Impuestos imps = of.createComprobanteImpuestos();
        Traslados trs = of.createComprobanteImpuestosTraslados();
        List<Traslado> list = trs.getTraslado();
        ResultSet rs = order.getOrderHeader(orderId);

        if (rs.next()){
            if (!rs.getString("I1_ID").equals("0")) {
                Traslado t1 = of.createComprobanteImpuestosTrasladosTraslado();
                t1.setImporte(new BigDecimal(rs.getString("I1_IMPORTE")));
                t1.setImpuesto(rs.getString("I1_IMPUESTO"));
                t1.setTasa(new BigDecimal(rs.getString("I1_TASA")));
                list.add(t1);
            }
            
            if (!rs.getString("I2_ID").equals("0")) {
                Traslado t2 = of.createComprobanteImpuestosTrasladosTraslado();
                t2.setImporte(new BigDecimal(rs.getString("I2_IMPORTE")));
                t2.setImpuesto(rs.getString("I2_IMPUESTO"));
                t2.setTasa(new BigDecimal(rs.getString("I2_TASA")));
                list.add(t2);
            }
        }
        imps.setTraslados(trs);
        return imps;
    }

    private static Addenda createAddenda(ObjectFactory of) {
        Addenda addenda = of.createComprobanteAddenda();
//        Company2 c = new Company2();
//        c.transaction = new Transaction2();
//        c.transaction.purchaseOrder = "4600364283";
//        addenda.getAny().add(c);
        return addenda;
    }

    @XmlRootElement(name = "Company2")
    private final static class Company2 {

        @XmlElement(name = "Transaction2")
        Transaction2 transaction;
    }

    @XmlRootElement
    private final static class Transaction2 {

        @SuppressWarnings("unused")
        @XmlAttribute(name = "PurchaseOrder2")
        String purchaseOrder;
    }
    
}
