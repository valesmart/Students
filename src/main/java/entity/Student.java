package entity;


import java.util.Date;

/**
 * Created by Валера on 07.03.2017.
 */
public class Student {

    private int id;
    private String name;
    private String surname;
    private Date date;
    private String group;

    public Student(){}

    public Student(int id, String name, String surname, Date date, String group) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.group = group;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", group='" + group + '\'' +
                ", date=" + date +
                ", id=" + id +
                '}';
    }
}