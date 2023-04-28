package cn.tedu.thread;

/**
 * sleep方法调用时，需要要处理中断异常
 * 当一个线程调用sleep方法处于睡眠阻塞状态的过程中，如果该线程的interrupt方法被调用时，
 * 会立即中断该睡眠阻塞，并抛出中断异常
 */
public class SleepDemo03 {
    public static void main(String[] args) {
        Thread lin = new Thread() {
            @Override
            public void run() {
                System.out.println("林：打扫完卫生，小憩一下~");
                try {
                    Thread.sleep(10000);
                    System.out.println("林：睡得真舒服啊~~");
                } catch (InterruptedException e) {
                    System.out.println("林：干嘛呢！干嘛呢！都破了相啦");
                }
            }
        };
        Thread huang = new Thread() {
            @Override
            public void run() {
                System.out.println("黄：大锤80！小锤40！");
                for (int i = 0; i < 5; i++) {
                    System.out.println("黄：80！！！");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("轰轰轰");
                System.out.println("黄：大哥！搞定！");
                //强制唤醒lin线程
                lin.interrupt();
            }
        };

        lin.start();
        huang.start();
    }
}
