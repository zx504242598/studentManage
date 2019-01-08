package cn.zx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.zx.pojo.Course;
import cn.zx.pojo.StuCourse;
import cn.zx.service.StuCourseService;

/**
 * @program: ssm
 * @description:
 * @author: liust
 * @create: 2018-10-22 20:31
 **/
@Controller
public class CourseController {
    @Autowired
    StuCourseService stuCourseService;

    @RequestMapping("/addCourse")
    public String addCourse(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        int sno = Integer.parseInt(request.getParameter("sno"));
        int cno = Integer.parseInt(request.getParameter("cno"));
        stuCourseService.add(sno, cno);
        List<StuCourse> stuCourses = stuCourseService.list(sno);
        List<Course> notCourses = stuCourseService.snoFindNotCourse(sno);
        session.setAttribute("stuCourses", stuCourses);
        session.setAttribute("notCourses", notCourses);
        System.out.println("选课:" + sno + " " + cno);
        return "redirect:/jsp/studentInfo.jsp";
    }
    @RequestMapping("/removeCourse")
    public String removeCourse(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        int sno = Integer.parseInt(request.getParameter("sno"));
        int cno = Integer.parseInt(request.getParameter("cno"));
        stuCourseService.remove(sno,cno);
        List<StuCourse> stuCourses = stuCourseService.list(sno);
        List<Course> notCourses = stuCourseService.snoFindNotCourse(sno);
        session.setAttribute("stuCourses", stuCourses);
        session.setAttribute("notCourses", notCourses);
        System.out.println("退选:" + sno + " " + cno);
        return "redirect:/jsp/studentInfo.jsp";
    }

}
