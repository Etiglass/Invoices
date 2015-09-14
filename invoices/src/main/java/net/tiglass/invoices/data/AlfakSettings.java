
package net.tiglass.invoices.data;

import java.sql.ResultSet;
import java.sql.Statement;
import net.tiglass.invoices.connection.AlfakDBConnection;

public class AlfakSettings {
    
    private static AlfakDBConnection connection = new AlfakDBConnection();
    
    public String getAttachPath() throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        String result = "";
        
        try {
            String sql = "SELECT P.VALUE AS ATTACH_PATH " +
                    "FROM SYSADM.KA_FIRMA F " +
                    "INNER JOIN SYSADM.KA_FIRMA_PARAMS P ON F.ID = P.ID " +
                    "WHERE P.PARAM = 3";
            stmt = connection.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
            
            if (rs.next())
                result = rs.getString("ATTACH_PATH");
        } catch (Exception ex) {
            throw ex;
        }
        
        return result;
    }
}
