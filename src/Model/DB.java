/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author Pkkg
 */
public class DB {
    public static Connection createConnection() throws Exception{
    
        Class.forName("com.mysql.jdbc.Driver"); 
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/service" , "root" , ""); //database connection , username and password
        return con;
        
    }
}
