package cn.tedu.exception;

public class ExceptionDemo {
    public static void main(String[] args) {
        int a = 1;
        //1.编译期异常 必须立即解决，否则程序不能执行
        //a = "hello";

        //2.运行时异常 编译器不会报错，程序是可以运行的，但是程序会在控制台打印异常信息
        //a = 1 / 0;
    }
}
