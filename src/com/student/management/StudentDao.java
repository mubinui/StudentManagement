package com.student.management;

import java.sql.*;


public class StudentDao {
    public static boolean insertStudentToDB(Student st){
        boolean flag = false;
        try{
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

    public static boolean deleteStudent(int userId) {
        boolean flag = false;
        try{
            Connection connection = Connector.createC();
            String query = "DELETE FROM students where sid = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            statement.executeUpdate();
            flag = true;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static void allStuedents() {

        try {
            Connection con = Connector.createC();
            //Connector is a class name ;
            String query = "SELECT * FROM students";
            Statement statement = con.createStatement();
            //for bringing data from database -> ResultSet -> statement.executeQuery (q);
            ResultSet resultSet = statement.executeQuery(query);
            System.err.println("Id  || "+"Name        ||  "+"Phone  || "+"City");
            //Printing the resultSet
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String phone = resultSet.getString(3);
                String city = resultSet.getString(4);
                System.out.println(id+" || "+name+" || "+phone+" || "+city);

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
