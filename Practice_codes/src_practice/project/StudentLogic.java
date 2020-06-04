/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Harshil Mehta
 * AU1841010
 */
public class StudentLogic {
    private Connection conn ;
    private Statement stmt ;
    private String dbName = "Table_11" ;
    private String username = "root" ;
    private String password = "" ;
    private String dbURL = "jdbc:mysql://localhost:3306/"+dbName ;
    String driverName = "com.mysql.jbdc.Driver" ;

    public StudentLogic(){
        
        try {
            conn = DriverManager.getConnection(dbURL,username,password) ;
            stmt = (Statement) conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("Exception"+ex);
        }  
    }
    public boolean addStudent(String name,int Roll_No,float Cgpa){
        boolean flag = false ;
        try {
            String insertQuery = "INSERT INTO Details" + " VALUES ("+name+",'"+Roll_No+",'"+Cgpa+")" ;
            int result = stmt.executeUpdate(insertQuery);
        } catch (SQLException ex) {
            Logger.getLogger(StudentLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
}
