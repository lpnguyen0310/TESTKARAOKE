/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import interface_dao.TaiKhoanInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.TaiKhoan;

/**
 *
 * @author nxnam
 */
public class TaiKhoan_dao {
    
    public TaiKhoan_dao(){
        
    }
    
    // Tạo tài khoản nhân viên 
    public boolean taoTaiKhoan(TaiKhoan tk)
    {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getcon();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("insert into" + "TAIKHOAN values (?,?,?)");
            stmt.setString(1, tk.getMaTaiKhoan());
            stmt.setString(2, tk.getMatKhau());
            stmt.setBoolean(3, tk.isLoaiTaiKhoan());
            
            n =  stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
        
    }
}
