import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

import javax.sound.midi.SysexMessage;

import cn.zx.mapper.CourseMapper;
import cn.zx.mapper.StuCourseMapper;
import cn.zx.mapper.StudentMapper;
import cn.zx.mapper.UserMapper;
import cn.zx.pojo.Category;
import cn.zx.pojo.Course;
import cn.zx.pojo.StuCourse;
import cn.zx.pojo.Student;
import cn.zx.pojo.User;
import cn.zx.service.StuCourseService;
import cn.zx.service.StudentService;

/**
 * @program: ssm
 * @description:
 * @author: liust
 * @create: 2018-09-27 15:11
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class test {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StuCourseMapper stuCourseMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private StudentService studentService;
    @Autowired
    private StuCourseService stuCourseService;
    @Test
    public void addStuCourse(){

        List<Map<String,Integer>> list=stuCourseMapper.avg();
        for (Map<String,Integer> map:list) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            }
            System.out.println("");
        }
    }




}
