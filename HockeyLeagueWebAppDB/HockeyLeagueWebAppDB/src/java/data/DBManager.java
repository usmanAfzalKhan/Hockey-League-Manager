/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.*;

/**
 *
 * @author garba
 */
public class DBManager {
    
    String conn="jdbc:mysql://localhost:3306/hockeyleaguedb";
    String user="root";
    String pass="pass";
    
    public Connection getConnection(){
        Connection con= null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(conn, user, pass);
        }catch(Exception e){
            System.out.println("error creating connection: "+e);
        }
        return con;
    }

    /* executeQuery 
        takes an sql statement as parameter
        runs the sql statement
        return the result set
    */
    public ResultSet executeQuery(String sql){
        ResultSet rs= null;
        try{
            Connection con = getConnection();
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
        }catch(Exception e){
            System.out.println("*** "+sql+"\n***error executing query: "+e);
        }
        return rs;
    }
    
    /* executeUpdate
        takes an sql statement as parameter
        runs the sql statement
        return the number of records affected
    */
    public int executeUpdate(String sql){
        int rs = -1;
        try{
            Connection con = getConnection();
            Statement st = con.createStatement();
            rs = st.executeUpdate(sql);
        }catch(Exception e){
            System.out.println("*** "+sql+"\n***error executing update: "+e);
        }
        return rs;
    }
    
    
}
