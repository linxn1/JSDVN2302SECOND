package cn.tedu.map;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map接口 查找表
 * Map体现的结构就是多行两列的表格，左列称为“key”，右列称为“value”
 * Map总是以key-value的形式保存一组数据，并且可以根据key获取对应的value
 */
public class MapDemo01 {
    public static void main(String[] args) {
        //LinkedMap 记录存储的顺序，更占用内存
        //HashMap不会记录存储顺序
        Map<String, Integer> map = new HashMap<>();
        //V put(K key, V value);向当前map存储一组键值对
        map.put("语文", 90);
        map.put("数学", 99);
        map.put("物理", 80);
        map.put("化学", 85);
        System.out.println(map);
        //Map中的value是允许重复的
        Integer score = map.put("英语", 80);
        System.out.println(map);
        System.out.println(score);
        //Map中的key不允许重复
        score = map.put("数学", 100);
        System.out.println(map);
        System.out.println(score);

        score = map.get("数学");//获取数学成绩，将数学的valuv返回
        System.out.println(score);
        score = map.get("体育");//获取体育城西，体育不存在，返回null
        System.out.println(score);
        int size = map.size();
        System.out.println("map中包含" + size + "个元素！");
        /**
         * V remove(Object key);
         * 删除给定的key的这组键值对，如果删除成功，会将删除的value返回
         */
        map.remove("数学");
        System.out.println(score);
        map.remove("体育");
        System.out.println(score);
        boolean k = map.containsKey("物理");
        if (k) {
            System.out.println("包含“物理”这个key");
        } else {
            System.out.println("不包含“物理”这个key");
        }
        boolean v = map.containsValue("101");
        if (v) {
            System.out.println("包含“101”这个value");
        } else {
            System.out.println("不包含“101”这个value");
        }
    }
}
