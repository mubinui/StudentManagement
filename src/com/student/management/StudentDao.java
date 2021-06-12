package com.student.management;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDao {
    public static boolean insertStudentToDB(Student st){
        boolean flag = false;
        try{
            //jdbc code
            Connection con = Connector.createC();
            String q = "insert into students(sname,sphone,scity) values(?,?,?)";
            //Dynamic query
            //preparedStatement
            PreparedStatement prestmpt = con.prepareStatement(q);
            //set the values of the parameters
            prestmpt.setString(1,st.getStudentName());
            prestmpt.setString(2, st.getStudentPhone());
            prestmpt.setString(3,st.getStudentCity());
            //executing query
            prestmpt.executeUpdate();
            flag = true;



        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
