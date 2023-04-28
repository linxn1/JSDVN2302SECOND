package homework;

import java.io.Console;
public class HomeworkDemo {

    public static void main(String[] args) {
//        String a = "11";
////        int s1 = toInt(a);//报错
////        int s3 = parse(a);//报错
//
//        Integer s2 = valueOf(a);// 报错
//        System.out.println(s2);
//    }
//        int[] a = {11, 22, 33};
//        System.out.println(Arrays.toString(a));
//
//        long time1 = System.currentTimeMillis();
//        System.out.println(time1);//获取从1970到现在的时间 单位为毫秒
        Console console = System.console();
        if (console == null) {
            System.err.println("控制台不可用");
            System.exit(1);
        }

        System.out.print("请输入您的名字：");
        String name = console.readLine();
        char[] password = console.readPassword("请输入您的密码：");

        System.out.println("您输入的名字是：" + name);
        System.out.println("您输入的密码是：" + new String(password));
    }
}

