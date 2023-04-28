package cn.tedu.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 泛型是JDK1.5增加的一个新特性，泛型本质是参数化类型，也就是说，操作的数据类型可以被指定为一个参数，
 * 增加泛型这个概念，主要是为了让集合能记住其元素的数据类型
 */
public class GenericsDemo {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        //集合在没有泛型的约束下，可以装任意的类型
        c.add("任意类型的元素");

        //声明了一个集合，泛型是String类型
        Collection<String> c1 = new ArrayList();
        c1.add("hello");
        //c1.add(1);//编译错误，add方法不能添加int类型

        Collection<Integer> c2 = new ArrayList<>();
        c2.add(1);
        //c2.add("hello");//编译错误，add方法不能添加String类型

        Test test = new Test();
        test.setObj("你好");
        Object obj = test.getObj();
        //声明泛型时，Test类中，所有的T的类型都是String类型
        Test<String> test1 = new Test();
        test1.setObj("我不好");
        String obj1 = test1.getObj();
    }


}

//1.在类名后使用泛型约束T->Type
class Test<T> {
    //2.将类中需要参数控制的地方改成泛型
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}