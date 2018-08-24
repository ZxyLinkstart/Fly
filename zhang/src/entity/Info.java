package entity;

public class Info {

    private String id;
    private String name;
    private String sex;
    private String grade;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setGrade(String grade) { this.grade = grade; }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }
    public String getGrade() { return grade; }
}
