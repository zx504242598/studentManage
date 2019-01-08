package cn.zx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
 * @create: 2018-10-21 19:51
 **/
@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    StuCourseService stuCourseService;
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        User user=(User) session.getAttribute("user");
        String sname=request.getParameter("sname");
        String age=request.getParameter("age");
        String dept=request.getParameter("dept");
        Student student=new Student();
        student.setSno(user.getStudent().getSno());student.setSname(sname);student.setAge(Integer.parseInt(age));student.setDept(dept);
        studentService.update(student);

        user.setStudent(student);
        session.setAttribute("user",user);
        System.out.println(student.toString());
        return new ModelAndView("redirect:/jsp/studentInfo.jsp");
    }

}
