package StudentManage;

public class Student {
    private String stu_id;
    private String stu_name;
    private String stu_age;
    private String stu_addr;

    public Student(){}

    public Student(String stu_id, String stu_name, String stu_age, String stu_addr) {
        this.stu_id = stu_id;
        this.stu_name = stu_name;
        this.stu_age = stu_age;
        this.stu_addr = stu_addr;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_age() {
        return stu_age;
    }

    public void setStu_age(String stu_age) {
        this.stu_age = stu_age;
    }

    public String getStu_addr() {
        return stu_addr;
    }

    public void setStu_addr(String stu_addr) {
        this.stu_addr = stu_addr;
    }
}
