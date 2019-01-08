/**
 * @program: ssm
 * @description:
 * @author: liust
 * @create: 2018-11-21 12:38
 **/
public class Hero {
    private String name;
    private float hp;
    private int damage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    static String copyright;

    @Override
    public String toString() {
        return "Hero{" + "name='" + name + '\'' + ", hp=" + hp + ", damage=" + damage + ", id=" + id + '}';
    }

    static {
        System.out.println("初始化 copyright");
        copyright = "版权由Riot Games公司所有";
    }
}
