
package net.tiglass.invoices.connection;

//import net.tiglass.properties.ProjectProperties;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.tiglass.invoices.properties.AppProperties;

public class SqlConnection {
    private static AppProperties properties = new AppProperties();
    private static Connection connection = null;
    private static SQLServerDataSource dataSource = new SQLServerDataSource();
    
    public static SQLServerDataSource getDataSource() {
        return dataSource;
    }
    
    public SqlConnection() {
        try {
            createConnection();
        } catch (Exception ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(
                    Level.SEVERE, null, ex);
//            throw ex;
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    private static Connection createConnection() throws Exception {

        try {
//            getDataSource().setUser(getProjectProperties().getProperties().
//                    getProperty("connector.user"));
//            getDataSource().setPassword(getProjectProperties().getProperties().
//                    getProperty("connector.password"));
//            getDataSource().setServerName(getProjectProperties().getProperties().
//                    getProperty("connector.server"));
//            getDataSource().setInstanceName(getProjectProperties().getProperties().
//                    getProperty("connector.instance"));
//            getDataSource().setDatabaseName(getProjectProperties().getProperties().
//                    getProperty("connector.database"));
            //properties.load(SqlConnection.class.getResourceAsStream("/net/tiglass/invoices/config.properties"));
            // temporal
            getDataSource().setUser(properties.getProperty("user"));
            getDataSource().setPassword(properties.getProperty("password"));
            getDataSource().setServerName(properties.getProperty("server"));
            getDataSource().setInstanceName(properties.getProperty("instance"));
            getDataSource().setDatabaseName(properties.getProperty("database"));

            connection = getDataSource().getConnection();
        } catch (Exception ex) {
            throw ex;
        }
        return connection;
    }
}
