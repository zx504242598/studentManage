package cn.zx.pojo;

/**
 * @program: ssm
 * @description:
 * @author: liust
 * @create: 2018-10-13 15:04
 **/
public class StuCourse {
    private Student student;
    private Course course;
    private double grade;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StuCourse{" + "student=" + student.toString() + ", course=" + course.toString() + ", grade=" + grade + '}';
    }
}
