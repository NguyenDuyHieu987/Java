/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import Controllers.PhongController;
import Models.Phong;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public final class frmPhong extends javax.swing.JFrame {

    private String MaPhong;
    private String TaiKhoan;
    private String MatKhau;
    private DefaultTableModel defaultTableModel;
    private PhongController phongController;

    /**
     * Creates new form frmPhong
     */
    public frmPhong() {
        initComponents();
        InsertDataTable();
        PopUpMenu();

    }

    public frmPhong(String TK, String MK, String MaPH) {
        initComponents();
        this.TaiKhoan = TK;
        this.MatKhau = MK;
        this.MaPhong = MaPH;

        InsertDataTable();
        PopUpMenu();
    }

    public void InsertDataTable() {
        phongController = new PhongController();
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tbPhong.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã phòng");
        defaultTableModel.addColumn("Tên phòng");
        defaultTableModel.addColumn("Diện tích");
        defaultTableModel.addColumn("Tiện nghi");
        defaultTableModel.addColumn("Giá");
        defaultTableModel.addColumn("Trạng thái");
        tbPhong.getColumnModel().getColumn(3).setPreferredWidth(300);

        LoadDataTable();
        txtMaPhong.requestFocus();
    }

    public void LoadDataTable() {
        cbMaPhong.removeAllItems();
        List<Phong> listphonPhongs = phongController.GetAllPhong();

        for (Phong phong : listphonPhongs) {
            defaultTableModel.addRow(new Object[]{
                phong.getMaPhong(),
                phong.getTenPhong(),
                phong.getDienTich(),
                phong.getTienNghi(),
                phong.getGia(),
                phong.getTrangThai(),});

            cbMaPhong.addItem(phong.getMaPhong());
        }

    }

    public void clearDataTable() {
        while (defaultTableModel.getRowCount() > 0) {
            defaultTableModel.removeRow(0);
        }
    }

    public void ClearTextField() {
        txtMaPhong.setText(null);
        txtTenPhong.setText(null);
        txtGia.setText(null);
        cbArea.setSelectedIndex(0);
        cbStatus.setSelectedIndex(0);
        cbxDieuHoa.setSelected(true);
        cbxNongLanh.setSelected(true);
        cbxTuLanh.setSelected(false);
        cbxBonNgam.setSelected(false);
        cbxTivi.setSelected(false);
        cbxMayGiat.setSelected(true);

    }

    public void ClearSelectedCB() {
        cbxDieuHoa.setSelected(false);
        cbxNongLanh.setSelected(false);
        cbxTuLanh.setSelected(false);
        cbxBonNgam.setSelected(false);
        cbxTivi.setSelected(false);
        cbxMayGiat.setSelected(false);
    }

    private void PopUpMenu() {
        // TODO add your handling code here:
        if (MaPhong != null) {
            defaultTableModel.setRowCount(0);
            List<Phong> listphPhongs = phongController.SearchPhong("PH" + MaPhong);
            for (Phong phong : listphPhongs) {
                defaultTableModel.addRow(new Object[]{
                    phong.getMaPhong(),
                    phong.getTenPhong(),
                    phong.getDienTich(),
                    phong.getTienNghi(),
                    phong.getGia(),
                    phong.getTrangThai(),});
                txtMaPhong.setText(phong.getMaPhong());
                txtTenPhong.setText(phong.getTenPhong());
                txtGia.setText(String.valueOf(phong.getGia()));
                String Area = phong.getDienTich();
                switch (Area) {
                    case "30m2":
                        cbArea.setSelectedIndex(0);
                        break;
                    case "35m2":
                        cbArea.setSelectedIndex(1);
                        break;
                    case "40m2":
                        cbArea.setSelectedIndex(2);
                        break;
                    case "45m2":
                        cbArea.setSelectedIndex(3);
                        break;
                    case "50m2":
                        cbArea.setSelectedIndex(4);
                        break;
                    default:
                        cbArea.getEditor().setItem(Area);
                        break;
                }
                String Status = phong.getTrangThai();
                switch (Status) {
                    case "Chưa thuê":
                        cbStatus.setSelectedIndex(0);
                        break;
                    case "Đã thuê":
                        cbStatus.setSelectedIndex(1);
                        break;
                    case "Hỏng":
                        cbStatus.setSelectedIndex(2);
                        break;
                    default:
                        break;
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

        jPanel4 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPhong = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        txtTenPhong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnClearText = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        cbxDieuHoa = new javax.swing.JCheckBox();
        cbxNongLanh = new javax.swing.JCheckBox();
        cbxBonNgam = new javax.swing.JCheckBox();
        cbxTivi = new javax.swing.JCheckBox();
        cbxTuLanh = new javax.swing.JCheckBox();
        cbxMayGiat = new javax.swing.JCheckBox();
        cbStatus = new javax.swing.JComboBox<>();
        cbArea = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        cbMaPhong = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý phòng");

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\arrow.png")); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel4.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ PHÒNG");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -2, 780, 50));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N

        tbPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbPhong.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbPhong.setCellSelectionEnabled(true);
        tbPhong.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPhongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbPhong);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã phòng");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tên phòng");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Diện tích");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Giá");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Trạng thái");

        btnClearText.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\eraser.png")); // NOI18N
        btnClearText.setText("Clear");
        btnClearText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearTextActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tiện nghi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N

        cbxDieuHoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxDieuHoa.setSelected(true);
        cbxDieuHoa.setText("Điều hòa");

        cbxNongLanh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxNongLanh.setSelected(true);
        cbxNongLanh.setText("Nóng lạnh");

        cbxBonNgam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxBonNgam.setText("Bồn ngâm");

        cbxTivi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxTivi.setText("Tivi");

        cbxTuLanh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxTuLanh.setText("Tủ lạnh");

        cbxMayGiat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxMayGiat.setSelected(true);
        cbxMayGiat.setText("Máy giặt");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxDieuHoa)
                    .addComponent(cbxNongLanh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxBonNgam)
                    .addComponent(cbxTivi))
                .addGap(153, 153, 153)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxMayGiat)
                    .addComponent(cbxTuLanh))
                .addGap(79, 79, 79))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxDieuHoa)
                    .addComponent(cbxBonNgam)
                    .addComponent(cbxTuLanh))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxNongLanh)
                    .addComponent(cbxTivi)
                    .addComponent(cbxMayGiat))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chưa thuê", "Đã thuê", "Hỏng" }));

        cbArea.setEditable(true);
        cbArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "30m2", "35m2", "40m2", "45m2", "50m2" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(txtMaPhong)
                            .addComponent(cbArea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(60, 60, 60)
                                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(btnClearText, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btnClearText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbArea, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\add.png")); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\refresh.png")); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\bin.png")); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRefresh.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\làm mới.png")); // NOI18N
        btnRefresh.setText("Làm mới");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon("D:\\Java\\Baocao\\QuanlyKhachsan\\src\\main\\java\\imgs\\search.png")); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        cbMaPhong.setEditable(true);
        cbMaPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem)
                .addGap(18, 18, 18)
                .addComponent(btnRefresh)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.dispose();
        TrangChu trangChu = new TrangChu(TaiKhoan, MatKhau);
        trangChu.setLocationRelativeTo(null);
        trangChu.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here: 
        //        clearDataTable();
        defaultTableModel.setRowCount(0);
        List<Phong> listphPhongs = phongController.SearchPhong(cbMaPhong.getSelectedItem().toString());

        for (Phong phong : listphPhongs) {
            defaultTableModel.addRow(new Object[]{
                phong.getMaPhong(),
                phong.getTenPhong(),
                phong.getDienTich(),
                phong.getTienNghi(),
                phong.getGia(),
                phong.getTrangThai(),});
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    public String GetAllTienNghi() {
        String convenient = "";
        if (cbxBonNgam.isSelected()) {
            if (convenient.equals("")) {
                convenient += cbxBonNgam.getText();
            } else {
                convenient += ", " + cbxBonNgam.getText();

            }
        }
        if (cbxDieuHoa.isSelected()) {
            if (convenient.equals("")) {
                convenient += cbxDieuHoa.getText();
            } else {
                convenient += ", " + cbxDieuHoa.getText();

            }
        }
        if (cbxMayGiat.isSelected()) {
            if (convenient.equals("")) {
                convenient += cbxMayGiat.getText();
            } else {
                convenient += ", " + cbxMayGiat.getText();

            }
        }
        if (cbxNongLanh.isSelected()) {
            if (convenient.equals("")) {
                convenient += cbxNongLanh.getText();
            } else {
                convenient += ", " + cbxNongLanh.getText();

            }
        }
        if (cbxTivi.isSelected()) {
            if (convenient.equals("")) {
                convenient += cbxTivi.getText();
            } else {
                convenient += ", " + cbxTivi.getText();

            }
        }
        if (cbxTuLanh.isSelected()) {
            if (convenient.equals("")) {
                convenient += cbxTuLanh.getText();
            } else {
                convenient += ", " + cbxTuLanh.getText();

            }
        }
        return convenient;
    }
    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        defaultTableModel.setRowCount(0);
        LoadDataTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        try {

            if (txtMaPhong.getText().equals("") || txtTenPhong.getText().equals("") || txtGia.getText().equals("")
                    || (!cbxBonNgam.isSelected() && !cbxDieuHoa.isSelected() && !cbxMayGiat.isSelected()
                    && !cbxNongLanh.isSelected() && !cbxTivi.isSelected() && !cbxTuLanh.isSelected())) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {

                List<Phong> listphoPhongs = phongController.GetAllPhong();
                for (Phong phong : listphoPhongs) {
                    if (txtMaPhong.getText().equals(phong.getMaPhong())) {
                        JOptionPane.showMessageDialog(null, "Mã phòng đã tồn tại", "Thông báo", JOptionPane.WARNING_MESSAGE);
                        txtMaPhong.requestFocus();
                        return;
                    }
                }
                int confirm = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm phòng " + txtTenPhong.getText() + " không?", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    Phong phong = new Phong();

                    phong.setMaPhong(txtMaPhong.getText());
                    phong.setTenPhong(txtTenPhong.getText());
                    phong.setDienTich(cbArea.getSelectedItem().toString());
                    phong.setTienNghi(GetAllTienNghi());
                    phong.setGia(Float.valueOf(txtGia.getText()));
                    phong.setTrangThai(cbStatus.getSelectedItem().toString());

                    boolean check = phongController.ThemPhong(phong);
                    if (check == true) {
                        JOptionPane.showMessageDialog(null, "Thêm mới thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                defaultTableModel.setRowCount(0);
                        clearDataTable();
                        LoadDataTable();
                        ClearTextField();
                        txtMaPhong.requestFocus();
                        btnThem.setEnabled(true);
                        txtMaPhong.setEnabled(true);

                    }
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Thêm mới thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tbPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPhongMouseClicked
        // TODO add your handling code here:
        defaultTableModel = (DefaultTableModel) tbPhong.getModel();
        int row = tbPhong.getSelectedRow();
        txtMaPhong.setText(defaultTableModel.getValueAt(row, 0).toString());
        txtTenPhong.setText(defaultTableModel.getValueAt(row, 1).toString());
        String Area = defaultTableModel.getValueAt(row, 2).toString();
        switch (Area) {
            case "30m2":
                cbArea.setSelectedIndex(0);
                break;
            case "35m2":
                cbArea.setSelectedIndex(1);
                break;
            case "40m2":
                cbArea.setSelectedIndex(2);
                break;
            case "45m2":
                cbArea.setSelectedIndex(3);
                break;
            case "50m2":
                cbArea.setSelectedIndex(4);
                break;
            default:
                cbArea.getEditor().setItem(Area);
                break;
        }
        String convenient = defaultTableModel.getValueAt(row, 3).toString();
        if (convenient.contains(", ")) {
            String[] parts = convenient.split(", ");
            ClearSelectedCB();
            for (int i = 0; i < parts.length; i++) {
                if (!parts[i].equals("")) {
                    switch (parts[i]) {
                        case "Điều hòa":
                            cbxDieuHoa.setSelected(true);
                            break;
                        case "Nóng lạnh":
                            cbxNongLanh.setSelected(true);
                            break;
                        case "Bồn ngâm":
                            cbxBonNgam.setSelected(true);
                            break;
                        case "Tivi":
                            cbxTivi.setSelected(true);
                            break;
                        case "Tủ lạnh":
                            cbxTuLanh.setSelected(true);
                            break;
                        case "Máy giặt":
                            cbxMayGiat.setSelected(true);
                            break;

                    }
                }
            }
        }

        txtGia.setText(defaultTableModel.getValueAt(row, 4).toString());
        String Status = defaultTableModel.getValueAt(row, 5).toString();
        switch (Status) {
            case "Chưa thuê":
                cbStatus.setSelectedIndex(0);
                break;
            case "Đã thuê":
                cbStatus.setSelectedIndex(1);
                break;
            case "Hỏng":
                cbStatus.setSelectedIndex(2);
                break;

        }

//        txtMaPhong.setEnabled(false);
//        btnThem.setEnabled(false);
    }//GEN-LAST:event_tbPhongMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        try {
            if (txtMaPhong.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn hoặc nhập 1 phòng cần chỉnh sửa", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {
                if (txtTenPhong.getText().equals("") || txtGia.getText().equals("")
                        || (!cbxBonNgam.isSelected() && !cbxDieuHoa.isSelected() && !cbxMayGiat.isSelected()
                        && !cbxNongLanh.isSelected() && !cbxTivi.isSelected() && !cbxTuLanh.isSelected())) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
                } else {
                    int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa phòng " + txtTenPhong.getText() + " không?", "Thông báo", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        Phong phong = new Phong();

                        phong.setMaPhong(txtMaPhong.getText());
                        phong.setTenPhong(txtTenPhong.getText());
                        phong.setDienTich(cbArea.getSelectedItem().toString());
                        phong.setTienNghi(GetAllTienNghi());
                        phong.setGia(Float.valueOf(txtGia.getText()));
                        phong.setTrangThai(cbStatus.getSelectedItem().toString());

                        boolean check = phongController.SuaPhong(phong);
                        if (check == true) {
                            JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                defaultTableModel.setRowCount(0);
                            clearDataTable();
                            LoadDataTable();
                            ClearTextField();
                            txtMaPhong.requestFocus();
                            btnThem.setEnabled(true);
                            txtMaPhong.setEnabled(true);
                        }
                    }
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sửa thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        try {
            if (txtMaPhong.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn hoặc nhập mã phòng cần xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {

                int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa phòng có mã" + txtMaPhong.getText() + " không?", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {

                    boolean check = phongController.XoaPhong(txtMaPhong.getText());
                    if (check == true) {
                        JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//                defaultTableModel.setRowCount(0);
                        clearDataTable();
                        LoadDataTable();
                        ClearTextField();
                        txtMaPhong.requestFocus();
                        btnThem.setEnabled(true);
                        txtMaPhong.setEnabled(true);

                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Xóa thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnClearTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearTextActionPerformed
        // TODO add your handling code here:
        ClearTextField();
        btnThem.setEnabled(true);
        txtMaPhong.setEnabled(true);
    }//GEN-LAST:event_btnClearTextActionPerformed

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
            java.util.logging.Logger.getLogger(frmQLNhanVien.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmQLNhanVien.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmQLNhanVien.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmQLNhanVien.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            frmPhong fPhong = new frmPhong();
            fPhong.setLocationRelativeTo(null);
            fPhong.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClearText;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbArea;
    private javax.swing.JComboBox<String> cbMaPhong;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JCheckBox cbxBonNgam;
    private javax.swing.JCheckBox cbxDieuHoa;
    private javax.swing.JCheckBox cbxMayGiat;
    private javax.swing.JCheckBox cbxNongLanh;
    private javax.swing.JCheckBox cbxTivi;
    private javax.swing.JCheckBox cbxTuLanh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbPhong;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtTenPhong;
    // End of variables declaration//GEN-END:variables
}
