package cn.tedu.exception;

/**
 * finally是异常处理机制中的最后一块,可以直接跟在try语句块最后一个catch之后
 */
public class FinallyDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了！");
        try {
            String str = null;
            System.out.println(str.length());
        } catch (Exception e) {
            System.out.println("出现了一个错误");
        }finally{//一定会被执行
            System.out.println("必须要执行的内容");
        }
        System.out.println("程序结束了");
    }
}
