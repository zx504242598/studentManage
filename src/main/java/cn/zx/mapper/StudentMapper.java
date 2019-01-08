package cn.zx.mapper;

import cn.zx.pojo.Student;

public interface StudentMapper {
    public void add(Student student);

    public void remove(int sno);

    public void update(Student student);

    public Student find(int sno);
}
