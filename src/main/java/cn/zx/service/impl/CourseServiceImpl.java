package cn.zx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import cn.zx.mapper.CourseMapper;
import cn.zx.pojo.Course;
import cn.zx.service.CourseService;

/**
 * @program: ssm
 * @description:
 * @author: liust
 * @create: 2018-10-14 14:27
 **/
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    public void add(Course course) {
        courseMapper.add(course);
    }

    public void remove(int cno) {
        courseMapper.remove(cno);
    }

    public void update(Course course) {
        courseMapper.update(course);
    }

    public List<Course> all() {
        return courseMapper.all();
    }
}
