
package net.tiglass.invoices.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.tiglass.invoices.connection.AlfakDBConnection;

public class AlfakOrder {
    
    private static AlfakDBConnection connection = new AlfakDBConnection();
    
    public ResultSet getOrderHeader(int OrderId) throws SQLException {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        
        try {
            cstmt = connection.getConnection().prepareCall("{call SYSADM.CFD_HEADER(?)}");
            cstmt.setInt("PEDIDO_ID", OrderId);
            cstmt.execute();
            rs = cstmt.getResultSet();
        } catch (SQLException ex) {
            throw ex;
        }
        return rs;
    }
    
    public ResultSet getOrderItems(int OrderId) throws SQLException {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        
        try {
            cstmt = connection.getConnection().prepareCall("{call SYSADM.CFD_ITEMS(?)}");
            cstmt.setInt("PEDIDO_ID", OrderId);
            cstmt.execute();
            rs = cstmt.getResultSet();
        } catch (SQLException ex) {
            throw ex;
        }
        return rs;
    }
    
    public boolean storePathFileOnDB(int orderId, String fileName, String bem, String transferKz) throws SQLException {
        CallableStatement cstmt = null;
        boolean result = true;

        try {
            cstmt = connection.getConnection().prepareCall("{call SYSADM.CFD_GUARDAR_RUTA_ANEXO(?, ?, ?, ?)}");
            cstmt.setInt("ID", orderId);
            cstmt.setString("FILE_NAME", fileName);
            cstmt.setString("BEM", bem);
            cstmt.setString("TRANSFER_KZ", transferKz);
            cstmt.execute();
        } catch (SQLException ex) {
            result = false;
            throw ex;
        }
        return result;
    }
    
    //---------Pruebas----------
    public ResultSet ObtenerDatos() throws Exception{
        try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
            String connectionUrl = "jdbc:sqlserver://TIGLASS2-PC\\AWBUSINESS;" + 
                                    "database=TECNOVIDRIO;" + 
                                    "user=sa;" + 
                                    "password=qwe369*"; 
            Connection con = DriverManager.getConnection(connectionUrl); 
            //System.out.println("Connected."); 

            // Create and execute an SQL statement that returns some data.  
            String SQL = "SELECT ID, NAME1 FROM SYSADM.KA_FIRMA";  
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery(SQL);
            
            return rs;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public ResultSet getData() throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            String sql = "SELECT ID, NAME1";
            sql += " FROM SYSADM.KA_FIRMA";
            stmt = connection.getConnection().createStatement();
            rs = stmt.executeQuery(sql);
        } catch (Exception ex) {
            throw ex;
        } finally {
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException e) {
//                    Logger.getLogger(CFDv32Factory.class.getName()).
//                            log(Level.WARNING, null, e);
//                }
//            }
//            if (stmt != null) {
//                try {
//                    stmt.close();
//                } catch (SQLException e) {
//                    Logger.getLogger(CFDv32Factory.class.getName()).
//                            log(Level.WARNING, null, e);
//                }
//            }
        }
        return rs;
    }
}
