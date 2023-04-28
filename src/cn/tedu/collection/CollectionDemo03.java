package cn.tedu.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合间的操作
 */
public class CollectionDemo03 {
    public static void main(String[] args) {
//        Collection c = new ArrayList();
//        Point p = new Point(1, 2);
//        c.add(p);
//        System.out.println("p=" + p);//p=Point{x=1, y=2}
//        System.out.println("c=" + c);//c=[Point{x=1, y=2}]
//        p.setX(2);
//        System.out.println("p=" + p);//p=Point{x=2, y=2}
//        System.out.println("c=" + c);//c=[Point{x=2, y=2}]
        Collection c1 = new ArrayList();
        c1.add("大娃");
        c1.add("二娃");
        c1.add("三娃");
        System.out.println("c1 = " + c1);
        Collection c2 = new ArrayList();
        c2.add("四娃");
        c2.add("五娃");
        System.out.println("c2 = " + c2);
        /**
         * boolean addAll(Collection c)
         * 将给定集合中的所有元素都添加到当前集合中（取并集）
         * 操作后，如果当前集合发生了改变，则返回true,会有重复
         */
        c1.addAll(c2);
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);

        Collection c3 = new ArrayList();
        c3.add("二娃");
        c3.add("大娃");
        c3.add("七娃");
        System.out.println("c3 = " + c3);
        c3.forEach(System.out::println);//打印集合对象

        /**
         * boolean containsAll (collection c );
         * 判断当前集合中是否包含给定集合中的所有元素
         */
        boolean b = c1.containsAll(c3);
        System.out.println("c1集合是否包含c3集合:" + b);

        /**
         * boolean retainsAll (collection c );
         * 判断当前集合中的元素和给定集合中的元素相同的部分（取交集）
         */
        c1.retainAll(c3);
        System.out.println("c1 = " + c1);
        System.out.println("c3 = " + c3);

        /**
         * boolean removeAll(Collection c);
         * 删除集合中有交集的部分
         */
        c1.add("蛇精");
        c1.removeAll(c3);
        System.out.println( "c1 = " + c1);
        System.out.println( "c3 = " + c3 );

    }
}
