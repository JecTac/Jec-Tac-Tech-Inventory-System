package jec.tac.tech.inventory.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class RequestMaintenancePage extends javax.swing.JFrame {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
    public RequestMaintenancePage() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ITEMNAME = new javax.swing.JComboBox<>();
        IssueDescription = new javax.swing.JTextField();
        SubmitMaintenanceReq = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("JEC TAC TECH INVENTORY");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("MAINTENANCE/REPAIRS FORM");

        jLabel3.setText("Item Name:");

        jLabel4.setText("Issue/Description:");
        
        try{
          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jectactechdb?zeroDateTimeBehavior=convertToNull", "root", "password");
          String sql = "SELECT * FROM machinestbl";
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          
          while(rs.next()){
              String name = rs.getString("machine_Name");
              ITEMNAME.addItem(name);
          }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

        ITEMNAME.setBackground(new java.awt.Color(102, 102, 102));
        //ITEMNAME.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ITEMNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ITEMNAMEActionPerformed(evt);
            }
        });

        IssueDescription.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        SubmitMaintenanceReq.setText("SUBMIT");
        SubmitMaintenanceReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitMaintenanceReqActionPerformed(evt);
            }
        });

        BackButton.setText("BACK");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ITEMNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SubmitMaintenanceReq, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(IssueDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ITEMNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IssueDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackButton)
                    .addComponent(SubmitMaintenanceReq))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }

    private void ITEMNAMEActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void SubmitMaintenanceReqActionPerformed(java.awt.event.ActionEvent evt) {
        
        try{
            long millis = System.currentTimeMillis();
            Timestamp timestamp = new Timestamp(millis);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyy hh.mm.ss");
            String formatedStrDate = sdf.format(timestamp);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jectactechdb?zeroDateTimeBehavior=convertToNull", "root", "password");
            
            String sql = "INSERT INTO repairReqTbl VALUES (repairReq_Num, ?, ?, ?)";
            String selectedItem = (String) ITEMNAME.getSelectedItem();
            ps = con.prepareStatement(sql);
            ps.setTimestamp(1, timestamp);
            ps.setString(2, selectedItem);
            ps.setString(3, IssueDescription.getText());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Your request was successfully submitted.");
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RequestMaintenancePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RequestMaintenancePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RequestMaintenancePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RequestMaintenancePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RequestMaintenancePage().setVisible(true);
            }
        });
    }

    private javax.swing.JButton BackButton;
    private javax.swing.JComboBox<String> ITEMNAME;
    private javax.swing.JTextField IssueDescription;
    private javax.swing.JButton SubmitMaintenanceReq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
}