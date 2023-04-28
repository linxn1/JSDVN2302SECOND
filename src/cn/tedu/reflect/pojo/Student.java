package cn.tedu.reflect.pojo;

public class Student {
    private String name = "李四";
    private int age = 18;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    public void eat() {
        System.out.println(name + ": 在吃饭！");
    }

    public void say() {
        System.out.println(name + ": 在说话！");
    }

    public void homework() {System.out.println(name + ": 在做作业！");}

    private void secret() {
        System.out.println(name + "的小秘密，不能被人知道");
    }

    public void doSome(String thing) {
        System.out.println(name + "正在做" + thing);
    }

    public void doSome(String thing, int num) {
        for (int i = 1; i <= num; i++) {
            System.out.println(name + "正在第" + i + "次做" + thing);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
