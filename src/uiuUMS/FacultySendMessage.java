/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uiuUMS;

import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
/**
 *
 * @author MeRiDa
 */
public class FacultySendMessage extends javax.swing.JFrame {

    Connection cnn;
    ResultSet res;
    PreparedStatement pst;
    
    public static String currentDate, currentTime;
    /**
     * Creates new form FacultySendMessage
     */
    public FacultySendMessage() {
        super("Send Message");
        initComponents();
        cnn = DBconnection.Connecrdb();
        setLocationRelativeTo(null);
        addItem();
        currentdate();
        clock();
        super.setResizable(false);
    }
    
    private void clock() {
        Thread tr = new Thread() {
            public void run() {
                for (;;) {
                    Calendar cal = new GregorianCalendar();
                    int hour = cal.get(Calendar.HOUR);
                    
                    int min = cal.get(Calendar.MINUTE);
                    String fixmin;
                    if(min<10)fixmin="0"+min;
                    else fixmin=""+min;
                    int second = cal.get(Calendar.SECOND);
                    String fixsec;
                    if(second<10)fixsec="0"+second;
                    else fixsec=""+second;
                  
                    currentTime = (hour + ":" + fixmin + ":" + fixsec);
                    try {
                        sleep(1000);

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, e);
                    }

                }

            }

        };
        tr.start();

    }

    private void currentdate() {
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int date = cal.get(Calendar.DAY_OF_MONTH);
        month = month+1;
        String monthName = "";
        if(month == 1)
            monthName = "Jan";
        else if(month == 2)
            monthName = "Feb";
        else if(month == 3)
            monthName = "Mar";
        else if(month == 4)
            monthName = "Apr";
        else if(month == 5)
            monthName = "May";
        else if(month == 6)
            monthName = "Jun";
        else if(month == 7)
            monthName = "Jul";
        else if(month == 8)
            monthName = "Aug";
        else if(month == 9)
            monthName = "Sep";
        else if(month == 10)
            monthName = "Oct";
        else if(month == 11)
            monthName = "Nov";
        else if(month == 12)
            monthName = "Dec";
        currentDate = (date + "-" + monthName + "-" + year);
    }
    
    private void addItem(){
        try{
            int id = 1;
            String sql2 = "select * from ExtraInfo where row='"+id+"'";
            pst = cnn.prepareStatement(sql2);
            res = pst.executeQuery();
            String currentUser = res.getString(4);
            String currentBatch = res.getString(3);
            res.close();
            pst.close();
            String sql = "select * from FacultyAllTrimesterHistory where Faculty='"+currentUser+"' and Batch='"+currentBatch+"'";
            pst = cnn.prepareStatement(sql);
            res = pst.executeQuery();
            while(res.next()){
                String courseID = res.getString(2);
                String courseTitle = res.getString(3);
                String add = courseID + " - " + courseTitle;
                jComboBox2.addItem(add);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void addItem2(){
        try{
            String sql1 = "select * from StudentList";
            pst = cnn.prepareStatement(sql1);
            res = pst.executeQuery();
            while(res.next()){
                String name = res.getString(1);
                String id = res.getString(14);
                String add = id + " - " + name;
                jComboBox1.addItem(add);
            }
            pst.close();
            res.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Student = new javax.swing.JLabel();
        btnSend = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 4));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 2), "Send Message", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(0, 102, 153))); // NOI18N

        Student.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Student.setText("Student");

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        lblMessage.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMessage.setText("Message");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jTextPane2);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("To");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<None>", "Other Students", "Course Students" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblMessage)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSend))
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(Student))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox2, 0, 266, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(15, 15, 15))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Student)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSend)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        FacultyHome fh = new FacultyHome();
        fh.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        try{
            if(jComboBox2.getSelectedIndex() == 0 || jTextPane2.getText().isEmpty() || jComboBox1.getItemCount() == 0)
                JOptionPane.showMessageDialog(null, "Invalid Input.", null, JOptionPane.ERROR_MESSAGE);
            else{
                int id = 1;
                String sql2 = "select * from ExtraInfo where row='"+id+"'";
                pst = cnn.prepareStatement(sql2);
                res = pst.executeQuery();
                String currentUserName = res.getString(4);
                res.close();
                pst.close();
                String sql = "Insert into StudentMessage (StudentID, Name, Message, Date, Time) values (?,?,?,?,?)";
                pst = cnn.prepareStatement(sql);
                String to = (String) jComboBox1.getSelectedItem();
                String[] words = to.split(" ");
                pst.setString(1, words[0]);
                pst.setString(2, currentUserName);
                pst.setString(3, jTextPane2.getText());
                pst.setString(4, currentDate);
                pst.setString(5, currentTime);

                pst.execute();
                JOptionPane.showMessageDialog(null, "Message Sent!");
                jTextPane2.setText("");
                jComboBox2.setSelectedIndex(0);
                res.close();
                pst.close();
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try{
                res.close();
                pst.close();
            }
            catch(Exception e)
            {
                
            }
        }
    }//GEN-LAST:event_btnSendActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        if(jComboBox2.getSelectedIndex() == 1){
            jComboBox1.removeAllItems();
            addItem2();
        }
        else if(jComboBox2.getSelectedIndex() == 2){
            jComboBox1.removeAllItems();
            addItem();
        }
        else if(jComboBox2.getSelectedIndex() == 0){
            jComboBox1.removeAllItems();
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FacultySendMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FacultySendMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FacultySendMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FacultySendMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FacultySendMessage().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Student;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JLabel lblMessage;
    // End of variables declaration//GEN-END:variables
}
