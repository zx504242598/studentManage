package cn.zx.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import cn.zx.pojo.Course;
import cn.zx.pojo.StuCourse;


public interface StuCourseMapper {
    public void add(@Param("sno") int sno, @Param("cno") int cno);

    public void remove(@Param("sno") int sno, @Param("cno") int cno);

    public void reviseGrade(@Param("sno") int sno, @Param("cno") int cno, @Param("grade") double grade);

    public List<StuCourse> list(int sno);

    public List<Course> snoFindNotCourse(int sno);

    public List<StuCourse> snoFindGrade(int sno);

    public List<Map<String,Integer>> avg();
}
