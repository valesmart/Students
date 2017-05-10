package database;

import constants.Constants;
import entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Валера on 21.03.2017.
 */
public class DataService {

    private static List<DBConnection> conPool = new ArrayList<DBConnection>();

    public synchronized DBConnection getDBConnection() {
        if (conPool.isEmpty()) {
            newConnection();
        }
        DBConnection conn = conPool.remove(0);//отдает конектион и сразу же удаляет
        return conn;
    }

    public synchronized void putDBConnection(DBConnection conn) {
        conPool.add(conn);//сразу возвращает в пул подключение
    }

    private synchronized void newConnection() {
        DBConnection conn = new DBConnection(Constants.CONNECTING_URL);
        conPool.add(conn);
    }

    public List<Student> getAllStudents() {
        DBConnection conn = getDBConnection();//new DBConnection .. берет из метода DBConnection
        List<Student> result = conn.getAllStudent();//
        this.putDBConnection(conn);//
        return result;//
    }

    public Student getAllStudentsId(int id) {
        DBConnection conn = getDBConnection();
        Student result = conn.getAllStudentId(id);
        this.putDBConnection(conn);
        return result;
    }

    public List<Discipline> getAllDisciplines() {
        DBConnection conn = getDBConnection();
        List<Discipline> result = conn.getAllDisciplines();
        this.putDBConnection(conn);
        return result;
    }

    public Discipline getDisciplineId(int id2) {
        DBConnection conn = getDBConnection();
        Discipline result = conn.getDisciplineId(id2);
        this.putDBConnection(conn);
        return result;
    }

    public boolean createStudent(Student student) {
        DBConnection conn = getDBConnection();
        boolean b = conn.createStudent(student);
        this.putDBConnection(conn);
        return b;
    }

    public boolean createDiscipline(Discipline discipline) {
        DBConnection conn = getDBConnection();
        boolean b = conn.createDiscipline(discipline);
        this.putDBConnection(conn);
        return b;
    }

    public boolean modifyDiscipline(Discipline discipline) {
        DBConnection conn = getDBConnection();
        boolean b = conn.modifyDiscipline(discipline);
        this.putDBConnection(conn);
        return b;
    }

    public boolean modifyStudent(Student student) {
        DBConnection conn = getDBConnection();
        boolean b = conn.modifyStudent(student);
        this.putDBConnection(conn);
        return b;
    }

    public List<Role> getRoles() {
        DBConnection conn = getDBConnection();
        List<Role> rezult = conn.getRoles();
        this.putDBConnection(conn);
        return rezult;
    }

    public boolean disciplineDelete(int id) {
        DBConnection conn = getDBConnection();
        boolean result = conn.disciplineDelete(id);
        this.putDBConnection(conn);
        return result;
    }

    public boolean studentDelete(int id) {
        DBConnection conn = getDBConnection();
        boolean result = conn.studentDelete(id);
        this.putDBConnection(conn);
        return result;
    }

    public Account getAccountByLogin(String login) {
        DBConnection conn = getDBConnection();
        Account result = conn.getAccountByLogin(login);
        this.putDBConnection(conn);
        return result;


    }

    public Role getRoleById(int role) {
        DBConnection conn = getDBConnection();
        Role result = conn.getRoleById(role);
        this.putDBConnection(conn);
        return result;
    }

    public List<Term> getAllTerms() {
        DBConnection conn = getDBConnection();
        List<Term> result = conn.getAllTerms();
        this.putDBConnection(conn);
        return result;
    }

    public Term getTermById(int idTerm) {
        DBConnection conn = getDBConnection();
        Term result = conn.getTermById(idTerm);
        this.putDBConnection(conn);
        return result;
    }

    public List<Discipline> getDisciplinesByTerm(int idTerm) {
        DBConnection conn = getDBConnection();
        List<Discipline> result = conn.getDisciplinesByTerm(idTerm);
        this.putDBConnection(conn);
        return result;
    }

    public int createTerm(Term term) {
        DBConnection conn = getDBConnection();
        int result = conn.createTerm(term);
        this.putDBConnection(conn);
        return result;
    }

    public boolean createDisByTerm(int idTerm, int idDiscipline) {
        DBConnection conn = getDBConnection();
        boolean b = conn.createDisByTerm(idTerm, idDiscipline);
        this.putDBConnection(conn);
        return b;
    }

    public int modifyTerm(Term term) {
        DBConnection conn = getDBConnection();
        int result = conn.modifyTerm(term);
        this.putDBConnection(conn);
        return result;
    }


    public boolean deleteTermById(int idTerm) {
        DBConnection conn = getDBConnection();
        boolean result = conn.deleteTermById(idTerm);
        this.putDBConnection(conn);
        return result;
    }

    public boolean createModTerm(Term term) {
        DBConnection conn = getDBConnection();
        boolean result = conn.createModTerm(term);
        this.putDBConnection(conn);
        return result;
    }
}
