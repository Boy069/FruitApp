package computer;

import java.awt.Color;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Frame extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    Object[] data = new Object[0];

    public Frame() {
        initComponents();
        model = (DefaultTableModel) tb_Sdb.getModel();
        showData();
    }
    private JFrame Frame;

    public void showData() {
        clearRow();
        String sql = "select * from tbcompar";
        try {
            Connection c = ComPuter.connectDB();
            ResultSet rs = c.createStatement().executeQuery(sql);
            int row = 0;
            while (rs.next()) {
                model.addRow(data);
                model.setValueAt(rs.getString(1), row, 0);
                model.setValueAt(rs.getString(2), row, 1);
                model.setValueAt(rs.getString(3), row, 2);
                model.setValueAt(rs.getString(4), row, 3);
                model.setValueAt(rs.getString(5), row, 4);
                row++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertdata() {
        String stdid = txt_stdbId.getText();
        String stdname = txt_stdbNmae.getText();
        String stddmy = txt_stdbDmy.getText();
        String stdtime = txt_stdbTime.getText();
        String room = cb_dbRoom.getSelectedItem().toString();
        String sql = "insert into tbCompar value("
                + " ' " + stdid + " ' , "
                + " ' " + stdname + " ' , "
                + " ' " + stddmy + " ' , "
                + " ' " + stdtime + " ' , "
                + " ' " + room + " ' )";
        try {
            Connection c = ComPuter.connectDB();
            Statement stm = c.createStatement();
            if (stm.executeUpdate(sql) != -1) {
                JOptionPane.showMessageDialog(null, "insert complete");
                clearTextBox();
                showData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearTextBox() {
        txt_stdbId.setText("");
        txt_stdbNmae.setText("");
        txt_stdbDmy.setText("");
        txt_stdbTime.setText("");
        cb_dbRoom.setSelectedIndex(0);
    }

    public void clearRow() {
        int row = model.getRowCount() - 1;
        while (row > -1) {
            model.removeRow(row);
            row--;
        }
    }

    public void deleteRecord() {
        String delId = txt_stdbId.getText();
        String sql = "delete from tbCompar where stdlD=' " + delId + " ' ";
        try {
            Connection c = ComPuter.connectDB();
            Statement stm = c.createStatement();
            if (stm.executeUpdate(sql) != -1) {
                JOptionPane.showMessageDialog(this, "Complete delete", "recording results",
                        JOptionPane.INFORMATION_MESSAGE);
                clearTextBox();
                showData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateRecord() {
        String stdid = txt_stdbId.getText();
        String stdname = txt_stdbNmae.getText();
        String stddmy = txt_stdbDmy.getText();
        String stdtime = txt_stdbTime.getText();
        String room = cb_dbRoom.getSelectedItem().toString();
        String sql = "update tbCompar set "
                + "stdName=' " + stdname + " ' , "
                + "stdDmy=' " + stddmy + " ' , "
                + "stdTime=' " + stdtime + " ' , "
                + "stdRoom=' " + room + " ' "
                + "where stdlD=' " + stdid + " ' ";
        try {
            Connection c = ComPuter.connectDB();
            Statement stm = c.createStatement();
            if (stm.executeUpdate(sql) != -1) {
                JOptionPane.showMessageDialog(this, "update finished");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Sdb = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_stdbId = new javax.swing.JTextField();
        txt_stdbNmae = new javax.swing.JTextField();
        txt_stdbDmy = new javax.swing.JTextField();
        txt_stdbTime = new javax.swing.JTextField();
        cb_dbRoom = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btn_Insert = new javax.swing.JButton();
        btn_Update = new javax.swing.JButton();
        btn_Delete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cbExit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Book a computer room", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 204))); // NOI18N

        tb_Sdb.setBackground(new java.awt.Color(153, 255, 102));
        tb_Sdb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "DMY", "Time", "Room"
            }
        ));
        tb_Sdb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_SdbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_Sdb);

        jLabel1.setBackground(new java.awt.Color(255, 255, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 2, 18)); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Segoe UI Historic", 2, 18)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI Historic", 2, 18)); // NOI18N
        jLabel3.setText("day/month/year");

        jLabel4.setFont(new java.awt.Font("Segoe UI Historic", 2, 18)); // NOI18N
        jLabel4.setText("Time");

        jLabel5.setFont(new java.awt.Font("Segoe UI Historic", 2, 18)); // NOI18N
        jLabel5.setText("Room");

        txt_stdbId.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        txt_stdbId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_stdbIdActionPerformed(evt);
            }
        });

        txt_stdbNmae.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N

        txt_stdbDmy.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N

        txt_stdbTime.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N

        cb_dbRoom.setFont(new java.awt.Font("Segoe UI Historic", 2, 14)); // NOI18N
        cb_dbRoom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT 301", "IT 302", "IT 303", "IT 304", "IT 305" }));

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "main menu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(204, 0, 0))); // NOI18N

        btn_Insert.setText("INSERT");
        btn_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InsertActionPerformed(evt);
            }
        });

        btn_Update.setText("UPDATE");
        btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateActionPerformed(evt);
            }
        });

        btn_Delete.setText("DELETE");
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_Update)
                    .addComponent(btn_Delete, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Insert, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btn_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btn_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 0, 51));

        cbExit.setText("Exit");
        cbExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbExit)
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon("D:\\computer.png")); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon("D:\\time-left.png")); // NOI18N
        jLabel7.setText("jLabel7");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon("D:\\calendar.png")); // NOI18N
        jLabel8.setText("jLabel8");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_stdbId, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_stdbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_stdbDmy, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_stdbNmae, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cb_dbRoom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_stdbId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_stdbNmae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_stdbDmy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_stdbTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cb_dbRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InsertActionPerformed
        insertdata();
    }//GEN-LAST:event_btn_InsertActionPerformed

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
        deleteRecord();
        showData();
        clearTextBox();
    }//GEN-LAST:event_btn_DeleteActionPerformed

    private void txt_stdbIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_stdbIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_stdbIdActionPerformed

    private void tb_SdbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_SdbMouseClicked
        int select = tb_Sdb.getSelectedRow();
        txt_stdbId.setText(tb_Sdb.getValueAt(select, 0).toString());
        txt_stdbNmae.setText(tb_Sdb.getValueAt(select, 1).toString());
        txt_stdbDmy.setText(tb_Sdb.getValueAt(select, 2).toString());
        txt_stdbTime.setText(tb_Sdb.getValueAt(select, 3).toString());
        String adName = tb_Sdb.getValueAt(select, 4).toString();
        for (int i = 0; i < cb_dbRoom.getItemCount(); i++) {
            if (adName.equals(cb_dbRoom.getItemAt(i))) {
                cb_dbRoom.setSelectedIndex(i);
            }

        }
    }//GEN-LAST:event_tb_SdbMouseClicked

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
        if (txt_stdbId.getText().trim().isEmpty() && txt_stdbNmae.getText().trim().isEmpty() && txt_stdbDmy.getText().trim().isEmpty() && txt_stdbTime.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter The Seller To Edit");
        } else {
            updateRecord();
        }
    }//GEN-LAST:event_btn_UpdateActionPerformed

    private void cbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbExitActionPerformed
        Frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(Frame, "You want to Exit?", "POS",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_cbExitActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_Insert;
    private javax.swing.JButton btn_Update;
    private javax.swing.JButton cbExit;
    private javax.swing.JComboBox<String> cb_dbRoom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_Sdb;
    private javax.swing.JTextField txt_stdbDmy;
    private javax.swing.JTextField txt_stdbId;
    private javax.swing.JTextField txt_stdbNmae;
    private javax.swing.JTextField txt_stdbTime;
    // End of variables declaration//GEN-END:variables
}
