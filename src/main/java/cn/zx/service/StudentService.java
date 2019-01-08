package cn.zx.service;

import cn.zx.pojo.Student;

public interface StudentService {
    public void add(Student student);
    public void remove(int sno);
    public void update(Student student);
    public Student find(int sno);
}
