/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uiuUMS;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author MeRiDa
 */
public class AdminCreateTrimester extends javax.swing.JFrame {

    Connection cnn;
    ResultSet res;
    PreparedStatement pst;
    /**
     * Creates new form AdminCreateTrimester
     */
    public AdminCreateTrimester() {
        super("Create New Trimester");
        initComponents();
        cnn = DBconnection.Connecrdb();
        setLocationRelativeTo(null);
        super.setResizable(false);
    }
    
    private void updateTrimester(){
        try{
            String currentBatch = txtBatch.getText();
            int id = 1;
            String sql1 = "update ExtraInfo set Batch='"+currentBatch+"'";
            pst = cnn.prepareStatement(sql1);
            pst.execute();
            pst.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void getResult(String currentStudent, String currentBatch, int completedTrimester, double gpaSum, int completedCredit){
            try{   
                pst.close();
                res.close();
                String sql1 = "select * from StudentResultHistory where Student = '"+currentStudent+"' and Batch = '"+currentBatch+"'";
                pst = cnn.prepareStatement(sql1);
                res = pst.executeQuery();
                double pointSum = 0;
                int creditSum = 0;
                int check = 0;
                while(res.next()){
                    String stringPoint = res.getString(7);
                    String stringCredit = res.getString(5);
                    int credit = Integer.parseInt(stringCredit);
                    double point = Double.parseDouble(stringPoint);
                    pointSum += (credit*point);
                    creditSum += credit;
                    check = 1;
                }
                if(check == 1){
                    double GPA = pointSum/creditSum;
                    gpaSum += GPA;
                    completedCredit += creditSum;
                    double CGPA = gpaSum / completedTrimester;
                    CGPA =Double.parseDouble(new DecimalFormat("##.##").format(CGPA));
                    pst.close();
                    res.close();
                    String sql3 = "update StudentList set CompletedTrimester='"+completedTrimester+"',CompletedCredit='"+completedCredit+"',CGPA='"+CGPA+"',GPAsum='"+gpaSum+"'where Username='"+currentStudent+"'";
                    pst = cnn.prepareStatement(sql3);
                    pst.execute();
                    pst.close();
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
    }
    
    private void updateFaculty(){
        try{
            int id = 1;
            String sql = "select * from ExtraInfo where row='"+id+"'";
            pst = cnn.prepareStatement(sql);
            res = pst.executeQuery();
            String stringtotalCourse = res.getString(5);
            int totalCourse = Integer.parseInt(stringtotalCourse);
            pst.close();
            res.close();
            
            String none = " ";
            int empty = 0;
            for(int i=1; i<=totalCourse; i++){
                String sql1 = "update CourseList set Faculty='"+none+"', Batch='"+none+"', TotalStudent='"+empty+"' where rowid='"+i+"'";
                pst = cnn.prepareStatement(sql1);
                pst.execute();
                pst.close();
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void updateStudent(){
        try{
            int id = 1;
            String sql2 = "select * from ExtraInfo where row='"+id+"'";
            pst = cnn.prepareStatement(sql2);
            res = pst.executeQuery();
            String currentBatch = res.getString(3);
            res.close();
            pst.close();
            
            String sql = "select * from StudentList";
            PreparedStatement pst1 = cnn.prepareStatement(sql);
            ResultSet res1 = pst1.executeQuery();
        
            while (res1.next())
            {
                String currentStudent = res1.getString(14);
                String stringTrimester = res1.getString(11);
                int completedTrimester = (Integer.parseInt(stringTrimester)) + 1;
                String stringgpa = res1.getString(16);
                double gpaSum = Double.parseDouble(stringgpa);
                String stringCredit1 = res1.getString(12);
                int completedCredit = Integer.parseInt(stringCredit1);
                getResult(currentStudent, currentBatch, completedTrimester,gpaSum, completedCredit);
            }
            res1.close();
            pst1.close();
        }
        catch(Exception e)
        {
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

        jOptionPane1 = new javax.swing.JOptionPane();
        jFrame1 = new javax.swing.JFrame();
        jDialog1 = new javax.swing.JDialog();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTrimester = new javax.swing.JLabel();
        txtYear = new javax.swing.JTextField();
        lblBatch = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblRegDate = new javax.swing.JLabel();
        lblEndDate = new javax.swing.JLabel();
        lblYear = new javax.swing.JLabel();
        txtBatch = new javax.swing.JTextField();
        lblStartDate = new javax.swing.JLabel();
        lblWithdrawDate = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 4));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 2), "Create New Trimester", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 102, 153))); // NOI18N

        lblTrimester.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTrimester.setText("Trimester");

        lblBatch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblBatch.setText("Batch");

        jButton1.setText("Create Trimester");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblRegDate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblRegDate.setText("Registration Deadline");

        lblEndDate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEndDate.setText("End Date");

        lblYear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblYear.setText("Year");

        lblStartDate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblStartDate.setText("Start Date");

        lblWithdrawDate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblWithdrawDate.setText("Withdraw Deadline");

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<None>", "Spring", "Summer", "Fall" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBatch)
                            .addComponent(lblTrimester)
                            .addComponent(lblYear)
                            .addComponent(lblStartDate)
                            .addComponent(lblEndDate)
                            .addComponent(lblRegDate)
                            .addComponent(lblWithdrawDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtYear, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBatch, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBatch)
                    .addComponent(txtBatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTrimester)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblYear)
                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStartDate)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEndDate)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRegDate)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWithdrawDate)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
            String d1 = ((JTextField) jDateChooser1.getDateEditor().getUiComponent()).getText();
            String d2 = ((JTextField) jDateChooser2.getDateEditor().getUiComponent()).getText();
            String d3 = ((JTextField) jDateChooser3.getDateEditor().getUiComponent()).getText();
            String d4 = ((JTextField) jDateChooser4.getDateEditor().getUiComponent()).getText();
            if (txtBatch.getText().isEmpty() || jComboBox1.getSelectedIndex() == 0 || txtYear.getText().isEmpty() || d1.equals("") || d2.equals("") || d3.equals("") || d4.equals(""))
                JOptionPane.showMessageDialog(null, "Invalid Input.", null, JOptionPane.ERROR_MESSAGE);
            else{
                String sql = "Insert into TrimesterList (Batch, Trimester, Year, StartDate, EndDate, RegistrationDate, WithdrawDate) values (?,?,?,?,?,?,?)";
                pst = cnn.prepareStatement(sql);
                pst.setString(1, txtBatch.getText());
                pst.setString(2, jComboBox1.getSelectedItem().toString());
                pst.setString(3, txtYear.getText());
                pst.setString(4, ((JTextField) jDateChooser1.getDateEditor().getUiComponent()).getText());
                pst.setString(5, ((JTextField) jDateChooser2.getDateEditor().getUiComponent()).getText());
                pst.setString(6, ((JTextField) jDateChooser3.getDateEditor().getUiComponent()).getText());
                pst.setString(7, ((JTextField) jDateChooser4.getDateEditor().getUiComponent()).getText());
                pst.execute();
                pst.close();
                updateStudent();
                updateTrimester();
                updateFaculty();
                JOptionPane.showMessageDialog(null, "New Trimester Created!");
                
                jDateChooser1.setCalendar(null);
                jDateChooser2.setCalendar(null);
                jDateChooser3.setCalendar(null);
                jDateChooser4.setCalendar(null);
                txtBatch.setText("");
                txtYear.setText("");
                jComboBox1.setSelectedIndex(0);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try{
                pst.close();
            }
            catch(Exception e)
            {
                
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        AdminHome ah = new AdminHome();
        ah.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
//            java.util.logging.Logger.getLogger(AdminCreateTrimester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AdminCreateTrimester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AdminCreateTrimester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AdminCreateTrimester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AdminCreateTrimester().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBatch;
    private javax.swing.JLabel lblEndDate;
    private javax.swing.JLabel lblRegDate;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblTrimester;
    private javax.swing.JLabel lblWithdrawDate;
    private javax.swing.JLabel lblYear;
    private javax.swing.JTextField txtBatch;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
