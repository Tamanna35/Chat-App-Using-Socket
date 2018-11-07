package app.chating;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ClientServer extends javax.swing.JFrame implements Runnable{
    Socket client;//class socket
    ServerSocket server;//class connect server
    BufferedReader Server_Reader,Client_Reader;//class buffer read String
    BufferedWriter Server_Writer,Client_Writer;
    /**
     * Creates new form ClientServer
     */
    public ClientServer() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBon = new javax.swing.JButton();
        jBabout = new javax.swing.JButton();
        jCBserver = new javax.swing.JComboBox<>();
        jTusername = new javax.swing.JTextField();
        Lchat = new java.awt.List();
        jTchat = new javax.swing.JTextField();
        jBsend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jBon.setBackground(new java.awt.Color(0, 51, 255));
        jBon.setText("ON");
        jBon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBonActionPerformed(evt);
            }
        });

        jBabout.setBackground(new java.awt.Color(0, 102, 204));
        jBabout.setText("About");

        jCBserver.setBackground(new java.awt.Color(0, 51, 255));
        jCBserver.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SERVER", "CLIENT" }));
        jCBserver.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBserverItemStateChanged(evt);
            }
        });
        jCBserver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBserverActionPerformed(evt);
            }
        });

        jTusername.setText("Username");

        Lchat.setBackground(new java.awt.Color(0, 153, 153));
        Lchat.setForeground(new java.awt.Color(255, 0, 51));
        Lchat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LchatActionPerformed(evt);
            }
        });

        jTchat.setText("Text Message");

        jBsend.setBackground(new java.awt.Color(0, 102, 255));
        jBsend.setText("Send");
        jBsend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTusername)
            .addComponent(Lchat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jCBserver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(jBon, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBabout, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jTchat, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBsend, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBon)
                    .addComponent(jCBserver)
                    .addComponent(jBabout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTusername, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(Lchat, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTchat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBsend, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void client_connection(){
        try{
            String ip=JOptionPane.showInputDialog("IP Address: ");
            client=new Socket(ip,2000);
            jCBserver.setEnabled(false);
            Server_Reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
            Server_Writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            jBon.setText("DISCONNECT");
        }catch (UnknownHostException ex){
            System.out.println("Accept Failed");
            System.exit(-1);
        }catch (IOException ex){
            Logger.getLogger(ClientServer.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    private void read_connection(){
        try{
            try{
                try{
                    server=new ServerSocket(2000);
                    this.setTitle("Please wait...");
                }catch(Exception ex){
                    System.out.println("Could not listen");
                    System.exit(-1);
                }
                client=server.accept();
                this.setTitle("CONNECTED "+client.getInetAddress());
            }catch (IOException ex){
                System.out.println("Accept Failed");
                System.exit(-1);
            }
            Server_Reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
            Server_Writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        }catch (IOException ex){
            System.out.println("Read Failed");
            System.exit(-1);
        }
    }
    
    private void disconnected_by_client(){
        try{
            client.close();
            Server_Reader.close();
            Server_Writer.close();
            jCBserver.setEnabled(true);
            jBon.setText("CONNECT");    
        }catch (IOException ex){
            Logger.getLogger(ClientServer.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    private void stopped_by_server(){
        try{
            Server_Reader.close();
            Server_Writer.close();
            jBon.setText("ON");
            setTitle("DISCONNECT");
        }catch(IOException ex){
            Logger.getLogger(ClientServer.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    private void jCBserverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBserverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBserverActionPerformed

    private void jBonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBonActionPerformed
       if(jBon.getText().equals("CONNECT")){
            jBon.setText("DISCONNECT");
            client_connection();
            Thread thread=new Thread(this);
            thread.start();
        }else if(jCBserver.getSelectedItem().equals("SERVER")){
            jBon.setText("OFF");
            read_connection();
            Thread thread=new Thread(this);
            thread.start();
        }
    }//GEN-LAST:event_jBonActionPerformed

    private void jBsendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsendActionPerformed
        try{
            Server_Writer.write(jTusername.getText()+":"+jTchat.getText());
            Server_Writer.newLine();
            Server_Writer.flush();
        }catch (Exception ex){
            Logger.getLogger(ClientServer.class.getName()).log(Level.SEVERE,null,ex);
        }
        Lchat.add("Me : "+jTchat.getText());
        jTchat.setText("");
    }//GEN-LAST:event_jBsendActionPerformed

    private void jCBserverItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBserverItemStateChanged
         if(jCBserver.getSelectedItem().equals("SERVER")){
            jBon.setText("ON");
            jTusername.setText("SERVER");
        }else{
            jBon.setText("CONNECT");
            jTusername.setText("CLIENT");
        }
    }//GEN-LAST:event_jCBserverItemStateChanged

    private void LchatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LchatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LchatActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientServer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.List Lchat;
    private javax.swing.JButton jBabout;
    private javax.swing.JButton jBon;
    private javax.swing.JButton jBsend;
    private javax.swing.JComboBox<String> jCBserver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTchat;
    private javax.swing.JTextField jTusername;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while(true){
            try{
                Lchat.add(Server_Reader.readLine());
            }catch(IOException ex){
                Logger.getLogger(ClientServer.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }
}
