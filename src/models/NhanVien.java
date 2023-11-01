/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author nxnam
 */
public final class NhanVien {
    private String maNV;
    private String tenNV;
    private LocalDate ngaySinh;
    private boolean gioiTinh;
    private LocalDate ngayVaoLam;
    private String diaChi;
    private String cCCD;
    private String soDienThoai;
    private String email;
    private int caLam;
    private int trangThai;
    private String anh;

    public NhanVien()
    {
        
    }
   

    public NhanVien(String maNV) {
        this.maNV = maNV;
    }

    public NhanVien(String maNV, String tenNV, LocalDate ngaySinh, boolean gioiTinh, LocalDate ngayVaoLam, String diaChi, String cCCD, String soDienThoai, String email, int caLam, int trangThai,String anh) throws Exception {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.ngayVaoLam = ngayVaoLam;
        setDiaChi(diaChi);
        this.cCCD = cCCD;
        this.soDienThoai = soDienThoai;
        this.email = email;
        setCaLam(caLam);
        setTrangThai(trangThai);
        this.anh = anh;
    }
    
    

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) throws Exception {
        this.tenNV = tenNV;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) throws Exception{
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) throws Exception {
        this.gioiTinh = gioiTinh;
    }

    public LocalDate getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(LocalDate ngayVaoLam)throws Exception{
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) throws Exception{
        if(!(diaChi.trim().length()>0))
            throw new Exception("Địa chỉ không được rỗng");
        else
            this.diaChi = diaChi;
    }

    public String getcCCD() {
        return cCCD;
    }

    public void setcCCD(String cCCD) throws Exception {
        this.cCCD = cCCD;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) throws Exception {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        this.email = email;
    }

    public String getDSCaLam() {
        String kq = "";
        switch (this.caLam) {
            case 1 ->
                kq = "Ca 1";
            case 2 ->
                kq = "Ca 2";    
            case 3 -> 
                kq = "Ca 3";
        }
        return kq;
    }
    
    public int getCalam(){
        return caLam;
    }

    public void setCaLam(int caLam) throws Exception {
        this.caLam = caLam;
    }

    public String getDSTrangThai() {
        String resultTrangThai = "";
        switch (this.trangThai) {
            case 1 ->
                 resultTrangThai = "Đang làm";
            case 2 ->
                resultTrangThai ="Tạm nghỉ";
            case 3 ->
                resultTrangThai = "Đã nghỉ việc";
        }
        return resultTrangThai;
    }
    
    public int getTrangThai(){
        return trangThai;
    }

    public void setTrangThai(int trangThai) throws Exception {
        this.trangThai = trangThai;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
    
    

    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + ", tenNV=" + tenNV + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", ngayVaoLam=" + ngayVaoLam + ", diaChi=" + diaChi + ", cCCD=" + cCCD + ", soDienThoai=" + soDienThoai + ", email=" + email + ", caLam=" + caLam + ", trangThai=" + trangThai + '}';
    }
    
    
    
}
