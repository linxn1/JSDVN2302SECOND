package cn.tedu.thread;

/**
 * 多线程并发安全问题
 * 当多个线程并发同一临界资源时，由于线程的切换存在不可确定性,就会导致线程的切换顺序出现混乱，而产生各种的逻辑错误
 * 临界资源就是指操作资源的完整过程应该同一时刻只能由单线程执行
 */
public class SyncDemo01 {
    public static void main(String[] args) {
        Table table = new Table();
        Thread t1 = new Thread("白露") {
            @Override
            public void run() {
                while (true) {
                    int beans = table.getBeans();
                    System.out.println(getName() + "出手抢一颗豆子，此时豆子数量为：" + (beans - 1));
                }
            }
        };
        Thread t2 = new Thread("青雀") {
            @Override
            public void run() {
                while (true) {
                    int beans = table.getBeans();
                    System.out.println(getName() + "出手抢一颗豆子，此时豆子数量为：" + (beans - 1));
                }
            }
        };
        t1.start();
        t2.start();
    }
}

class Table {
    private int beans = 20;//桌子上有20颗豆子

    /**
     * 当一个方法使用关键字synchronized时，该方法称为“同步方法”
     * 同步方法：指多个线程调用该方法有先后顺序
     * 多线程的并发安全问题通过让线程排队执行，可以有效解决该问题
     */
    public synchronized int getBeans() {
        if (beans == 0) {
            throw new RuntimeException("桌子上已经没有豆子了！！！");
        }
        //礼让线程，主动让出cpu分配的时间片
        Thread.yield();
        return beans--;
    }
}
