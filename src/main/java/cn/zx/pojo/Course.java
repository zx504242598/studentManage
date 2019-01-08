package cn.zx.pojo;

/**
 * @program: ssm
 * @description:
 * @author: liust
 * @create: 2018-10-13 15:00
 **/
public class Course {
    private int cno;
    private String cname;
    private String teacher;
    private int credit;

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Course{" + "cno=" + cno + ", cname='" + cname + '\'' + ", teacher='" + teacher + '\'' + ", credit=" + credit + '}';
    }
}
