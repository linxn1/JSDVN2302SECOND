package cn.tedu.reflect.pojo;

import cn.tedu.reflect.annotation.AutoRunClass;
import cn.tedu.reflect.annotation.AutoRunMethod;

@AutoRunClass
public class Person {
    private String name = "张三";
    private int age = 18;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    @AutoRunMethod
    public void eat() {
        System.out.println(name + ": 在吃饭！");
    }

    public void say() {
        System.out.println(name + ": 在说话！");
    }

    @AutoRunMethod
    public void sleep() {
        System.out.println(name + ": 在睡觉！");
    }

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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
