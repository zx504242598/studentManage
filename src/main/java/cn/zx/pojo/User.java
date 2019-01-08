package cn.zx.pojo;

/**
 * @program: ssm
 * @description:
 * @author: liust
 * @create: 2018-10-12 15:00
 **/
public class User {
    public enum Role {
        ZERO, ONE, TWO
    }

    private String username;
    private String pwd;
    private Role role;
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" + "username='" + username + '\'' + ", pwd='" + pwd + '\'' + ", role=" + role + ", student=" + student + '}';
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
