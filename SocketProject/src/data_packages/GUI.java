package data_packages;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author belal
 */
public final class GUI extends javax.swing.JFrame {

    public GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGlobal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDownload = new javax.swing.JTable();
        btnDownload = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        prgProgress = new javax.swing.JProgressBar();
        pnlLocal = new javax.swing.JPanel();
        txtShare = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        btnShare = new javax.swing.JButton();
        btnUnshare = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLocal = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        chkSpecific = new javax.swing.JCheckBox();
        pnlIP = new javax.swing.JPanel();
        txtIP = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("P2P");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlGlobal.setBorder(javax.swing.BorderFactory.createTitledBorder("Download Files"));

        tblDownload.setAutoCreateRowSorter(true);
        tblDownload.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Filename", "Size", "IP Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDownload.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblDownload);
        tblDownload.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDownload.getAccessibleContext().setAccessibleName("");

        btnDownload.setText("Download");
        btnDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        prgProgress.setForeground(new java.awt.Color(0, 204, 51));
        prgProgress.setStringPainted(true);

        javax.swing.GroupLayout pnlGlobalLayout = new javax.swing.GroupLayout(pnlGlobal);
        pnlGlobal.setLayout(pnlGlobalLayout);
        pnlGlobalLayout.setHorizontalGroup(
            pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGlobalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prgProgress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlGlobalLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlGlobalLayout.createSequentialGroup()
                        .addComponent(btnDownload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlGlobalLayout.setVerticalGroup(
            pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGlobalLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(btnDownload))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prgProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlLocal.setBorder(javax.swing.BorderFactory.createTitledBorder("Share Files"));

        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        btnShare.setText("Share");
        btnShare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShareActionPerformed(evt);
            }
        });

        btnUnshare.setText("Unshare Selected");
        btnUnshare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnshareActionPerformed(evt);
            }
        });

        tblLocal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Filename", "Size"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblLocal);
        tblLocal.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jLabel2.setText("Shared Files");

        chkSpecific.setText("to specific");

        javax.swing.GroupLayout pnlLocalLayout = new javax.swing.GroupLayout(pnlLocal);
        pnlLocal.setLayout(pnlLocalLayout);
        pnlLocalLayout.setHorizontalGroup(
            pnlLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLocalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLocalLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel2)
                        .addContainerGap(99, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLocalLayout.createSequentialGroup()
                        .addGroup(pnlLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUnshare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLocalLayout.createSequentialGroup()
                                .addGroup(pnlLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtShare)
                                    .addComponent(btnShare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(chkSpecific, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBrowse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        pnlLocalLayout.setVerticalGroup(
            pnlLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLocalLayout.createSequentialGroup()
                .addGroup(pnlLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtShare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowse))
                .addGap(3, 3, 3)
                .addGroup(pnlLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShare)
                    .addComponent(chkSpecific))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUnshare, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlIP.setBorder(javax.swing.BorderFactory.createTitledBorder("My IP"));

        txtIP.setEditable(false);
        txtIP.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout pnlIPLayout = new javax.swing.GroupLayout(pnlIP);
        pnlIP.setLayout(pnlIPLayout);
        pnlIPLayout.setHorizontalGroup(
            pnlIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtIP)
                .addContainerGap())
        );
        pnlIPLayout.setVerticalGroup(
            pnlIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlGlobal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlLocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlIP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlGlobal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //The first thing that gets launched.
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /*Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            myGUI = new GUI();
            myGUI.setLocationRelativeTo(null);
            new StartWorker().execute();
        });
    }
    //Everything before this line was created automatically by the designer.
    //
    //Stores a static version of this frame so we can access it from other classes
    public static GUI myGUI;
    Peer myPeer = new Peer();

    private void btnShareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShareActionPerformed
        if (txtShare.getText().isEmpty()) {
            return;
        }
        if (chkSpecific.isSelected()) {
            shareSpecific frm = new shareSpecific(this, true);

            frm.setLocationRelativeTo(this);
            //frm.setLocationByPlatform(true);

            frm.setVisible(true);
            String[] response = frm.getValue();
            frm.dispose();
            if (response == null || response.length == 0) {
                return;
            }

            myPeer.addFilesToLocalList(txtShare.getText(), response);

        } else {
            myPeer.addFilesToLocalList(txtShare.getText(), null);
        }
        txtShare.setText("");
        Helper.RefreshLocal();

    }//GEN-LAST:event_btnShareActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Choose files to share:");
        chooser.setMultiSelectionEnabled(true);
        if (chooser.showDialog(this, "Choose") == JFileChooser.APPROVE_OPTION) {
            StringBuilder st = new StringBuilder();

            for (File file : chooser.getSelectedFiles()) {
                st.append(file.getAbsolutePath());
                st.append("|");
            }
            st.deleteCharAt(st.length() - 1);
            txtShare.setText(st.toString());
        }

    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadActionPerformed
        int idx = tblDownload.getSelectedRow();
        if (idx == -1) {
            return;
        }

        JFileChooser chooser = new JFileChooser();
        chooser.setDialogType(JFileChooser.SAVE_DIALOG);
        chooser.setDialogTitle("Choose where you want to save the file: ");

        String path = myPeer.getAvailableFiles().get(idx).filename;
        String ext = Helper.getExtension(path);
        if (!ext.isEmpty()) {
            chooser.setFileFilter(new FileNameExtensionFilter(ext.toUpperCase() + " file", ext));
            ext = "." + ext;
        }

        if (chooser.showDialog(this, null) == JFileChooser.APPROVE_OPTION) {
            new DownloadWorker(idx, chooser.getSelectedFile().getAbsolutePath() + ext).execute();
        }

    }//GEN-LAST:event_btnDownloadActionPerformed

    private void btnUnshareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnshareActionPerformed
        int slc[] = tblLocal.getSelectedRows();
        myPeer.removeFromLocalList(slc);
        Helper.RefreshLocal();
    }//GEN-LAST:event_btnUnshareActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        myPeer.close();
    }//GEN-LAST:event_formWindowClosing

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        new RefreshWorker().execute();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //we need to do a few things before we start the program.

    }//GEN-LAST:event_formWindowOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnBrowse;
    protected javax.swing.JButton btnDownload;
    protected javax.swing.JButton btnRefresh;
    protected javax.swing.JButton btnShare;
    protected javax.swing.JButton btnUnshare;
    private javax.swing.JCheckBox chkSpecific;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlGlobal;
    private javax.swing.JPanel pnlIP;
    private javax.swing.JPanel pnlLocal;
    protected javax.swing.JProgressBar prgProgress;
    protected javax.swing.JTable tblDownload;
    protected javax.swing.JTable tblLocal;
    protected javax.swing.JTextField txtIP;
    protected javax.swing.JTextField txtShare;
    // End of variables declaration//GEN-END:variables
}