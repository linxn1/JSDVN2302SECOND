package homework;

public class DeleteRepetitionDemo {
    public static void main(String[] args) {
        /**
         * 利用StringBuilder实现
         */
        String a = "dbasdhasdgdfgsdgdfshsgsabhjkbkjkkkk";
        String b = DeleteRepetition(a);
        System.out.println(b);
    }

    private static String DeleteRepetition(String a) {
        StringBuilder oldStringBuilder = new StringBuilder(a);
        StringBuilder newStringBuilder = new StringBuilder();

        for (int i = 0; i < oldStringBuilder.length(); i++) {
            //取出元素并转化为字符串
            char c = oldStringBuilder.charAt(i);
            boolean found = false;//默认没有找到
            for (int j = 0; j < newStringBuilder.length(); j++) {
                if (newStringBuilder.charAt(j) == c) {
                    found = true;
                    break;
                }
            }
            if (found == false) {
                newStringBuilder.append(c);
            }
        }
        String newString = new String(newStringBuilder);
        return newString;
    }
}
