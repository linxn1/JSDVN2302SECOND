package cn.tedu.thread;

/**
 * 使用匿名内部类简化两种线程的创建方式
 */
public class ThreadDemo03 {
    public static void main(String[] args) {
        //简化直接继承Thread重写run方法的创建方式
        Thread r1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("我是毛利小五郎！");
                }
            }
        };
        Thread t1 = new Thread(r1);
        //简化实现Runnable重写run方法的创建方式
        Runnable r2 = new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("我是齐天大圣！！！！");
                }
            }
        };
        Thread t2 = new Thread(r2);
        //通过lambda表达式简化实现Runnable重写run方法的创建方式
        Thread r3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("我是二郎神！！！");
            }
        });
        Thread t3 = new Thread(r3);
        t1.start();
        t2.start();
        t3.start();
    }
}
