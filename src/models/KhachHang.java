/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author nxnam
 */
public class KhachHang {
    private String maKH;
    private String tenKH;
    private String SĐT;
    private boolean gioiTinh;
    private LocalDate ngaySinh;
    private int diemThanhVien;

    public KhachHang() {
    }

    public KhachHang(String maKH) {
        this.maKH = maKH;
    }

    public KhachHang(String maKH, String tenKH, String SĐT, boolean gioiTinh, LocalDate ngaySinh, int diemThanhVien) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.SĐT = SĐT;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        setDiemThanhVien(diemThanhVien);
    }
   

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) throws Exception{
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH)throws Exception {
        this.tenKH = tenKH;
    }

    public String getSĐT() {
        return SĐT;
    }

    public void setSĐT(String SĐT)throws Exception {
        this.SĐT = SĐT;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh)throws Exception {
        this.gioiTinh = gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh)throws Exception {
        this.ngaySinh = ngaySinh;
    }

    public int getDiemThanhVien() {
        return diemThanhVien;
    }

    public void setDiemThanhVien(int diemThanhVien) {
        if(diemThanhVien > 0)
            this.diemThanhVien = diemThanhVien;
        else 
            this.diemThanhVien = 0;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.maKH);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KhachHang other = (KhachHang) obj;
        return Objects.equals(this.maKH, other.maKH);
    }

    @Override
    public String toString() {
        return "KhachHang{" + "maKH=" + maKH + ", tenKH=" + tenKH + ", S\u0110T=" + SĐT + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", diemThanhVien=" + diemThanhVien + '}';
    }
    
    
    
}
