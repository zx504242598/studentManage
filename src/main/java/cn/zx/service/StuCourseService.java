package cn.zx.service;

import java.util.List;
import java.util.Map;

import cn.zx.pojo.Course;
import cn.zx.pojo.StuCourse;

public interface StuCourseService {
    public void add(int sno, int cno);

    public void remove(int sno, int cno);

    public void reviseGrade(int sno, int cno, double grade);

    public List<StuCourse> list(int sno);

    public List<Course> snoFindNotCourse(int sno);

    public List<StuCourse> snoFindGrade(int sno);

    public List<Map<String,Integer>> avg();
}
