/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interface_dao;

import java.util.ArrayList;
import models.NhanVien;

/**
 *
 * @author Dell
 */
public interface NhanVienInterface {
    public ArrayList<NhanVien> getAllNhanVien();
    
    public static String sinhMa(String lastMa,String tienTo,int soHauTo)
    {
        int num = Integer.parseInt(lastMa.substring(tienTo.length()));
        num++;
        String nextNum ="";
        switch (soHauTo) {
            case 2 -> 
                nextNum = String.format("%02d", num);
            case 4 ->
                nextNum = String.format("%04d", num);
            default ->
            {
                nextNum = String.format("%03d", num);
            }
           
        }
        return tienTo + nextNum;
    }
    
}
