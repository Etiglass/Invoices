
package net.tiglass.invoices.data;

import java.sql.CallableStatement;
import java.util.Date;
import java.sql.SQLException;
import net.tiglass.invoices.connection.DBConnection;

public class Invoice {
    
    public boolean saveInvoice(int invoiceId, String uuid, String cert, Date date, String selloCfd, 
            String selloSat, String cadOrig, String certSat, Date certDate, String expPlace) throws SQLException {
        CallableStatement cstmt = null;
        boolean result = true;

        try {
            DBConnection connection = new DBConnection();
            cstmt = connection.getConnection().prepareCall("{call dbo.SAVE_INVOICE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cstmt.setInt("INVOICE_ID", invoiceId);
            cstmt.setString("UUID", uuid);
            cstmt.setString("CERT", cert);
            java.sql.Timestamp sqlDate = new java.sql.Timestamp(date.getTime());
            cstmt.setTimestamp("DATE", sqlDate);
            cstmt.setString("SELLO_CFD", selloCfd);
            cstmt.setString("SELLO_SAT", selloSat);
            cstmt.setString("CAD_ORIG", cadOrig);
            cstmt.setString("CERT_SAT", certSat);
            java.sql.Timestamp sqlCertDate = new java.sql.Timestamp(certDate.getTime());
            cstmt.setTimestamp("CERT_DATE", sqlCertDate);
            cstmt.setString("EXP_PLACE", expPlace);
            cstmt.execute();
        } catch (SQLException ex) {
            result = false;
            throw ex;
        }
        return result;
    }
    
}
