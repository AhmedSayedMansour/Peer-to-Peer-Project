/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_packages;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author MegaDardery
 */
public class StartWorker extends SwingWorker<Void, Void> {

    Loading loader;

    public StartWorker() {       //before running
        loader = new Loading();
        loader.setLocationRelativeTo(null);    //null is the screen at middle the screen (loader)
        loader.setVisible(true);
    }

    @Override
    protected Void doInBackground() throws Exception {

        int port;
        while (true) {
            String selected = JOptionPane.showInputDialog(null, "Input Peer to Peer port number:");

            if (selected == null) {
                System.exit(0);
            }

            try {
                //converts 'selected' from string to integer, throws an exception on failure
                port = Integer.decode(selected);

                //'myPeer.initialize(port)' returns true if successfull
                if (port > 0 && GUI.myGUI.myPeer.initialize(port)) {
                    break;
                }
            } catch (NumberFormatException ex) {
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
            if (JOptionPane.showConfirmDialog(null,
                    "Unable to establish a connection with the given port. Retry?",
                    "Error in connection", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                System.exit(0);
            }

        }
        return null;

    }

    @Override
    protected void done() {
        try {
            GUI.myGUI.txtIP.setText(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
        GUI.myGUI.prgProgress.setVisible(false);

        loader.dispose();
        GUI.myGUI.setVisible(true);
    }
}