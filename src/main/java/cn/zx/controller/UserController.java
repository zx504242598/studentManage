package cn.zx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.zx.pojo.Course;
import cn.zx.pojo.StuCourse;
import cn.zx.pojo.Student;
import cn.zx.pojo.User;
import cn.zx.service.StuCourseService;
import cn.zx.service.StudentService;
import cn.zx.service.UserService;

/**
 * @program: ssm
 * @description:
 * @author: liust
 * @create: 2018-10-16 19:41
 **/
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    StudentService studentService;
    @Autowired
    StuCourseService stuCourseService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+password);
        User user = userService.find(username);
        PrintWriter writer = response.getWriter();
        if (user != null && user.getPwd().equals(password)) {
            session.setAttribute("user",user);
            List<StuCourse> stuCourses=stuCourseService.list(user.getStudent().getSno());
            List<Course> notCourses=stuCourseService.snoFindNotCourse(user.getStudent().getSno());
            List<Map<String, Integer>> avgs=stuCourseService.avg();
            session.setAttribute("stuCourses",stuCourses);
            session.setAttribute("avgs",avgs);
            for (StuCourse stuCourse:stuCourses){
                System.out.println(stuCourse.getCourse().toString());
            }
            session.setAttribute("notCourses",notCourses);
            System.out.println(user.toString());

            writer.print(true);
        } else writer.print(false);
        writer.close();
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView=new ModelAndView();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role=request.getParameter("role");
        String sno=request.getParameter("sno");

        if (userService.find(username)!=null){
            return modelAndView;
        }
        User user=new User();
        user.setUsername(username);
        user.setPwd(password);
        if (sno.length()>0){
            Student student=studentService.find(Integer.parseInt(sno));
            user.setStudent(student);
        }

        if (role.equals("ZERO")){
            user.setRole(User.Role.ZERO);
        }else if (role.equals("ONE")){
            user.setRole(User.Role.ONE);
        }else user.setRole(User.Role.TWO);
        userService.add(user);
        System.out.println("注册成功");
        modelAndView.setViewName("/login");
        return modelAndView;
    }
    @RequestMapping(value = "/checkUser",method = RequestMethod.GET)
    public void checkUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        PrintWriter writer = response.getWriter();
        if (userService.find(username)!=null){
            writer.print(false);
        }
        writer.close();
    }
    @RequestMapping(value = "/checkSno",method = RequestMethod.GET)
    public void checkSno(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String sno = request.getParameter("sno");
        if (sno.length()<0){
            return;
        }
        PrintWriter writer = response.getWriter();
        if (studentService.find(Integer.parseInt(sno))!=null){
            writer.print(true);
        }
        writer.close();
    }
    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "/login";
    }
}
