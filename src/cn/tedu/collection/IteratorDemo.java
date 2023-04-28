package cn.tedu.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合支持随机访问(根据指定的位置获取对应的元素)
 * 但是Collection层面不支持随机访问原因是Collection层面没有下标概念
 * 所以Collection选择采取其他的方式，就是迭代器遍历
 * 而迭代器遍历是父类中定义的，所以所有集合本身都是支持迭代器的
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("A");
        c.add("B");
        c.add("C");
        c.add("D");
        c.add("E");
        c.add("F");
        System.out.println("c = " + c);
        //1.获取迭代器
        Iterator it = c.iterator();
        //2.判断当前迭代器所处位置是否有下一个元素
        while (it.hasNext()) {
            //3.如果有，则取出下一个元素，并且将迭代器的位置向后移动一个
            Object e = it.next();
            System.out.println(e);
            //4.判断遍历的元素是否是D，如果是，则删除
            if ("D".equals(e)) {
                //5.迭代器中提供的删除方法 remove()会删除当前遍历的元素
                it.remove();
            }
        }
        System.out.println("c = " + c);

        Iterator t2 = c.iterator();
        while (t2.hasNext()) {
            Object next = t2.next();
            System.out.println(next);
        }
    }
}
