/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class connectDB {
    private static Connection con = null;
    private static connectDB instance = new connectDB();

    public static Connection getCon() {
        return con;
    }
    
    public void connect() throws SQLException{
        String url = "jdbc:sqlserver://localhost:1433;databasename=KaraokeNightLight";
        String user ="sa";
        String password = "sapassword";
        con = DriverManager.getConnection(url,user,password);
    }
    
    public void disconnect(){
        if(con!=null)
        {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static connectDB getInstance() {
        return instance;
    }
    
}
