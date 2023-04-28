package homework;

public class CountNumDemo {
    public static void main(String[] args) {
        String a = "jlvdlksd";
        System.out.println("数组长度为：" + CountNum(a));
    }


    public static int CountNum(String a) {
        StringBuilder stringBuilder = new StringBuilder(a);
        int count = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            count++;
        }
        return count;
    }
}


