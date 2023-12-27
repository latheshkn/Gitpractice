import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ComparatorExample {


    public static void main(String[] args) {
//        System.out.println(isAnagram("anagram", "nagaram"));
//        System.out.println(isAnagrams("anagram", "nagaram"));

        System.out.println(reverseOnlyLetters("F`abk"));
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }
        for (char c : t.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char o = t.charAt(i);
            if (!map2.containsKey(o)) {
                return false;
            }
            int val1 = map1.get(o);
            int val2 = map2.get(o);
            if (val1 != val2) {
                return false;
            }

        }
        return true;
    }

    public static boolean isAnagrams(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }

    public static String reverseOnlyLetters(String s) {

        char[] a = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        char temp = ' ';
        while (i <= j) {
            if ((s.charAt(i) < 'a' && s.charAt(i) > 'Z')  || ( s.charAt(i) <'A' || s.charAt(i) > 'z')) {
                i++;
                continue;
            }
            if ((s.charAt(j) < 'a' && s.charAt(j) > 'Z')  || ( s.charAt(j) <'A' || s.charAt(j) > 'z')) {
                j--;
                continue;
            }

            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            i++;
            j--;

        }

        return String.valueOf(a);
    }
}
