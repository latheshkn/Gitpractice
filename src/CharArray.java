import java.util.Objects;

public class CharArray {

    public static void main(String[] args) {
//        findSubString("abbcbaddcbabbbaae","cba");

        int[] a = {7, 10, 4, 3, 20, 15};
        System.out.println(kthSmallest(a, 3));

    }

    private static void findSubString(String n, String sub) {
        int i = 0;
        String temp = n;
        while (i < temp.length()) {

            if (i + sub.length() < temp.length() && Objects.equals(sub, getSubstring(temp, i, i + sub.length()))) {
                temp = getRemovedSubstring(temp, i, i + sub.length());
                i = 0;
            } else {
                i++;
            }
        }
        System.out.println(temp);
    }

    private static String getSubstring(String toSub, int start, int toIndex) {
        return toSub.substring(start, toIndex);
    }

    private static String getRemovedSubstring(String toSub, int start, int toIndex) {
        return toSub.substring(0, start) + toSub.substring(toIndex, toSub.length() - 1 + 1);
    }

    private static int[] reverseArray(int[] a) {
//        int size = a.length;
//        int [] b = new int[size];
//
//        for (int i = 0; i < a.length; i++) {
//            b[(size-1)-i] = a[i];
//        }

        int start = 0;
        int end = a.length - 1;
        int tep;
        while (start <= end) {
            tep = a[start];
            a[start] = a[end];
            a[end] = tep;
            start++;
            end--;
        }
        return a;
    }

    private static int kthSmallest(int[] a, int k) {
        int cont = 0;
        for (int j : a) {
            for (int value : a) {

                if (value < j) {
                    cont++;
                }
            }
            if (cont == k - 1) {
                return j;
            }
            cont = 0;
        }
        return -1;
    }
}