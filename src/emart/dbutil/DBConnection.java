/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alina
 */
public class DBConnection {
    private static Connection conn;
    static{
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//LAPTOP-JH9OMHF6:1521/XE","grocery","grocery");
            JOptionPane.showMessageDialog(null,"connection open successfully!!!","success",JOptionPane.INFORMATION_MESSAGE );
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "error in loading the driver","Driver error !",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(1);
        }
        catch(SQLException e){
             JOptionPane.showMessageDialog(null, "error in opening connection","connection error !",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection(){
        try{
            conn.close();
             JOptionPane.showMessageDialog(null,"connection closed successfully!!!","success",JOptionPane.INFORMATION_MESSAGE );
        
            
        }
        catch(SQLException e){
             JOptionPane.showMessageDialog(null, "error in closing the  connection","connection error !",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
           
        }
    }

  
          
    
}
