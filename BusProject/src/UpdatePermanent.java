

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;


public class UpdatePermanent extends javax.swing.JFrame {

    String gender;
    /**
     * Creates new form update
     */
    public UpdatePermanent() {
        initComponents();
        setExtendedState(getExtendedState()|MainMenu.MAXIMIZED_BOTH);  //sets to full screen
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        for(int i=0;i<22;i++){
        TableColumn col = jTable1.getColumnModel().getColumn(i);
        col.setPreferredWidth(100);}
        show_table();
        
       // jTable1.getTableHeader().setDefaultRenderer(new update());
    }
    public void openDeletePanel()
    {
        updatePanel.setVisible(false);
        deletePanel.setVisible(true);
    }
    public void openUpdatePanel()
    {
         deletePanel.setVisible(false);
         updatePanel.setVisible(true);
        
    }
     public ArrayList<CorpsePar>corpseList(){
        ArrayList<CorpsePar> corpseList = new ArrayList<>();
     try {

     try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     } 
     catch (ClassNotFoundException ex) 
     {
         JOptionPane.showMessageDialog(upPanel, "Error connecting to database");
     }
            Connection connection = DriverManager .getConnection(
                            "jdbc:sqlserver://localhost:1433;databaseName=Graveyard;selectMethod=cursor", "sa", "123456");
            System.out.println("DATABASE NAME IS:" + connection.getMetaData().getDatabaseProductName());

            System.out.println("connected sucessfully");
         
            String query1 = "SELECT * FROM PermanentGrave";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query1);
            CorpsePar corpse;
            while(rs.next())
            {
               corpse = new CorpsePar(rs.getInt("generalGraveId"),rs.getString("generalGraveSize"),rs.getInt("generalCorpseId"),
                      rs.getString("corpseName"),rs.getString("corpseGender"),
                      rs.getString("corpseFatherName"),rs.getString("corpseMotherName"),rs.getString("corpseDateOfBirth"),
                      rs.getString("corpseDateOfDeath"),rs.getString("corpseTimeOfDeath"),rs.getString("corpseCauseOfDeath"),
                      rs.getString("guardianContactNo"),rs.getString("guardianRelation"),rs.getString("guardianAddress"),
                      rs.getString("guardianName"),rs.getString("corpseNidNo"),rs.getString("corpseBirthCertificateNo"),
                      rs.getString("burriedDate"),rs.getString("RecycleDate"),rs.getInt("fee"),rs.getInt("OwnerId"),
                      rs.getString("ownerNid"));
                      
              corpseList.add(corpse);
            }
            //connection.close();
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(upPanel, e);
        } catch (SQLException ex) {
          
            JOptionPane.showMessageDialog(upPanel,ex);
        }
     return corpseList;
           
    }
     
    public void show_table(){
    ArrayList<CorpsePar> list = corpseList();
    DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
    Object[] row = new Object[22];
    for(int i = 0; i<list.size(); i++)
    {
        row[0] = list.get(i).getgeneralGraveId();
        row[1] = list.get(i).getgeneralGraveSize();
        row[2] = list.get(i).getgeneralCorpseId();
        row[3] = list.get(i).getcorpseName();
        row[4] = list.get(i).getcorpseGender();
        row[5] = list.get(i).getcorpseFatherName();
        row[6] = list.get(i).getcorpseMotherName();
        row[7] = list.get(i).getcorpseDateOfBirth(); 
        row[8] = list.get(i).getcorpseDateOfDeath();
        row[9] = list.get(i).getcorpseTimeOfDeath();
        row[10] = list.get(i).getcorpseCauseOfDeath();
        row[11] = list.get(i).getcorpseNidNo();
        row[12] = list.get(i).getcorpseBirthCertificateNo();
        row[13] = list.get(i).getburriedDate();
        row[14] = list.get(i).getRecycleDate();
        row[15] = list.get(i).getOwnerId();
        row[16] = list.get(i).getguardianName();
        row[17] = list.get(i).getguardianRelation();
        row[18] = list.get(i).getownerNid();
        row[19] = list.get(i).getguardianAddress();
        row[20] = list.get(i).getguardianContactNo();
        row[21] = list.get(i).getfee();
        model.addRow(row);
        
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        timeSelector = new cambodia.raven.Time();
        mainPanel = new javax.swing.JPanel();
        upPanel = new javax.swing.JPanel();
        updatePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        plotSize = new javax.swing.JComboBox<>();
        plotNo = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        fathersName = new javax.swing.JTextField();
        mothersName = new javax.swing.JTextField();
        causeOfDeath = new javax.swing.JTextField();
        nid = new javax.swing.JTextField();
        guardianAddress = new javax.swing.JTextField();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        other = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        birthCertificateNo = new javax.swing.JTextField();
        timeOfDeath = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        relation = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        GuardianName = new javax.swing.JTextField();
        guardianContactNo = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        deletePanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        delete1 = new javax.swing.JButton();
        signinBackLabel1 = new javax.swing.JLabel();
        burriedDate = new com.toedter.calendar.JDateChooser();
        recycleDate = new com.toedter.calendar.JDateChooser();
        dateOfDeath = new com.toedter.calendar.JDateChooser();
        dateOfBirth = new com.toedter.calendar.JDateChooser();
        fee = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        ownerNid = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        deletePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        delete = new javax.swing.JButton();
        signinBackLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        timeSelector.setTextRefernce(timeOfDeath);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        upPanel.setLayout(new java.awt.CardLayout());

        updatePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Plot no:");
        updatePanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel4.setText("Name:");
        updatePanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        jLabel5.setText("Gender:");
        updatePanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, -1, 20));

        jLabel6.setText("Father's name:");
        updatePanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 120, -1, -1));

        jLabel7.setText("Mother's name:");
        updatePanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 80, -1, -1));

        jLabel8.setText("Date of birth:");
        updatePanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 80, -1, -1));

        jLabel9.setText("Date of death:");
        updatePanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, -1, -1));

        jLabel10.setText("Time of death:");
        updatePanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, -1, -1));

        jLabel11.setText("Cause of death:");
        updatePanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel12.setText("Plot size:");
        updatePanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, 20));

        jLabel14.setText("NID:");
        updatePanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 130, 40, -1));

        jLabel15.setText("Address:");
        updatePanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, -1));

        jLabel16.setText("Burried date:");
        updatePanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 70, 20));

        jLabel17.setText("Recycle date:");
        updatePanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 80, 20));

        update.setText("update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        updatePanel.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, -1, -1));

        plotSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Small", "Medium", "Large" }));
        updatePanel.add(plotSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 70, -1));

        plotNo.setText("jTextField1");
        updatePanel.add(plotNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 50, 20));

        name.setText("jTextField2");
        updatePanel.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 110, -1));

        fathersName.setText("jTextField4");
        updatePanel.add(fathersName, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 120, 90, -1));

        mothersName.setText("jTextField5");
        updatePanel.add(mothersName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 80, -1, -1));

        causeOfDeath.setText("jTextField6");
        updatePanel.add(causeOfDeath, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        nid.setText("jTextField7");
        updatePanel.add(nid, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, -1, -1));

        guardianAddress.setText("jTextField8");
        updatePanel.add(guardianAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

        male.setText("Male");
        updatePanel.add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, -1));

        female.setText("Female");
        updatePanel.add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, -1, -1));

        other.setText("Other");
        updatePanel.add(other, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, -1, -1));

        jLabel18.setText("Birth Certificate no:");
        updatePanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, -1, -1));

        birthCertificateNo.setText("jTextField9");
        updatePanel.add(birthCertificateNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, -1, -1));
        updatePanel.add(timeOfDeath, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, 40, -1));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        updatePanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 30, 30, -1));

        jLabel25.setText("Death Certificate:");
        updatePanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 30, -1, -1));

        jLabel27.setText("Relation:");
        updatePanel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, -1));

        relation.setText("jTextField1");
        updatePanel.add(relation, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, -1));

        jLabel28.setText("Name:");
        updatePanel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, -1, -1));

        jLabel29.setText("Contact no:");
        updatePanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, -1, -1));

        GuardianName.setText("jTextField2");
        updatePanel.add(GuardianName, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, -1, -1));

        guardianContactNo.setText("jTextField3");
        updatePanel.add(guardianContactNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("SELECT A ROW FROM THE TABLE BELOW TO UPDATE");
        updatePanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 500, 30));

        deletePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("SELECT A ROW FROM THE TABLE TO DELETE");
        deletePanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 320, 40));

        delete1.setText("Delete");
        delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete1ActionPerformed(evt);
            }
        });
        deletePanel1.add(delete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, -1, -1));

        signinBackLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        signinBackLabel1.setForeground(new java.awt.Color(0, 51, 51));
        signinBackLabel1.setText("<<");
        signinBackLabel1.setToolTipText("<<");
        signinBackLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signinBackLabel1MouseClicked(evt);
            }
        });
        deletePanel1.add(signinBackLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 40, -1));

        updatePanel.add(deletePanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 30));
        updatePanel.add(burriedDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));
        updatePanel.add(recycleDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, -1, -1));
        updatePanel.add(dateOfDeath, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, -1, -1));
        updatePanel.add(dateOfBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, -1, -1));

        fee.setText("jTextField1");
        updatePanel.add(fee, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        id.setText("jTextField2");
        updatePanel.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, -1, -1));

        ownerNid.setText("jTextField3");
        updatePanel.add(ownerNid, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, -1, -1));

        jLabel13.setText("fee");
        updatePanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel20.setText("owner id:");
        updatePanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        jLabel21.setText("owner nid");
        updatePanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, -1, -1));

        upPanel.add(updatePanel, "card2");

        deletePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("SELECT A ROW FROM THE TABLE TO DELETE");
        deletePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 320, 40));

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        deletePanel.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, -1, -1));

        signinBackLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        signinBackLabel.setForeground(new java.awt.Color(0, 51, 51));
        signinBackLabel.setText("<<");
        signinBackLabel.setToolTipText("<<");
        signinBackLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signinBackLabelMouseClicked(evt);
            }
        });
        deletePanel.add(signinBackLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 40, -1));

        upPanel.add(deletePanel, "card3");

        mainPanel.add(upPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 210));

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Plot Id", "Plot Size", "Corpse Id", "Corpse Name", "Gender", "Father's name", "Mother's name", "Date of birth", "Date of death", "Time of death", "Cause of death", "NID No", "Birth Certificate No", "Burried Date", "Recycle Date.", "Owner Id", "Owner Name", "Owner Relation", "Owner NID", "Owner Address", "Owner Contact No", "Fee"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        mainPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 1340, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1340, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        try {
            System.out.println("hi");

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(upPanel, "Database not connected successfully");
            }
            Connection connection = DriverManager .getConnection(
                "jdbc:sqlserver://localhost:1433;databaseName=Graveyard;selectMethod=cursor", "sa", "123456");
            System.out.println("DATABASE NAME IS:" + connection.getMetaData().getDatabaseProductName());

            System.out.println("connected sucessfully");
            int row = jTable1.getSelectedRow();
            String value = (jTable1.getModel().getValueAt(row,2).toString());
            String sql = "UPDATE PermanentGrave SET generalGraveId=?,generalGraveSize=?,corpseGender=?,burriedDate=?,"
            +"RecycleDate=?,corpseTimeOfDeath=?,corpseName=?,corpseFatherName=?,corpseMotherName=?,corpseDateOfBirth=?,corpseDateOfDeath=?,"
            +"corpseCauseOfDeath=?,corpseNidNo=?,corpseBirthCertificateNo=?,guardianName=?,guardianRelation=?,fee=?,OwnerId=?,ownerNid=?,guardianAddress=?,guardianContactNo=? where generalCorpseId="+value;

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,plotNo.getText());

            String size;
            size = plotSize.getSelectedItem().toString();
            pst.setString(2,size);

            

            if(male.isSelected()){
                gender="male";
            }
            if(female.isSelected()){
                gender="female";
            }
            if(other.isSelected()){
                gender="other";
            }
            pst.setString(3,gender);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String bdate = sdf.format(burriedDate.getDate());
            pst.setString(4,bdate);
            String rdate = sdf.format(recycleDate.getDate());
            pst.setString(5,rdate);
            pst.setString(6,timeOfDeath.getText());
            pst.setString(7,name.getText());
            pst.setString(8,fathersName.getText());
            pst.setString(9,mothersName.getText());
            String birthdate = sdf.format(dateOfBirth.getDate());
            pst.setString(10,birthdate);
            String deathdate = sdf.format(dateOfDeath.getDate());
            pst.setString(11,deathdate);
            pst.setString(12,causeOfDeath.getText());
            pst.setString(13,nid.getText());
            pst.setString(14,birthCertificateNo.getText());
            pst.setString(15,GuardianName.getText());
            pst.setString(16,relation.getText());
            pst.setString(17,guardianContactNo.getText());
            pst.setString(18,guardianAddress.getText());
            pst.setString(19,fee.getText());
            pst.setString(20,id.getText());
            pst.setString(21,ownerNid.getText());
            pst.executeUpdate();
            
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();

            model.setRowCount(0);
            show_table();
            JOptionPane.showMessageDialog(upPanel,"Updated successfully");

            connection.close();
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(upPanel, "Failed to update the selected row");
            // Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(upPanel,ex);
            //Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        timeSelector.showPopup();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delete1ActionPerformed

    private void signinBackLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signinBackLabel1MouseClicked
        this.setVisible(false);
        MainMenu mm = new MainMenu();
        mm.setVisible(true);
        mm.openGravePanel();

    }//GEN-LAST:event_signinBackLabel1MouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int opt = JOptionPane.showConfirmDialog(null,"Are you sure to Delete","Delete",JOptionPane.YES_NO_OPTION);
        if(opt==0){
            try {
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(upPanel, "Database not connected successfully");
                }
                Connection connection = DriverManager .getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=Graveyard;selectMethod=cursor", "sa", "123456");
                System.out.println("DATABASE NAME IS:" + connection.getMetaData().getDatabaseProductName());

                System.out.println("connected sucessfully");
                int row = jTable1.getSelectedRow();
                String value = (jTable1.getModel().getValueAt(row,2).toString());
                String sql = "DELETE FROM PermanentGrave where generalCorpseId="+value;

                PreparedStatement pst = connection.prepareStatement(sql);

                pst.executeUpdate();

                DefaultTableModel model = (DefaultTableModel)jTable1.getModel();

                model.setRowCount(0);
                show_table();
                JOptionPane.showMessageDialog(upPanel,"Deleted successfully");

                connection.close();
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(upPanel, "Failed to delete the selected row");
                // Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, e);
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(upPanel,"Failed to delete the selected row");
                //Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void signinBackLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signinBackLabelMouseClicked
        this.setVisible(false);
        MainMenu mm = new MainMenu();
        mm.setVisible(true);
        mm.openGravePanel();
    }//GEN-LAST:event_signinBackLabelMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
        int i = jTable1.getSelectedRow();
        
        TableModel model = jTable1.getModel();
        plotNo.setText(model.getValueAt(i, 0).toString());
        String size = model.getValueAt(i, 1).toString();
        switch(size){
            case "Small":
            plotSize.setSelectedIndex(0);
            break;
            case "Medium":
            plotSize.setSelectedIndex(1);
            break;
            case "Large":
            plotSize.setSelectedIndex(2);
            break;
        }
        
        name.setText(model.getValueAt(i, 3 ).toString());
        String sex = model.getValueAt(i, 4 ).toString();
        if(sex.equals("male"))
        {
            male.setSelected(true);
        }
        else if(sex.equals("female"))
        {
            female.setSelected(true);
        }
        if(other.equals("other"))
        {
            other.setSelected(true);
        }
        fathersName.setText(model.getValueAt(i, 5).toString());
        mothersName.setText(model.getValueAt(i, 6).toString());
        try{
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(i,7));
            dateOfBirth.setDate(date);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        try{
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(i,8));
            dateOfDeath.setDate(date);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }

        timeOfDeath.setText(model.getValueAt(i, 9).toString());
        causeOfDeath.setText(model.getValueAt(i, 10).toString());
        nid.setText(model.getValueAt(i, 11).toString());
        birthCertificateNo.setText(model.getValueAt(i, 12).toString());
        try{
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(i,13));
            burriedDate.setDate(date);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        try{
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(i,14));
            recycleDate.setDate(date);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        id.setText(model.getValueAt(i, 15).toString());
        GuardianName.setText(model.getValueAt(i, 16).toString());
        relation.setText(model.getValueAt(i, 17).toString());
        ownerNid.setText(model.getValueAt(i, 18).toString());
        guardianAddress.setText(model.getValueAt(i, 19).toString());
        guardianContactNo.setText(model.getValueAt(i, 20).toString());
        fee.setText(model.getValueAt(i, 21).toString());
         
        

    }//GEN-LAST:event_jTable1MouseClicked

    
    
    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane2MouseClicked

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
            java.util.logging.Logger.getLogger(UpdatePermanent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdatePermanent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdatePermanent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdatePermanent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdatePermanent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField GuardianName;
    private javax.swing.JTextField birthCertificateNo;
    private com.toedter.calendar.JDateChooser burriedDate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField causeOfDeath;
    private com.toedter.calendar.JDateChooser dateOfBirth;
    private com.toedter.calendar.JDateChooser dateOfDeath;
    private javax.swing.JButton delete;
    private javax.swing.JButton delete1;
    private javax.swing.JPanel deletePanel;
    private javax.swing.JPanel deletePanel1;
    private javax.swing.JTextField fathersName;
    private javax.swing.JTextField fee;
    private javax.swing.JRadioButton female;
    private javax.swing.JTextField guardianAddress;
    private javax.swing.JTextField guardianContactNo;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField mothersName;
    private javax.swing.JTextField name;
    private javax.swing.JTextField nid;
    private javax.swing.JRadioButton other;
    private javax.swing.JTextField ownerNid;
    private javax.swing.JTextField plotNo;
    private javax.swing.JComboBox<String> plotSize;
    private com.toedter.calendar.JDateChooser recycleDate;
    private javax.swing.JTextField relation;
    private javax.swing.JLabel signinBackLabel;
    private javax.swing.JLabel signinBackLabel1;
    private javax.swing.JTextField timeOfDeath;
    private cambodia.raven.Time timeSelector;
    private javax.swing.JPanel upPanel;
    private javax.swing.JButton update;
    private javax.swing.JPanel updatePanel;
    // End of variables declaration//GEN-END:variables
}
