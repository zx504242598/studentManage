package cn.zx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.mapper.StudentMapper;
import cn.zx.pojo.Student;
import cn.zx.service.StudentService;

/**
 * @program: ssm
 * @description:
 * @author: liust
 * @create: 2018-10-14 14:24
 **/
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public void add(Student student) {
        studentMapper.add(student);
    }

    public void remove(int sno) {
        studentMapper.remove(sno);
    }

    public void update(Student student) {
        studentMapper.update(student);
    }

    public Student find(int sno) {
        return studentMapper.find(sno);
    }
}
