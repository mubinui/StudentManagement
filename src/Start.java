import com.student.management.Student;
import com.student.management.StudentDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
    public static void main(String[] args) throws IOException {
        System.out.println("🎈🎈 Welcome to Student Management App 🎈🎈");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            System.out.println("=> PRESS 1 to ADD student");
            System.out.println("=> PRESS 2 to DELETE student");
            System.out.println("=> PRESS 3 to DISPLAY student");
            System.out.println("=> PRESS 4 to EXIT the app");
            int c = Integer.parseInt(br.readLine());
            if (c == 1){
                //add student..
                System.out.println("Enter User Name ");
                String name = br.readLine();
                System.out.println("Enter User Phone ");
                String phone = br.readLine();
                System.out.println("Enter User City ");
                String city = br.readLine();
                //create student object to store student
                Student st = new Student(name,phone,city);
                boolean result = StudentDao.insertStudentToDB(st);
                if(result){
                    System.out.println(" => Student is successfully added ");
                }
                else {
                    System.out.println("=>Something went wrong ");
                }
                System.out.println(st);


            }
            else if (c == 2){
                //delete student..
                System.out.println("=> Enter student id to delete");
                int userId= Integer.parseInt(br.readLine());
                boolean flag = StudentDao.deleteStudent(userId);
                if(flag){
                    System.out.println("=> Deleted Successfully");
                }
                else{
                    System.out.println("=> Id not found ");
                }

            }
            else if (c == 3){
                //display student..
                StudentDao.allStuedents();

            }
            else if (c == 4){
                //Exit
                break;
            }
            else{

            }
        }
        System.out.println(" =>Thank for using my application ! ");
        System.out.println(" =>See you soon !");
    }
}
