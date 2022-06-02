/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.demo1_gui;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicListUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ddom6
 */
public class frmMain extends javax.swing.JFrame {

    /**
     * Creates new form frmMain
     */
    public frmMain() {
        initComponents();

//        cbCounTry.addItem(new QuocGia("VN", "Việt Nam"));
//        cbCounTry.addItem(new QuocGia("US", "Mỹ"));
//        cbCounTry.addItem(new QuocGia("JP", "Nhật Bản"));
//      combo Box or Post-Creation Code in [Code]
//----------------
//      Table
        DefaultTableModel defaultTableModel = new DefaultTableModel();

        defaultTableModel.addColumn("Mã Quốc Gia");
        defaultTableModel.addColumn("Tên Quốc Gia");

        defaultTableModel.addRow(new Object[]{"VN", "Việt Nam"});
        defaultTableModel.addRow(new Object[]{"US", "Mỹ"});
        defaultTableModel.addRow(new Object[]{"JP", "Nhật Bản"});

        tbCounTry.setModel(defaultTableModel);

        ListSelectionModel listSelectionModel = tbCounTry.getSelectionModel();

        listSelectionModel.setSelectionMode(listSelectionModel.SINGLE_INTERVAL_SELECTION);

        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int[] rows = tbCounTry.getSelectedRows();
                int[] cols = tbCounTry.getSelectedColumns();

                String select = String.valueOf(tbCounTry.getValueAt(rows[0], cols[0]));

                lbresult.setText("Result: " + select);
            }
        });

//----------------
//      List
        DefaultListModel<QuocGia> defaultListModel = new DefaultListModel<>();
        defaultListModel.addElement(new QuocGia("VN", "Việt Nam"));
        defaultListModel.addElement(new QuocGia("JP", "Nhật Bản"));
        defaultListModel.addElement(new QuocGia("USA", "Mỹ"));
        lstCounTry.setModel(defaultListModel);

//        Spinner 
        QuocGia qg1 = new QuocGia("VN", "Việt Nam");
        QuocGia qg2 = new QuocGia("JP", "Nhật Bản");
        QuocGia qg3 = new QuocGia("USA", "Mỹ");

        SpinnerListModel spinnerListModel = new SpinnerListModel();
    }

    public frmMain(String TK) {
        initComponents();
        this.TaiKhoan = TK;
        lbTaiKhoan.setText("Tài khoản: " + TaiKhoan);

    }
    private String TaiKhoan;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbTaiKhoan = new javax.swing.JLabel();
        cbCounTry = new javax.swing.JComboBox<>();
        cbCounTry.addItem(new QuocGia("VN", "Việt Nam"));
        cbCounTry.addItem(new QuocGia("US", "Mỹ"));
        cbCounTry.addItem(new QuocGia("JP", "Nhật Bản"));
        lbresult = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCounTry = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstCounTry = new javax.swing.JList<>();
        btnResult = new javax.swing.JButton();
        spinNumber = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Chức năng hệ thống");

        lbTaiKhoan.setText("Tài khoản");

        cbCounTry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCounTryActionPerformed(evt);
            }
        });

        lbresult.setText("result: ");

        tbCounTry.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã", "Tên"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbCounTry);

        jScrollPane2.setViewportView(lstCounTry);

        btnResult.setText("Result");
        btnResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultActionPerformed(evt);
            }
        });

        spinNumber.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 5));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(118, 118, 118)
                                .addComponent(spinNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnResult, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(lbresult, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(127, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTaiKhoan)
                            .addComponent(cbCounTry, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 57, Short.MAX_VALUE)
                        .addComponent(lbTaiKhoan)
                        .addGap(47, 47, 47)
                        .addComponent(cbCounTry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(spinNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResult, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbresult))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbCounTryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCounTryActionPerformed
        // TODO add your handling code here:
        QuocGia result = (QuocGia) (cbCounTry.getSelectedItem());

        lbresult.setText("Result: " + result);
    }//GEN-LAST:event_cbCounTryActionPerformed

    private void btnResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultActionPerformed
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thêm không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (x == JOptionPane.YES_OPTION) {
            lbresult.setText("Result: Thêm");
        }
        if (lstCounTry.getSelectedIndex() != -1) {
            List<QuocGia> countries = lstCounTry.getSelectedValuesList();
            String result = "";
            for (QuocGia s : countries) {
                result += " " + s.toString();
            }
            lbresult.setText("Result: " + result);
        }

        int value = (int) spinNumber.getValue();
        lbresult.setText("Result: " + value);

//        String input = JOptionPane.showInputDialog(this, "Mời nhập tên", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
//        lbresult.setText("Result: " + input);
    }//GEN-LAST:event_btnResultActionPerformed

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
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnResult;
    private javax.swing.JComboBox<QuocGia> cbCounTry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbTaiKhoan;
    private javax.swing.JLabel lbresult;
    private javax.swing.JList<QuocGia> lstCounTry;
    private javax.swing.JSpinner spinNumber;
    private javax.swing.JTable tbCounTry;
    // End of variables declaration//GEN-END:variables
}
