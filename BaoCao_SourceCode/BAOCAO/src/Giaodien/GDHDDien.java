/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Giaodien;

import Entity.DienObject;
import Entity.HGDObject;
import Entity.NhanvienObject;
import Entity.canhoOject;
import NguoidungUse.CanhoSevice;
import NguoidungUse.DienUse;
import NguoidungUse.HGDsevice;
import NguoidungUse.NhanvienUse;
import java.awt.Color;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFChartSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Admin
 */
public class GDHDDien extends javax.swing.JPanel {
    DefaultTableModel defaultTableModel;
    DienUse dienUse;
    List<NhanvienObject> nv;
    CanhoSevice chsv = new CanhoSevice();
    HGDsevice hgd = new HGDsevice();
    NhanvienUse nhanvienUse = new NhanvienUse();
  
    /**
     * Creates new form GDHDDien
     */
    public GDHDDien() {
        dienUse = new DienUse();
        initComponents();
        btnThem.setEnabled(false);
       
        LOADMAHDD();
        loadMANVCB();
        loadMACHCB();
        loadMAHGD();
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        defaultTableModel.addColumn("Mã hóa đơn điện");
        defaultTableModel.addColumn("Tên hóa đơn");
        defaultTableModel.addColumn("Mã nhân viên");
        defaultTableModel.addColumn("Tên nhân viên");
        defaultTableModel.addColumn("Ngày in");
        defaultTableModel.addColumn("Mã hộ gia đình");
        defaultTableModel.addColumn("Tên chủ hộ");
        defaultTableModel.addColumn("Mã căn hộ");
        defaultTableModel.addColumn("Tên căn hộ");
        defaultTableModel.addColumn("Ghi chú");
        defaultTableModel.addColumn("Số lượng");
        defaultTableModel.addColumn("Đơn giá");
        defaultTableModel.addColumn("Tổng tiền");
        defaultTableModel.addColumn("Trạng thái");
        DIENTABLE.setModel(defaultTableModel);
        defaultTableModel.setRowCount(0);
        setdata(dienUse.getALL());
    }
    public GDHDDien(String mahgd) {
        dienUse = new DienUse();
        initComponents();
        btnThem.setEnabled(false);
        btnLammoi.setEnabled(false);
      
        LOADMAHDD();
        loadMANVCB();
        loadMACHCB();
        loadMAHGD();
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        defaultTableModel.addColumn("Mã hóa đơn điện");
        defaultTableModel.addColumn("Tên hóa đơn");
        defaultTableModel.addColumn("Mã nhân viên");
        defaultTableModel.addColumn("Tên nhân viên");
        defaultTableModel.addColumn("Ngày in");
        defaultTableModel.addColumn("Mã hộ gia đình");
        defaultTableModel.addColumn("Tên chủ hộ");
        defaultTableModel.addColumn("Mã căn hộ");
        defaultTableModel.addColumn("Tên căn hộ");
        defaultTableModel.addColumn("Ghi chú");
        defaultTableModel.addColumn("Số lượng");
        defaultTableModel.addColumn("Đơn giá");
        defaultTableModel.addColumn("Tổng tiền");
        defaultTableModel.addColumn("Trạng thái");
        
        DIENTABLE.setModel(defaultTableModel);
        defaultTableModel.setRowCount(0);
        DienObject d = dienUse.getOnebyMahgd(mahgd);
        defaultTableModel.addRow(new Object[]{
                d.getMahddien(),d.getTenhd(),d.getManv(),d.getTennv(),
                d.getNgayin(),d.getMahgd(),d.getTenchuho(),d.getMacanho(),
                d.getTencanho(),d.getGhichu(),d.getSoluong(),d.getDongia(),
                d.getTongtien(),d.getTrangthai()
            });
    }
    public void LOADMAHDD()
    {
        DienUse dienUse = new DienUse();
        List<DienObject> list = dienUse.getALL();
        MaHDDienCB.removeAllItems();
        for (DienObject dien : list) {
             MaHDDienCB.addItem(dien.getMahddien());
        }
    }
    public void loadMAHGD()
    {
        List<HGDObject> list = hgd.getALL();
        MAHGDCB.removeAllItems();
        for (HGDObject hGDObject : list) {
             MAHGDCB.addItem(hGDObject.getMahgd());
        }
    }
    public void loadMANVCB()
    {
        nv = nhanvienUse.getALL();
        MANVCB.removeAllItems();
        for (NhanvienObject nvOb : nv) {
            MANVCB.addItem(nvOb.getManv());
        }
    }
    public void loadMACHCB()
    {
        List<canhoOject> ch = chsv.getALLCH();
        MACANHOCB.removeAllItems();
        for (canhoOject oject : ch) {
            MACANHOCB.addItem(oject.getMa_can_ho());
        }
    }
    public void setdata(List<DienObject> list)
    {
        for (DienObject d : list) {
            defaultTableModel.addRow(new Object[]{
                d.getMahddien(),d.getTenhd(),d.getManv(),d.getTennv(),
                d.getNgayin(),d.getMahgd(),d.getTenchuho(),d.getMacanho(),
                d.getTencanho(),d.getGhichu(),d.getSoluong(),d.getDongia(),
                d.getTongtien(),d.getTrangthai()
            });
            
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        MANVCB = new javax.swing.JComboBox<>();
        MAHDDIENTF = new javax.swing.JTextField();
        TENHDTF = new javax.swing.JTextField();
        TENNVTF = new javax.swing.JTextField();
        NGAYINPICKER = new org.jdesktop.swingx.JXDatePicker();
        MAHGDCB = new javax.swing.JComboBox<>();
        TENCHUHOTF = new javax.swing.JTextField();
        MACANHOCB = new javax.swing.JComboBox<>();
        TENCANHOTF = new javax.swing.JTextField();
        GHICHUTF = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        SOLUONGTF = new javax.swing.JTextField();
        DONGIA = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DIENTABLE = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        SOLUONGTF2 = new javax.swing.JTextField();
        GHICHUTF2 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        TongtienTF = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        TrangthaiTF = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLammoi = new javax.swing.JButton();
        btnTimkiem = new javax.swing.JButton();
        btnIn = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        MaHDDienCB = new javax.swing.JComboBox<>();
        btnThoat = new javax.swing.JButton();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("QUẢN LÝ HÓA ĐƠN ĐIỆN");

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin chung", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel2.setText("              Mã hóa đơn điện");

        jLabel3.setText("              Tên hóa đơn");

        jLabel4.setText("              Mã nhân viên");

        jLabel5.setText("              Tên nhân viên");

        jLabel6.setText("              Ngày in");

        jLabel7.setText("Mã hộ gia đình");

        jLabel8.setText("Mã căn hộ");

        jLabel9.setText("Tên căn hộ");

        jLabel10.setText("Ghi chú");

        jLabel11.setText("Tên chủ hộ");

        MANVCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MANVCBActionPerformed(evt);
            }
        });

        MAHDDIENTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MAHDDIENTFKeyPressed(evt);
            }
        });

        MAHGDCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MAHGDCBActionPerformed(evt);
            }
        });

        MACANHOCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MACANHOCBActionPerformed(evt);
            }
        });

        jLabel12.setText("              Số lượng");

        jLabel13.setText("Đơn giá");

        DONGIA.setText("                      4000");

        jLabel18.setText("kWh");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MANVCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MAHDDIENTF)
                    .addComponent(TENHDTF)
                    .addComponent(NGAYINPICKER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TENNVTF)
                    .addComponent(SOLUONGTF, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addGap(207, 207, 207)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MAHGDCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TENCHUHOTF)
                    .addComponent(MACANHOCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TENCANHOTF)
                    .addComponent(GHICHUTF)
                    .addComponent(DONGIA, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(MAHDDIENTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(TENHDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(MANVCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(TENNVTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(NGAYINPICKER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SOLUONGTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(MAHGDCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11)
                            .addComponent(TENCHUHOTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(MACANHOCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(TENCANHOTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(GHICHUTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(DONGIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(0, 51, 255))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));

        DIENTABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        DIENTABLE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DIENTABLEMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DIENTABLE);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        jLabel15.setText("Số lượng");

        jLabel16.setText("Ghi chú");

        jLabel17.setText("Thuê VAT 10%");

        jLabel20.setText("Tổng tiền");

        jLabel21.setText("Trạng thái");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel21))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SOLUONGTF2, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(TrangthaiTF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(99, 99, 99)
                        .addComponent(GHICHUTF2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(TongtienTF, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(GHICHUTF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(TrangthaiTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17)
                    .addComponent(SOLUONGTF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(TongtienTF, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(317, 317, 317))
        );

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/reuse.png"))); // NOI18N
        btnLammoi.setText("Làm mới");
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });

        btnTimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/search-icon-24.png"))); // NOI18N
        btnTimkiem.setText("Tìm kiếm");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        btnIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Print preview.png"))); // NOI18N
        btnIn.setText("In");
        btnIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInActionPerformed(evt);
            }
        });

        jLabel19.setText("Mã hóa đơn điện");

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Button-Close-icon-16.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem)
                .addGap(29, 29, 29)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnLammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MaHDDienCB, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btnTimkiem)
                .addGap(30, 30, 30)
                .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MaHDDienCB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(405, 405, 405))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        add(jScrollPane2);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        DienObject dien = new DienObject();
        dien.setMahddien(MAHDDIENTF.getText());
        dien.setTenhd(TENHDTF.getText());
        String manv = String.valueOf(MANVCB.getSelectedItem());
        dien.setManv(manv);
        dien.setTennv(TENNVTF.getText());
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        dien.setNgayin(date.format(NGAYINPICKER.getDate()));
        String mahgd = String.valueOf(MAHGDCB.getSelectedItem());
        dien.setMahgd(mahgd);
        dien.setTenchuho(TENCHUHOTF.getText());
        String mach = String.valueOf(MACANHOCB.getSelectedItem());
        dien.setMacanho(mach);
        dien.setTencanho(TENCANHOTF.getText());
        dien.setGhichu(GHICHUTF.getText());
        dien.setSoluong(Integer.valueOf(String.valueOf(SOLUONGTF.getText())));
        dien.setDongia(4000);
        dien.setTrangthai(TrangthaiTF.getText());
        float tongtien = 4000*Integer.valueOf(String.valueOf(SOLUONGTF.getText()));
        dien.setTongtien(tongtien);
        
        if(dienUse.CheckADD(MAHDDIENTF.getText()) == 1)
        {
            
            JOptionPane.showMessageDialog(this, "Hóa đơn điện '"+MAHDDIENTF.getText()+"' đã tồn tại","Lỗi ",JOptionPane.ERROR_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "Thêm thành công ","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            dienUse.ThemHD(dien);
            defaultTableModel.setRowCount(0);
            setdata(dienUse.getALL());
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void MAHDDIENTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MAHDDIENTFKeyPressed
        // TODO add your handling code here:
        if(MAHDDIENTF.getText().equals(""))
        {
            btnThem.setEnabled(false);
        } else btnThem.setEnabled(true);
    }//GEN-LAST:event_MAHDDIENTFKeyPressed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int row = DIENTABLE.getSelectedRow();
        if(row == -1)
        {
            JOptionPane.showMessageDialog(this, "VUI LÒNG CHỌN DÒNG CẦN XÓA ", "LỖI",JOptionPane.ERROR_MESSAGE);
        }
        else{
            int comfirm = JOptionPane.showConfirmDialog(this, "BẠN CÓ CHẮC CHẮN KHÔNG ?");
            if(comfirm == JOptionPane.YES_OPTION)
            {
                String mahddien = String.valueOf(DIENTABLE.getValueAt(row, 0));
                dienUse.XoaHD(mahddien);
                defaultTableModel.setRowCount(0);
                setdata(dienUse.getALL());
                ClearText();
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        
        DienObject dien = new DienObject();
        dien.setMahddien(MAHDDIENTF.getText());
        dien.setTenhd(TENHDTF.getText());
        String manv = String.valueOf(MANVCB.getSelectedItem());
        dien.setManv(manv);
        dien.setTennv(TENNVTF.getText());
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        dien.setNgayin(date.format(NGAYINPICKER.getDate()));
        String mahgd = String.valueOf(MAHGDCB.getSelectedItem());
        dien.setMahgd(mahgd);
        dien.setTenchuho(TENCHUHOTF.getText());
        String mach = String.valueOf(MACANHOCB.getSelectedItem());
        dien.setMacanho(mach);
        dien.setTencanho(TENCANHOTF.getText());
        dien.setGhichu(GHICHUTF.getText());
        dien.setSoluong(Integer.valueOf(String.valueOf(SOLUONGTF.getText())));
        dien.setDongia(4000);
        dien.setTrangthai(TrangthaiTF.getText());
        float tongtien = 4000*Integer.valueOf(String.valueOf(SOLUONGTF.getText()));
        dien.setTongtien(tongtien);
        
        dienUse.UpdateHD(dien);
        defaultTableModel.setRowCount(0);
        setdata(dienUse.getALL());
        ClearText();
    }//GEN-LAST:event_btnSuaActionPerformed
    private  void ClearText()
    {
        MAHGDCB.setSelectedIndex(0);
        TENCHUHOTF.setText("");
        MACANHOCB.setSelectedIndex(0);
        TENCANHOTF.setText("");
        GHICHUTF.setText("");
        SOLUONGTF.setText("");
        GHICHUTF2.setText("");
        SOLUONGTF2.setText("0");
        DONGIA.setText("0.0");
        TrangthaiTF.setText("");
        TongtienTF.setText("0");
    }
    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        // TODO add your handling code here:
        MAHDDIENTF.setText("");
        TENHDTF.setText("");
        MANVCB.setSelectedIndex(0);
        TENNVTF.setText("");
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        try {
            NGAYINPICKER.setDate(date.parse(String.valueOf("2021-1-1")));
        } catch (ParseException ex) {
            Logger.getLogger(GDHDDien.class.getName()).log(Level.SEVERE, null, ex);
        }
        ClearText();
        btnThem.setEnabled(true);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
    }//GEN-LAST:event_btnLammoiActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
         int comfirm = JOptionPane.showConfirmDialog(this, "BẠN CÓ CHẮC CHẮN MUỐN THOÁT KHÔNG ?");
        if(comfirm == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        // TODO add your handling code here:
        String mahddien = String.valueOf(MaHDDienCB.getSelectedItem());
        DienObject d = dienUse.getOne(mahddien);
        if(d.getMahddien() ==null ||d.getSoluong() == 0 || d.getDongia() == 0 || d.getTongtien() == 0)
        {
           
            JOptionPane.showMessageDialog(this, "Không tìm thấy với mã trên","LỖI",JOptionPane.ERROR_MESSAGE);
        }
        else{
             defaultTableModel.setRowCount(0);
            defaultTableModel.addRow(new Object[]{
                d.getMahddien(),d.getTenhd(),d.getManv(),d.getTennv(),
                d.getNgayin(),d.getMahgd(),d.getTenchuho(),d.getMacanho(),
                d.getTencanho(),d.getGhichu(),d.getSoluong(),d.getDongia(),
                d.getTongtien(),d.getTrangthai()
            });
        }
       
    }//GEN-LAST:event_btnTimkiemActionPerformed

    private void btnInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInActionPerformed
        // TODO add your handling code here:
        // mở tab chọn
        JFileChooser execelChooser = new JFileChooser("C:\\Users\\Admin\\Documents\\JavaSwingfile");
        execelChooser.setDialogTitle("Save as");
        // chọn định dạng files excel
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("EXCEL FILES", "xlsx","xls");
        execelChooser.setFileFilter(extensionFilter);
        
        int excelchooser = execelChooser.showSaveDialog(null);
        // kiểm tra xem save được click
        if(excelchooser == JFileChooser.APPROVE_OPTION)
        {
            FileOutputStream fileOutputStream = null;
            BufferedOutputStream  bufferedOutputStream = null;
            XSSFWorkbook excelJtable = null;
            try {
                // import excel poi libraries to netbeans
                excelJtable = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJtable.createSheet("Hóa đơn điện");
                for (int i = 0; i < DIENTABLE.getRowCount(); i++) {
                    XSSFRow  excelrow = excelSheet.createRow(i);
                    
                    for (int j = 0; j < DIENTABLE.getColumnCount(); j++) {
                        XSSFCell excelCell = excelrow.createCell(j);
                        
                        excelCell.setCellValue(DIENTABLE.getValueAt(i, j).toString());
                    }
                }   
                // mở file kiểu nguyên thủy này giúp mở file có kí tự
                fileOutputStream = new FileOutputStream(execelChooser.getSelectedFile() + ".xlsx" );
                // dùng bộ nhớ điệm để lưu dữ liệu giúp cho việc xuất dữ liệu ko thông qua luồng trực tiếp mà thông qua luồng đệm nên lấy dự liệu nhanh hơn
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                // lưu 
                excelJtable.write(bufferedOutputStream);
                JOptionPane.showMessageDialog(null, "XUẤT FILE EXCEL THÀNH CÔNG");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GDHDDien.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GDHDDien.class.getName()).log(Level.SEVERE, null, ex);
            } 
            finally {
                try {
                    if(bufferedOutputStream !=null)
                    {
                        bufferedOutputStream.close();
                    }
                    if(fileOutputStream !=null)
                    {
                        fileOutputStream.close();
                    }
                    
                    if(excelJtable !=null)
                    {
                        excelJtable.close();
                    }
                    
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btnInActionPerformed

    private void MANVCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MANVCBActionPerformed
        // TODO add your handling code here:
        String value = MANVCB.getSelectedItem().toString();
        NhanvienObject nv = nhanvienUse.getOne(value);
        TENNVTF.setText(nv.getTennv().toString());
    }//GEN-LAST:event_MANVCBActionPerformed

    private void MACANHOCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MACANHOCBActionPerformed
        // TODO add your handling code here:
        String value = MACANHOCB.getSelectedItem().toString();
        canhoOject ch = chsv.getONE(value);
        TENCANHOTF.setText(ch.getLoai_can_ho().toString());
    }//GEN-LAST:event_MACANHOCBActionPerformed

    private void MAHGDCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MAHGDCBActionPerformed
        // TODO add your handling code here:
        String value = MAHGDCB.getSelectedItem().toString();
        HGDObject hogd = hgd.getBYID(value);
        TENCHUHOTF.setText(hogd.getTenchuho().toString());
    }//GEN-LAST:event_MAHGDCBActionPerformed

    private void DIENTABLEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DIENTABLEMouseClicked
        // TODO add your handling code here:
        int row = DIENTABLE.getSelectedRow();
        if(row == -1)
        {
            JOptionPane.showMessageDialog(this, "VUI LÒNG CHỌN DÒNG CẦN SỬA ", "LỖI",JOptionPane.ERROR_MESSAGE);
        }
        else{
            String mahddien = String.valueOf(DIENTABLE.getValueAt(row, 0));
            DienObject d = dienUse.getOne(mahddien);
            MAHDDIENTF.setText(d.getMahddien());
            TENHDTF.setText(d.getTenhd());
            MANVCB.setSelectedItem(String.valueOf(d.getManv()));
            TENNVTF.setText(d.getTennv());
            DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            try {
                NGAYINPICKER.setDate(date.parse(String.valueOf(d.getNgayin())));
            } catch (ParseException ex) {
                Logger.getLogger(GDHDDien.class.getName()).log(Level.SEVERE, null, ex);
            }
            MAHGDCB.setSelectedItem(String.valueOf(d.getMahgd()));
            TENCHUHOTF.setText(d.getTenchuho());
            MACANHOCB.setSelectedItem(String.valueOf(d.getMacanho()));
            TENCANHOTF.setText(d.getTencanho());
            GHICHUTF.setText(d.getGhichu());
            SOLUONGTF.setText(String.valueOf(Integer.valueOf(d.getSoluong())));
            GHICHUTF2.setText(d.getGhichu());
            SOLUONGTF2.setText(String.valueOf(Integer.valueOf(d.getSoluong())));
            DONGIA.setText(String.valueOf(Float.valueOf(d.getDongia())));
            TrangthaiTF.setText(d.getTrangthai());
            TongtienTF.setText(String.valueOf(Float.valueOf(d.getTongtien())));
            
             btnThem.setEnabled(false);
            btnSua.setEnabled(true);
            btnXoa.setEnabled(true);
        }
    }//GEN-LAST:event_DIENTABLEMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DIENTABLE;
    private javax.swing.JTextField DONGIA;
    private javax.swing.JTextField GHICHUTF;
    private javax.swing.JTextField GHICHUTF2;
    private javax.swing.JComboBox<String> MACANHOCB;
    private javax.swing.JTextField MAHDDIENTF;
    private javax.swing.JComboBox<String> MAHGDCB;
    private javax.swing.JComboBox<String> MANVCB;
    private javax.swing.JComboBox<String> MaHDDienCB;
    private org.jdesktop.swingx.JXDatePicker NGAYINPICKER;
    private javax.swing.JTextField SOLUONGTF;
    private javax.swing.JTextField SOLUONGTF2;
    private javax.swing.JTextField TENCANHOTF;
    private javax.swing.JTextField TENCHUHOTF;
    private javax.swing.JTextField TENHDTF;
    private javax.swing.JTextField TENNVTF;
    private javax.swing.JTextField TongtienTF;
    private javax.swing.JTextField TrangthaiTF;
    private javax.swing.JButton btnIn;
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
