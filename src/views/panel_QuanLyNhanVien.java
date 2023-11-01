/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import ConnectDB.connectDB;
import controller.NhanVien_bus;
import dao.NhanVien_dao;
import interface_dao.NhanVienInterface;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import models.NhanVien;

/**
 *
 * @author Dell
 */
public final class panel_QuanLyNhanVien extends javax.swing.JPanel {
    
    
    private DefaultTableModel modelNhanVien;
    private final ArrayList<NhanVien> listNV = new ArrayList<NhanVien>();
    private NhanVien_dao nv_dao;
    private NhanVien_bus nv_bus;
    
    public panel_QuanLyNhanVien() {
        try {
            connectDB.getInstance().connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
       nv_dao = new NhanVien_dao();
       nv_bus = new NhanVien_bus();
    
       String cols [] = {"Mã nhân viên","Họ và tên","Ngày sinh","Giới tính","Ngày vào làm","Địa chỉ","CCCD","SĐT","email","Ca làm","Trạng thái"};
       modelNhanVien = new DefaultTableModel(cols,0);
       
       initComponents();
       docDSNVToTable();
      
     
    }

    public Object[] getObjectsNhanVien(NhanVien nv){
        Object[] objNhanVien = {nv.getMaNV(),nv.getTenNV(),nv.getNgaySinh(),nv.isGioiTinh(),nv.getNgayVaoLam(),nv.getDiaChi(),nv.getcCCD(),nv.getSoDienThoai(),nv.getEmail(),nv.getCalam(),nv.getTrangThai()};
        return objNhanVien;
    }
    
    /**
     *
     */
    public void XoaHetDuLieuTable()
    {
        DefaultTableModel tmp = (DefaultTableModel) tableNhanVien.getModel();
        tmp.getDataVector().removeAllElements();
    }
    
    
    public void docDSNVToTable() {
        ArrayList<NhanVien> ds = nv_bus.getAllNhanVien();
        for (NhanVien nv :ds){
            modelNhanVien.addRow(getObjectsNhanVien(nv));
        }
    }
    
    public void clearAll(){
        txtmaNV.setText("");
        txttenNV.setText("");
        dchngaySinh.setDate(null);
        radNam.setSelected(true);
        dchNgayVaoLam.setDate(null);
        txtDiaChi.setText("");
        txtCCCD.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
        cboCaLam.setSelectedIndex(0);
        cboTrangThai.setSelectedIndex(0);
        lblAnh.setIcon(ResizeImage(String.valueOf(duongdananh)));
    }
    
    
    public NhanVien createNV() throws Exception{
        String maNV = nv_bus.phatSinhMa();
        String tenNV = txttenNV.getText().toString();
        Date ngaySinh = dchngaySinh.getDate();
        boolean gioiTinh ;
        if(radNam.isSelected())
            gioiTinh = true;
        else gioiTinh = false;
        Date ngayVaoLam = dchNgayVaoLam.getDate();
        String diaChi = txtDiaChi.getText().toString();
        String CCCD = txtCCCD.getText().toString();
        String SDT =  txtSDT.getText().toString();
        String email = txtEmail.getText().toString();
        String caLam = (String) cboCaLam.getSelectedItem();
        String trangThai = (String) cboTrangThai.getSelectedItem();
        String anh = lblAnh.getText();
       NhanVien nv = new NhanVien(maNV, tenNV, LocalDate.MIN, gioiTinh, LocalDate.MAX, diaChi, CCCD, trangThai, email, WIDTH, WIDTH, anh);
       
        return nv;
        }
 
    public boolean validData()
    {
        
        return false;
        
    }
    
  
    
    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grGioiTinh = new javax.swing.ButtonGroup();
        pnl_TieuDe = new javax.swing.JPanel();
        lblTieuDe = new javax.swing.JLabel();
        filler17 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 25));
        pnl_Center = new javax.swing.JPanel();
        pnl_ChucNang = new javax.swing.JPanel();
        pnl_TacVu = new javax.swing.JPanel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnThem = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnXoaTrangThai = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnSua = new javax.swing.JButton();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnLamMoi = new javax.swing.JButton();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        pnl_TimKiem = new javax.swing.JPanel();
        btnTim = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        lblTimKiem = new javax.swing.JLabel();
        pnl_ThongTinNV = new javax.swing.JPanel();
        pnl_TTNVWest = new javax.swing.JPanel();
        filler36 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 25));
        pnl_maNV = new javax.swing.JPanel();
        filler39 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        lblmaNV = new javax.swing.JLabel();
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(16, 0), new java.awt.Dimension(160, 0));
        txtmaNV = new javax.swing.JTextField();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 15), new java.awt.Dimension(0, 15));
        pnl_TenNV = new javax.swing.JPanel();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(45, 0), new java.awt.Dimension(55, 0));
        lbltenNV = new javax.swing.JLabel();
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(32767, 0));
        txttenNV = new javax.swing.JTextField();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 15));
        pnl_NgaySinh = new javax.swing.JPanel();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(45, 0));
        lblngaySinh = new javax.swing.JLabel();
        filler42 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(45, 0));
        dchngaySinh = new com.toedter.calendar.JDateChooser();
        filler14 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 15));
        pnl_GioiTInh = new javax.swing.JPanel();
        filler43 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(27, 0));
        lblGioiTinh = new javax.swing.JLabel();
        filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(125, 0));
        radNam = new javax.swing.JRadioButton();
        filler13 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(30, 0));
        radNu = new javax.swing.JRadioButton();
        filler16 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 15));
        pnl_NgayVaoLam = new javax.swing.JPanel();
        filler44 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(52, 0));
        lblNgayVaoLam = new javax.swing.JLabel();
        filler15 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(30, 0));
        dchNgayVaoLam = new com.toedter.calendar.JDateChooser();
        filler18 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(35, 0));
        pnl_TTNVCenter = new javax.swing.JPanel();
        filler38 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 25));
        pnl_Anh = new javax.swing.JPanel();
        lblAnh = new javax.swing.JLabel();
        pnl_ChonAnh = new javax.swing.JPanel();
        filler19 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(27, 0));
        btnAnh = new javax.swing.JButton();
        pnl_TTNVEast = new javax.swing.JPanel();
        filler37 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 25));
        pnl_DiaCHi = new javax.swing.JPanel();
        lblDiaChi = new javax.swing.JLabel();
        filler20 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(60, 0));
        txtDiaChi = new javax.swing.JTextField();
        filler30 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(15, 0));
        filler22 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 15));
        pml_CMND = new javax.swing.JPanel();
        lblCCCD = new javax.swing.JLabel();
        filler21 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(67, 0), new java.awt.Dimension(115, 0));
        txtCCCD = new javax.swing.JTextField();
        filler31 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(15, 0), new java.awt.Dimension(15, 0));
        filler24 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 15));
        pnl_SĐT = new javax.swing.JPanel();
        lblSoDienThoai = new javax.swing.JLabel();
        filler23 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(85, 0), new java.awt.Dimension(120, 0));
        txtSDT = new javax.swing.JTextField();
        filler32 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(15, 0), new java.awt.Dimension(15, 0));
        filler26 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 15));
        pnl_Email = new javax.swing.JPanel();
        lblEmail = new javax.swing.JLabel();
        filler25 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(75, 0));
        txtEmail = new javax.swing.JTextField();
        filler33 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(15, 0));
        filler28 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 15));
        pnl_CaLam = new javax.swing.JPanel();
        lblCaLam = new javax.swing.JLabel();
        filler27 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(55, 0), new java.awt.Dimension(35, 0));
        cboCaLam = new javax.swing.JComboBox<>();
        filler34 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(15, 0), new java.awt.Dimension(15, 0));
        filler29 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 15));
        pnl_TrangThai = new javax.swing.JPanel();
        lblTrangThai = new javax.swing.JLabel();
        filler41 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(30, 0), new java.awt.Dimension(35, 0));
        cboTrangThai = new javax.swing.JComboBox<>();
        filler35 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(15, 0), new java.awt.Dimension(15, 0));
        pnl_DanhSachNhanVien = new javax.swing.JPanel();
        pnl_Loc = new javax.swing.JPanel();
        filler40 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(35, 0));
        btnLoc = new javax.swing.JButton();
        pnl_danhSach = new javax.swing.JPanel();
        pane = new javax.swing.JScrollPane();
        tableNhanVien = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(1200, 700));
        setPreferredSize(new java.awt.Dimension(1200, 700));
        setLayout(new java.awt.BorderLayout());

        pnl_TieuDe.setBackground(new java.awt.Color(0, 255, 255));
        pnl_TieuDe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnl_TieuDe.setForeground(new java.awt.Color(255, 255, 255));
        pnl_TieuDe.setPreferredSize(new java.awt.Dimension(1001, 50));
        pnl_TieuDe.setLayout(new java.awt.BorderLayout());

        lblTieuDe.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTieuDe.setText("QUẢN LÝ NHÂN VIÊN");
        pnl_TieuDe.add(lblTieuDe, java.awt.BorderLayout.CENTER);

        add(pnl_TieuDe, java.awt.BorderLayout.NORTH);
        add(filler17, java.awt.BorderLayout.LINE_END);

        pnl_Center.setMaximumSize(new java.awt.Dimension(1200, 700));
        pnl_Center.setMinimumSize(new java.awt.Dimension(1200, 700));
        pnl_Center.setPreferredSize(new java.awt.Dimension(1200, 600));
        pnl_Center.setLayout(new java.awt.BorderLayout());

        pnl_ChucNang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnl_ChucNang.setMaximumSize(new java.awt.Dimension(1000, 60));
        pnl_ChucNang.setPreferredSize(new java.awt.Dimension(1000, 60));
        pnl_ChucNang.setLayout(new javax.swing.BoxLayout(pnl_ChucNang, javax.swing.BoxLayout.LINE_AXIS));

        pnl_TacVu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_TacVu.setInheritsPopupMenu(true);
        pnl_TacVu.setMaximumSize(new java.awt.Dimension(164199, 60));
        pnl_TacVu.setName(""); // NOI18N
        pnl_TacVu.setPreferredSize(new java.awt.Dimension(450, 60));
        pnl_TacVu.setLayout(new javax.swing.BoxLayout(pnl_TacVu, javax.swing.BoxLayout.LINE_AXIS));
        pnl_TacVu.add(filler4);

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/person add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setMargin(new java.awt.Insets(3, 14, 3, 14));
        btnThem.setMaximumSize(new java.awt.Dimension(84, 30));
        btnThem.setPreferredSize(new java.awt.Dimension(120, 40));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        pnl_TacVu.add(btnThem);
        pnl_TacVu.add(filler1);

        btnXoaTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoaTrangThai.setText("Xóa Trạng Thái");
        btnXoaTrangThai.setIconTextGap(5);
        btnXoaTrangThai.setMaximumSize(new java.awt.Dimension(121, 30));
        btnXoaTrangThai.setPreferredSize(new java.awt.Dimension(130, 30));
        btnXoaTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTrangThaiActionPerformed(evt);
            }
        });
        pnl_TacVu.add(btnXoaTrangThai);
        pnl_TacVu.add(filler2);

        btnSua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setMaximumSize(new java.awt.Dimension(72, 30));
        btnSua.setPreferredSize(new java.awt.Dimension(120, 35));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        pnl_TacVu.add(btnSua);
        pnl_TacVu.add(filler6);

        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setMaximumSize(new java.awt.Dimension(83, 30));
        btnLamMoi.setPreferredSize(new java.awt.Dimension(120, 30));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        pnl_TacVu.add(btnLamMoi);
        pnl_TacVu.add(filler7);

        pnl_ChucNang.add(pnl_TacVu);

        pnl_TimKiem.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnl_TimKiem.setAlignmentY(0.6F);
        pnl_TimKiem.setMinimumSize(new java.awt.Dimension(87, 10));
        pnl_TimKiem.setPreferredSize(new java.awt.Dimension(540, 35));

        btnTim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTim.setText("Tìm");
        btnTim.setPreferredSize(new java.awt.Dimension(90, 30));
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        txtTimKiem.setColumns(35);
        txtTimKiem.setActionCommand("<Not Set>");
        txtTimKiem.setAlignmentX(1.0F);
        txtTimKiem.setMinimumSize(new java.awt.Dimension(64, 15));
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.setPreferredSize(new Dimension(146,35));

        lblTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTimKiem.setText("Tìm Kiếm");

        javax.swing.GroupLayout pnl_TimKiemLayout = new javax.swing.GroupLayout(pnl_TimKiem);
        pnl_TimKiem.setLayout(pnl_TimKiemLayout);
        pnl_TimKiemLayout.setHorizontalGroup(
            pnl_TimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_TimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnl_TimKiemLayout.setVerticalGroup(
            pnl_TimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_TimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_TimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTimKiem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtTimKiem.getAccessibleContext().setAccessibleDescription("");

        pnl_ChucNang.add(pnl_TimKiem);

        pnl_Center.add(pnl_ChucNang, java.awt.BorderLayout.PAGE_START);

        pnl_ThongTinNV.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        pnl_ThongTinNV.setMaximumSize(new java.awt.Dimension(1000, 300));
        pnl_ThongTinNV.setMinimumSize(new java.awt.Dimension(646, 300));
        pnl_ThongTinNV.setPreferredSize(new java.awt.Dimension(1000, 300));
        pnl_ThongTinNV.setRequestFocusEnabled(false);
        pnl_ThongTinNV.setLayout(new java.awt.BorderLayout());

        pnl_TTNVWest.setMaximumSize(new java.awt.Dimension(500, 300));
        pnl_TTNVWest.setPreferredSize(new java.awt.Dimension(500, 300));
        pnl_TTNVWest.setLayout(new javax.swing.BoxLayout(pnl_TTNVWest, javax.swing.BoxLayout.Y_AXIS));
        pnl_TTNVWest.add(filler36);

        pnl_maNV.setMaximumSize(new java.awt.Dimension(480, 30));
        pnl_maNV.setLayout(new javax.swing.BoxLayout(pnl_maNV, javax.swing.BoxLayout.LINE_AXIS));
        pnl_maNV.add(filler39);

        lblmaNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblmaNV.setText("Mã nhân viên:");
        pnl_maNV.add(lblmaNV);
        pnl_maNV.add(filler10);

        txtmaNV.setMaximumSize(new java.awt.Dimension(350, 25));
        txtmaNV.setMinimumSize(new java.awt.Dimension(60, 22));
        txtmaNV.setPreferredSize(new java.awt.Dimension(320, 35));
        txtmaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaNVActionPerformed(evt);
            }
        });
        pnl_maNV.add(txtmaNV);

        pnl_TTNVWest.add(pnl_maNV);
        pnl_TTNVWest.add(filler3);

        pnl_TenNV.setMaximumSize(new java.awt.Dimension(480, 30));
        pnl_TenNV.setPreferredSize(new java.awt.Dimension(400, 30));
        pnl_TenNV.setLayout(new javax.swing.BoxLayout(pnl_TenNV, javax.swing.BoxLayout.LINE_AXIS));
        pnl_TenNV.add(filler9);

        lbltenNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbltenNV.setText("Tên nhân viên:");
        pnl_TenNV.add(lbltenNV);
        pnl_TenNV.add(filler11);

        txttenNV.setText("jTextField2");
        txttenNV.setMaximumSize(new java.awt.Dimension(320, 25));
        txttenNV.setPreferredSize(new java.awt.Dimension(320, 25));
        pnl_TenNV.add(txttenNV);

        pnl_TTNVWest.add(pnl_TenNV);
        pnl_TTNVWest.add(filler8);

        pnl_NgaySinh.setMaximumSize(new java.awt.Dimension(480, 30));
        pnl_NgaySinh.setLayout(new javax.swing.BoxLayout(pnl_NgaySinh, javax.swing.BoxLayout.LINE_AXIS));
        pnl_NgaySinh.add(filler5);

        lblngaySinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblngaySinh.setText("Ngày sinh: ");
        pnl_NgaySinh.add(lblngaySinh);
        pnl_NgaySinh.add(filler42);

        dchngaySinh.setMaximumSize(new java.awt.Dimension(320, 25));
        dchngaySinh.setPreferredSize(new java.awt.Dimension(25, 22));
        pnl_NgaySinh.add(dchngaySinh);

        pnl_TTNVWest.add(pnl_NgaySinh);
        pnl_TTNVWest.add(filler14);

        pnl_GioiTInh.setMaximumSize(new java.awt.Dimension(450, 30));
        pnl_GioiTInh.setLayout(new javax.swing.BoxLayout(pnl_GioiTInh, javax.swing.BoxLayout.LINE_AXIS));
        pnl_GioiTInh.add(filler43);

        lblGioiTinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGioiTinh.setText("Giới tính:");
        pnl_GioiTInh.add(lblGioiTinh);
        pnl_GioiTInh.add(filler12);

        grGioiTinh.add(radNam);
        radNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radNam.setText("Nam");
        radNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNamActionPerformed(evt);
            }
        });
        pnl_GioiTInh.add(radNam);
        pnl_GioiTInh.add(filler13);

        grGioiTinh.add(radNu);
        radNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radNu.setText("Nữ");
        pnl_GioiTInh.add(radNu);

        pnl_TTNVWest.add(pnl_GioiTInh);
        pnl_TTNVWest.add(filler16);

        pnl_NgayVaoLam.setMaximumSize(new java.awt.Dimension(480, 30));
        pnl_NgayVaoLam.setLayout(new javax.swing.BoxLayout(pnl_NgayVaoLam, javax.swing.BoxLayout.LINE_AXIS));
        pnl_NgayVaoLam.add(filler44);

        lblNgayVaoLam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNgayVaoLam.setText("Ngày vào làm: ");
        pnl_NgayVaoLam.add(lblNgayVaoLam);
        pnl_NgayVaoLam.add(filler15);

        dchNgayVaoLam.setMaximumSize(new java.awt.Dimension(360, 25));
        dchNgayVaoLam.setPreferredSize(new java.awt.Dimension(25, 22));
        pnl_NgayVaoLam.add(dchNgayVaoLam);

        pnl_TTNVWest.add(pnl_NgayVaoLam);

        pnl_ThongTinNV.add(pnl_TTNVWest, java.awt.BorderLayout.WEST);
        pnl_ThongTinNV.add(filler18, java.awt.BorderLayout.PAGE_START);

        pnl_TTNVCenter.setMaximumSize(new java.awt.Dimension(150, 400));
        pnl_TTNVCenter.setPreferredSize(new java.awt.Dimension(200, 400));
        pnl_TTNVCenter.setLayout(new javax.swing.BoxLayout(pnl_TTNVCenter, javax.swing.BoxLayout.Y_AXIS));
        pnl_TTNVCenter.add(filler38);

        pnl_Anh.setBackground(new java.awt.Color(204, 204, 204));
        pnl_Anh.setMaximumSize(new java.awt.Dimension(200, 150));
        pnl_Anh.setPreferredSize(new java.awt.Dimension(200, 150));
        pnl_Anh.setLayout(new javax.swing.BoxLayout(pnl_Anh, javax.swing.BoxLayout.LINE_AXIS));

        lblAnh.setBackground(new java.awt.Color(102, 0, 51));
        lblAnh.setMaximumSize(new java.awt.Dimension(200, 300));
        pnl_Anh.add(lblAnh);

        pnl_TTNVCenter.add(pnl_Anh);

        pnl_ChonAnh.setMaximumSize(new java.awt.Dimension(150, 100));
        pnl_ChonAnh.setPreferredSize(new java.awt.Dimension(150, 50));
        pnl_ChonAnh.setLayout(new javax.swing.BoxLayout(pnl_ChonAnh, javax.swing.BoxLayout.LINE_AXIS));
        pnl_ChonAnh.add(filler19);

        btnAnh.setText("Chọn Ảnh");
        btnAnh.setAlignmentX(5.0F);
        btnAnh.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnAnh.setMargin(new java.awt.Insets(3, 14, 3, 14));
        btnAnh.setMaximumSize(new java.awt.Dimension(90, 35));
        btnAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnhActionPerformed(evt);
            }
        });
        pnl_ChonAnh.add(btnAnh);

        pnl_TTNVCenter.add(pnl_ChonAnh);

        pnl_ThongTinNV.add(pnl_TTNVCenter, java.awt.BorderLayout.CENTER);

        pnl_TTNVEast.setMaximumSize(new java.awt.Dimension(500, 300));
        pnl_TTNVEast.setMinimumSize(new java.awt.Dimension(400, 250));
        pnl_TTNVEast.setPreferredSize(new java.awt.Dimension(500, 300));
        pnl_TTNVEast.setLayout(new javax.swing.BoxLayout(pnl_TTNVEast, javax.swing.BoxLayout.Y_AXIS));
        pnl_TTNVEast.add(filler37);

        pnl_DiaCHi.setMaximumSize(new java.awt.Dimension(450, 30));
        pnl_DiaCHi.setLayout(new javax.swing.BoxLayout(pnl_DiaCHi, javax.swing.BoxLayout.LINE_AXIS));

        lblDiaChi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDiaChi.setText("Địa chỉ:");
        pnl_DiaCHi.add(lblDiaChi);
        pnl_DiaCHi.add(filler20);

        txtDiaChi.setMaximumSize(new java.awt.Dimension(360, 30));
        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });
        pnl_DiaCHi.add(txtDiaChi);
        pnl_DiaCHi.add(filler30);

        pnl_TTNVEast.add(pnl_DiaCHi);
        pnl_TTNVEast.add(filler22);

        pml_CMND.setInheritsPopupMenu(true);
        pml_CMND.setMaximumSize(new java.awt.Dimension(450, 30));
        pml_CMND.setLayout(new javax.swing.BoxLayout(pml_CMND, javax.swing.BoxLayout.LINE_AXIS));

        lblCCCD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCCCD.setText("CCCD: ");
        pml_CMND.add(lblCCCD);
        pml_CMND.add(filler21);

        txtCCCD.setMaximumSize(new java.awt.Dimension(350, 25));
        txtCCCD.setPreferredSize(new java.awt.Dimension(360, 30));
        pml_CMND.add(txtCCCD);
        pml_CMND.add(filler31);

        pnl_TTNVEast.add(pml_CMND);
        pnl_TTNVEast.add(filler24);

        pnl_SĐT.setMaximumSize(new java.awt.Dimension(450, 30));
        pnl_SĐT.setPreferredSize(new java.awt.Dimension(400, 30));
        pnl_SĐT.setLayout(new javax.swing.BoxLayout(pnl_SĐT, javax.swing.BoxLayout.LINE_AXIS));

        lblSoDienThoai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSoDienThoai.setText("SĐT:");
        pnl_SĐT.add(lblSoDienThoai);
        pnl_SĐT.add(filler23);

        txtSDT.setMaximumSize(new java.awt.Dimension(360, 25));
        txtSDT.setPreferredSize(new java.awt.Dimension(360, 30));
        pnl_SĐT.add(txtSDT);
        pnl_SĐT.add(filler32);

        pnl_TTNVEast.add(pnl_SĐT);
        pnl_TTNVEast.add(filler26);

        pnl_Email.setMaximumSize(new java.awt.Dimension(450, 30));
        pnl_Email.setPreferredSize(new java.awt.Dimension(400, 30));
        pnl_Email.setLayout(new javax.swing.BoxLayout(pnl_Email, javax.swing.BoxLayout.LINE_AXIS));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmail.setText("Email:");
        pnl_Email.add(lblEmail);
        pnl_Email.add(filler25);

        txtEmail.setMaximumSize(new java.awt.Dimension(360, 25));
        txtEmail.setPreferredSize(new java.awt.Dimension(64, 20));
        pnl_Email.add(txtEmail);
        pnl_Email.add(filler33);

        pnl_TTNVEast.add(pnl_Email);
        pnl_TTNVEast.add(filler28);

        pnl_CaLam.setMaximumSize(new java.awt.Dimension(450, 30));
        pnl_CaLam.setLayout(new javax.swing.BoxLayout(pnl_CaLam, javax.swing.BoxLayout.LINE_AXIS));

        lblCaLam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCaLam.setText("Ca Làm:");
        pnl_CaLam.add(lblCaLam);
        pnl_CaLam.add(filler27);

        cboCaLam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ca 1", "Ca 2", "Ca 3" }));
        cboCaLam.setMaximumSize(new java.awt.Dimension(32767, 30));
        cboCaLam.setPreferredSize(new java.awt.Dimension(72, 20));
        cboCaLam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCaLamActionPerformed(evt);
            }
        });
        pnl_CaLam.add(cboCaLam);
        pnl_CaLam.add(filler34);

        pnl_TTNVEast.add(pnl_CaLam);
        pnl_TTNVEast.add(filler29);

        pnl_TrangThai.setMaximumSize(new java.awt.Dimension(450, 30));
        pnl_TrangThai.setLayout(new javax.swing.BoxLayout(pnl_TrangThai, javax.swing.BoxLayout.LINE_AXIS));

        lblTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai.setText("Trạng thái: ");
        pnl_TrangThai.add(lblTrangThai);
        pnl_TrangThai.add(filler41);

        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang làm", "Tạm nghỉ", "Nghỉ việc" }));
        cboTrangThai.setMaximumSize(new java.awt.Dimension(32767, 25));
        pnl_TrangThai.add(cboTrangThai);
        pnl_TrangThai.add(filler35);

        pnl_TTNVEast.add(pnl_TrangThai);

        pnl_ThongTinNV.add(pnl_TTNVEast, java.awt.BorderLayout.EAST);

        pnl_Center.add(pnl_ThongTinNV, java.awt.BorderLayout.CENTER);

        pnl_DanhSachNhanVien.setPreferredSize(new java.awt.Dimension(1000, 400));
        pnl_DanhSachNhanVien.setLayout(new java.awt.BorderLayout());

        pnl_Loc.setMaximumSize(new java.awt.Dimension(300, 100));
        pnl_Loc.setPreferredSize(new java.awt.Dimension(200, 50));
        pnl_Loc.setLayout(new javax.swing.BoxLayout(pnl_Loc, javax.swing.BoxLayout.LINE_AXIS));
        pnl_Loc.add(filler40);

        btnLoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLoc.setForeground(new java.awt.Color(255, 51, 51));
        btnLoc.setText("Lọc theo ca làm");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });
        pnl_Loc.add(btnLoc);

        pnl_DanhSachNhanVien.add(pnl_Loc, java.awt.BorderLayout.PAGE_START);

        pnl_danhSach.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách nhân viên"));
        pnl_danhSach.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnl_danhSach.setMaximumSize(new java.awt.Dimension(1200, 300));
        pnl_danhSach.setPreferredSize(new java.awt.Dimension(1200, 350));
        pnl_danhSach.setLayout(new java.awt.BorderLayout());

        pane.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneMouseClicked(evt);
            }
        });

        tableNhanVien.setModel(modelNhanVien);
        pane.setViewportView(tableNhanVien);

        pnl_danhSach.add(pane, java.awt.BorderLayout.CENTER);

        pnl_DanhSachNhanVien.add(pnl_danhSach, java.awt.BorderLayout.SOUTH);

        pnl_Center.add(pnl_DanhSachNhanVien, java.awt.BorderLayout.SOUTH);

        add(pnl_Center, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        clearAll();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnXoaTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTrangThaiActionPerformed
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_btnXoaTrangThaiActionPerformed

    private void radNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radNamActionPerformed

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiActionPerformed

    private void cboCaLamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCaLamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCaLamActionPerformed
    String duongdananh ="D:\\DH17KTPM\\HK1_2023-2024\\Anh\\anhmacdinh.png";
    public ImageIcon ResizeImage(String ImagePath){
        ImageIcon myImage = new ImageIcon(ImagePath);
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(lblAnh.getWidth(),lblAnh.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    private void btnAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnhActionPerformed
        // TODO add your handling code here:
        JFileChooser f = new JFileChooser("D:\\DH17KTPM\\HK1_2023-2024\\Anh");
        f.setDialogTitle("Mở File");
        f.showOpenDialog(null);
        File ftenAnh = f.getSelectedFile();
        duongdananh = ftenAnh.getAbsolutePath();
        lblAnh.setIcon(ResizeImage(String.valueOf(duongdananh)));
          
    }//GEN-LAST:event_btnAnhActionPerformed

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLocActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if(validData())
        {
            NhanVien nv = new NhanVien();
            if(nv_da)
           
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtmaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaNVActionPerformed
    
    
    
    private void paneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneMouseClicked
        // TODO add your handling code here:
        int r = tableNhanVien.getSelectedRow();
        if(r!=-1)
        {
        txtmaNV.setText(tableNhanVien.getValueAt(r,0).toString());
        txttenNV.setText(tableNhanVien.getValueAt(r, 1).toString());
        LocalDate ngaySinh = (LocalDate) tableNhanVien.getValueAt(r, 2);
        dchngaySinh.setDate(Date.from(ngaySinh.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        if(tableNhanVien.getValueAt(r, 3).toString()=="Nam"){
            radNam.setSelected(true);
        }
        else 
            radNu.setSelected(true);
        LocalDate ngayVaoLam = (LocalDate) tableNhanVien.getValueAt(r,4 );
        dchNgayVaoLam.setDate(Date.from(ngayVaoLam.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        txtDiaChi.setText(tableNhanVien.getValueAt(r, 5).toString());
        txtCCCD.setText(tableNhanVien.getValueAt(r, 6).toString());
        txtSDT.setText(tableNhanVien.getValueAt(r, 7).toString());
        txtEmail.setText(tableNhanVien.getValueAt(r, 8).toString());
        cboCaLam.setSelectedItem(tableNhanVien.getValueAt(r, 9).toString());
        cboTrangThai.setSelectedItem(tableNhanVien.getValueAt(r, 10));
        lblAnh.setText(String.valueOf(duongdananh));
        }
    }//GEN-LAST:event_paneMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnh;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoaTrangThai;
    private javax.swing.JComboBox<String> cboCaLam;
    private javax.swing.JComboBox<String> cboTrangThai;
    private com.toedter.calendar.JDateChooser dchNgayVaoLam;
    private com.toedter.calendar.JDateChooser dchngaySinh;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler12;
    private javax.swing.Box.Filler filler13;
    private javax.swing.Box.Filler filler14;
    private javax.swing.Box.Filler filler15;
    private javax.swing.Box.Filler filler16;
    private javax.swing.Box.Filler filler17;
    private javax.swing.Box.Filler filler18;
    private javax.swing.Box.Filler filler19;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler20;
    private javax.swing.Box.Filler filler21;
    private javax.swing.Box.Filler filler22;
    private javax.swing.Box.Filler filler23;
    private javax.swing.Box.Filler filler24;
    private javax.swing.Box.Filler filler25;
    private javax.swing.Box.Filler filler26;
    private javax.swing.Box.Filler filler27;
    private javax.swing.Box.Filler filler28;
    private javax.swing.Box.Filler filler29;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler30;
    private javax.swing.Box.Filler filler31;
    private javax.swing.Box.Filler filler32;
    private javax.swing.Box.Filler filler33;
    private javax.swing.Box.Filler filler34;
    private javax.swing.Box.Filler filler35;
    private javax.swing.Box.Filler filler36;
    private javax.swing.Box.Filler filler37;
    private javax.swing.Box.Filler filler38;
    private javax.swing.Box.Filler filler39;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler40;
    private javax.swing.Box.Filler filler41;
    private javax.swing.Box.Filler filler42;
    private javax.swing.Box.Filler filler43;
    private javax.swing.Box.Filler filler44;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    private javax.swing.ButtonGroup grGioiTinh;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblCCCD;
    private javax.swing.JLabel lblCaLam;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblNgayVaoLam;
    private javax.swing.JLabel lblSoDienThoai;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JLabel lblmaNV;
    private javax.swing.JLabel lblngaySinh;
    private javax.swing.JLabel lbltenNV;
    private javax.swing.JScrollPane pane;
    private javax.swing.JPanel pml_CMND;
    private javax.swing.JPanel pnl_Anh;
    private javax.swing.JPanel pnl_CaLam;
    private javax.swing.JPanel pnl_Center;
    private javax.swing.JPanel pnl_ChonAnh;
    private javax.swing.JPanel pnl_ChucNang;
    private javax.swing.JPanel pnl_DanhSachNhanVien;
    private javax.swing.JPanel pnl_DiaCHi;
    private javax.swing.JPanel pnl_Email;
    private javax.swing.JPanel pnl_GioiTInh;
    private javax.swing.JPanel pnl_Loc;
    private javax.swing.JPanel pnl_NgaySinh;
    private javax.swing.JPanel pnl_NgayVaoLam;
    private javax.swing.JPanel pnl_SĐT;
    private javax.swing.JPanel pnl_TTNVCenter;
    private javax.swing.JPanel pnl_TTNVEast;
    private javax.swing.JPanel pnl_TTNVWest;
    private javax.swing.JPanel pnl_TacVu;
    private javax.swing.JPanel pnl_TenNV;
    private javax.swing.JPanel pnl_ThongTinNV;
    private javax.swing.JPanel pnl_TieuDe;
    private javax.swing.JPanel pnl_TimKiem;
    private javax.swing.JPanel pnl_TrangThai;
    private javax.swing.JPanel pnl_danhSach;
    private javax.swing.JPanel pnl_maNV;
    private javax.swing.JRadioButton radNam;
    private javax.swing.JRadioButton radNu;
    private javax.swing.JTable tableNhanVien;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtmaNV;
    private javax.swing.JTextField txttenNV;
    // End of variables declaration//GEN-END:variables


   
}
