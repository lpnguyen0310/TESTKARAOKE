/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.NhanVien_dao;
import java.util.ArrayList;
import models.NhanVien;
import interface_dao.NhanVienInterface;
import java.awt.Window;
/**
 *
 * @author nxnam
 */
public class NhanVien_bus implements NhanVienInterface{
    private NhanVien_dao nv_dao;
    private NhanVienInterface nv_interface;
    
    public NhanVien_bus(){
        nv_dao = new NhanVien_dao();
    }

    @Override
    public ArrayList<NhanVien> getAllNhanVien() {
        return nv_dao.getAllNhanVien();
    }
    
    public String phatSinhMa(){
        String ma = nv_dao.getMaNVThuThuTu();
        return  NhanVienInterface.sinhMa(ma, "NV", 4);
    }
}
