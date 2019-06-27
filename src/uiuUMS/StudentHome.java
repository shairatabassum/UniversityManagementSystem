/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uiuUMS;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import static java.sql.JDBCType.BLOB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static java.sql.Types.BLOB;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author MeRiDa
 */
public class StudentHome extends javax.swing.JFrame {

    Connection cnn;
    ResultSet res;
    PreparedStatement pst;
    /**
     * Creates new form StudentHome
     */
    public StudentHome() {
        super("Home");
        initComponents();
        cnn = DBconnection.Connecrdb();
        setLocationRelativeTo(null);
        personalInfo();
        super.setResizable(false);
        
    }
    
    private void ImageChange(){
        try{
            int id = 1;
            String sql2 = "select * from ExtraInfo where row='"+id+"'";
            pst = cnn.prepareStatement(sql2);
            res = pst.executeQuery();
            String currentUser = res.getString(2);
            pst.close();
            res.close();
            
            //get all info
            String a1 = null, a2 = null, a3 = null, a4 = null, a5 = null, a6 = null, a7 = null, a8 = null, a9 = null, a10 = null, a11 = null, a12 = null, a13 = null, a14 = null, a15 = null, a16 = null, a17;
            String sql = "select * from StudentList where Username = '"+currentUser+"'";
            pst = cnn.prepareStatement(sql);
            res = pst.executeQuery();
            if(res.next()){
                a1 = res.getString(1);
                a2 = res.getString(2);
                a3 = res.getString(3);
                a4 = res.getString(4);
                a5 = res.getString(5);
                a6 = res.getString(6);
                a7 = res.getString(7);
                a8 = res.getString(8);
                a9 = res.getString(9);
                a10 = res.getString(10);
                a11 = res.getString(11);
                a12 = res.getString(12);
                a13 = res.getString(13);
                a14 = res.getString(14);
                a15 = res.getString(15);
                a16 = res.getString(16);
                a17 = res.getString(17);
            }
            res.close();
            pst.close();
            
            //delete profile
            String sql3="Delete from StudentList where Username='"+currentUser+"' ";
            pst=cnn.prepareStatement(sql3);
            pst.execute();
            pst.close();
            
            //recreate profile with image
           String sql5 = "Insert into StudentList (Name,FatherName,MotherName,Address,Mobile,Email,DOB,BloodGroup,Department, Batch, CompletedTrimester, CompletedCredit, CGPA, Username, Password, GPAsum, Image) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = cnn.prepareStatement(sql5);
            pst.setString(1, a1);
            pst.setString(2, a2);
            pst.setString(3, a3);
            pst.setString(4, a4);
            pst.setString(5, a5);
            pst.setString(6, a6);
            pst.setString(7, a7);
            pst.setString(8, a8);
            pst.setString(9, a9);
            pst.setString(10, a10);
            pst.setString(11, a11);
            pst.setString(12, a12);
            pst.setString(13, a13);
            pst.setString(14, a14);
            pst.setString(15, a15);
            pst.setString(16, a16);
            pst.setBytes(17, personImage);
            pst.execute();
            pst.close();
                
            JOptionPane.showMessageDialog(null, "Image Changed.");
            personalInfo();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void personalInfo()
    {
        try{
            int id = 1;
            String sql2 = "select * from ExtraInfo where row='"+id+"'";
            pst = cnn.prepareStatement(sql2);
            res = pst.executeQuery();
            String currentUser = res.getString(2);
            res.close();
            pst.close();
            String sql = "select * from StudentList where Username = '"+currentUser+"'";
            pst = cnn.prepareStatement(sql);
            res = pst.executeQuery();
            if(res.next())
            {
                String add1 = res.getString("Name");
                lblshowName.setText(add1);
                String add2 = res.getString("Username");
                lblshowID.setText(add2);
                String add3 = res.getString("Department");
                lblshowDepartment.setText(add3);
                String add4 = res.getString("Batch");
                lblshowBatch.setText(add4);
                String add5 = res.getString("CompletedTrimester");
                lblshowCompletedTrimester.setText(add5);
                String add6 = res.getString("CompletedCredit");
                lblshowCompletedCredit.setText(add6);
                String add7 = res.getString("CGPA");
                lblshowCGPA.setText(add7);
                
                byte[] imagedata = res.getBytes("Image");
                format = new ImageIcon(imagedata);
                if(!format.equals(null)){
                Image.setIcon(format);}
                
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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblshowDepartment = new javax.swing.JLabel();
        lblCGPA = new javax.swing.JLabel();
        lblshowCGPA = new javax.swing.JLabel();
        lblDepartment = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblCompletedCredit = new javax.swing.JLabel();
        lblshowBatch = new javax.swing.JLabel();
        lblCompletedTrimester = new javax.swing.JLabel();
        lblshowCompletedTrimester = new javax.swing.JLabel();
        lblshowCompletedCredit = new javax.swing.JLabel();
        lblshowName = new javax.swing.JLabel();
        lblBatch = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblshowID = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Image = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 4));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 3), "Academic Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(0, 102, 153))); // NOI18N

        lblshowDepartment.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblshowDepartment.setForeground(new java.awt.Color(0, 102, 153));
        lblshowDepartment.setText("jLabel2");

        lblCGPA.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblCGPA.setText("CGPA");

        lblshowCGPA.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblshowCGPA.setForeground(new java.awt.Color(0, 102, 153));
        lblshowCGPA.setText("jLabel6");

        lblDepartment.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblDepartment.setText("Department");

        lblName.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblName.setText("Name");

        lblCompletedCredit.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblCompletedCredit.setText("Completed Credit");

        lblshowBatch.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblshowBatch.setForeground(new java.awt.Color(0, 102, 153));
        lblshowBatch.setText("jLabel3");

        lblCompletedTrimester.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblCompletedTrimester.setText("Completed Trimester");

        lblshowCompletedTrimester.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblshowCompletedTrimester.setForeground(new java.awt.Color(0, 102, 153));
        lblshowCompletedTrimester.setText("jLabel4");

        lblshowCompletedCredit.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblshowCompletedCredit.setForeground(new java.awt.Color(0, 102, 153));
        lblshowCompletedCredit.setText("jLabel5");

        lblshowName.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblshowName.setForeground(new java.awt.Color(0, 102, 153));
        lblshowName.setText("jLabel1");

        lblBatch.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblBatch.setText("Batch");

        lblID.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblID.setText("ID");

        lblshowID.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblshowID.setForeground(new java.awt.Color(0, 102, 153));
        lblshowID.setText("jLabel1");

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153)));

        Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uiuUMS/icon/Profile.png"))); // NOI18N
        Image.setText("                                ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Image, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Image, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Change Image");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName)
                    .addComponent(lblID)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCompletedCredit)
                            .addComponent(lblCompletedTrimester)
                            .addComponent(lblCGPA)
                            .addComponent(lblDepartment)
                            .addComponent(lblBatch))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblshowID, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(lblshowName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblshowBatch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(lblshowDepartment, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(lblshowCompletedTrimester, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblshowCompletedCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblshowCGPA, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(lblshowName))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblID)
                            .addComponent(lblshowID))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDepartment)
                            .addComponent(lblshowDepartment))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBatch)
                            .addComponent(lblshowBatch))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCompletedTrimester)
                            .addComponent(lblshowCompletedTrimester))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCompletedCredit)
                            .addComponent(lblshowCompletedCredit))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCGPA)
                    .addComponent(lblshowCGPA)
                    .addComponent(jButton1))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uiuUMS/icon/Student Registration.png"))); // NOI18N
        jLabel1.setText("      Registration");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uiuUMS/icon/Student Profile.png"))); // NOI18N
        jLabel2.setText("      Personal Info");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uiuUMS/icon/Student Current Trimester.png"))); // NOI18N
        jLabel3.setText("   Current Trimester");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uiuUMS/icon/Student Result History.png"))); // NOI18N
        jLabel4.setText("       Result History");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uiuUMS/icon/Student Inbox.png"))); // NOI18N
        jLabel5.setText("      Inbox");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uiuUMS/icon/Change Password 2.png"))); // NOI18N
        jLabel6.setText("  Change Password");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uiuUMS/icon/Logout 2.png"))); // NOI18N
        jLabel7.setText("      Logout");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        StudentRegistration sr = new StudentRegistration();
        sr.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        StudentProfile sp = new StudentProfile();
        sp.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        StudentCurrentTrimester sct = new StudentCurrentTrimester();
        sct.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        StudentResultHistory sr = new StudentResultHistory();
        sr.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        StudentInbox sr = new StudentInbox();
        sr.setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        ChangePassword cp = new ChangePassword();
        cp.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        Login l = new Login();
        l.setVisible(true);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Perfect image pixel : 130 x 130");
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        FileName = f.getAbsolutePath();
        
        try{
            File image = new File(FileName);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for(int i; (i=fis.read(buf)) != -1; ){
                bos.write(buf, 0, i);
            }
            personImage = bos.toByteArray();
            ImageChange();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
//            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new StudentHome().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Image;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblBatch;
    private javax.swing.JLabel lblCGPA;
    private javax.swing.JLabel lblCompletedCredit;
    private javax.swing.JLabel lblCompletedTrimester;
    private javax.swing.JLabel lblDepartment;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblshowBatch;
    private javax.swing.JLabel lblshowCGPA;
    private javax.swing.JLabel lblshowCompletedCredit;
    private javax.swing.JLabel lblshowCompletedTrimester;
    private javax.swing.JLabel lblshowDepartment;
    private javax.swing.JLabel lblshowID;
    private javax.swing.JLabel lblshowName;
    // End of variables declaration//GEN-END:variables
    private ImageIcon format = null;
    String FileName = null;
    int s = 0;
    byte[] personImage = null;
}
