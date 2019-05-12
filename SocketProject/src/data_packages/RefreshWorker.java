/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_packages;

import java.io.File;
import java.util.ArrayList;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MegaDardery
 */
public class RefreshWorker extends SwingWorker {

    public RefreshWorker() {
        GUI.myGUI.btnDownload.setEnabled(false);
        GUI.myGUI.btnRefresh.setEnabled(false);
    }

    @Override
    protected Void doInBackground() {
        GUI.myGUI.myPeer.refreshFileList();

        return null;
    }

    @Override
    protected void done() {        //to add files to external download list
        DefaultTableModel tableModelN = (DefaultTableModel) GUI.myGUI.tblDownload.getModel();
        tableModelN.setRowCount(0);         //to empty the list

        ArrayList<FileInfo> disp = GUI.myGUI.myPeer.getAvailableFiles();
        for (int i = 0; i < disp.size(); ++i) {
            FileInfo curr = disp.get(i);
            File fname = new File(curr.filename);
            Object[] obj = {fname.getName(), Helper.getSizeInText(curr.size), curr.owner.address.getHostAddress()};
            tableModelN.addRow(obj);           //to add to the list
        }

        GUI.myGUI.tblDownload.setModel(tableModelN);
        GUI.myGUI.btnDownload.setEnabled(true);
        GUI.myGUI.btnRefresh.setEnabled(true);
    }

}