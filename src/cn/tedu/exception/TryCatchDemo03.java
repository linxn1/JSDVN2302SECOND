package cn.tedu.exception;

/**
 * 捕获多个异常，可以合并捕获
 */
public class TryCatchDemo03 {
    public static void main(String[] args) {
        try {
            //1.将可能发生异常的代码放在try中
            String str = "";
            //在java中，null表示什么都没有，不能调用方法，所以虚拟机会调用空指针异常
            System.out.println(str.length());
            System.out.println(str.charAt(0));
            //try中代码一旦发生异常，异常之后的代码不会被执行

            //合并捕获
        } catch (NullPointerException | StringIndexOutOfBoundsException e) {//2.通过catch关键字捕获try中代码出现的异常类型
            //3.如果try中出现空指针异常，会捕获，并执行catch中的内容
            System.out.println("出现了空指针或字符串下标越界异常！！！");
            //4.将捕获的异常打印出来，一般是给程序员观看解决问题
            e.printStackTrace();
        }
        System.out.println("程序结束了！");
    }
}
