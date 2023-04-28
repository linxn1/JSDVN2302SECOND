package cn.tedu.thread;

import java.util.Scanner;

/**
 * Thread中提供了一个静态的sleep方法
 * 当线程调用sleep方法后，会进入阻塞状态指定的毫秒，超过这个时间后，会自动进入到就绪状态，当cpu分配时间片后，会继续执行
 */
public class SleepDemo01 {
    public static void main(String[] args) {
        System.out.println("程序开始了！");
        //1秒=1000毫秒 让线程进入睡眠阻塞5秒
        /**
         * 用sleep写一个倒计时程序
         */

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入要倒计时的时间：");
            int time = scanner.nextInt();
            //变量.forr 生成逆向for循环
            for (int i = time; i > 0; i--) {
                System.out.println(i);
                //每循环一次，睡眠阻塞1秒
                Thread.sleep(1000);
            }
            System.out.println("时间到！！！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("程序结束了！");
    }
}
