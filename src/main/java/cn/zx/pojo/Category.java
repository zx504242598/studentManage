package cn.zx.pojo;

/**
 * @program: ssm
 * @description:
 * @author: liust
 * @create: 2018-09-26 21:28
 **/
public class Category {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
