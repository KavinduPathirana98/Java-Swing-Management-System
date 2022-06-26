/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/**
 *
 * @author Pkkg
 */
public class DBConnection {
     public Connection con;
    public static DBConnection db;
     private DBConnection()
     {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "service";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
        
        try
        {
            Class.forName(driver).newInstance();
            this.con = (Connection) DriverManager.getConnection(url + dbName, userName, password);
        } 
        catch (Exception sqle)
        {
            sqle.printStackTrace();
        }
}
      public static synchronized DBConnection getDbCon() {
        if (db == null) {
            db = new DBConnection();
        }
        return db;

    }
}
