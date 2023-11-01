/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.util.ArrayList;
import models.NhanVien;
import ConnectDB.connectDB;
import java.io.File;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.sql.*;
import models.TaiKhoan;
/**
 *
 * @author nxnam
 */
public class NhanVien_dao {
    public NhanVien_dao(){
        
    }
    
    // lấy tất cả danh sách nhân viên
    public ArrayList<NhanVien> getAllNhanVien(){
        ArrayList<NhanVien> dsNV = new ArrayList<>();
        connectDB.getInstance();
        Connection con = connectDB.getCon();
        try {
            String sql = "Select * from NHANVIEN";
            PreparedStatement psm = con.prepareStatement(sql);
            ResultSet rs = psm.executeQuery();
            
            
            while (rs.next())
            {
                String maNV = rs.getString("maNV");
                String tenNV = rs.getString("hoTenNV");
                LocalDate ngaySinh = rs.getDate("ngaySinh").toLocalDate();
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                LocalDate ngayVaoLam = rs.getDate("ngayVaoLam").toLocalDate();
                String diaChi = rs.getString("diaChi");
                String CCCD = rs.getString("cCCD");
                String SDT = rs.getString("soDienThoai");
                String email = rs.getString("email");
                int caLam = rs.getInt("caLam");
                int trangThai = rs.getInt("trangThai");
                
               NhanVien nv = new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, ngayVaoLam, diaChi, CCCD, diaChi, email, caLam, trangThai, maNV);
                dsNV.add(nv);
                
            }
        } catch (Exception e) {
        }
        return dsNV;
}
    
    public boolean addNhanVien(NhanVien nv) throws SQLException{
        ConnectDB.getInstance();
        Connection con = ConnectDB.getcon();
        PreparedStatement stmt = null;
        
        int n = 0;
        try {
            
            TaiKhoan_dao tkdao = new TaiKhoan_dao();
            con.prepareStatement("insert into" + "NHANVIEN values (?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, nv.getMaNV());
            stmt.setString(2, nv.getTenNV());
            LocalDate ngaySinh = nv.getNgaySinh();
            stmt.setDate(3, java.sql.Date.valueOf(ngaySinh));
            stmt.setBoolean(4, nv.isGioiTinh());
            LocalDate ngayVaoLam = nv.getNgayVaoLam();
            stmt.setDate(5, java.sql.Date.valueOf(ngayVaoLam));
            stmt.setString(6, nv.getDiaChi());
            stmt.setString(7, nv.getcCCD());
            stmt.setString(8, nv.getSoDienThoai());
            stmt.setString(9, nv.getEmail());
            stmt.setInt(10, nv.getCalam());
            stmt.setInt(11, nv.getTrangThai());
            stmt.setString(12, nv.getAnh());
            
            n = stmt.executeUpdate();
            tkdao.taoTaiKhoan(new TaiKhoan(nv.getMaNV(), "1111", false));
            if (n > 0) {
                System.out.println("Tài khoản của bạn là mã nhân viên với mật khẩu là:1111");
            } else {
                System.out.println("Tạo tài khoản không thành công");
            }

            
        } catch (Exception e) {
        }
        return n >0;
        
    }
    
    public String getMaNVThuThuTu(){
        String maNV = "NV0001";
        ConnectDB.getInstance();
        Connection con = connectDB.getCon();
        
        try {
            String sql = "select top 1 maNV from NHANVIEN order by maNV desc";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            maNV = rs.getString("maNV");
        } catch (Exception e) {
        }
        return maNV;
    }
  }
    
    
