package homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class CountEnglishWordsDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./demo/英语文章.txt");
//        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

        byte[] data = new byte[fis.available()];
        //一次性读取data大小的内容（文件中所有的数据）
        fis.read(data);
        //利用String的构造方法将data数组还原为字符串
        String str = new String(data, StandardCharsets.UTF_8);

        //将读取的字符串转化为数组
        String[] words = str.split(" ");//空格分割
        String[] dict = {"Blue", "Volcano", "Tofu", "Umbrella", "Night", "sky", "Coffee", "Butterfly", "Octopus", "Elephant", "Amber",};
//        System.out.println(Arrays.toString(words));
        int[] count = new int[10];
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(dict[0])) count[0]++;
            if (words[i].equals(dict[1])) count[1]++;
            if (words[i].equals(dict[2])) count[2]++;
            if (words[i].equals(dict[3])) count[3]++;
            if (words[i].equals(dict[4])) count[4]++;
            if (words[i].equals(dict[5])) count[5]++;
            if (words[i].equals(dict[6])) count[6]++;
            if (words[i].equals(dict[7])) count[7]++;
            if (words[i].equals(dict[8])) count[8]++;
            if (words[i].equals(dict[9])) count[9]++;
        }
        for (int i = 0; i < dict.length; i++) {
            System.out.println(dict[i] + "出现的个数是" + count[i]);
        }

    }
}
