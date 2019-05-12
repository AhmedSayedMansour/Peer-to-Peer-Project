package data_packages;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MegaDardery
 */
public class Helper {
    
    static void RefreshLocal() {
        DefaultTableModel tableModelL = (DefaultTableModel) GUI.myGUI.tblLocal.getModel();
        tableModelL.setRowCount(0);         //empty
        ArrayList<FileInfo> dispL = GUI.myGUI.myPeer.getLocalFiles();
        for (int i = 0; i < dispL.size(); ++i) {
            File fname = new File(dispL.get(i).filename);
            Object[] obj = {fname.getName(), Helper.getSizeInText(fname.length())};
            
            tableModelL.addRow(obj);
        }
        GUI.myGUI.tblLocal.setModel(tableModelL);
    }
    
    static String getSizeInText(long size) {
        int degree = 0;
        while (size > 1024) {
            size /= 1024;
            ++degree;
        }
        String extra;
        switch (degree) {
            case 0:
                extra = " bytes";
                break;
            case 1:
                extra = " KB";
                break;
            case 2:
                extra = " MB";
                break;
            case 3:
                extra = " GB";
                break;
            case 4:
                extra = " TB";
                break;
            default:
                extra = " wtf";
                break;
        }
        return size + extra;
    }
    
    public static String getExtension(String fileName) {          //like txt to get the kind of hte file 
        String extension = "";
        
        int i = fileName.lastIndexOf('.');
        int p = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));
        
        if (i > p) {
            extension = fileName.substring(i + 1);
        }
        
        return extension;
    }
}