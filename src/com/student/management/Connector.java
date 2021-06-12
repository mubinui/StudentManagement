package com.student.management;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    static Connection con;
    public static Connection createC(){
        //loading the driver
        try{
            Class.forName("org.postgresql.Driver");
            //create the connection
            String user = "postgres";
            String password = "root";
            String url="jdbc:postgresql://localhost:5432/student_manage";
            con= DriverManager.getConnection(url,user,password);



        }
        catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
