/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.xemacscode.demo;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Category extends javax.swing.JFrame {

   DefaultTableModel model = new DefaultTableModel();
    Object[] data = new Object[0];
    
    public Category() {
        initComponents();
        model = (DefaultTableModel) CateTable.getModel();
        showData();
    }

    Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;
     private JFrame frame;
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
            Rs = St.executeQuery("Select * from categorytb");
            int row = 0;
            while (Rs.next()) {
                model.addRow(data);
                model.setValueAt(Rs.getString(1), row, 0);
                model.setValueAt(Rs.getString(2), row, 1);
                model.setValueAt(Rs.getString(3), row, 2);   
                row++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clearTextBox() {
        txt_CatId.setText("");
        txt_CatName.setText("");
        txt_CatDesc.setText("");
    }
    public void EditRecord() {

        String catid = txt_CatId.getText();
        String catname = txt_CatName.getText();
        String catdesc = txt_CatDesc.getText();
        
        String sql = "update CATEGORYTB set "
                + "CatName='" + catname + "',"
                + "CatDesc='" + catdesc + "' "
                + "where CatId='" + catid + "'";
        try {
            Connection c = DBConnection.connectDB();
            Statement stm = c.createStatement();
            if (stm.executeUpdate(sql) != -1) {
                JOptionPane.showMessageDialog(this, "Categories Updated");
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        bt_Edit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CateTable = new javax.swing.JTable();
        btn_Clear = new javax.swing.JButton();
        txt_CatName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_CatDesc = new javax.swing.JTextField();
        txt_CatId = new javax.swing.JTextField();
        Addbtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbl_CatId = new javax.swing.JLabel();
        lbl_CatName = new javax.swing.JLabel();
        lbl_CatDesc = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setForeground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));

        bt_Edit.setBackground(new java.awt.Color(204, 204, 255));
        bt_Edit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bt_Edit.setText("Edit");
        bt_Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_EditMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DESCRIPTION");

        jButton3.setBackground(new java.awt.Color(255, 51, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        CateTable.setBackground(new java.awt.Color(0, 0, 51));
        CateTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CateTable.setForeground(new java.awt.Color(255, 255, 255));
        CateTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "NAME", "DESCRIPTION"
            }
        ));
        CateTable.setGridColor(new java.awt.Color(255, 102, 0));
        CateTable.setRowHeight(25);
        CateTable.setSelectionBackground(new java.awt.Color(0, 51, 102));
        CateTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        CateTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CateTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CateTable);

        btn_Clear.setBackground(new java.awt.Color(255, 255, 204));
        btn_Clear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_Clear.setText("Clear");
        btn_Clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ClearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ClearMouseEntered(evt);
            }
        });

        txt_CatName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_CatName.setForeground(new java.awt.Color(0, 51, 102));
        txt_CatName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_CatNameKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CATECORIES LIST");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NAME");

        txt_CatDesc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_CatDesc.setForeground(new java.awt.Color(0, 51, 102));
        txt_CatDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_CatDescKeyReleased(evt);
            }
        });

        txt_CatId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_CatId.setForeground(new java.awt.Color(0, 51, 102));
        txt_CatId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_CatIdKeyReleased(evt);
            }
        });

        Addbtn.setBackground(new java.awt.Color(204, 255, 255));
        Addbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Addbtn.setText("Add");
        Addbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddbtnMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CATID");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(Addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(bt_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btn_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_CatName, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lbl_CatName, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(150, 150, 150))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lbl_CatId, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_CatId, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbl_CatDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_CatDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(251, 251, 251))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_CatName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txt_CatId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_CatId, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_CatName, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_CatDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_CatDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Edit)
                    .addComponent(jButton3)
                    .addComponent(btn_Clear)
                    .addComponent(Addbtn))
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 850, 490));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MANAGE CATEGORIES");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/x-mark-5-32.jpg"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 20, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 102, 0));
        jLabel10.setText("PRODUCTS");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 102, 0));
        jLabel12.setText("SELLER");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 102, 0));
        jLabel13.setText("LOGOUT");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddbtnMouseClicked
        if (txt_CatId.getText().trim().isEmpty() && txt_CatName.getText().trim().isEmpty() && txt_CatDesc.getText().trim().isEmpty()) {
            lbl_CatId.setText("CatID is Empty");
            lbl_CatName.setText("Name is Empty");
            lbl_CatDesc.setText("Description is Empty");
            //JOptionPane.showMessageDialog(this, "Missing Information");
        } else if (txt_CatId.getText().trim().isEmpty()) {
            lbl_CatId.setText("Sell ID is Empty");
        } else if (txt_CatName.getText().trim().isEmpty()) {
            lbl_CatName.setText("Name is Empty");
        } else if (txt_CatDesc.getText().trim().isEmpty()) {
            lbl_CatDesc.setText("Password is Empty");
        } else {

            try {
                //  Connection Con = DBConnection.connectDB();
                Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:/demo", "root", "");
                PreparedStatement add = Con.prepareStatement("insert into CATEGORYTB values(?,?,?)");
                add.setInt(1, Integer.valueOf(txt_CatId.getText()));
                add.setString(2, txt_CatName.getText());
                add.setString(3, txt_CatDesc.getText());
                int row = add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Categories Added Successfully");
                showData();
                Con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_AddbtnMouseClicked

    private void btn_ClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ClearMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ClearMouseEntered

    private void btn_ClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ClearMouseClicked
        clearTextBox();
    }//GEN-LAST:event_btn_ClearMouseClicked

    private void txt_CatIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CatIdKeyReleased
        lbl_CatId.setText("");
    }//GEN-LAST:event_txt_CatIdKeyReleased

    private void txt_CatNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CatNameKeyReleased
        lbl_CatName.setText("");
    }//GEN-LAST:event_txt_CatNameKeyReleased

    private void txt_CatDescKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CatDescKeyReleased
        lbl_CatDesc.setText("");
    }//GEN-LAST:event_txt_CatDescKeyReleased

    private void CateTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CateTableMouseClicked
        int select = CateTable.getSelectedRow();
        txt_CatId.setText(CateTable.getValueAt(select, 0).toString());
        txt_CatName.setText(CateTable.getValueAt(select, 1).toString());
        txt_CatDesc.setText(CateTable.getValueAt(select, 2).toString());
        
    }//GEN-LAST:event_CateTableMouseClicked

    private void bt_EditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_EditMouseClicked
        if (txt_CatId.getText().isEmpty() && txt_CatName.getText().isEmpty() && txt_CatDesc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "");
        } else {
            EditRecord();
        }
    }//GEN-LAST:event_bt_EditMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        if (txt_CatId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter The Seller To Deleted");
        } else {
            try {
                Connection c = DBConnection.connectDB();
                String delId = txt_CatId.getText();
                String sql = "delete from categorytb where CatId='" + delId + "'";
                Statement stm = c.createStatement();
                if (stm.executeUpdate(sql) != -1) {
                    JOptionPane.showMessageDialog(this, "category Deleted Succesfully", "recording results",
                            JOptionPane.INFORMATION_MESSAGE);
                    clearTextBox();
                    showData();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        new Seler().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

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
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Category().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addbtn;
    private javax.swing.JTable CateTable;
    private javax.swing.JButton bt_Edit;
    private javax.swing.JButton btn_Clear;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_CatDesc;
    private javax.swing.JLabel lbl_CatId;
    private javax.swing.JLabel lbl_CatName;
    private javax.swing.JTextField txt_CatDesc;
    private javax.swing.JTextField txt_CatId;
    private javax.swing.JTextField txt_CatName;
    // End of variables declaration//GEN-END:variables
}
