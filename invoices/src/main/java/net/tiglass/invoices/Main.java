
package net.tiglass.invoices;

import net.tiglass.invoices.forms.*;

public class Main {
    
    public static void main(String[] args) {
        if (args.length > 0) {
            frmGenerateInvoice myGenInvoice = new frmGenerateInvoice();
            int orderId = Integer.parseInt(args[0]);
            myGenInvoice.setOrderId(orderId);
            myGenInvoice.setLocationRelativeTo(null);
            myGenInvoice.setVisible(true);
            //new ScreenSplash().animar();
        } else {
            frmAdministration myAdmin = new frmAdministration();
            myAdmin.setLocationRelativeTo(null);
            myAdmin.setVisible(true);
        }
//        frmTest myTest = new frmTest();
//        myTest.setLocationRelativeTo(null);
//        myTest.setVisible(true);

    }
    
}
