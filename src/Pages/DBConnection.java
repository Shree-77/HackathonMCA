/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pages;
import java.sql.*;

/**
 *
 * @author user
 */
public class DBConnection {
        static final String DB_Url ="jdbc:mysql://localhost/demoo";
        static final String USER = "root";
        static final String PASS="";
    public static Connection connectDB(){
        
        Connection conn=null;
        try{
           Class.forName("com.mysql.jdbc.Driver");
           //open connction
           conn=DriverManager.getConnection(DB_Url,USER,PASS);
           return conn;
        }catch(Exception ex){
            System.out.println("There Were Error While Connecting To Dtabase");
            return null;
        }
    }
}
