package net.tiglass.invoices.properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class AppProperties {

    private Properties properties = new Properties();
    private OutputStream os = null;
    private InputStream is = null; 

    public void setProperty(String name, String value) {
        try {
            os = new FileOutputStream(System.getenv("APPDATA") + "\\Invoices\\Properties\\config.properties");
            //os = new FileOutputStream(getClass().getResource("config.properties").getFile());
            properties.setProperty(name, value);

            properties.store(os, "Application properties");
        } catch (IOException io) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, io);
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException io) {
                    java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, io);
                }
            }
        }
    }
    
    public String getProperty(String name) {
        String result = "";
        
        try {
            is = new FileInputStream(System.getenv("APPDATA") + "\\Invoices\\Properties\\config.properties");
//            properties.load(is);
            //is = getClass().getResourceAsStream("config.properties");
            properties.load(is);

            result = properties.getProperty(name);
        } catch (IOException io) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, io);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException io) {
                    java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, io);
                }
            }
        }
        
        return result;
    }
}
