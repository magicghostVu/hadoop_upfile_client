/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import utils.FileSelectStatus;
import utils.FileUploadUtils;
import utils.GlobalStatus;
import constants.ClientConstants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 *
 * @author magic_000
 */
public final class MainUI extends javax.swing.JFrame {

    /**
     * Creates new form MainUI
     */
    public MainUI() {
        initComponents();
        this.setResizable(false);
        setGlobalStatus(GlobalStatus.NOT_CONNECT);
        setFileSelectStatus(FileSelectStatus.NOT_SELECTED);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textFieldUrlMaster = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textFieldPort = new javax.swing.JTextField();
        btn_testConnect = new javax.swing.JButton();
        labelStatus = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_selectFile = new javax.swing.JButton();
        btn_upload = new javax.swing.JButton();
        progressUpFile = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("URL Master");

        textFieldUrlMaster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldUrlMasterActionPerformed(evt);
            }
        });

        jLabel2.setText("Port");

        btn_testConnect.setText("Test Connection");
        btn_testConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_testConnectActionPerformed(evt);
            }
        });

        labelStatus.setText("Message here");

        jLabel4.setText("Path to File");

        btn_selectFile.setText("Select File");
        btn_selectFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selectFileActionPerformed(evt);
            }
        });

        btn_upload.setText("Upload to server");
        btn_upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_uploadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_upload)
                    .addComponent(btn_selectFile)
                    .addComponent(jLabel4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                        .addComponent(btn_testConnect))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldUrlMaster)
                            .addComponent(textFieldPort, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)))
                    .addComponent(progressUpFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textFieldUrlMaster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(textFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_testConnect)
                    .addComponent(labelStatus))
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addComponent(btn_selectFile)
                .addGap(26, 26, 26)
                .addComponent(btn_upload)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressUpFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldUrlMasterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldUrlMasterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldUrlMasterActionPerformed

    private void btn_selectFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selectFileActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int res = chooser.showOpenDialog(this);
        if (res == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            System.out.println("selected file :" + selectedFile.getAbsolutePath());
            jLabel4.setText(selectedFile.getAbsolutePath());
            setFileSelectStatus(FileSelectStatus.SELECTED);
            setFileSelected(selectedFile);
        }

    }//GEN-LAST:event_btn_selectFileActionPerformed

    private void btn_testConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_testConnectActionPerformed
        // TODO add your handling code here:
        try {
            Socket sc = new Socket(textFieldUrlMaster.getText(), Integer.parseInt(textFieldPort.getText()));
            System.out.println("Connect success");
            String hdfsUlr = textFieldUrlMaster.getText();
            setHadoopFileSystem(FileUploadUtils.getFileSystemFromConfig(hdfsUlr, Integer.parseInt(textFieldPort.getText())));
            setGlobalStatus(GlobalStatus.CONNECTED);
        } catch (NumberFormatException | IOException E) {
            System.out.println("Cannot connect to server");
            this.labelStatus.setText(ClientConstants.ERR_CONN);
            setGlobalStatus(GlobalStatus.NOT_CONNECT);
        }

    }//GEN-LAST:event_btn_testConnectActionPerformed

    private void btn_uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_uploadActionPerformed
        // TODO add your handling code here:
        //upload to server will be handled here
        //FileSystem hdfs = this.getHadoopFileSystem();
        try {
            FileInputStream fis = new FileInputStream(getFileSelected());
            BufferedInputStream bis = new BufferedInputStream(fis);
            byte[] buffer = new byte[2048];
            double fileSize = getFileSelected().length();
            
            FSDataOutputStream fSDataOutputStream= getHadoopFileSystem().create(new Path("/data/"+ getFileSelected().getName()));
            
            new Thread(() -> {
                try {
                    int totalByteRead = 0;
                    while (true) {
                        int sizeRead = bis.read(buffer);
                        if (sizeRead < 0 ) {
                            break;
                        }
                        totalByteRead += sizeRead;
                        int valueProgress=(int)(totalByteRead/fileSize*100);

                        this.progressUpFile.setValue(valueProgress);
                        System.out.println("progress : "+ valueProgress);

                        fSDataOutputStream.write(buffer);
                        System.out.println(totalByteRead);
                    }
                    fSDataOutputStream.close();
                    this.setGlobalStatus(GlobalStatus.DONE_UPLOAD);
                    this.labelStatus.setText(this.getGlobalStatus().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }).start();
            this.setGlobalStatus(GlobalStatus.UPLOADING);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btn_uploadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            /*for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
             if ("Nimbus".equals(info.getName())) {
             javax.swing.UIManager.setLookAndFeel(info.getClassName());
             break;
             }
             }*/
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new MainUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_selectFile;
    private javax.swing.JButton btn_testConnect;
    private javax.swing.JButton btn_upload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JProgressBar progressUpFile;
    private javax.swing.JTextField textFieldPort;
    private javax.swing.JTextField textFieldUrlMaster;
    // End of variables declaration//GEN-END:variables
    GlobalStatus globalStatus;
    FileSelectStatus fileSelectStatus;
    FileSystem hadoopFileSystem;
    File fileSelected;

    public GlobalStatus getGlobalStatus() {
        return globalStatus;
    }

    public void setGlobalStatus(GlobalStatus status) {
        if (status == GlobalStatus.NOT_CONNECT) {
            btn_selectFile.setEnabled(false);
            btn_upload.setEnabled(false);
        } else if (status == GlobalStatus.CONNECTED) {
            btn_selectFile.setEnabled(true);
        }
        else if(status==GlobalStatus.UPLOADING){
            btn_selectFile.setEnabled(false);
            btn_upload.setEnabled(false);
            btn_testConnect.setEnabled(false);
        }else if(status== GlobalStatus.DONE_UPLOAD){
            btn_selectFile.setEnabled(true);
            btn_upload.setEnabled(true);
            btn_testConnect.setEnabled(true);
        }
        this.globalStatus = status;
        this.labelStatus.setText(status.toString());
    }

    public FileSelectStatus getFileSelectStatus() {
        return fileSelectStatus;
    }

    public void setFileSelectStatus(FileSelectStatus fileSelectStatus) {
        if (fileSelectStatus == FileSelectStatus.NOT_SELECTED) {
            btn_upload.setEnabled(false);
        } else {
            btn_upload.setEnabled(true);
        }
        this.fileSelectStatus = fileSelectStatus;
    }

    public FileSystem getHadoopFileSystem() {
        return hadoopFileSystem;
    }

    public void setHadoopFileSystem(FileSystem hadoopFileSystem) {
        this.hadoopFileSystem = hadoopFileSystem;
    }

    public File getFileSelected() {
        return fileSelected;
    }

    public void setFileSelected(File fileSelected) {
        this.fileSelected = fileSelected;
    }

}
