/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Giaodien;

import Entity.DienObject;
import Entity.HGDObject;
import Entity.HopdongObject;
import Entity.NuocObject;
import NguoidungUse.DienUse;
import NguoidungUse.HGDsevice;
import NguoidungUse.NuocUse;
import NguoidungUse.Thanhviensevice;
import NguoidungUse.hopdongUse;
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class Trangchu extends javax.swing.JFrame {

    private JPanel child;
    String mahogd = "";

    /**
     * Creates new form QLDV
     */
    public Trangchu() throws ParseException {
        initComponents();
        this.setSize(1050, 689);
        HGDsevice hgduse = new HGDsevice();
        checkALL();
    }

    private void checkALL() throws ParseException {
        hopdongUse hduse = new hopdongUse();
        Date date = new Date();
        DateFormat dateFM = new SimpleDateFormat("yyyy-MM-dd");
        // kiem tra tinh trang hgd 01
        String mahgd = "HGD01";
        HopdongObject hd;
        String time;
        if (kiemtraTinhtrang(mahgd) == 1) {
            btnHGD01.setEnabled(true);
            hd = hduse.getOnebymaHGD(mahgd);
            time = hd.getThoihan();
            if (dateFM.parse(time).compareTo(date) <= 0 || kiemtratinhtrangDien(mahgd) == 1 || kiemtratinhtrangNuoc(mahgd) == 1) {
                btnHGD01.setBackground(Color.red);
            } else {
                btnHGD01.setBackground(Color.CYAN);
            }
        } else {
            btnHGD01.setBackground(Color.gray);
            btnHGD01.setEnabled(false);
        }

        // kiem tra tinh trang hgd 02
        mahgd = "HGD02";
        if (kiemtraTinhtrang(mahgd) == 1) {
            btnHGD02.setEnabled(true);
            hd = hduse.getOnebymaHGD(mahgd);
            time = hd.getThoihan();
            if (dateFM.parse(time).compareTo(date) <= 0 || kiemtratinhtrangDien(mahgd) == 1 || kiemtratinhtrangNuoc(mahgd) == 1) {
                btnHGD02.setBackground(Color.red);
            } else {
                btnHGD02.setBackground(Color.CYAN);
            }
        } else {
            btnHGD02.setBackground(Color.gray);
            btnHGD02.setEnabled(false);
        }

        // kiem tra tinh trang hgd 03
        mahgd = "HGD03";
        if (kiemtraTinhtrang(mahgd) == 1) {
            btnHGD03.setEnabled(true);
            hd = hduse.getOnebymaHGD(mahgd);
            time = hd.getThoihan();
            if (dateFM.parse(time).compareTo(date) <= 0 || kiemtratinhtrangDien(mahgd) == 1 || kiemtratinhtrangNuoc(mahgd) == 1) {
                btnHGD03.setBackground(Color.red);
            } else {
                btnHGD03.setBackground(Color.CYAN);
            }
        } else {
            btnHGD03.setBackground(Color.gray);
            btnHGD03.setEnabled(false);
        }

        // kiem tra tinh trang hgd 04
        mahgd = "HGD04";
        if (kiemtraTinhtrang(mahgd) == 1) {
            btnHGD04.setEnabled(true);
            hd = hduse.getOnebymaHGD(mahgd);
            time = hd.getThoihan();
            if (dateFM.parse(time).compareTo(date) <= 0 || kiemtratinhtrangDien(mahgd) == 1 || kiemtratinhtrangNuoc(mahgd) == 1) {
                btnHGD04.setBackground(Color.red);
            } else {
                btnHGD04.setBackground(Color.CYAN);
            }
        } else {
            btnHGD04.setBackground(Color.gray);
            btnHGD04.setEnabled(false);
        }

        // kiem tra tinh trang hgd 05
        mahgd = "HGD05";
        if (kiemtraTinhtrang(mahgd) == 1) {
            btnHGD05.setEnabled(true);
            hd = hduse.getOnebymaHGD(mahgd);
            time = hd.getThoihan();
            if (dateFM.parse(time).compareTo(date) <= 0 || kiemtratinhtrangDien(mahgd) == 1 || kiemtratinhtrangNuoc(mahgd) == 1) {
                btnHGD05.setBackground(Color.red);
            } else {
                btnHGD05.setBackground(Color.CYAN);
            }
        } else {
            btnHGD05.setBackground(Color.gray);
            btnHGD05.setEnabled(false);
        }

        // kiem tra tinh trang hgd 06
        mahgd = "HGD06";
        if (kiemtraTinhtrang(mahgd) == 1) {
            btnHGD06.setEnabled(true);
            hd = hduse.getOnebymaHGD(mahgd);
            time = hd.getThoihan();
            if (dateFM.parse(time).compareTo(date) <= 0 || kiemtratinhtrangDien(mahgd) == 1 || kiemtratinhtrangNuoc(mahgd) == 1) {
                btnHGD06.setBackground(Color.red);
            } else {
                btnHGD06.setBackground(Color.CYAN);
            }
        } else {
            btnHGD06.setBackground(Color.gray);
            btnHGD06.setEnabled(false);
        }

        // kiem tra tinh trang hgd 07
        mahgd = "HGD07";
        if (kiemtraTinhtrang(mahgd) == 1) {
            btnHGD07.setEnabled(true);
            hd = hduse.getOnebymaHGD(mahgd);
            time = hd.getThoihan();
            if (dateFM.parse(time).compareTo(date) <= 0 || kiemtratinhtrangDien(mahgd) == 1 || kiemtratinhtrangNuoc(mahgd) == 1) {
                btnHGD07.setBackground(Color.red);
            } else {
                btnHGD07.setBackground(Color.CYAN);
            }
        } else {
            btnHGD07.setBackground(Color.gray);
            btnHGD07.setEnabled(false);
        }

        // kiem tra tinh trang hgd 08
        mahgd = "HGD08";
        if (kiemtraTinhtrang(mahgd) == 1) {
            btnHGD08.setEnabled(true);
            hd = hduse.getOnebymaHGD(mahgd);
            time = hd.getThoihan();
            if (dateFM.parse(time).compareTo(date) <= 0 || kiemtratinhtrangDien(mahgd) == 1 || kiemtratinhtrangNuoc(mahgd) == 1) {
                btnHGD08.setBackground(Color.red);
            } else {
                btnHGD08.setBackground(Color.CYAN);
            }
        } else {
            btnHGD08.setBackground(Color.gray);
            btnHGD08.setEnabled(false);
        }

        // kiem tra tinh trang hgd 09
        mahgd = "HGD09";
        if (kiemtraTinhtrang(mahgd) == 1) {
            btnHGD09.setEnabled(true);
            hd = hduse.getOnebymaHGD(mahgd);
            time = hd.getThoihan();
            if (dateFM.parse(time).compareTo(date) <= 0 || kiemtratinhtrangDien(mahgd) == 1 || kiemtratinhtrangNuoc(mahgd) == 1) {
                btnHGD09.setBackground(Color.red);
            } else {
                btnHGD09.setBackground(Color.CYAN);
            }
        } else {
            btnHGD09.setBackground(Color.gray);
            btnHGD09.setEnabled(false);
        }

        // kiem tra tinh trang hgd 10
        mahgd = "HGD10";
        if (kiemtraTinhtrang(mahgd) == 1) {
            btnHGD10.setEnabled(true);
            hd = hduse.getOnebymaHGD(mahgd);
            time = hd.getThoihan();
            if (dateFM.parse(time).compareTo(date) <= 0 || kiemtratinhtrangDien(mahgd) == 1 || kiemtratinhtrangNuoc(mahgd) == 1) {
                btnHGD10.setBackground(Color.red);
            } else {
                btnHGD10.setBackground(Color.CYAN);
            }
        } else {
            btnHGD10.setBackground(Color.gray);
            btnHGD10.setEnabled(false);
        }

        // kiem tra tinh trang hgd 11
        mahgd = "HGD11";
        if (kiemtraTinhtrang(mahgd) == 1) {
            btnHGD11.setEnabled(true);
            hd = hduse.getOnebymaHGD(mahgd);
            time = hd.getThoihan();
            if (dateFM.parse(time).compareTo(date) <= 0 || kiemtratinhtrangDien(mahgd) == 1 || kiemtratinhtrangNuoc(mahgd) == 1) {
                btnHGD11.setBackground(Color.red);
            } else {
                btnHGD11.setBackground(Color.CYAN);
            }
        } else {
            btnHGD11.setBackground(Color.gray);
            btnHGD11.setEnabled(false);
        }

        // kiem tra tinh trang hgd 12
        mahgd = "HGD12";
        if (kiemtraTinhtrang(mahgd) == 1) {
            btnHGD12.setEnabled(true);
            hd = hduse.getOnebymaHGD(mahgd);
            time = hd.getThoihan();
            if (dateFM.parse(time).compareTo(date) <= 0 || kiemtratinhtrangDien(mahgd) == 1 || kiemtratinhtrangNuoc(mahgd) == 1) {
                btnHGD12.setBackground(Color.red);
            } else {
                btnHGD12.setBackground(Color.CYAN);
            }
        } else {
            btnHGD12.setBackground(Color.gray);
            btnHGD12.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // kiem tra tinh trang
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_bottom = new javax.swing.JPanel();
        Panel_main = new javax.swing.JPanel();
        btnHGD01 = new javax.swing.JButton();
        btnHGD02 = new javax.swing.JButton();
        btnHGD03 = new javax.swing.JButton();
        btnHGD06 = new javax.swing.JButton();
        btnHGD09 = new javax.swing.JButton();
        btnHGD12 = new javax.swing.JButton();
        btnHGD04 = new javax.swing.JButton();
        btnHGD07 = new javax.swing.JButton();
        btnHGD10 = new javax.swing.JButton();
        btnHGD05 = new javax.swing.JButton();
        btnHGD08 = new javax.swing.JButton();
        btnHGD11 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        BtnDangxuat = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        bntQLHGD = new javax.swing.JButton();
        btnThongkedt = new javax.swing.JButton();
        btnQLNV = new javax.swing.JButton();
        btnQLTK = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnGioithieu = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        quanlycanho = new javax.swing.JMenu();
        Quanlycanho = new javax.swing.JMenuItem();
        QLdichvuItem = new javax.swing.JMenuItem();
        QLhopdongItem = new javax.swing.JMenuItem();
        QLhogdItem = new javax.swing.JMenuItem();
        ThanhvienItem = new javax.swing.JMenuItem();
        QLnhanvienItem = new javax.swing.JMenuItem();
        QLDIenItem = new javax.swing.JMenuItem();
        QLnuocItem = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        NuocItem = new javax.swing.JMenuItem();
        DienItem = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        QLTKItem = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GIAO DIỆN CHÍNH");
        setMinimumSize(null);

        Panel_bottom.setMaximumSize(new java.awt.Dimension(0, 0));
        Panel_bottom.setLayout(new javax.swing.BoxLayout(Panel_bottom, javax.swing.BoxLayout.LINE_AXIS));

        Panel_main.setBackground(new java.awt.Color(204, 255, 255));

        btnHGD01.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnHGD01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/house_1.png"))); // NOI18N
        btnHGD01.setText("Hộ gia đình 01");
        btnHGD01.setAlignmentX(1.0F);
        btnHGD01.setMargin(new java.awt.Insets(2, 20, 2, 20));
        btnHGD01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHGD01ActionPerformed(evt);
            }
        });

        btnHGD02.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnHGD02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/house_1.png"))); // NOI18N
        btnHGD02.setText("Hộ gia đình 02");
        btnHGD02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHGD02ActionPerformed(evt);
            }
        });

        btnHGD03.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnHGD03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/house_1.png"))); // NOI18N
        btnHGD03.setText("Hộ gia đình 03");
        btnHGD03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHGD03ActionPerformed(evt);
            }
        });

        btnHGD06.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnHGD06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/house_1.png"))); // NOI18N
        btnHGD06.setText("Hộ gia đình 06");
        btnHGD06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHGD06ActionPerformed(evt);
            }
        });

        btnHGD09.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnHGD09.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/house_1.png"))); // NOI18N
        btnHGD09.setText("Hộ gia đình 09");
        btnHGD09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHGD09ActionPerformed(evt);
            }
        });

        btnHGD12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnHGD12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/house_1.png"))); // NOI18N
        btnHGD12.setText("Hộ gia đình 12");
        btnHGD12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHGD12ActionPerformed(evt);
            }
        });

        btnHGD04.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnHGD04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/house_1.png"))); // NOI18N
        btnHGD04.setText("Hộ gia đình 04");
        btnHGD04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHGD04ActionPerformed(evt);
            }
        });

        btnHGD07.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnHGD07.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/house_1.png"))); // NOI18N
        btnHGD07.setText("Hộ gia đình 07");
        btnHGD07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHGD07ActionPerformed(evt);
            }
        });

        btnHGD10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnHGD10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/house_1.png"))); // NOI18N
        btnHGD10.setText("Hộ gia đình 10");
        btnHGD10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHGD10ActionPerformed(evt);
            }
        });

        btnHGD05.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnHGD05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/house_1.png"))); // NOI18N
        btnHGD05.setText("Hộ gia đình 05");
        btnHGD05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHGD05ActionPerformed(evt);
            }
        });

        btnHGD08.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnHGD08.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/house_1.png"))); // NOI18N
        btnHGD08.setText("Hộ gia đình 08");
        btnHGD08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHGD08ActionPerformed(evt);
            }
        });

        btnHGD11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnHGD11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/house_1.png"))); // NOI18N
        btnHGD11.setText("Hộ gia đình 11");
        btnHGD11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHGD11ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Đã thuê");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Chưa thuê");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Cảnh báo");

        jPanel2.setBackground(java.awt.Color.cyan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jPanel4.setBackground(java.awt.Color.lightGray);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/PM.png"))); // NOI18N

        javax.swing.GroupLayout Panel_mainLayout = new javax.swing.GroupLayout(Panel_main);
        Panel_main.setLayout(Panel_mainLayout);
        Panel_mainLayout.setHorizontalGroup(
            Panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_mainLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(Panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnHGD04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHGD07, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHGD10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHGD01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(Panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnHGD08, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHGD05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHGD11, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnHGD02, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(Panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnHGD03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHGD06, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHGD09, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHGD12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(Panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap())
            .addGroup(Panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_mainLayout.setVerticalGroup(
            Panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_mainLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(Panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_mainLayout.createSequentialGroup()
                        .addComponent(btnHGD01, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHGD04, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHGD07, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHGD10, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_mainLayout.createSequentialGroup()
                        .addComponent(btnHGD02, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHGD05, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHGD08, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHGD11, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_mainLayout.createSequentialGroup()
                        .addGroup(Panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_mainLayout.createSequentialGroup()
                                .addComponent(btnHGD03, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHGD06, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_mainLayout.createSequentialGroup()
                                .addGroup(Panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(30, 30, 30)
                                .addGroup(Panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(30, 30, 30)
                                .addGroup(Panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHGD09, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHGD12, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(195, Short.MAX_VALUE))
            .addGroup(Panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Panel_bottom.add(Panel_main);

        jToolBar1.setRollover(true);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/house_2.png"))); // NOI18N
        jButton1.setText("Trang chủ");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        BtnDangxuat.setBackground(new java.awt.Color(255, 255, 255));
        BtnDangxuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/arrow.png"))); // NOI18N
        BtnDangxuat.setText("Đăng xuất");
        BtnDangxuat.setFocusable(false);
        BtnDangxuat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnDangxuat.setPreferredSize(new java.awt.Dimension(80, 70));
        BtnDangxuat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnDangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDangxuatActionPerformed(evt);
            }
        });
        jToolBar1.add(BtnDangxuat);
        jToolBar1.add(jSeparator2);

        bntQLHGD.setBackground(new java.awt.Color(255, 255, 255));
        bntQLHGD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/family.png"))); // NOI18N
        bntQLHGD.setText("Quản lý hộ gia đình");
        bntQLHGD.setFocusable(false);
        bntQLHGD.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bntQLHGD.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bntQLHGD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntQLHGDActionPerformed(evt);
            }
        });
        jToolBar1.add(bntQLHGD);

        btnThongkedt.setBackground(new java.awt.Color(255, 255, 255));
        btnThongkedt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/analytics.png"))); // NOI18N
        btnThongkedt.setText("Xem hóa đơn");
        btnThongkedt.setFocusable(false);
        btnThongkedt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThongkedt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThongkedt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongkedtActionPerformed(evt);
            }
        });
        jToolBar1.add(btnThongkedt);

        btnQLNV.setBackground(new java.awt.Color(255, 255, 255));
        btnQLNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/steward.png"))); // NOI18N
        btnQLNV.setText("Quản lý nhân viên");
        btnQLNV.setFocusable(false);
        btnQLNV.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQLNV.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnQLNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLNVActionPerformed(evt);
            }
        });
        jToolBar1.add(btnQLNV);

        btnQLTK.setBackground(new java.awt.Color(255, 255, 255));
        btnQLTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/account.png"))); // NOI18N
        btnQLTK.setText("Quản lý tài khoản");
        btnQLTK.setFocusable(false);
        btnQLTK.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQLTK.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnQLTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLTKActionPerformed(evt);
            }
        });
        jToolBar1.add(btnQLTK);
        jToolBar1.add(jSeparator3);

        btnGioithieu.setBackground(new java.awt.Color(255, 255, 255));
        btnGioithieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/laptop.png"))); // NOI18N
        btnGioithieu.setText("Giới thiệu");
        btnGioithieu.setFocusable(false);
        btnGioithieu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGioithieu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGioithieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGioithieuActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGioithieu);

        jMenuBar2.setBackground(new java.awt.Color(204, 255, 255));
        jMenuBar2.setPreferredSize(new java.awt.Dimension(847, 31));

        quanlycanho.setText("Quản lý");

        Quanlycanho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Home.png"))); // NOI18N
        Quanlycanho.setText("Quản lý căn hộ ");
        Quanlycanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuanlycanhoActionPerformed(evt);
            }
        });
        quanlycanho.add(Quanlycanho);

        QLdichvuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/customer-support.png"))); // NOI18N
        QLdichvuItem.setText("Quản lý dịch vụ");
        QLdichvuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLdichvuItemActionPerformed(evt);
            }
        });
        quanlycanho.add(QLdichvuItem);

        QLhopdongItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Notes.png"))); // NOI18N
        QLhopdongItem.setText("Quản lý hợp đồng");
        QLhopdongItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLhopdongItemActionPerformed(evt);
            }
        });
        quanlycanho.add(QLhopdongItem);

        QLhogdItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Users.png"))); // NOI18N
        QLhogdItem.setText("Quản lý hộ gia đình");
        QLhogdItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLhogdItemActionPerformed(evt);
            }
        });
        quanlycanho.add(QLhogdItem);

        ThanhvienItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Person-Male-Light-icon-24.png"))); // NOI18N
        ThanhvienItem.setText("Quản lý thành viên");
        ThanhvienItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThanhvienItemActionPerformed(evt);
            }
        });
        quanlycanho.add(ThanhvienItem);

        QLnhanvienItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Unknown person.png"))); // NOI18N
        QLnhanvienItem.setText("Quản lý nhân viên");
        QLnhanvienItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLnhanvienItemActionPerformed(evt);
            }
        });
        quanlycanho.add(QLnhanvienItem);

        QLDIenItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/idea.png"))); // NOI18N
        QLDIenItem.setText("Quản lý điện");
        QLDIenItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLDIenItemActionPerformed(evt);
            }
        });
        quanlycanho.add(QLDIenItem);

        QLnuocItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/tank.png"))); // NOI18N
        QLnuocItem.setText("Quản lý nước");
        QLnuocItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLnuocItemActionPerformed(evt);
            }
        });
        quanlycanho.add(QLnuocItem);

        jMenuBar2.add(quanlycanho);

        jMenu6.setText(" Thống kê");

        NuocItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Statistics.png"))); // NOI18N
        NuocItem.setText("Thống kê tiền nước");
        NuocItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuocItemActionPerformed(evt);
            }
        });
        jMenu6.add(NuocItem);

        DienItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Task list.png"))); // NOI18N
        DienItem.setText("Thống kê tiền điện");
        DienItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DienItemActionPerformed(evt);
            }
        });
        jMenu6.add(DienItem);

        jMenuBar2.add(jMenu6);

        jMenu7.setText("Hệ thống");

        QLTKItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Unknown person.png"))); // NOI18N
        QLTKItem.setText("Quản lý tài khoản");
        QLTKItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLTKItemActionPerformed(evt);
            }
        });
        jMenu7.add(QLTKItem);

        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Log out.png"))); // NOI18N
        jMenuItem15.setText("Đăng xuất");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem15);

        jMenuBar2.add(jMenu7);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Panel_bottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel_bottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private int kiemtraTinhtrang(String mahgd) throws ParseException {
        HGDsevice sv = new HGDsevice();
        List<HGDObject> list = sv.getALL();
        for (HGDObject OB : list) {
            if (OB.getMahgd().equals(mahgd)) {
                return 1;
            }
        }
        return 0;
    }

    public int kiemtratinhtrangDien(String mahgd) {
        DienUse dienU = new DienUse();
        DienObject dienOb = dienU.getOnebyMahgd(mahgd);
        if (dienOb.getTrangthai().equals("Chưa đóng")) {
            return 1;
        }
        return 0;
    }

    public int kiemtratinhtrangNuoc(String mahgd) {
        NuocUse NuocU = new NuocUse();
        NuocObject ncOb = NuocU.getOnebyMahgd(mahgd);
        if (ncOb.getTrangthai().equals("Chưa đóng")) {
            return 1;
        }
        return 0;
    }
    private void QuanlycanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuanlycanhoActionPerformed
        this.setSize(930, 800);
        child = new GGCanho();
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_QuanlycanhoActionPerformed

    private void QLdichvuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLdichvuItemActionPerformed
        // TODO add your handling code here:
        this.setSize(930, 800);
        child = new GDDichvu();
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_QLdichvuItemActionPerformed

    private void QLhopdongItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLhopdongItemActionPerformed
        // TODO add your handling code here:
        this.setSize(1120, 800);
        child = new GDHopdong();
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_QLhopdongItemActionPerformed

    private void QLhogdItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLhogdItemActionPerformed
        // TODO add your handling code here:
        this.setSize(930, 800);
        child = new GGHoGD();
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_QLhogdItemActionPerformed

    private void BtnDangxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDangxuatActionPerformed
        // TODO add your handling code here:
        String tk = "";
        String mk = "";
        DANGNHAP dn = new DANGNHAP(tk, mk);
        dn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnDangxuatActionPerformed

    private void bntQLHGDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntQLHGDActionPerformed
        // TODO add your handling code here:
        this.setSize(1000, 800);
        child = new GGHoGD();
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_bntQLHGDActionPerformed

    private void btnQLTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLTKActionPerformed
        // TODO add your handling code here:
        this.setSize(1000, 800);
        child = new GDTaikhoan();
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_btnQLTKActionPerformed

    private void ThanhvienItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThanhvienItemActionPerformed
        // TODO add your handling code here:
        this.setSize(1120, 800);
        child = new GDQLThanhvien();
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_ThanhvienItemActionPerformed

    private void QLTKItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLTKItemActionPerformed
        // TODO add your handling code here:
        child = new GDTaikhoan();
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_QLTKItemActionPerformed

    private void btnQLNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLNVActionPerformed
        // TODO add your handling code here:
        this.setSize(920, 800);
        child = new GDNhanvien();
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_btnQLNVActionPerformed

    private void QLnhanvienItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLnhanvienItemActionPerformed
        // TODO add your handling code here:
        this.setSize(930, 800);
        child = new GDNhanvien();
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_QLnhanvienItemActionPerformed

    private void QLDIenItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLDIenItemActionPerformed
        // TODO add your handling code here:
        this.setSize(1230, 800);
        child = new GDHDDien();
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_QLDIenItemActionPerformed

    private void QLnuocItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLnuocItemActionPerformed
        // TODO add your handling code here:
        this.setSize(1230, 800);
        child = new GDHDNuoc();
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_QLnuocItemActionPerformed

    private void btnGioithieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGioithieuActionPerformed
        // TODO add your handling code here:
        new GDGioithieu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGioithieuActionPerformed

    private void DienItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DienItemActionPerformed
        // TODO add your handling code here:
        this.setSize(1300, 800);
        child = new GDTKTienDien();
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_DienItemActionPerformed

    private void NuocItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuocItemActionPerformed
        // TODO add your handling code here:
        this.setSize(1300, 800);
        child = new GDTKNuoc();
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_NuocItemActionPerformed

    private void btnHGD01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHGD01ActionPerformed
        this.setSize(900, 700);
        try {
            // TODO add your handling code here:
            child = new GDHGD("HGD01");
        } catch (ParseException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();

    }//GEN-LAST:event_btnHGD01ActionPerformed

    private void btnHGD02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHGD02ActionPerformed
        // TODO add your handling code here:
        this.setSize(900, 700);
        try {
            // TODO add your handling code here:
            child = new GDHGD("HGD02");
        } catch (ParseException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_btnHGD02ActionPerformed

    private void btnHGD04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHGD04ActionPerformed
        // TODO add your handling code here:
        this.setSize(900, 700);
        try {
            // TODO add your handling code here:
            child = new GDHGD("HGD04");
        } catch (ParseException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_btnHGD04ActionPerformed

    private void btnHGD03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHGD03ActionPerformed
        // TODO add your handling code here:
        this.setSize(900, 700);
        try {
            // TODO add your handling code here:
            child = new GDHGD("HGD03");
        } catch (ParseException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_btnHGD03ActionPerformed

    private void btnHGD05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHGD05ActionPerformed
        // TODO add your handling code here:
        this.setSize(900, 700);
        try {
            // TODO add your handling code here:
            child = new GDHGD("HGD05");
        } catch (ParseException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_btnHGD05ActionPerformed

    private void btnHGD06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHGD06ActionPerformed
        // TODO add your handling code here:
        this.setSize(900, 700);
        try {
            // TODO add your handling code here:
            child = new GDHGD("HGD06");
        } catch (ParseException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_btnHGD06ActionPerformed

    private void btnHGD07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHGD07ActionPerformed
        // TODO add your handling code here:
        this.setSize(900, 700);
        try {
            // TODO add your handling code here:
            child = new GDHGD("HGD07");
        } catch (ParseException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_btnHGD07ActionPerformed

    private void btnHGD08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHGD08ActionPerformed
        // TODO add your handling code here:
        this.setSize(900, 700);
        try {
            // TODO add your handling code here:
            child = new GDHGD("HGD08");
        } catch (ParseException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_btnHGD08ActionPerformed

    private void btnHGD09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHGD09ActionPerformed
        // TODO add your handling code here:
        this.setSize(900, 700);
        try {
            // TODO add your handling code here:
            child = new GDHGD("HGD09");
        } catch (ParseException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_btnHGD09ActionPerformed

    private void btnHGD10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHGD10ActionPerformed
        // TODO add your handling code here:
        this.setSize(900, 700);
        try {
            // TODO add your handling code here:
            child = new GDHGD("HGD10");
        } catch (ParseException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_btnHGD10ActionPerformed

    private void btnHGD11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHGD11ActionPerformed
        // TODO add your handling code here:
        this.setSize(900, 700);
        try {
            // TODO add your handling code here:
            child = new GDHGD("HGD11");
        } catch (ParseException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_btnHGD11ActionPerformed

    private void btnHGD12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHGD12ActionPerformed
        // TODO add your handling code here:
        this.setSize(900, 700);
        try {
            // TODO add your handling code here:
            child = new GDHGD("HGD12");
        } catch (ParseException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();
    }//GEN-LAST:event_btnHGD12ActionPerformed

    private void btnThongkedtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongkedtActionPerformed
        // TODO add your handling code here

        child = new GDXEMHOADON();
        Panel_bottom.removeAll();
        Panel_bottom.add(child);
        Panel_bottom.validate();

    }//GEN-LAST:event_btnThongkedtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            Trangchu tr = new Trangchu();
            Container c = tr.getContentPane();
            tr.setSize(1050, 689);
            tr.setVisible(true);

        } catch (ParseException ex) {
            Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
        String tk = "";
        String mk = "";
        DANGNHAP dn = new DANGNHAP(tk, mk);
        dn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

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
            java.util.logging.Logger.getLogger(Trangchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Trangchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Trangchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Trangchu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Trangchu().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(Trangchu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDangxuat;
    private javax.swing.JMenuItem DienItem;
    private javax.swing.JMenuItem NuocItem;
    private javax.swing.JPanel Panel_bottom;
    private javax.swing.JPanel Panel_main;
    private javax.swing.JMenuItem QLDIenItem;
    private javax.swing.JMenuItem QLTKItem;
    private javax.swing.JMenuItem QLdichvuItem;
    private javax.swing.JMenuItem QLhogdItem;
    private javax.swing.JMenuItem QLhopdongItem;
    private javax.swing.JMenuItem QLnhanvienItem;
    private javax.swing.JMenuItem QLnuocItem;
    private javax.swing.JMenuItem Quanlycanho;
    private javax.swing.JMenuItem ThanhvienItem;
    private javax.swing.JButton bntQLHGD;
    private javax.swing.JButton btnGioithieu;
    private javax.swing.JButton btnHGD01;
    private javax.swing.JButton btnHGD02;
    private javax.swing.JButton btnHGD03;
    private javax.swing.JButton btnHGD04;
    private javax.swing.JButton btnHGD05;
    private javax.swing.JButton btnHGD06;
    private javax.swing.JButton btnHGD07;
    private javax.swing.JButton btnHGD08;
    private javax.swing.JButton btnHGD09;
    private javax.swing.JButton btnHGD10;
    private javax.swing.JButton btnHGD11;
    private javax.swing.JButton btnHGD12;
    private javax.swing.JButton btnQLNV;
    private javax.swing.JButton btnQLTK;
    private javax.swing.JButton btnThongkedt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu quanlycanho;
    // End of variables declaration//GEN-END:variables
}
