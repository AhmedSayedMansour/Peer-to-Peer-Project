/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_packages;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author MegaDardery
 */
public class DownloadWorker extends SwingWorker<Boolean, Integer> {

    int idx;
    String filename;

    public DownloadWorker(int idx, String filename) {
        GUI.myGUI.prgProgress.setVisible(true);
        GUI.myGUI.btnDownload.setEnabled(false);
        GUI.myGUI.btnRefresh.setEnabled(false);

        this.idx = idx;
        this.filename = filename;
    }

    @Override
    protected Boolean doInBackground() {
        return GUI.myGUI.myPeer.requestFile(this::publish, idx, filename);      //reporter(int),idx,filename to send
    }

    @Override
    protected void done() {
        try {
            if (get().equals(false)) {
                GUI.myGUI.prgProgress.setVisible(false);
                JOptionPane.showMessageDialog(GUI.myGUI,
                        "This file is not being shared anymore by the peer, or the peer is offline."
                        + " The list needs to be refreshed.",
                        "Unable to request file",
                        JOptionPane.WARNING_MESSAGE);
                new RefreshWorker().execute();
            } else {
                if (Desktop.isDesktopSupported()) {
                    if (JOptionPane.showConfirmDialog(GUI.myGUI,
                            "Your requsted file has arrived! Do you want to open it?",
                            "File recieved",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

                        Desktop desktop = Desktop.getDesktop();
                        File f = new File(filename);
                        if (f.exists()) {
                            try {
                                desktop.open(f);
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(GUI.myGUI, "Unable to start recieved file!", "Error", JOptionPane.INFORMATION_MESSAGE);
                            }

                        }
                    }
                }

            }
            GUI.myGUI.btnDownload.setEnabled(true);
            GUI.myGUI.btnRefresh.setEnabled(true);
            GUI.myGUI.prgProgress.setVisible(false);

        } catch (InterruptedException | ExecutionException ex) {
            //Logger.getLogger(DownloadWorker.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    @Override
    protected void process(List<Integer> args) {        //called by publish
        int v = args.get(args.size() - 1);
        GUI.myGUI.prgProgress.setValue(v);           //progress bar
    }
}