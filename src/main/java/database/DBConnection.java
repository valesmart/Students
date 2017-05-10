package database;

import entity.*;

import java.sql.*;
import java.time.Period;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Валера on 21.03.2017.
 */
public class DBConnection {

    private Connection conn = null;

    private ResultSet rs = null;

    private static PreparedStatement loadAllStudents;
    private static PreparedStatement studentId;
    private static PreparedStatement loadAllDisciplines;
    private static PreparedStatement disciplineId;
    private static PreparedStatement createStudent;
    private static PreparedStatement createDiscipline;
    private static PreparedStatement modifyDiscipline;
    private static PreparedStatement modifyStudent;
    private static PreparedStatement loadRoles;
    private static PreparedStatement disciplineDelete;
    private static PreparedStatement studentDelete;
    private static PreparedStatement loadAccountByLogin;
    private static PreparedStatement loadRoleById;
    private static PreparedStatement createTerm;
    private static PreparedStatement loadAllTerms;
    private static PreparedStatement termId;
    private static PreparedStatement loadDisciplinesByTerm;
    private static PreparedStatement createDisByTerm;
    private static PreparedStatement modyfyTerm;
    private static PreparedStatement createModTerm;
    private static PreparedStatement deleteTermById;

    public DBConnection(String url) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);// подключение драйвера
            loadPreparedStatements();//регистрация драйвера
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadPreparedStatements() {
        try {
            deleteTermById = conn.prepareStatement("DELETE FROM term WHERE id=?;");
            createModTerm = conn.prepareStatement("INSERT INTO term (id, duration) VALUES (?, ?);");
            modyfyTerm = conn.prepareStatement("UPDATE term SET duration=? WHERE id=?;");
            createDisByTerm = conn.prepareStatement("INSERT INTO term_discipline (id_term, id_discipline) VALUES (?, ?);");
            loadDisciplinesByTerm = conn.prepareStatement("SELECT * FROM term as t left join term_discipline as td on t.id=td.id_term left join discipline as d on td.id_discipline=d.id where id_term=?");
            termId = conn.prepareStatement("SELECT * FROM term WHERE id=?;");
            loadAllTerms = conn.prepareStatement("SELECT * FROM term");
            createTerm = conn.prepareStatement("INSERT INTO term (duration) VALUES (?);");
            loadRoleById = conn.prepareStatement("SELECT * FROM roles WHERE id=?");
            loadAccountByLogin = conn.prepareStatement("SELECT * FROM accounts LEFT JOIN accounts_roles ON accounts.id = accounts_roles.id_account LEFT JOIN roles ON accounts_roles.id_role=roles.id WHERE login = ?");
            studentDelete = conn.prepareStatement("DELETE FROM student WHERE id=?;");
            disciplineDelete = conn.prepareStatement("DELETE FROM discipline WHERE id=?;");
            loadRoles = conn.prepareStatement("SELECT * FROM roles");
            modifyStudent = conn.prepareStatement("UPDATE student SET `name`=?, `surname`=?, `date`=?, `group`=? WHERE `id`=?");
            modifyDiscipline = conn.prepareStatement("UPDATE discipline SET disciplinename=? WHERE id=?");
            createDiscipline = conn.prepareStatement("INSERT INTO discipline (disciplinename) VALUES (?);\n");
            createStudent = conn.prepareStatement("INSERT INTO student (`name`, `surname`, `date`, `group`) VALUES (?, ?, ?, ?)");
            loadAllStudents = conn.prepareStatement("SELECT * FROM student");
            studentId = conn.prepareCall("SELECT * FROM student WHERE id=?;");
            loadAllDisciplines = conn.prepareCall("SELECT * FROM discipline");
            disciplineId = conn.prepareCall("SELECT * FROM discipline WHERE id=?");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Student> getAllStudent() {
        rs = null;//нужно всегда обнулять
        List<Student> studentsArray = new LinkedList<Student>();// создаем лист студентов
        try {
            rs = loadAllStudents.executeQuery();
            while (rs.next()) {
                Student newStudent = new Student();
                newStudent.setId(rs.getInt("id"));
                newStudent.setName(rs.getString("name"));
                newStudent.setSurname(rs.getString("surname"));
                newStudent.setDate(rs.getDate("date"));
                newStudent.setGroup(rs.getString("group"));
                studentsArray.add(newStudent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentsArray;
    }

    public Student getAllStudentId(int id) {
        rs = null;
        Student student = new Student();
        try {
            studentId.setInt(1, id);
            rs = studentId.executeQuery();
            if (rs.next()) {//если один студент вайл не нужен применяем иф
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setDate(rs.getDate("date"));
                student.setId(rs.getInt("id"));
                student.setGroup(rs.getString("group"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }


    public List<Discipline> getAllDisciplines() {
        rs = null;
        List<Discipline> disciplines = new LinkedList<Discipline>();
        try {
            rs = loadAllDisciplines.executeQuery();
            while (rs.next()) {
                Discipline newDisciplines = new Discipline();
                newDisciplines.setId1(rs.getInt("id"));
                newDisciplines.setDisciplinename(rs.getString("disciplinename"));
                disciplines.add(newDisciplines);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disciplines;
    }


    public Discipline getDisciplineId(int id2) {
        rs = null;
        Discipline newDiscipline = new Discipline();
        try {
            disciplineId.setInt(1, id2);
            rs = disciplineId.executeQuery();
            if (rs.next()) {
                newDiscipline.setId1(rs.getInt("id"));
                newDiscipline.setDisciplinename(rs.getString("disciplinename"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newDiscipline;
    }


    public boolean createStudent(Student student) {
        //createStudent = conn.prepareStatement("INSERT INTO student (name, surname, date, group) VALUES (?, ?, ?, ?);\n");
        java.util.Date utilDate = student.getDate();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println(sqlDate);
        try {
            createStudent.setString(1, student.getName());
            createStudent.setString(2, student.getSurname());
            createStudent.setDate(3, sqlDate);
            createStudent.setString(4, student.getGroup());
            createStudent.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean createDiscipline(Discipline discipline) {
        try {
            createDiscipline.setString(1, discipline.getDisciplinename());
            createDiscipline.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modifyDiscipline(Discipline discipline) {
        //modifyDiscipline = conn.prepareStatement("UPDATE discipline SET disciplinename=? WHERE id=?");
        try {
            modifyDiscipline.setString(1, discipline.getDisciplinename());
            modifyDiscipline.setInt(2, discipline.getId1());
            modifyDiscipline.executeUpdate();
            modifyDiscipline.close();
            // System.out.println(discipline.toString());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean modifyStudent(Student student) {
        //modifyStudent = conn.prepareStatement("UPDATE students SET name=?, surname=?, date=?, groupe=? WHERE id=?");
        java.util.Date utilDate = student.getDate();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        try {

            modifyStudent.setString(1, student.getName());
            modifyStudent.setString(2, student.getSurname());
            modifyStudent.setDate(3, sqlDate);
            modifyStudent.setString(4, student.getGroup());
            modifyStudent.setInt(5, student.getId());
            modifyStudent.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Role> getRoles() {
        rs = null;
        List<Role> roles = new LinkedList<Role>();
        try {
            rs = loadRoles.executeQuery();
            while (rs.next()) {
                Role newRole = new Role();
                newRole.setId(rs.getInt("id"));
                newRole.setName(rs.getString("role"));
                roles.add(newRole);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    public boolean disciplineDelete(int id) {
        try {
            disciplineDelete.setInt(1, id);
            disciplineDelete.executeUpdate();
            // System.out.println(discipline.toString());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean studentDelete(int id) {
        try {
            studentDelete.setInt(1, id);
            studentDelete.executeUpdate();
            // System.out.println(discipline.toString());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Account getAccountByLogin(String login) {

        rs = null;

        Account account = new Account();

        try {
            loadAccountByLogin.setNString(1, login);
            rs = loadAccountByLogin.executeQuery();

            if (rs.next()){
                account.setId(rs.getInt("id"));
                account.setLogin(rs.getString("login"));
                account.setPassword(rs.getString("password"));
                account.setRoleList(getAllRoles(rs));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }

    public List<Role> getAllRoles(ResultSet rs) {

        List<Role> result = new LinkedList<Role>();
        try {

            do{
                Role r = new Role();
                r.setId(rs.getInt("id_role"));
                r.setName(rs.getString("role"));
                result.add(r);
            }while (rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public Role getRoleById(int id){
        rs = null;
        Role role = new Role();
        try {
            loadRoleById.setInt(1, id);
            rs = loadRoleById.executeQuery();
            while (rs.next()){
                role.setId(rs.getInt("id"));
                role.setName(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    public List<Term> getAllTerms() {
        rs = null;
        List<Term> terms = new LinkedList<Term>();
        try {
            rs = loadAllTerms.executeQuery();
            while (rs.next()) {
                Term newTerms = new Term();
                newTerms.setId(rs.getInt("id"));
                newTerms.setDuration(rs.getInt("duration"));
                terms.add(newTerms);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return terms;

    }

    public Term getTermById(int idTerm) {
        rs = null;
        Term newTerm = new Term();
        try {
            termId.setInt(1, idTerm);
            rs = termId.executeQuery();
            if (rs.next()) {
                newTerm.setDuration(rs.getInt("duration"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newTerm;
    }

    public List<Discipline> getDisciplinesByTerm(int idTerm) {
        rs = null;
        List<Discipline> disciplinesByTerm = new LinkedList<Discipline>();
        try {
            loadDisciplinesByTerm.setInt(1, idTerm);
            rs = loadDisciplinesByTerm.executeQuery();
            while (rs.next()) {
                Discipline newDisciplines = new Discipline();
                newDisciplines.setId1(rs.getInt("id_discipline"));
                newDisciplines.setDisciplinename(rs.getString("disciplinename"));
                disciplinesByTerm.add(newDisciplines);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return disciplinesByTerm;

    }


    public int createTerm(Term term) {
        long result = 0;
        try {
            createTerm.setInt(1, term.getDuration());
            createTerm.executeUpdate();
            result = ((com.mysql.jdbc.PreparedStatement) createTerm).getLastInsertID ();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return (int) result;
    }

    public boolean createDisByTerm(int idTerm, int idDiscipline) {
        //INSERT INTO term_discipline (id_term, id_discipline) VALUES (?, ?);

        try {
            createDisByTerm.setInt(1, idTerm);
            createDisByTerm.setInt(2, idDiscipline);
            createDisByTerm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int modifyTerm(Term term) {
        //UPDATE term SET duration=? WHERE id=?;
        int result = 0;
        try {
            modyfyTerm.setInt(1, term.getDuration());
            modyfyTerm.setInt(2, term.getId());
            modyfyTerm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return result;

    }



    public boolean deleteTermById(int idTerm) {
//        DELETE FROM term WHERE id=?;

        try {
            deleteTermById.setInt(1, idTerm);
            deleteTermById.executeUpdate();
            // System.out.println(discipline.toString());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean createModTerm(Term term) {
        //INSERT INTO term (id, duration) VALUES (?, ?);
        try {
            createModTerm.setInt(1, term.getId());
            createModTerm.setInt(2, term.getDuration());
            createModTerm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
