package controler;

import com.sun.org.apache.bcel.internal.generic.Select;
import entity.Discipline;
import entity.Student;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Валера on 17.03.2017.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        try{
            ResultSet rs;//набор данных


            PreparedStatement zapros1;  // созданые обьекта запрос
            PreparedStatement zapros2;
            PreparedStatement zapros3;
            PreparedStatement zapros4;




            Class.forName("com.mysql.jdbc.Driver");//схема
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/st?user=root&password=root&characterEncoding=UTF-8");

            zapros1 = conn.prepareCall("SELECT * FROM student;");//вызиваем метод у конекшена
            zapros2 = conn.prepareCall("SELECT * FROM student WHERE id=?;");
            zapros3 = conn.prepareCall("SELECT * FROM discipline");
            zapros4 = conn.prepareCall("SELECT * FROM student;");


            List<Student> students = new LinkedList<>();
            rs = null;//нужно всегда обнулять
            rs = zapros1.executeQuery();
            while (rs.next()){
                Student st = new Student();
                st.setName(rs.getString("name"));
                st.setSurname(rs.getString("surname"));
                st.setDate(rs.getDate("date"));
                st.setId(rs.getInt("id"));
                st.setGroup(rs.getString("group"));
                students.add(st);
            }
            //zapros1.executeUpdate("UPDATE `st`.`student` SET `name`='Влад', `surname`='Павленко', `group`='Т-89' WHERE `id`='6';\n");






            for (Student s:students){
                System.out.println(s.toString());
            }

            System.out.println("-----------------------------");

            Student st2 = new Student();
            rs = null;//нужно всегда обнулять
            zapros2.setInt(1, 6);//1 - знак вопроса ...  2 - ид студента
            rs = zapros2.executeQuery();
            if (rs.next()){

                st2.setName(rs.getString("name"));
                st2.setSurname(rs.getString("surname"));
                st2.setDate(rs.getDate("date"));
                st2.setId(rs.getInt("id"));
                st2.setGroup(rs.getString("group"));
            }
                System.out.println(st2.toString());
            System.out.println("--------------------");

            List<Discipline> disciplines = new LinkedList<>();
            rs=null;
            rs = zapros3.executeQuery();
            while (rs.next()){
                Discipline dis = new Discipline();
                dis.setId1(rs.getInt("id"));
                dis.setDisciplinename(rs.getString("disciplinename"));
                disciplines.add(dis);
            }
            for (Discipline d:disciplines){
                System.out.println(d.toString());
            }

        }catch (Exception e) {e.printStackTrace();}
    }
}
