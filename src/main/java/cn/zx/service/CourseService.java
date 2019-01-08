package cn.zx.service;

import java.util.List;

import cn.zx.pojo.Course;

public interface CourseService {
    public void add(Course course);
    public void remove(int cno);
    public void update(Course course);
    public List<Course> all();
}
