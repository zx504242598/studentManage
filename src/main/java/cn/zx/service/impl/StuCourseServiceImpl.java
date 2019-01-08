package cn.zx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.zx.mapper.StuCourseMapper;
import cn.zx.pojo.Course;
import cn.zx.pojo.StuCourse;
import cn.zx.service.StuCourseService;

/**
 * @program: ssm
 * @description:
 * @author: liust
 * @create: 2018-10-14 14:29
 **/
@Service
public class StuCourseServiceImpl implements StuCourseService {
    @Autowired
    private StuCourseMapper stuCourseMapper;

    public void add(int sno, int cno) {
        stuCourseMapper.add(sno, cno);
    }

    public void remove(int sno, int cno) {
        stuCourseMapper.remove(sno, cno);
    }

    public void reviseGrade(int sno, int cno, double grade) {
        stuCourseMapper.reviseGrade(sno, cno, grade);
    }

    public List<StuCourse> list(int sno) {
        return stuCourseMapper.list(sno);
    }

    public List<Course> snoFindNotCourse(int sno) {
        return stuCourseMapper.snoFindNotCourse(sno);
    }

    public List<StuCourse> snoFindGrade(int sno) {
        return stuCourseMapper.snoFindGrade(sno);
    }

    public List<Map<String, Integer>> avg() {
        return stuCourseMapper.avg();
    }
}
