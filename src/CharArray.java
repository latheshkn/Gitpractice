import java.util.Objects;

public class CharArray {

    public static void main(String[] args) {
        findSubString("abbcbaddcbabbbaae","cba");

    }

    private static void findSubString(String n, String sub) {
        int i = 0;
        String temp = n;
        while (i < temp.length()) {

            if (i+sub.length() < temp.length() && Objects.equals(sub, getSubstring(temp, i, i+sub.length()))) {
                temp =getRemovedSubstring(temp,i,i+sub.length());
                i=0;
            }else {
                i++;
            }
        }
        System.out.println(temp);
    }

    private static String getSubstring(String toSub, int start, int toIndex) {
        return toSub.substring(start, toIndex);
    }

    private static String getRemovedSubstring(String toSub, int start, int toIndex) {
        return toSub.substring(0, start) + toSub.substring(toIndex, toSub.length()-1+1);
    }
}