/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import Controllers.DangNhapController;
import Controllers.PhongController;
import Models.Phong;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.w3c.dom.events.MouseEvent;

/**
 *
 * @author ddom6
 */
public final class TrangChu extends javax.swing.JFrame {

    private PhongController phongController = new PhongController();
    private DangNhapController dangNhapController;
    private String TaiKhoan;
    private String MatKhau;

    /**
     * Creates new form TrangChu
     */
    public TrangChu() {
        initComponents();
        dangNhapController = new DangNhapController();
//        ListPhong.setComponentPopupMenu(PopupMenuPhong);
        PopupMenu();
        CheckAll_Phong();
    }

    public TrangChu(String TK, String MK) {
        initComponents();
        dangNhapController = new DangNhapController();
        this.TaiKhoan = TK;
        this.MatKhau = MK;
        PopupMenu();
        CheckAll_Phong();

    }

    public void PopupMenu() {
        Component[] component = ListPhong.getComponents();
        for (int i = 0; i < component.length; i++) {
            if (component[i] instanceof JButton) {
                JButton button = (JButton) component[i];
                String CurrentBtn = button.getText();

                String[] parts = CurrentBtn.split(" ");
                String Status = phongController.CheckStatus_Phong("PH" + parts[1]);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        if (Status.equals("Chưa thuê")) {
                            frmThueTraPhong fThueTraPhong = new frmThueTraPhong(TaiKhoan, MatKhau, parts[1], "Check_in");
                            fThueTraPhong.setLocationRelativeTo(null);
                            fThueTraPhong.setVisible(true);
                        } else if (Status.equals("Đã thuê")) {
                            frmThueTraPhong fThueTraPhong = new frmThueTraPhong(TaiKhoan, MatKhau, parts[1], "Check_out");
                            fThueTraPhong.setLocationRelativeTo(null);
                            fThueTraPhong.setVisible(true);
                        } else if (Status.equals("Hỏng")) {
                            frmPhong fPhong = new frmPhong(TaiKhoan, MatKhau, parts[1]);
                            fPhong.setLocationRelativeTo(null);
                            fPhong.setVisible(true);
                        }

                    }

                });

                button.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent e) {

                    }

                    @Override
                    public void mousePressed(java.awt.event.MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) { // if right click

                            String Status = phongController.CheckStatus_Phong("PH" + parts[1]);
                            if (Status.equals("Chưa thuê")) {
                                menuThue.setEnabled(true);
                                menuTra.setEnabled(false);
                            } else if (Status.equals("Đã thuê")) {
                                menuThue.setEnabled(false);
                                menuTra.setEnabled(true);
                            } else if (Status.equals("Hỏng")) {
                                menuThue.setEnabled(false);
                                menuTra.setEnabled(false);
                            }
                            button.setComponentPopupMenu(PopupMenuPhong);

                        }
                    }

                    @Override
                    public void mouseReleased(java.awt.event.MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent e) {
                    }

                    @Override
                    public void mouseExited(java.awt.event.MouseEvent e) {
                    }
                });
            }

        }

    }

    public void CheckAll_Phong() {
        Component[] component = ListPhong.getComponents();
        for (int i = 0; i < component.length; i++) {
            if (component[i] instanceof JButton) {
                JButton button = (JButton) component[i];
                String CurrentBtn = button.getText();
                String[] parts = CurrentBtn.split(" ");
                String Status = phongController.CheckStatus_Phong("PH" + parts[1]);
                if (Status.equals("Chưa thuê")) {
                    button.setBackground(new Color(240, 240, 240));
                } else if (Status.equals("Đã thuê")) {
                    button.setBackground(new Color(255, 255, 0));
                } else if (Status.equals("Hỏng")) {
                    button.setBackground(new Color(250, 51, 51));
                }

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

        PopupMenuPhong = new javax.swing.JPopupMenu();
        menuThue = new javax.swing.JMenuItem();
        menuTra = new javax.swing.JMenuItem();
        menuQLPhong = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnManageRoom = new javax.swing.JButton();
        btnManageStaff = new javax.swing.JButton();
        btnStatistic = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        ListPhong = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnQLPhong = new javax.swing.JMenuItem();
        btnQLNhanVien = new javax.swing.JMenuItem();
        btnQuanLyTK = new javax.swing.JMenuItem();
        MenuItemQLThue_Tra = new javax.swing.JMenuItem();
        MenuitemQLDoDung = new javax.swing.JMenuItem();
        MenuitemQLDichVu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        btnLogOut_Toolbar = new javax.swing.JMenuItem();
        frmChangePassword = new javax.swing.JMenuItem();

        menuThue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuThue.setText("Thuê phòng");
        menuThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuThueActionPerformed(evt);
            }
        });
        PopupMenuPhong.add(menuThue);

        menuTra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuTra.setText("Trả phòng");
        menuTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTraActionPerformed(evt);
            }
        });
        PopupMenuPhong.add(menuTra);

        menuQLPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuQLPhong.setText("Quản lý phòng");
        menuQLPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuQLPhongActionPerformed(evt);
            }
        });
        PopupMenuPhong.add(menuQLPhong);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trang chủ");
        setSize(new java.awt.Dimension(750, 700));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QUẢN LÝ KHÁCH SẠN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 760, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\mau_background_don_gian_11_768x536_bffdffbf5cd74dc4a3426fdccc2d180f_master.jpg")); // NOI18N
        jLabel1.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 2, -1, 70));

        btnHome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\Home.png")); // NOI18N
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnManageRoom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnManageRoom.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\room.png")); // NOI18N
        btnManageRoom.setText("Quản lý phòng");
        btnManageRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageRoomActionPerformed(evt);
            }
        });

        btnManageStaff.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnManageStaff.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\multiple-users-silhouette.png")); // NOI18N
        btnManageStaff.setText("Quản lý nhân viên");
        btnManageStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageStaffActionPerformed(evt);
            }
        });

        btnStatistic.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnStatistic.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\trend.png")); // NOI18N
        btnStatistic.setText("Thống kê");
        btnStatistic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatisticActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLogout.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\logout2.png")); // NOI18N
        btnLogout.setText("Đăng xuất");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnManageRoom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnManageStaff)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStatistic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHome)
                    .addComponent(btnManageRoom)
                    .addComponent(btnManageStaff)
                    .addComponent(btnStatistic)
                    .addComponent(btnLogout))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        ListPhong.setBackground(new java.awt.Color(204, 204, 204));
        ListPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách các phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(51, 51, 255))); // NOI18N

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\living-room.png")); // NOI18N
        jButton1.setText("Phòng 01");
        jButton1.setBorder(null);
        jButton1.setPreferredSize(new java.awt.Dimension(110, 33));

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\living-room.png")); // NOI18N
        jButton7.setText("Phòng 02");
        jButton7.setBorder(null);
        jButton7.setPreferredSize(new java.awt.Dimension(110, 33));

        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\living-room.png")); // NOI18N
        jButton8.setText("Phòng 03");
        jButton8.setBorder(null);
        jButton8.setMaximumSize(new java.awt.Dimension(110, 33));
        jButton8.setMinimumSize(new java.awt.Dimension(110, 33));
        jButton8.setPreferredSize(new java.awt.Dimension(110, 33));

        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\living-room.png")); // NOI18N
        jButton9.setText("Phòng 04");
        jButton9.setBorder(null);
        jButton9.setPreferredSize(new java.awt.Dimension(110, 33));

        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\living-room.png")); // NOI18N
        jButton10.setText("Phòng 05");
        jButton10.setBorder(null);
        jButton10.setPreferredSize(new java.awt.Dimension(110, 33));

        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\living-room.png")); // NOI18N
        jButton11.setText("Phòng 06");
        jButton11.setBorder(null);
        jButton11.setPreferredSize(new java.awt.Dimension(110, 33));

        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\living-room.png")); // NOI18N
        jButton12.setText("Phòng 09");
        jButton12.setBorder(null);
        jButton12.setPreferredSize(new java.awt.Dimension(110, 33));

        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\living-room.png")); // NOI18N
        jButton13.setText("Phòng 08");
        jButton13.setBorder(null);
        jButton13.setPreferredSize(new java.awt.Dimension(110, 33));

        jButton14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\living-room.png")); // NOI18N
        jButton14.setText("Phòng 07");
        jButton14.setBorder(null);
        jButton14.setPreferredSize(new java.awt.Dimension(110, 33));

        jButton15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\living-room.png")); // NOI18N
        jButton15.setText("Phòng 10");
        jButton15.setBorder(null);
        jButton15.setPreferredSize(new java.awt.Dimension(110, 33));

        jButton16.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\living-room.png")); // NOI18N
        jButton16.setText("Phòng 11");
        jButton16.setBorder(null);
        jButton16.setPreferredSize(new java.awt.Dimension(110, 33));

        jButton17.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton17.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\living-room.png")); // NOI18N
        jButton17.setText("Phòng 12");
        jButton17.setBorder(null);
        jButton17.setPreferredSize(new java.awt.Dimension(110, 33));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Chưa thuê");

        jPanel6.setBackground(new java.awt.Color(255, 255, 0));
        jPanel6.setPreferredSize(new java.awt.Dimension(45, 31));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Đã thuê");

        jPanel7.setBackground(new java.awt.Color(255, 51, 51));
        jPanel7.setPreferredSize(new java.awt.Dimension(45, 31));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Hỏng");

        javax.swing.GroupLayout ListPhongLayout = new javax.swing.GroupLayout(ListPhong);
        ListPhong.setLayout(ListPhongLayout);
        ListPhongLayout.setHorizontalGroup(
            ListPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ListPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ListPhongLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(ListPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ListPhongLayout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addGroup(ListPhongLayout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))))
                    .addGroup(ListPhongLayout.createSequentialGroup()
                        .addGroup(ListPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ListPhongLayout.createSequentialGroup()
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ListPhongLayout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(ListPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ListPhongLayout.createSequentialGroup()
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ListPhongLayout.createSequentialGroup()
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ListPhongLayout.setVerticalGroup(
            ListPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ListPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ListPhongLayout.createSequentialGroup()
                        .addGroup(ListPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ListPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ListPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ListPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ListPhongLayout.createSequentialGroup()
                        .addGroup(ListPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ListPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(ListPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jMenuBar1.setMinimumSize(new java.awt.Dimension(249, 40));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(221, 35));

        jMenu1.setForeground(new java.awt.Color(51, 51, 51));
        jMenu1.setText("Quản lý");
        jMenu1.setFocusable(false);
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        btnQLPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnQLPhong.setText("Quản lý phòng");
        btnQLPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLPhongActionPerformed(evt);
            }
        });
        jMenu1.add(btnQLPhong);

        btnQLNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnQLNhanVien.setText("Quản lý nhân viên");
        btnQLNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLNhanVienActionPerformed(evt);
            }
        });
        jMenu1.add(btnQLNhanVien);

        btnQuanLyTK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnQuanLyTK.setText("Quản lý tài khoản");
        btnQuanLyTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyTKActionPerformed(evt);
            }
        });
        jMenu1.add(btnQuanLyTK);

        MenuItemQLThue_Tra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuItemQLThue_Tra.setText("Quản lý thuê, trả phòng");
        MenuItemQLThue_Tra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemQLThue_TraActionPerformed(evt);
            }
        });
        jMenu1.add(MenuItemQLThue_Tra);

        MenuitemQLDoDung.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuitemQLDoDung.setText("Quản lý đồ dùng");
        MenuitemQLDoDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuitemQLDoDungActionPerformed(evt);
            }
        });
        jMenu1.add(MenuitemQLDoDung);

        MenuitemQLDichVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuitemQLDichVu.setText("Quản lý dịch vụ");
        MenuitemQLDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuitemQLDichVuActionPerformed(evt);
            }
        });
        jMenu1.add(MenuitemQLDichVu);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(51, 51, 51));
        jMenu2.setText("Thống kê");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem3.setText("Thống kê doanh số");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setForeground(new java.awt.Color(51, 51, 51));
        jMenu3.setText("Hệ thống");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        btnLogOut_Toolbar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLogOut_Toolbar.setText("Đăng xuất");
        btnLogOut_Toolbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOut_ToolbarActionPerformed(evt);
            }
        });
        jMenu3.add(btnLogOut_Toolbar);

        frmChangePassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        frmChangePassword.setText("Đổi mật khẩu");
        frmChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frmChangePasswordActionPerformed(evt);
            }
        });
        jMenu3.add(frmChangePassword);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ListPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ListPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đăng xuất không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            this.dispose();
            try {
                DangNhap dangNhap = new DangNhap();
                dangNhap.setLocationRelativeTo(null);
                dangNhap.setVisible(true);

            } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
                Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        this.dispose();
        TrangChu trangchu = new TrangChu(TaiKhoan, MatKhau);
        trangchu.setLocationRelativeTo(this);
        trangchu.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnManageStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageStaffActionPerformed
        // TODO add your handling code here:

        if (dangNhapController.GetRoleCurrentAcount(TaiKhoan, MatKhau).equals("ADMIN")) {
            this.dispose();
            frmQLNhanVien frLNhanVien = new frmQLNhanVien(TaiKhoan, MatKhau);
            frLNhanVien.setLocationRelativeTo(this);
            frLNhanVien.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Chỉ ADMIN mới được sử dụng chức năng này", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnManageStaffActionPerformed

    private void btnManageRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageRoomActionPerformed
        // TODO add your handling code here:
        if (dangNhapController.GetRoleCurrentAcount(TaiKhoan, MatKhau).equals("ADMIN") || dangNhapController.GetRoleCurrentAcount(TaiKhoan, MatKhau).equals("USER")) {
            this.dispose();
            frmPhong fPhong = new frmPhong(TaiKhoan, MatKhau, null);
            fPhong.setLocationRelativeTo(this);
            fPhong.setVisible(true);

        }
    }//GEN-LAST:event_btnManageRoomActionPerformed

    private void btnQLPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLPhongActionPerformed
        // TODO add your handling code here:
        if (dangNhapController.GetRoleCurrentAcount(TaiKhoan, MatKhau).equals("ADMIN") || dangNhapController.GetRoleCurrentAcount(TaiKhoan, MatKhau).equals("USER")) {
            this.dispose();
            frmPhong fPhong = new frmPhong(TaiKhoan, MatKhau, null);
            fPhong.setLocationRelativeTo(this);
            fPhong.setVisible(true);

        }
    }//GEN-LAST:event_btnQLPhongActionPerformed

    private void btnQLNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLNhanVienActionPerformed
        // TODO add your handling code here:
        if (dangNhapController.GetRoleCurrentAcount(TaiKhoan, MatKhau).equals("ADMIN")) {
            this.dispose();
            frmQLNhanVien fQLNhanVien = new frmQLNhanVien(TaiKhoan, MatKhau);
            fQLNhanVien.setLocationRelativeTo(this);
            fQLNhanVien.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Chỉ ADMIN mới được sử dụng chức năng này", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnQLNhanVienActionPerformed

    private void btnLogOut_ToolbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOut_ToolbarActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đăng xuất không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            this.dispose();
            try {
                DangNhap dangNhap = new DangNhap();
                dangNhap.setLocationRelativeTo(null);
                dangNhap.setVisible(true);
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
                Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnLogOut_ToolbarActionPerformed

    private void frmChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frmChangePasswordActionPerformed
        // TODO add your handling code here:

        this.dispose();
        frmChangePassword fChangePassword = new frmChangePassword(TaiKhoan, MatKhau);
        fChangePassword.setLocationRelativeTo(this);
        fChangePassword.setVisible(true);

    }//GEN-LAST:event_frmChangePasswordActionPerformed

    private void btnQuanLyTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyTKActionPerformed
        // TODO add your handling code here:
        if (dangNhapController.GetRoleCurrentAcount(TaiKhoan, MatKhau).equals("ADMIN")) {
            this.dispose();
            try {
                frmQLTaiKhoan fQLTaiKhoan = new frmQLTaiKhoan(TaiKhoan, MatKhau);
                fQLTaiKhoan.setLocationRelativeTo(null);
                fQLTaiKhoan.setVisible(true);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Chỉ ADMIN mới được sử dụng chức năng này", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnQuanLyTKActionPerformed

    private void menuQLPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQLPhongActionPerformed
        // TODO add your handling code here:
        JButton invoker = (JButton) PopupMenuPhong.getInvoker();
        String CurrentBtn = invoker.getText();

        String[] parts = CurrentBtn.split(" ");

        this.dispose();
        frmPhong fPhong = new frmPhong(TaiKhoan, MatKhau, parts[1]);
        fPhong.setLocationRelativeTo(this);
        fPhong.setVisible(true);

    }//GEN-LAST:event_menuQLPhongActionPerformed

    private void menuThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuThueActionPerformed
        // TODO add your handling code here:
        JButton invoker = (JButton) PopupMenuPhong.getInvoker();
        String CurrentBtn = invoker.getText();

        String[] parts = CurrentBtn.split(" ");

        this.dispose();
        frmThueTraPhong fThueTraPhong = new frmThueTraPhong(TaiKhoan, MatKhau, parts[1], "Check_in");
        fThueTraPhong.setLocationRelativeTo(this);
        fThueTraPhong.setVisible(true);
    }//GEN-LAST:event_menuThueActionPerformed

    private void menuTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTraActionPerformed
        // TODO add your handling code here:
        JButton invoker = (JButton) PopupMenuPhong.getInvoker();
        String CurrentBtn = invoker.getText();

        String[] parts = CurrentBtn.split(" ");

        this.dispose();
        frmThueTraPhong fThueTraPhong = new frmThueTraPhong(TaiKhoan, MatKhau, parts[1], "Check_out");
        fThueTraPhong.setLocationRelativeTo(this);
        fThueTraPhong.setVisible(true);

    }//GEN-LAST:event_menuTraActionPerformed

    private void MenuItemQLThue_TraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemQLThue_TraActionPerformed
        // TODO add your handling code here:
        this.dispose();
        frmThueTraPhong fThueTraPhong = new frmThueTraPhong(TaiKhoan, MatKhau, "", "");
        fThueTraPhong.setLocationRelativeTo(this);
        fThueTraPhong.setVisible(true);
    }//GEN-LAST:event_MenuItemQLThue_TraActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        frmThongKeDoanhSo fThongKeDoanhSo = new frmThongKeDoanhSo(TaiKhoan, MatKhau);
        fThongKeDoanhSo.setLocationRelativeTo(this);
        fThongKeDoanhSo.setVisible(true);

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void MenuitemQLDoDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuitemQLDoDungActionPerformed
        // TODO add your handling code here:
        this.dispose();
        formQuanlyDoDung fQuanlyDoDung = new formQuanlyDoDung(TaiKhoan, MatKhau);
        fQuanlyDoDung.setLocationRelativeTo(this);
        fQuanlyDoDung.setVisible(true);

    }//GEN-LAST:event_MenuitemQLDoDungActionPerformed

    private void MenuitemQLDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuitemQLDichVuActionPerformed
        // TODO add your handling code here:
        this.dispose();
        formQuanLyDichVu fQuanLyDichVu = new formQuanLyDichVu(TaiKhoan, MatKhau);
        fQuanLyDichVu.setLocationRelativeTo(this);
        fQuanLyDichVu.setVisible(true);
    }//GEN-LAST:event_MenuitemQLDichVuActionPerformed

    private void btnStatisticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatisticActionPerformed
        // TODO add your handling code here:
        this.dispose();
        frmThongKeDoanhSo fThongKeDoanhSo = new frmThongKeDoanhSo(TaiKhoan, MatKhau);
        fThongKeDoanhSo.setLocationRelativeTo(null);
        fThongKeDoanhSo.setVisible(true);

    }//GEN-LAST:event_btnStatisticActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmQLNhanVien.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TrangChu trangChu = new TrangChu();
                trangChu.setLocationRelativeTo(null);
                trangChu.setVisible(true);

            }
        }
        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ListPhong;
    private javax.swing.JMenuItem MenuItemQLThue_Tra;
    private javax.swing.JMenuItem MenuitemQLDichVu;
    private javax.swing.JMenuItem MenuitemQLDoDung;
    private javax.swing.JPopupMenu PopupMenuPhong;
    private javax.swing.JButton btnHome;
    private javax.swing.JMenuItem btnLogOut_Toolbar;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManageRoom;
    private javax.swing.JButton btnManageStaff;
    private javax.swing.JMenuItem btnQLNhanVien;
    private javax.swing.JMenuItem btnQLPhong;
    private javax.swing.JMenuItem btnQuanLyTK;
    private javax.swing.JButton btnStatistic;
    private javax.swing.JMenuItem frmChangePassword;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem menuQLPhong;
    private javax.swing.JMenuItem menuThue;
    private javax.swing.JMenuItem menuTra;
    // End of variables declaration//GEN-END:variables
}
