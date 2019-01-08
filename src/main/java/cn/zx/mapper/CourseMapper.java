package cn.zx.mapper;

import java.util.List;

import cn.zx.pojo.Course;

public interface CourseMapper {
    public void add(Course course);

    public void remove(int cno);

    public void update(Course course);

    public List<Course> all();

}
