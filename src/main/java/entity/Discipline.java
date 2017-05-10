package entity;

/**
 * Created by Валера on 10.03.2017.
 */
public class Discipline {

    private  String disciplinename;

    private int id1;

    @Override
    public String toString() {
        return "Discipline{" +
                "disciplinename='" + disciplinename + '\'' +
                ", id1=" + id1 +
                '}';
    }

    public String getDisciplinename() {
        return disciplinename;
    }

    public void setDisciplinename(String disciplinename) {
        this.disciplinename = disciplinename;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

}