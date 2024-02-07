/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.xemacscode.demo;
import java.awt.Color;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Seler extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    Object[] data = new Object[0];

    public Seler() {
        initComponents();
        model = (DefaultTableModel) Selable.getModel();
        showData();
    }

    Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;
     private JFrame frame;
    public void SelectSeller() {
        showData();
    }

    public void clearRow() {
        int row = model.getRowCount() - 1;
        while (row > -1) {
            model.removeRow(row);
            row--;
        }
    }

    public void showData() {
        clearRow();
        try {
            Connection Con = DBConnection.connectDB();
            St = Con.createStatement();
            Rs = St.executeQuery("Select * from SELLERTB");
            int row = 0;
            while (Rs.next()) {
                model.addRow(data);
                model.setValueAt(Rs.getString(1), row, 0);
                model.setValueAt(Rs.getString(2), row, 1);
                model.setValueAt(Rs.getString(3), row, 2);
                model.setValueAt(Rs.getString(4), row, 3);
                row++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearTextBox() {
        SelId.setText("");
        SelName.setText("");
        SelPass.setText("");
        GenderCb.setSelectedIndex(0);
    }

    public void EditRecord() {

        String selid = SelId.getText();
        String selname = SelName.getText();
        String selpass = SelPass.getText();
        String gendercb = GenderCb.getSelectedItem().toString();
        
        String sql = "update SELLERTB set "
                + "SelName='" + selname + "',"
                + "SelPass='" + selpass + "',"
                + "SelGender='" + gendercb + "' "
                + "where SelId='" + selid + "'";
        try {
            Connection c = DBConnection.connectDB();
            Statement stm = c.createStatement();
            if (stm.executeUpdate(sql) != -1) {
                JOptionPane.showMessageDialog(this, "Seller Updated");
                showData();
                clearTextBox();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Selable = new javax.swing.JTable();
        SelPass = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        GenderCb = new javax.swing.JComboBox<>();
        AddBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        EditBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        DeleteBtn = new javax.swing.JButton();
        ClearBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SelName = new javax.swing.JTextField();
        SelId = new javax.swing.JTextField();
        lbl_SellId = new javax.swing.JLabel();
        lbl_SellPass = new javax.swing.JLabel();
        lbl_SellName = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(0, 0, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setForeground(new java.awt.Color(255, 102, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Selable.setBackground(new java.awt.Color(0, 0, 51));
        Selable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Selable.setForeground(new java.awt.Color(255, 255, 255));
        Selable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "PASSWORD", "GENDER"
            }
        ));
        Selable.setGridColor(new java.awt.Color(255, 102, 0));
        Selable.setRowHeight(25);
        Selable.setSelectionBackground(new java.awt.Color(0, 51, 102));
        Selable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        Selable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SelableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Selable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 303, 799, 211));

        SelPass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SelPass.setForeground(new java.awt.Color(0, 51, 102));
        SelPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SelPassKeyReleased(evt);
            }
        });
        jPanel1.add(SelPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 185, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("SELLER LIST");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 268, 167, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NAME");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 140, 81, -1));

        GenderCb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        GenderCb.setForeground(new java.awt.Color(0, 51, 102));
        GenderCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Famale" }));
        GenderCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenderCbActionPerformed(evt);
            }
        });
        jPanel1.add(GenderCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 137, 185, -1));

        AddBtn.setBackground(new java.awt.Color(204, 255, 255));
        AddBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AddBtn.setText("Add");
        AddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBtnMouseClicked(evt);
            }
        });
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });
        jPanel1.add(AddBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 217, 100, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SELLER ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 121, -1));

        EditBtn.setBackground(new java.awt.Color(204, 204, 255));
        EditBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        EditBtn.setText("Edit");
        EditBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditBtnMouseClicked(evt);
            }
        });
        jPanel1.add(EditBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 217, 100, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PASSWORD");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 114, -1));

        DeleteBtn.setBackground(new java.awt.Color(255, 51, 51));
        DeleteBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DeleteBtn.setText("Delete");
        DeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteBtnMouseClicked(evt);
            }
        });
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });
        jPanel1.add(DeleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 217, 100, -1));

        ClearBtn.setBackground(new java.awt.Color(255, 255, 204));
        ClearBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ClearBtn.setText("Clear");
        ClearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearBtnMouseClicked(evt);
            }
        });
        jPanel1.add(ClearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 217, 100, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("GENDER");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 140, 94, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MANAGE SELLER");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 6, -1, -1));

        SelName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SelName.setForeground(new java.awt.Color(0, 51, 102));
        SelName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SelNameKeyReleased(evt);
            }
        });
        jPanel1.add(SelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 185, -1));

        SelId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SelId.setForeground(new java.awt.Color(0, 51, 102));
        SelId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SelIdKeyReleased(evt);
            }
        });
        jPanel1.add(SelId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 185, -1));

        lbl_SellId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_SellId.setForeground(new java.awt.Color(255, 255, 0));
        lbl_SellId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lbl_SellIdKeyReleased(evt);
            }
        });
        jPanel1.add(lbl_SellId, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 110, 20));

        lbl_SellPass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_SellPass.setForeground(new java.awt.Color(255, 255, 0));
        lbl_SellPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lbl_SellPassKeyReleased(evt);
            }
        });
        jPanel1.add(lbl_SellPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 130, 20));

        lbl_SellName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_SellName.setForeground(new java.awt.Color(255, 255, 0));
        jPanel1.add(lbl_SellName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 120, 20));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 850, 520));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/x-mark-5-32.jpg"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 102, 0));
        jLabel10.setText("PRODUCTS");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 140, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 102, 0));
        jLabel13.setText("LOGOUT");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 539, -1, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 102, 0));
        jLabel12.setText("CATEGORIES");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1036, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GenderCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenderCbActionPerformed
        
    }//GEN-LAST:event_GenderCbActionPerformed

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed

    }//GEN-LAST:event_AddBtnActionPerformed

    private void AddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBtnMouseClicked
        if (SelId.getText().trim().isEmpty() && SelName.getText().trim().isEmpty() && SelPass.getText().trim().isEmpty()) {
            lbl_SellId.setText("Sell ID is Empty");
            lbl_SellName.setText("Name is Empty");
            lbl_SellPass.setText("Password is Empty");
            //JOptionPane.showMessageDialog(this, "Missing Information");
        } else if (SelId.getText().trim().isEmpty()) {
            lbl_SellId.setText("Sell ID is Empty");
        } else if (SelName.getText().trim().isEmpty()) {
            lbl_SellName.setText("Name is Empty");
        } else if (SelPass.getText().trim().isEmpty()) {
            lbl_SellPass.setText("Password is Empty");
        } else {

            try {
                //  Connection Con = DBConnection.connectDB();
                Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:/demo", "root", "");
                PreparedStatement add = Con.prepareStatement("insert into SELLERTB values(?,?,?,?)");
                add.setInt(1, Integer.valueOf(SelId.getText()));
                add.setString(2, SelName.getText());
                add.setString(3, SelPass.getText());
                add.setString(4, GenderCb.getSelectedItem().toString());
                int row = add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Seller Added Successfully");
                showData();
                Con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_AddBtnMouseClicked

    private void lbl_SellIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_SellIdKeyReleased

    }//GEN-LAST:event_lbl_SellIdKeyReleased

    private void lbl_SellPassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_SellPassKeyReleased

    }//GEN-LAST:event_lbl_SellPassKeyReleased

    private void SelIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SelIdKeyReleased
        lbl_SellId.setText("");
    }//GEN-LAST:event_SelIdKeyReleased

    private void SelNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SelNameKeyReleased
        lbl_SellName.setText("");
    }//GEN-LAST:event_SelNameKeyReleased

    private void SelPassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SelPassKeyReleased
        lbl_SellPass.setText("");
    }//GEN-LAST:event_SelPassKeyReleased

    private void SelableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelableMouseClicked
        int select = Selable.getSelectedRow();
        SelId.setText(Selable.getValueAt(select, 0).toString());
        SelName.setText(Selable.getValueAt(select, 1).toString());
        SelPass.setText(Selable.getValueAt(select, 2).toString());
        String adName = Selable.getValueAt(select, 3).toString();
        for (int i = 0; i < GenderCb.getItemCount(); i++) {
            if (adName.equals(GenderCb.getItemAt(i))) {
                GenderCb.setSelectedIndex(i);
            }
            
        }
        
    }//GEN-LAST:event_SelableMouseClicked

    private void ClearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearBtnMouseClicked
        clearTextBox();
    }//GEN-LAST:event_ClearBtnMouseClicked

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void DeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteBtnMouseClicked
        if (SelId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter The Seller To Deleted");
        } else {
            try {
                Connection c = DBConnection.connectDB();
                String delId = SelId.getText();
                String sql = "delete from sellertb where SelId='" + delId + "'";
                Statement stm = c.createStatement();
                if (stm.executeUpdate(sql) != -1) {
                    JOptionPane.showMessageDialog(this, "Seller Deleted Succesfully", "recording results",
                            JOptionPane.INFORMATION_MESSAGE);
                    clearTextBox();
                    showData();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_DeleteBtnMouseClicked

    private void EditBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditBtnMouseClicked
        if (SelId.getText().isEmpty() && SelName.getText().isEmpty() && SelPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter The Seller To Edit");
        } else {
            EditRecord();
        }
    }//GEN-LAST:event_EditBtnMouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        new Products().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        if (JOptionPane.showConfirmDialog(frame, "You want to Logout?", "POS",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        new Category().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Seler().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton EditBtn;
    private javax.swing.JComboBox<String> GenderCb;
    private javax.swing.JTextField SelId;
    private javax.swing.JTextField SelName;
    private javax.swing.JTextField SelPass;
    private javax.swing.JTable Selable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_SellId;
    private javax.swing.JLabel lbl_SellName;
    private javax.swing.JLabel lbl_SellPass;
    // End of variables declaration//GEN-END:variables
}
