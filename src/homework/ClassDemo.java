package homework;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class ClassDemo {
    Scanner scanner = new Scanner(System.in);
    Student[] students = new Student[0];//初始长度设为0

    public ClassDemo() {//利用构造方法执行
        System.out.println("欢迎使用本系统：");
        getMenu();
    }

    public static void main(String[] args) {
        new ClassDemo();

    }

    public void getMenu() {
        System.out.println("请选择功能：");
        System.out.println("1.查询学生功能，2.新增学生信息，3.删除学生信息");
        int choose = scanner.nextInt();
        if (choose == 1) {
            select();
        } else if (choose == 2) {
            add();
        } else if (choose == 3) {
            delete();
        } else {
            System.out.println("程序推出，感谢使用");
            return;
        }
    }

    public void add() {
//        System.out.println("添加");
        System.out.println("请输入学生姓名：");
        String username = scanner.next();
        System.out.println("请输入学生年龄：");
        int age = scanner.nextInt();
        Student student = new Student(username, age);
        students = Arrays.copyOf(students, students.length + 1);
        students[students.length - 1] = student;
        System.out.println(Arrays.toString(students));

        System.out.println("添加成功，返回菜单");
        getMenu();
    }

    public void delete() {
        System.out.println("删除");
        System.out.println("请输入学生姓名");
        String username = scanner.next();
        for (int i = 0; i < students.length; i++) {
            if (students[i].getUsername().equals(username)) {
                students[i] = students[students.length - 1];//将最后一个元素移到当前位置
                students = Arrays.copyOf(this.students, students.length - 1);
                System.out.println("删除成功，返回菜单");
            } else {
                System.out.println("不存在该学生的信息！");
            }
        }
        getMenu();
    }

    public void select() {
//        System.out.println("查询");
        System.out.println(Arrays.toString(students));
        System.out.println("查询成功，返回菜单");
        getMenu();
    }
}

//@Data 可以使用这个方法自动生成
class Student {
    private String username;
    private Integer age;

    public Student(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return username.equals(student.username) && age.equals(student.age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, age);
    }
}
