
package net.tiglass.invoices.forms;

import java.awt.*;
import java.awt.SplashScreen;
import javax.swing.JOptionPane;

public final class ScreenSplash {
    final SplashScreen splash;
    //texto que se muestra a medida que se va cargando el screenSplash
    final String[] texto = {"Gimme the power" ,"configuration", "library",
                          "files XYZ","forms","iconos","properties",
                          "XML files", "X-files", "anonymous",
                          "database" ,"server","wtf!",
                          ""};
    
    public ScreenSplash() {
        splash = SplashScreen.getSplashScreen();
    }
    
    public void animar() {
        if (splash != null) {
            Graphics2D g = splash.createGraphics();
            for (int i=1; i < texto.length; i++) {
                g.setColor(Color.yellow); //color de fondo
                g.fillRect(203, 328, 280, 12);
                g.setColor(Color.white); // color de texto
                g.drawString("Loading " + texto[1-1] + "...", 203, 338);
                g.setColor(Color.green); // color de barra de progreso
                g.fillRect(204, 308, (i * 307/texto.length), 12); // la barra de progreso
                // se dibuja una linea segmentada encima de la barra verde
                float dash1[] = {2.0f};
                BasicStroke dashed = new BasicStroke(9.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, dash1, 0.0f);
                g.setStroke(dashed);
                g.setColor(Color.GREEN); // Color de la barra de progreso
                g.setColor(Color.orange);
                g.drawLine(205, 314, 510, 314);
                splash.update(); // se actualiza todo
                
                try {
                    Thread.sleep(321);
                } catch (InterruptedException e) {
                }
                
                splash.close();
            }
            
            // una vez terminada la aplicacion se muestra la aplicacion principal
            try {
                frmAdministration myAdmin = new frmAdministration();
                myAdmin.setLocationRelativeTo(null);
                myAdmin.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
}
