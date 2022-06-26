/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Pkkg
 */
public class Add_User extends javax.swing.JFrame {

    /**
     * Creates new form Add_User
     */
    public Add_User() {
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

        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        lbl_type = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        chk_show = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        cmb_type = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        txt_cpassword = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableuser = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txt_delete_username = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_address = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_tele = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(45, 118, 232));

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Kelso Lanka(Pvt)Ltd.");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/navigation.png"))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sales Management");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Webp.net-resizeimage (3).png"))); // NOI18N

        lbl_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_name.setText("Username");

        lbl_type.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_type.setText("Type");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_type)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_type)
                            .addComponent(lbl_name)))))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setText("Create User");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        chk_show.setBackground(new java.awt.Color(255, 255, 255));
        chk_show.setText("Show Password");
        chk_show.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chk_showStateChanged(evt);
            }
        });
        chk_show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_showActionPerformed(evt);
            }
        });

        jLabel7.setText("Confirm Password");

        cmb_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Administrator" }));

        jLabel9.setText("Type");

        jLabel8.setText("Password");

        jLabel6.setText("Email");

        jLabel5.setText("Username");

        jLabel4.setText("Full Name");

        txt_password.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txt_cpassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        tableuser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Name ", "Username", "Address", "Telephone", "Email", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableuserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableuser);
        if (tableuser.getColumnModel().getColumnCount() > 0) {
            tableuser.getColumnModel().getColumn(0).setResizable(false);
            tableuser.getColumnModel().getColumn(1).setResizable(false);
            tableuser.getColumnModel().getColumn(2).setResizable(false);
            tableuser.getColumnModel().getColumn(3).setResizable(false);
            tableuser.getColumnModel().getColumn(4).setResizable(false);
            tableuser.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backnew.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel10.setText("Username");

        jButton3.setText("Delete User");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txt_delete_username.setEditable(false);

        jLabel12.setText("Address");

        jLabel13.setText("Telephone");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jButton2))
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tele, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_type, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chk_show))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txt_delete_username, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_delete_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(45, 45, 45)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addComponent(jLabel5))
                            .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txt_tele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txt_cpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(cmb_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(66, 66, 66)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(244, 244, 244)
                                .addComponent(chk_show))))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
void delete_user()
{
    try 
            {
                Connection con = DB.createConnection();
                String sql = "delete from users where username='"+txt_delete_username.getText()+"'";
                PreparedStatement stmt = con.prepareStatement(sql);
                int i = stmt.executeUpdate();

                if (i == 1) 
                {
                    JOptionPane.showMessageDialog(this, "Successfully Deleted the User. Now Please Login", "Done", JOptionPane.PLAIN_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Cannot Delete the User. Try Again","Error  ",JOptionPane.ERROR_MESSAGE);
                }

            } 
            
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(this,"Database Error. Please Try Again","Database Error",JOptionPane.ERROR_MESSAGE);
            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(this,"Please Try Again","Error  " + e,JOptionPane.ERROR_MESSAGE);
            }
}
    void view() throws Exception
{
    try
        {
         
       Connection con = DB.createConnection();
                Statement st = con.createStatement();
                String sql = "select Name,Username,Address,Telephone,Email,Password from users where category='user'";
        ResultSet rst = st.executeQuery(sql);
         
         DefaultTableModel model=new DefaultTableModel(new String[]{"Name","Username","Address","Telephone","Email","Password"},0);
         
          while (rst.next()){
         Vector vec = new Vector();
         
         vec.add(rst.getString("Name"));
         vec.add(rst.getString("Username"));
         vec.add(rst.getString("Address"));
         vec.add(rst.getString("Telephone"));
         vec.add(rst.getString("Email"));
         vec.add(rst.getString("Password"));

        
         model.addRow(vec);
         tableuser.setModel(model);
        
          
         }
         
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Database Error !!");
        }
}
    void create_user()
{
    try 
            {
                Connection con = DB.createConnection();
                String sql = "INSERT INTO users (Name ,Username,Password,Address,Telephone,Email,Category) VALUES ('" + txt_name.getText() + "', '" + txt_username.getText() + "' , '" + txt_password.getText() + "','" + txt_address.getText() + "','" + txt_tele.getText() + "','" + txt_email.getText() + "','" + cmb_type.getSelectedItem()+ "')";
                PreparedStatement stmt = con.prepareStatement(sql);
                int i = stmt.executeUpdate();

                if (i == 1) 
                {
                    JOptionPane.showMessageDialog(this, "Successfully Created a New User. Now Please Login", "Done", JOptionPane.PLAIN_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Cannot Create a User. Try Again","Error  ",JOptionPane.ERROR_MESSAGE);
                }

            } 
            catch(SQLIntegrityConstraintViolationException e)
            {
                JOptionPane.showMessageDialog(this,"You Entered Username already exist","Duplicate Found",JOptionPane.INFORMATION_MESSAGE);
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(this,"Database Error. Please Try Again","Database Error",JOptionPane.ERROR_MESSAGE);
            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(this,"Please Try Again","Error  " + e,JOptionPane.ERROR_MESSAGE);
            }
            
}
void vali()
{
    if (txt_username.getText().equals(""))
    {
                            JOptionPane.showMessageDialog(this,"Username cannot be blank","Error  ",JOptionPane.ERROR_MESSAGE);
    }
    else if(txt_name.getText().equals(""))
    {
                            JOptionPane.showMessageDialog(this,"Name cannot be blank","Error  ",JOptionPane.ERROR_MESSAGE);
    }
    else if(txt_email.getText().equals(""))
    {
                            JOptionPane.showMessageDialog(this,"Email cannot be blank","Error  ",JOptionPane.ERROR_MESSAGE);
    }
    else if(txt_password.getText().equals(""))
    {
                           JOptionPane.showMessageDialog(this,"Password cannot be blank","Error  ",JOptionPane.ERROR_MESSAGE);
    }
    else if(txt_cpassword.getText().equals(""))
    {
                            JOptionPane.showMessageDialog(this,"Confirm Password cannot be blank","Error  ",JOptionPane.ERROR_MESSAGE);
    }
    else if(txt_address.getText().equals(""))
    {
                            JOptionPane.showMessageDialog(this,"Address cannot be blank","Error  ",JOptionPane.ERROR_MESSAGE);
    }
    else if(txt_tele.getText().equals(""))
    {
                           JOptionPane.showMessageDialog(this,"Telephone cannot be blank","Error  ",JOptionPane.ERROR_MESSAGE);
    }
      else if(!Pattern.matches("[a-zA-Z]+", txt_name.getText()))
 {
       JOptionPane.showMessageDialog(this,"Name Cannot Be a Number","Error  ",JOptionPane.ERROR_MESSAGE);
 }
   
    
    
    else if (!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", txt_email.getText())))
    {
                 JOptionPane.showMessageDialog(this,"This Email is not Valid !!","Error  ",JOptionPane.ERROR_MESSAGE);
    }
    else if(!Pattern.matches("^(?:0|94|\\+94|0094)?(?:(11|21|23|24|25|26|27|31|32|33|34|35|36|37|38|41|45|47|51|52|54|55|57|63|65|66|67|81|91)(0|2|3|4|5|7|9)|7(0|1|2|5|6|7|8)\\d)\\d{6}$", txt_tele.getText()))
    {
         JOptionPane.showMessageDialog(this,"This Telephone Number is InValid !!","Error  ",JOptionPane.ERROR_MESSAGE);
    }
    else
    {
        
        create_user();
    }
}
void clear()
{
    txt_address.setText("");
    txt_cpassword.setText("");
    txt_email.setText("");
    txt_name.setText("");
    txt_password.setText("");
    txt_tele.setText("");
    txt_username.setText("");
}
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        vali();  
try {
            view();// TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(Add_User.class.getName()).log(Level.SEVERE, null, ex);
        }
clear();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
delete_user();    
        try {
            view();// TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(Add_User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        get_user_details();
        new Admin_Menu(name, type).setVisible(true);     
        this.dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            view();
        } catch (Exception ex) {
            Logger.getLogger(Add_User.class.getName()).log(Level.SEVERE, null, ex);
        }
        get_user_details();
        get_user_details();        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void chk_showStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chk_showStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_showStateChanged

    private void chk_showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_showActionPerformed
        if(chk_show.isSelected())
        {
            txt_password.setEchoChar((char)0);
            txt_cpassword.setEchoChar((char)0);

        }
        else
        {
            txt_password.setEchoChar('\u25cf');
            txt_cpassword.setEchoChar('\u25cf');
        }
    }//GEN-LAST:event_chk_showActionPerformed

    private void tableuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableuserMouseClicked
 int i = tableuser.getSelectedRow();
        TableModel model = tableuser.getModel();
        txt_delete_username.setText(model.getValueAt(i, 1).toString());        // TODO add your handling code here:
    }//GEN-LAST:event_tableuserMouseClicked
String name,type;
    void get_user_details()
    {
        name=lbl_name.getText();
        type=lbl_type.getText();
    }
    public Add_User(String name,String type)
    {
         initComponents();
       lbl_name.setText(name);
       lbl_type.setText(type);
       lbl_name.setVisible(true);
       lbl_type.setVisible(true);
        
    }
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
            java.util.logging.Logger.getLogger(Add_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chk_show;
    private javax.swing.JComboBox<String> cmb_type;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_type;
    private javax.swing.JTable tableuser;
    private javax.swing.JTextField txt_address;
    private javax.swing.JPasswordField txt_cpassword;
    private javax.swing.JTextField txt_delete_username;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_name;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_tele;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
