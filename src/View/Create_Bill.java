/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.DB;
import java.awt.Container;
import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Pattern;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Pkkg
 */
public class Create_Bill extends javax.swing.JFrame {

    /**
     * Creates new form Create_Bill
     */
    public Create_Bill() {
        initComponents();
    }
    Connection con;
public Create_Bill(String name,String type)
{
    initComponents();
       lbl_name.setText(name);
       lbl_type.setText(type);
       lbl_name.setVisible(true);
       lbl_type.setVisible(true);
}
void get_date()
{
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
    Date date = new Date();  
    txt_date.setText(formatter.format(date));  
}
 String name,type;
    void get_user_details()
    {
        name=lbl_name.getText();
        type=lbl_type.getText();
    }
    int payment,balance;
    void final_cal()
    {
        try
        { payment=Integer.parseInt(txt_payment.getText());
    balance=payment-net_total;
    txt_balance.setText(Integer.toString(balance));
            
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this,"Payment Cannot Include Letters");
        }
   
    
        
    }
    void next_mileage()
    {
        try
        {
            int mileage=Integer.parseInt(txt_mieage.getText());
        int next_service;
        next_service=mileage+3000;
        txt_next_service.setText(Integer.toString(next_service));
        }
        catch(Exception ex)
            
        {
           JOptionPane.showMessageDialog(this,"Milage Cannot Include Letters");
        }
        
        
    }
    String vehicle_type,wash_type,wash_name,service_name_cal,service_id,service_cat;
    int service_price,previous_service_price,washprice,previous_wash_price;
    void vehicle_type() throws SQLException
    {vehicle_type=cmb_type.getSelectedItem().toString();
    
     try{
             con = DB.createConnection();
                Statement stmt = con.createStatement();
                String sql = "select Service_id,Service_name,service_category,service_price from service where Service_name='"+cmb_type.getSelectedItem().toString()+"' and service_category='Service'";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next())
                {    service_name_cal=rs.getString("Service_name");
                     service_id=rs.getString("Service_id");
                     service_cat=rs.getString("service_category");
                     service_price=rs.getInt("service_price");
                }
              
        }
       catch(Exception e)
        {
         JOptionPane.showMessageDialog(this, e);
        }
     try{
           String sql1 = "delete from bill_service where Bill_no='"+txt_no.getText()+"' and service_category='"+service_cat+"' limit 1";
                PreparedStatement mt = con.prepareStatement(sql1);
                mt.executeUpdate();
     }
     
        catch(SQLException ex)
        {
         
        }
     try{
          con = DB.createConnection();
                String sql = "INSERT INTO bill_service (Service_id,Bill_no,service_category) VALUES ('"+service_id+"','"+txt_no.getText()+"','"+service_cat+"')";
                PreparedStatement stt = con.prepareStatement(sql);
                int i = stt.executeUpdate();

                if (i == 1) 
                {

                }
                else
                {
               
                }
net_total=net_total+service_price;
net_total=net_total-previous_service_price;
previous_service_price=service_price;
txt_subtotal.setText(Integer.toString(net_total));
                
     }
     catch(Exception e)
     {
         
     }
        con.close();
        
        
    }
    void wash_type() throws SQLException
    {
        wash_type=cmb_wash.getSelectedItem().toString();
       try{
             con = DB.createConnection();
                Statement stmt = con.createStatement();
                String sql = "select Service_id,Service_name,service_category,service_price from service where Service_name='"+cmb_type.getSelectedItem().toString()+"' and service_category='Wash'";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next())
                {    service_name_cal=rs.getString("Service_name");
                     service_id=rs.getString("Service_id");
                     service_cat=rs.getString("service_category");
                     service_price=rs.getInt("service_price");
                }
              
        }
       catch(Exception e)
        {
         JOptionPane.showMessageDialog(this, e);
        }
     try{
           String sql1 = "delete from bill_service where Bill_no='"+txt_no.getText()+"' and service_category='"+service_cat+"' limit 1";
                PreparedStatement mt = con.prepareStatement(sql1);
                mt.executeUpdate();
     }
     
        catch(SQLException ex)
        {
         
        }
     try{
          con = DB.createConnection();
                String sql = "INSERT INTO bill_service (Service_id,Bill_no,service_category) VALUES ('"+service_id+"','"+txt_no.getText()+"','"+service_cat+"')";
                PreparedStatement stt = con.prepareStatement(sql);
                int i = stt.executeUpdate();

                if (i == 1) 
                {

                }
                else
                {
               
                }

     }
     catch(Exception e)
     {
         
     }
net_total=net_total+washprice;
net_total=net_total-previous_wash_price;
previous_wash_price=washprice;
txt_subtotal.setText(Integer.toString(net_total));
        con.close();
        
        
    }
    void save()
    {
        try 
            {
                Connection con = DB.createConnection();
                String sql = "Insert into past_bills (Bill_no,Date,Vehicle_no,Telephone,Name,Mileage,Next_service,Sub_total,Balance,Payment) values('"+txt_no.getText()+"','"+txt_date.getText()+"','"+txt_vehical_no.getText()+"','"+txt_tp.getText()+"','"+txt_nic.getText()+"','"+txt_mieage.getText()+"','"+txt_next_service.getText()+"','"+txt_subtotal.getText()+"','"+txt_balance.getText()+"','"+txt_payment.getText()+"')";
                PreparedStatement stmt = con.prepareStatement(sql);
                int i = stmt.executeUpdate();

                if (i == 1) 
                {
                    JOptionPane.showMessageDialog(this, "Successfully Added a New Service.", "Done", JOptionPane.PLAIN_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Cannot Add Service. Try Again","Error  ",JOptionPane.ERROR_MESSAGE);
                }

            } 
            
            catch(SQLException e)
            {JOptionPane.showMessageDialog(null,e);
               // JOptionPane.showMessageDialog(this,"Database Error. Please Try Again","Database Error",JOptionPane.ERROR_MESSAGE);
            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(this,"Please Try Again","Error  " + e,JOptionPane.ERROR_MESSAGE);
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

        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        lbl_type = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_no = new javax.swing.JTextField();
        txt_date = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_vehical_no = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        txt_nic = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmb_type = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txt_tp = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_balance = new javax.swing.JTextField();
        txt_payment = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_mieage = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_next_service = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablebill = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        cmb_wash = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        lbl_amount = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        txt_quantity = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        btn_print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(45, 118, 232));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Kelso Lanka(Pvt)Ltd.");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 11, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/navigation.png"))); // NOI18N
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sales Management");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 47, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Webp.net-resizeimage (3).png"))); // NOI18N
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 168, -1, -1));

        lbl_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_name.setText("Username");
        jPanel4.add(lbl_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 203, -1, -1));

        lbl_type.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_type.setText("Type");
        jPanel4.add(lbl_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 200, -1, -1));

        panel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backnew.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Bill No:");

        txt_no.setEditable(false);

        txt_date.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Date");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Vehical No:");

        jScrollPane1.setViewportView(list);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Vehicle Type");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Name");

        cmb_type.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_typeItemStateChanged(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Telephone");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Sub Total");

        txt_subtotal.setEditable(false);
        txt_subtotal.setText("0");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Balance");

        txt_balance.setEditable(false);

        txt_payment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_paymentKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Payment");

        txt_mieage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_mieageKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_mieageKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_mieageKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText(" Mileage");

        txt_next_service.setEditable(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Next Service");

        tablebill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Selling_price", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablebill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablebillMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablebill);
        if (tablebill.getColumnModel().getColumnCount() > 0) {
            tablebill.getColumnModel().getColumn(0).setResizable(false);
            tablebill.getColumnModel().getColumn(1).setResizable(false);
            tablebill.getColumnModel().getColumn(2).setResizable(false);
            tablebill.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Wash");

        jLabel18.setText("ID");

        txt_id.setEditable(false);

        lbl_amount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_amount.setText("0");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Total Quantity:");

        jButton3.setText("Remove");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel20.setText("Quantity");

        jButton4.setText("Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btn_print.setText("Print");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel4)))
                        .addGap(56, 56, 56)
                        .addComponent(txt_no, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel20))
                        .addGap(28, 28, 28)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel19))
                            .addComponent(jButton3))
                        .addGap(7, 7, 7)
                        .addComponent(lbl_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel16))
                                        .addGap(35, 35, 35)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_vehical_no, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_nic, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_mieage, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_next_service, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_payment, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel12))
                                        .addGap(15, 15, 15)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_tp, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmb_type, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmb_wash, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(20, 20, 20))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                        .addComponent(txt_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel11))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel20))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jButton4))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButton3))
                    .addComponent(lbl_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(143, 143, 143)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel16)
                                            .addComponent(txt_next_service, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(txt_vehical_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txt_nic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8))
                                        .addGap(30, 30, 30)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txt_mieage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_payment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12)
                                        .addComponent(txt_balance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel7)
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel17)
                                        .addGap(45, 45, 45)
                                        .addComponent(jLabel10))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(txt_tp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(cmb_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(cmb_wash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(txt_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(58, 58, 58)))
                        .addGap(67, 67, 67)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_save)
                            .addComponent(jButton1)
                            .addComponent(btn_print))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1408, Short.MAX_VALUE)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
DefaultListModel dm=new DefaultListModel();
    int quantity,net_total,total_profit;
    int selling_price_int=0,profit_int=0;
   String item_name = null;
    PreparedStatement pst;
    Statement st;
     int subtotal;
    void vali()
    {
        if (txt_mieage.getText().equals("") )
    {      
        JOptionPane.showMessageDialog(this,"ID Cannot Be Blank","Error  ",JOptionPane.ERROR_MESSAGE);
    }
    else if (txt_nic.getText().equals("") )
    {      
        JOptionPane.showMessageDialog(this,"Name Cannot Be Blank","Error  ",JOptionPane.ERROR_MESSAGE);
    }
    else if (txt_payment.getText().equals("") )
    {      
        JOptionPane.showMessageDialog(this,"Payment Cannot Be Blank","Error  ",JOptionPane.ERROR_MESSAGE);
    }
    else if (txt_tp.getText().equals("") )
    {      
        JOptionPane.showMessageDialog(this,"Telephone Cannot Be Blank","Error  ",JOptionPane.ERROR_MESSAGE);
    }
    else if (txt_vehical_no.getText().equals("") )
    {      
        JOptionPane.showMessageDialog(this,"Vehicle No Cannot Be Blank","Error  ",JOptionPane.ERROR_MESSAGE);
    }
    else if(!Pattern.matches("^(?:0|94|\\+94|0094)?(?:(11|21|23|24|25|26|27|31|32|33|34|35|36|37|38|41|45|47|51|52|54|55|57|63|65|66|67|81|91)(0|2|3|4|5|7|9)|7(0|1|2|5|6|7|8)\\d)\\d{6}$",
            txt_tp.getText()))
    {
         JOptionPane.showMessageDialog(this,"This Telephone Number is InValid !!","Error  ",JOptionPane.ERROR_MESSAGE);
    }
    else if(!Pattern.matches("[a-zA-Z]+", txt_nic.getText()))
 {
       JOptionPane.showMessageDialog(this,"Name Cannot Be a Number","Error  ",JOptionPane.ERROR_MESSAGE);
 }
    else if(Integer.parseInt(txt_payment.getText())<1)
{
        JOptionPane.showMessageDialog(this,"Payment Cannot Be a Negative Number","Error  ",JOptionPane.ERROR_MESSAGE);
}
    else if(Integer.parseInt(txt_mieage.getText())<1)
{
        JOptionPane.showMessageDialog(this,"Mileage Cannot Be a Negative Number","Error  ",JOptionPane.ERROR_MESSAGE);
}
    else if(Pattern.matches("[a-zA-Z]+",txt_mieage.getText()))
   {
       JOptionPane.showMessageDialog(this,"Mileage Cannot Be a Letter ","Error  ",JOptionPane.ERROR_MESSAGE);
   }
    else if(Pattern.matches("[a-zA-Z]+",txt_payment.getText()))
   {
       JOptionPane.showMessageDialog(this,"Payment Cannot include a Letter ","Error  ",JOptionPane.ERROR_MESSAGE);
   }
   else
   {
       save();
                    
   }
    }
    void clear() throws Exception
    {
        txt_vehical_no.setText("");
        txt_tp.setText("");
        txt_mieage.setText("");
        txt_nic.setText("");
        txt_payment.setText("");
        txt_next_service.setText("");
        txt_balance.setText("");
        
        txt_subtotal.setText("");
        get_bill_id();
    }
    void get_bill_id() throws Exception
    {
        try
        {
          con= DB.createConnection();
          String id="select MAX(Bill_no) AS Max_id from  past_bills";
       pst=con.prepareStatement(id);
          ResultSet rst=pst.executeQuery(id);
          rst.next();
          int newid=0;
          newid=rst.getInt(1);
          newid=newid+1;
          txt_no.setText(newid+"");
          
          
        }
        catch(SQLException ex)
        {
            
        }
    }

  public void add(String item_name, int selling_price_int, int quantity_int)
{
    list.setModel(dm);
    dm.addElement("item name : "+item_name);
    dm.addElement("price : "+selling_price_int);
    dm.addElement("Amount : "+quantity_int);
}
  public void remove(String item_name, int selling_price_int, int quantity_int)
  {
    list.setModel(dm);
    dm.removeElement("item name : "+item_name);
    dm.removeElement("price : "+selling_price_int);
    dm.removeElement("Amount : "+quantity_int);
      
  }
  void fill_wash_combo()
  {
      try 
            {
                con = DB.createConnection();
                String sql = "select service_name from service where service_category='Wash' ";
                 pst = con.prepareStatement(sql);
               ResultSet rst= pst.executeQuery();
                while (rst.next())
                {
                    String service_name=rst.getString("service_name");
                    cmb_wash.addItem(service_name);
                }
                con.close();
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
  void fill_sevice_combo()
  {
      
       try 
            {
                con = DB.createConnection();
                String sql = "select service_name from service where service_category='service' ";
                PreparedStatement pst = con.prepareStatement(sql);
               ResultSet rst= pst.executeQuery();
                while (rst.next())
                {
                    String service_name=rst.getString("service_name");
                    cmb_type.addItem(service_name);
                }
                con.close();
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
  void save_bill_service()
  {
        try 
            {
                
                con.close();
            } 
            catch(SQLIntegrityConstraintViolationException e)
            {
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(this,e);
            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(this,"Please Try Again","Error  " + e,JOptionPane.ERROR_MESSAGE);
            }
  }
  void save_bill_item()
  {
       try 
            {
                con = DB.createConnection();
                String sql = "INSERT INTO bill_item (Bill_no,Item_ID,price,Quantity) VALUES ( '" +txt_no.getText() + "' , '" + txt_id.getText() + "','"+total+"','"+txt_quantity.getText()+"')";
                PreparedStatement stmt = con.prepareStatement(sql);
                int i = stmt.executeUpdate();

                if (i == 1) 
                {

                }
                else
                {
               
                }
 con.close();
            } 
            catch(SQLIntegrityConstraintViolationException e)
            {
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(this,e);
            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(this,"Please Try Again","Error  " + e,JOptionPane.ERROR_MESSAGE);
            }
  }
  void remove_bill_item()
  {
       try 
            {
                con = DB.createConnection();
                String sql = "delete from bill_item where Bill_no='"+txt_no.getText()+"' and Item_ID='"+txt_id.getText()+"' and Quantity='"+txt_quantity.getText()+"' limit 1";
                PreparedStatement mt = con.prepareStatement(sql);
                mt.executeUpdate();
                con.close();
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
   void save_profit()
  {
       try 
            {
                con = DB.createConnection();
                String sql = "INSERT INTO sales (Bill_no,Item_id,Item_name,Sold_Quantity,Sales_Profit,Date) VALUES ( '" +txt_no.getText() + "' , '" + txt_id.getText() + "','" + item_name + "','" + txt_quantity.getText() + "','" + total_profit + "','" + txt_date.getText() + "')";
                PreparedStatement stmt = con.prepareStatement(sql);
                int i = stmt.executeUpdate();

                if (i == 1) 
                {

                }
                else
                {
               
                }
 con.close();
            } 
            catch(SQLIntegrityConstraintViolationException e)
            {
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(this,e);
            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(this,"Please Try Again","Error  " + e,JOptionPane.ERROR_MESSAGE);
            }
  }
   int total;
    void add_item()
{
 String sell_price,profit;
int amount,sub_profit = 0;
             
    if(Pattern.matches("[a-zA-Z]+",txt_quantity.getText()))
   {
       JOptionPane.showMessageDialog(this,"Quantity Cannot include a Letter ","Error  ",JOptionPane.ERROR_MESSAGE);
   }
           else if (txt_id.getText().equals("") )
{
    JOptionPane.showMessageDialog(this,"ID Cannot Be Blank","Error  ",JOptionPane.ERROR_MESSAGE);
}
           else if (txt_quantity.getText().equals("") )
{
    JOptionPane.showMessageDialog(this,"Quantity Cannot Be Blank","Error  ",JOptionPane.ERROR_MESSAGE);   
}
  
           else if(Integer.parseInt(txt_quantity.getText())<1)
{
        JOptionPane.showMessageDialog(this,"Quantity Cannot Be a Negative Number","Error  ",JOptionPane.ERROR_MESSAGE);
}
   else
           {
            try 
            { 
                con = DB.createConnection();
                Statement stmt = con.createStatement();
                String sql = "select Name,Selling_price,profit from products where id='"+txt_id.getText()+"'";
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) 
                {
                    item_name = rs.getString("Name");
                    sell_price = rs.getString("Selling_price");
                    profit = rs.getString("profit");
                    selling_price_int=rs.getInt("selling_price");
                    profit_int=rs.getInt("profit");
          
                  
                }
                update_stock();
                
              amount=selling_price_int*Integer.parseInt(txt_quantity.getText());
                add(item_name,amount,Integer.parseInt(txt_quantity.getText()));
            total=(selling_price_int)*(Integer.parseInt(txt_quantity.getText()));
            save_bill_item();
            subtotal=Integer.parseInt(txt_subtotal.getText());
          net_total=subtotal+total;
              txt_subtotal.setText(Integer.toString(net_total));
          quantity=Integer.parseInt(txt_quantity.getText())+Integer.parseInt(lbl_amount.getText());
          lbl_amount.setText(quantity+"");
         total_profit= profit_int*Integer.parseInt(txt_quantity.getText());
         sub_profit=sub_profit+total_profit;
         save_profit();              
          txt_id.setText("");
          txt_quantity.setText("");
            con.close();  
          
            } 
            catch (SQLException e) 
            {
                JOptionPane.showMessageDialog(this, "Database Error" + e.getMessage());
            } catch (Exception e) 
            {
                JOptionPane.showMessageDialog(this, "Error, Try Again" + e.getMessage());
            }
                   }
}
  void update_stock()
  {String quantity;
         try{   
                 con = DB.createConnection();
                String sql = "UPDATE products SET Quantity=Quantity-'"+txt_quantity.getText()+"' WHERE ID='"+txt_id.getText()+"'";
                PreparedStatement stmt = con.prepareStatement(sql);
                int i = stmt.executeUpdate();

                if (i == 1) 
                {
                   
                }
                else
                {
                    
                }
                 con.close();
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
                JOptionPane.showMessageDialog(this,"Please Try Again","Error " + e,JOptionPane.ERROR_MESSAGE);
            }     

               
            

  }
    void view() throws Exception
{
    try
        {
         
       con = DB.createConnection();
                Statement st = con.createStatement();
                String sql = "select ID,Name,Selling_price,Quantity from products ";
        ResultSet rst = st.executeQuery(sql);
         
         DefaultTableModel model=new DefaultTableModel(new String[]{"ID","Name","Selling_price","Quantity"},0);
         
          while (rst.next()){
         Vector vec = new Vector();
         vec.add(rst.getString("ID"));
         vec.add(rst.getString("Name"));
         vec.add(rst.getString("Selling_price"));
         vec.add(rst.getString("Quantity"));

        
         model.addRow(vec);
         tablebill.setModel(model);
         
        
          
         }
        con.close();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Database Error !!");
        }
}
    void remove_profit()
    {
        try 
            {
                 con = DB.createConnection();
                String sql = "delete from sales where Item_Id='"+txt_id.getText()+"' and Sold_Quantity='"+txt_quantity.getText()+"' and Date='"+txt_date.getText()+"' limit 1";
                PreparedStatement mt = con.prepareStatement(sql);
                 mt.executeUpdate();

              
con.close();
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
    void remove_item_selection()
    {String sell_price,profit;
    int amount,total;
        try 
            { 

                con = DB.createConnection();
                Statement stmt = con.createStatement();
                String sql = "select Name,Selling_price,profit from products where id='"+txt_id.getText()+"'";
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) 
                {
                    item_name = rs.getString("Name");
                    sell_price = rs.getString("Selling_price");
                    profit = rs.getString("profit");
                    selling_price_int=rs.getInt("selling_price");
                    profit_int=rs.getInt("profit");
          
                  
                }
               
                 amount=selling_price_int*Integer.parseInt(txt_quantity.getText());
                 remove( item_name, amount,  Integer.parseInt(txt_quantity.getText()));
                  total=(selling_price_int)*(Integer.parseInt(txt_quantity.getText()));
           
            subtotal=Integer.parseInt(txt_subtotal.getText());
          net_total=subtotal-total;
        
          quantity=Integer.parseInt(lbl_amount.getText())-Integer.parseInt(txt_quantity.getText());
          if(quantity<0 || net_total<0)
          {
             JOptionPane.showMessageDialog(this,"quantity cannot be negative number");
             con.close();
             
          }
          else
          {
              remove_bill_item();
               remove();
                 txt_subtotal.setText(Integer.toString(net_total));
               lbl_amount.setText(quantity+"");
          remove_profit();
          txt_id.setText("");
          txt_quantity.setText("");
          con.close();
          }
         
    }   catch (Exception ex) {
            Logger.getLogger(Create_Bill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void remove()
    { 
       
        try{    
                con = DB.createConnection();
                String sql = "UPDATE products SET Quantity=Quantity+'"+txt_quantity.getText()+"' WHERE ID='"+txt_id.getText()+"'";
                PreparedStatement stmt = con.prepareStatement(sql);
                int i = stmt.executeUpdate();

                if (i == 1) 
                {
                   
                }
                else
                {
                    
                }
 con.close();
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

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked

        new User_Menu(name, type).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
fill_wash_combo();fill_sevice_combo();        try {
            get_bill_id();
            view();
        } catch (Exception ex) {
            Logger.getLogger(Create_Bill.class.getName()).log(Level.SEVERE, null, ex);
        }
        get_date();
        get_user_details();
        btn_print.setEnabled(false);
// TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if(txt_id.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please Select a Item");
        }
        else if(txt_quantity.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please Enter Quantity");
        }
        else if(Integer.parseInt(txt_quantity.getText())<1)
        {
            JOptionPane.showMessageDialog(this,"Quantity cannot be a Negative Number");
        }
        else if(Pattern.matches("[a-zA-Z]+",txt_quantity.getText()))
        {
       JOptionPane.showMessageDialog(this,"Quantity Cannot include a Letter ","Error  ",JOptionPane.ERROR_MESSAGE);
        }
          else if(Integer.parseInt(txt_quantity.getText())>5)
        {
            JOptionPane.showMessageDialog(this,"Quantity Cannot Greater Than 5");
        }
           else if (list == null)
          {
              JOptionPane.showMessageDialog(this,"list empty");
          }
        else
        {
            remove_item_selection();
        }
        



 try {
            view();
        } catch (Exception ex) {
            Logger.getLogger(Create_Bill.class.getName()).log(Level.SEVERE, null, ex);
        }// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 if(txt_id.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please Select a Item");
        }
 else if(Pattern.matches("[a-zA-Z]+",txt_quantity.getText()))
   {
       JOptionPane.showMessageDialog(this,"Quantity Cannot include a Letter ","Error  ",JOptionPane.ERROR_MESSAGE);
   }
 
        else if(txt_quantity.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please Enter Quantity");
        }
        else if(Integer.parseInt(txt_quantity.getText())<1)
        {
            JOptionPane.showMessageDialog(this,"Quantity cannot be a Negative Number");
        }
          else if(Integer.parseInt(txt_quantity.getText())>5)
        {
            JOptionPane.showMessageDialog(this,"Quantity Cannot Greater Than 5");
        }
         
        else
        {
          add_item();
       
        try {
            view();
        } catch (Exception ex) {
            Logger.getLogger(Create_Bill.class.getName()).log(Level.SEVERE, null, ex);
        }    
        }
            // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    void print_bill()
{
     try
       { con = DB.createConnection();
           JasperDesign jd=JRXmlLoader.load("C:\\KELSO_LANKA\\src\\Reports\\Customer_Bill.jrxml");
           String sql="SELECT bill_item.Quantity,bill_item.Item_ID,bill_item.price,products.Name from bill_item INNER JOIN products on products.ID=bill_item.Item_ID WHERE bill_item.Bill_no='"+txt_no.getText()+"'";
           JRDesignQuery newquery =new JRDesignQuery();
           newquery.setText(sql);
           
           jd.setQuery(newquery);
           
           HashMap<String,Object> m=new HashMap<>();
           m.put("Bill_no",txt_no.getText());
          m.put("txt_nic",txt_nic.getText());
         m.put("txt_date", txt_date.getText());
          m.put("txt_vehical_no", txt_vehical_no.getText());
          m.put("lbl_name", lbl_name.getText());
          m.put("txt_subtotal", txt_subtotal.getText());
          m.put("txt_payment", txt_payment.getText());
          m.put("txt_balance", txt_balance.getText());
          m.put("cmb_type",cmb_type.getSelectedItem().toString());
          
           JasperReport js=JasperCompileManager.compileReport(jd);
           JasperPrint jp=JasperFillManager.fillReport(js,m,con);
           JasperExportManager.exportReportToPdfFile(jp,"C:\\Users\\Pkkg\\Documents\\NetBeansProjects\\Final Project\\src\\Past_Bills\\Bill_"+txt_no.getText()+".pdf");
           JasperViewer.viewReport(jp,false);
           
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
}
    void pdf()
{
    if(Desktop.isDesktopSupported())
    {
        try
        {File myFile = new File("C:\\Users\\Pkkg\\Documents\\NetBeansProjects\\Final Project\\src\\Past_Bills\\Bill_"+txt_no.getText()+".pdf");
        Desktop.getDesktop().open(myFile);    
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex);
        }
    }
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            clear();        // TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(Create_Bill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
    vali();
    btn_print.setEnabled(true);
    btn_save.setEnabled(false);
    }//GEN-LAST:event_btn_saveActionPerformed

    private void tablebillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablebillMouseClicked
int i = tablebill.getSelectedRow();
        TableModel model = tablebill.getModel();
        txt_id.setText((String) model.getValueAt(i, 0));         // TODO add your handling code here:
    }//GEN-LAST:event_tablebillMouseClicked

    private void txt_mieageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mieageKeyTyped
       // TODO add your handling code here:
    }//GEN-LAST:event_txt_mieageKeyTyped

    private void txt_mieageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mieageKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mieageKeyPressed

    private void txt_mieageKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mieageKeyReleased
next_mileage();         // TODO add your handling code here:
    }//GEN-LAST:event_txt_mieageKeyReleased

    private void cmb_typeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_typeItemStateChanged
        try {
            vehicle_type();        // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Create_Bill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmb_typeItemStateChanged

    private void txt_paymentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_paymentKeyReleased
final_cal();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_paymentKeyReleased

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
print_bill();        // TODO add your handling code here:
    }//GEN-LAST:event_btn_printActionPerformed

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
            java.util.logging.Logger.getLogger(Create_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Create_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Create_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Create_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Create_Bill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_save;
    private javax.swing.JComboBox<String> cmb_type;
    private javax.swing.JComboBox<String> cmb_wash;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_amount;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_type;
    private javax.swing.JList<String> list;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tablebill;
    private javax.swing.JTextField txt_balance;
    private javax.swing.JTextField txt_date;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_mieage;
    private javax.swing.JTextField txt_next_service;
    private javax.swing.JTextField txt_nic;
    private javax.swing.JTextField txt_no;
    private javax.swing.JTextField txt_payment;
    private javax.swing.JTextField txt_quantity;
    private javax.swing.JTextField txt_subtotal;
    private javax.swing.JTextField txt_tp;
    private javax.swing.JTextField txt_vehical_no;
    // End of variables declaration//GEN-END:variables
}
