package cn.zx.pojo;

/**
 * @program: ssm
 * @description:
 * @author: liust
 * @create: 2018-10-13 14:59
 **/
public class Student {
    private int sno;
    private String sname;
    private int age;
    private String  dept;

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Student{" + "sno=" + sno + ", sname='" + sname + '\'' + ", age=" + age + ", dept='" + dept + '\'' + '}';
    }
}
