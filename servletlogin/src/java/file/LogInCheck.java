/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sonu
 */
public class LogInCheck {
    public static boolean validate(String user,String pass) throws SQLException{
    boolean status = false;
    try{
       Class.forName("oracle.jdbc.driver.OracleDriver");  
        try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","saumeen","4869")) {
            PreparedStatement ps = con.prepareStatement("select * from LOGIN where USERNAME = ? and PASSWORD = ?");
            ps.setString(1,user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        }
    }catch(ClassNotFoundException e){ System.out.println(e);}
        return status;
 }


}



