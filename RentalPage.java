
import DbConnection.DatabaseCSMS;
import java.awt.Image;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author PMYLS
 */
public class RentalPage extends javax.swing.JFrame {

    Connection conn = DatabaseCSMS.getConnection();
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public RentalPage() {
        initComponents();
          setExtendedState(JFrame.MAXIMIZED_BOTH);
            setImage();
    }
      private void setImage() {
//        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/carshowroomHomebg.jpg"));
        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/CSMSLogo-removebg-preview.png"));
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
        logo.setIcon(new ImageIcon(newImg));
        
//        add car 
        ImageIcon car_Icon = new ImageIcon(getClass().getResource("/Images/carIcon.png"));
        Image AddCarimg = car_Icon.getImage();
        Image newAddCarImg = AddCarimg.getScaledInstance(AddCar.getWidth(), AddCar.getHeight(), Image.SCALE_SMOOTH);
        AddCar.setIcon(new ImageIcon(newAddCarImg));
        
        //        add customer
        ImageIcon customer_Icon = new ImageIcon(getClass().getResource("/Images/userIcon.png"));
        Image AddCustomerimg = customer_Icon.getImage();
        Image newAddCustomerImg = AddCustomerimg.getScaledInstance(AddCustomer.getWidth(), AddCustomer.getHeight(), Image.SCALE_SMOOTH);
        AddCustomer.setIcon(new ImageIcon(newAddCustomerImg));
        
//        payment 
        ImageIcon Payment_Icon = new ImageIcon(getClass().getResource("/Images/paymentIcon.png"));
        Image Payment_img = Payment_Icon.getImage();
        Image newPaymentImg = Payment_img.getScaledInstance(Payment.getWidth(), Payment.getHeight(), Image.SCALE_SMOOTH);
        Payment.setIcon(new ImageIcon(newPaymentImg));
        
//        Rent
        ImageIcon Rent_Icon = new ImageIcon(getClass().getResource("/Images/rentIcon.png"));
        Image Rent_img = Rent_Icon.getImage();
        Image newRentImg = Rent_img.getScaledInstance(Rent.getWidth(), Rent.getHeight(), Image.SCALE_SMOOTH);
        Rent.setIcon(new ImageIcon(newRentImg));
        
//        Bill
        ImageIcon Bill_Icon = new ImageIcon(getClass().getResource("/Images/billIcon.png"));
        Image Bill_img = Bill_Icon.getImage();
        Image newBillImg = Bill_img.getScaledInstance(Bill.getWidth(), Bill.getHeight(), Image.SCALE_SMOOTH);
        Bill.setIcon(new ImageIcon(newBillImg));
        
        //        View Details
        ImageIcon View_Icon = new ImageIcon(getClass().getResource("/Images/dashboardIcon.png"));
        Image View_img = View_Icon.getImage();
        Image newViewImg = View_img.getScaledInstance(ViewDetails.getWidth(), ViewDetails.getHeight(), Image.SCALE_SMOOTH);
        ViewDetails.setIcon(new ImageIcon(newViewImg));

      // Logout
        ImageIcon Logout_Icon = new ImageIcon(getClass().getResource("/Images/logoutIcon.png"));
        Image Logout_img = Logout_Icon.getImage();
        Image newLogoutImg = Logout_img.getScaledInstance(Logout.getWidth(), Logout.getHeight(), Image.SCALE_SMOOTH);
        Logout.setIcon(new ImageIcon(newLogoutImg));
    }
      
        // Save data to database
 private void saveRentToDatabase() {
    String car_Id = carId.getText();
    String user_Id = userId.getText();
    String rentStart = rentStartDate.getText();
    String total_Rent = totalRent.getText();
    String monthly_installment = monthlyInstallment.getText();
    String installmentPaid = paidInstallment.getText();
    String remaining_installment = remainingInstallment.getText();
    String installment_status = installmentStatus.getSelectedItem().toString();

    // Corrected if condition
    if (car_Id.isEmpty() || user_Id.isEmpty() || rentStart.isEmpty() || 
        total_Rent.isEmpty() || monthly_installment.isEmpty() || 
        installmentPaid.isEmpty() || remaining_installment.isEmpty() || 
        installment_status.isEmpty()) {
        
        JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
        try {
            String query = "INSERT INTO `rentalstable`( `car_id`, `user_id`, `rental_start_date`, `total_rent`, `monthly_installment`, `installments_paid`, `remaining_installments`, `status`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pst = conn.prepareStatement(query);
            pst.setString(1, car_Id);
            pst.setString(2, user_Id);
            pst.setString(3, rentStart);
            pst.setString(4, total_Rent);
            pst.setString(5, monthly_installment);
            pst.setString(6, installmentPaid);
            pst.setString(7, remaining_installment);
            pst.setString(8, installment_status);

            int rows = pst.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Customer added successfully!");
                clearForm();
            }

            st.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    //  Clear form fields
    private void clearForm() {
        carId.setText("");
        userId.setText("");
        rentStartDate.setText("");
        totalRent.setText("");
        monthlyInstallment.setText("");
        paidInstallment.setText("");
        remainingInstallment.setText("");
        installmentStatus.setSelectedIndex(0);
       
    }
    
    public void openNewFrame(JFrame currentFrame, JFrame newFrame) {
    currentFrame.dispose();  // Purani frame close
    newFrame.setVisible(true);  // Nayi frame show
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        AddCar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        AddCustomer = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Payment = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        Rent = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        Bill = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        Logout = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        ViewDetails = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        carId = new javax.swing.JTextField();
        userId = new javax.swing.JTextField();
        remainingInstallment = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        rentStartDate = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        installmentStatus = new javax.swing.JComboBox<>();
        Cancel = new javax.swing.JButton();
        addRentalDetails = new javax.swing.JButton();
        totalRent = new javax.swing.JTextField();
        monthlyInstallment = new javax.swing.JTextField();
        paidInstallment = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 29, 61));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CSMS");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOpaque(true);

        jPanel3.setBackground(new java.awt.Color(255, 215, 0));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Add Car");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddCar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(AddCar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(20, 20, 20))))
        );

        jPanel4.setBackground(new java.awt.Color(255, 215, 0));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        AddCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Add Customer");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 215, 0));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Payment");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Payment, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Payment, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(22, 22, 22))
        );

        jPanel6.setBackground(new java.awt.Color(255, 165, 0));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Rent");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Rent, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Rent, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(23, 23, 23))
        );

        jPanel7.setBackground(new java.awt.Color(255, 215, 0));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Bill");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Bill, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Bill, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(22, 22, 22))
        );

        jPanel8.setBackground(new java.awt.Color(244, 14, 17));
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Logout");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18))
        );

        jPanel9.setBackground(new java.awt.Color(255, 215, 0));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("View Details");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ViewDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ViewDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel1)
                    .addContainerGap())
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        closeButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        closeButton.setForeground(new java.awt.Color(0, 29, 61));
        closeButton.setText("X");
        closeButton.setBorder(null);
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(2, 48, 71), 3, true), "RENTAL ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Stencil", 1, 24), new java.awt.Color(2, 48, 71))); // NOI18N
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(2, 48, 71));
        jLabel9.setText("CAR ID");
        jPanel10.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(2, 48, 71));
        jLabel10.setText("USER ID");
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(2, 48, 71));
        jLabel11.setText("RENTAL START DATE");
        jPanel10.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(2, 48, 71));
        jLabel12.setText("TOTAL RENT");
        jPanel10.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, -1));

        carId.setForeground(new java.awt.Color(255, 255, 255));
        carId.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(2, 48, 71), 2, true));
        jPanel10.add(carId, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 230, -1));

        userId.setForeground(new java.awt.Color(255, 255, 255));
        userId.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(2, 48, 71), 2, true));
        userId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIdActionPerformed(evt);
            }
        });
        jPanel10.add(userId, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 230, -1));

        remainingInstallment.setForeground(new java.awt.Color(255, 255, 255));
        remainingInstallment.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(2, 48, 71), 2, true));
        jPanel10.add(remainingInstallment, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 230, -1));

        jSeparator3.setBackground(new java.awt.Color(2, 48, 71));
        jSeparator3.setForeground(new java.awt.Color(2, 48, 71));
        jPanel10.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 90, 10));

        rentStartDate.setForeground(new java.awt.Color(255, 255, 255));
        rentStartDate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(2, 48, 71), 2, true));
        rentStartDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentStartDateActionPerformed(evt);
            }
        });
        jPanel10.add(rentStartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 230, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(2, 48, 71));
        jLabel14.setText("MONTHLY INSTALLMENTS");
        jPanel10.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(2, 48, 71));
        jLabel15.setText("INSTALLMENTS PAID");
        jPanel10.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(2, 48, 71));
        jLabel16.setText("REMAINING INSTALLMENTS");
        jPanel10.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(2, 48, 71));
        jLabel17.setText("STATUS");
        jPanel10.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, -1));

        installmentStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Rental Status", "Pending", "Completed", "Active" }));
        installmentStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                installmentStatusActionPerformed(evt);
            }
        });
        jPanel10.add(installmentStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 230, 30));

        Cancel.setBackground(new java.awt.Color(244, 14, 17));
        Cancel.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        Cancel.setForeground(new java.awt.Color(255, 255, 255));
        Cancel.setText("CANCEL");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });
        jPanel10.add(Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, 190, 40));

        addRentalDetails.setBackground(new java.awt.Color(0, 53, 102));
        addRentalDetails.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        addRentalDetails.setForeground(new java.awt.Color(255, 255, 255));
        addRentalDetails.setText("ADD RENTAL DETAILS");
        addRentalDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRentalDetailsActionPerformed(evt);
            }
        });
        jPanel10.add(addRentalDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 190, 40));

        totalRent.setForeground(new java.awt.Color(255, 255, 255));
        totalRent.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(2, 48, 71), 2, true));
        jPanel10.add(totalRent, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 230, -1));

        monthlyInstallment.setForeground(new java.awt.Color(255, 255, 255));
        monthlyInstallment.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(2, 48, 71), 2, true));
        jPanel10.add(monthlyInstallment, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 230, -1));

        paidInstallment.setForeground(new java.awt.Color(255, 255, 255));
        paidInstallment.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(2, 48, 71), 2, true));
        jPanel10.add(paidInstallment, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 230, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 992, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(413, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(215, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closeButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(108, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(96, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 790));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
       openNewFrame(this, new Dashboard());
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
       openNewFrame(this, new AddCustomer());
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
       openNewFrame(this, new Payment());
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
       openNewFrame(this, new Login());
    }//GEN-LAST:event_jPanel8MouseClicked

    private void userIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userIdActionPerformed

    private void installmentStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_installmentStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_installmentStatusActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
            clearForm();
    }//GEN-LAST:event_CancelActionPerformed

    private void addRentalDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRentalDetailsActionPerformed
         saveRentToDatabase();
    }//GEN-LAST:event_addRentalDetailsActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
          int yes = JOptionPane.showConfirmDialog(this, "Are You Sure?","Exit", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
       if(yes==JOptionPane.YES_OPTION){
       System.exit(0);}
    }//GEN-LAST:event_closeButtonActionPerformed

    private void rentStartDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentStartDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rentStartDateActionPerformed

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
      openNewFrame(this, new RentalPage());
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
      openNewFrame(this, new BillReceipt());
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
      openNewFrame(this, new  ViewCarsDetailsPage());
    }//GEN-LAST:event_jPanel9MouseClicked

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
            java.util.logging.Logger.getLogger(RentalPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RentalPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RentalPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RentalPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RentalPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddCar;
    private javax.swing.JLabel AddCustomer;
    private javax.swing.JLabel Bill;
    private javax.swing.JButton Cancel;
    private javax.swing.JLabel Logout;
    private javax.swing.JLabel Payment;
    private javax.swing.JLabel Rent;
    private javax.swing.JLabel ViewDetails;
    private javax.swing.JButton addRentalDetails;
    private javax.swing.JTextField carId;
    private javax.swing.JButton closeButton;
    private javax.swing.JComboBox<String> installmentStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField monthlyInstallment;
    private javax.swing.JTextField paidInstallment;
    private javax.swing.JTextField remainingInstallment;
    private javax.swing.JTextField rentStartDate;
    private javax.swing.JTextField totalRent;
    private javax.swing.JTextField userId;
    // End of variables declaration//GEN-END:variables
}
