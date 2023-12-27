import java.util.HashMap;
import java.util.Map;

public class DecodeMessage {

    public static void main(String[] args) {

//        String key = "the quick brown fox jumps over dog";
//        System.out.println(decodeMessage(key, "vkbs bs t suepuv"));
//        String[] garbage = {"G", "P", "GP", "GG"};
//        int[] travel = {2, 4, 3};

//        orderString("cbafg", "cbad");
        System.out.println(orderString("kqep", "pekeq"));
    }

    private static String decodeMessage(String key, String message) {
        StringBuilder ans = new StringBuilder();
        char start = 'a';
        char[] map = new char[280];
        for (char c : key.toCharArray()) {
            if (c != ' ' && map[c] == '\0') {
                map[c] = start++;
            }
        }

        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                ans.append(" ");
            } else {
                ans.append(map[message.charAt(i)]);
            }
        }
        return ans.toString();
    }

    public static int garbageCollection(String[] garbage, int[] travel) {
        int mIndex = 0;
        int pIndex = 0;
        int gIndex = 0;

        int mCount = 0;
        int pCount = 0;
        int gCount = 0;
        int lastM = 0;
        int lastP = 0;
        int lastG = 0;

        for (int i = 0; i < garbage.length; i++) {

            for (int j = 0; j < garbage[i].length(); j++) {

                if (garbage[i].charAt(j) == 'G') {
                    gCount++;
                    gIndex = i;
                }
                if (garbage[i].charAt(j) == 'M') {
                    mCount++;
                    mIndex = i;
                }
                if (garbage[i].charAt(j) == 'P') {
                    pCount++;
                    pIndex = i;
                }
            }
        }

        for (int i = 0; i < gIndex; i++) {
            lastG = lastG + travel[i];
        }
        for (int i = 0; i < pIndex; i++) {
            lastP = lastP + travel[i];
        }
        for (int i = 0; i < mIndex; i++) {
            lastM = lastM + travel[i];
        }

        return (lastP + pCount) + (lastG + gCount) + (lastM + mCount);

    }

    /*"kqep","pekeq"*/
    private static String orderString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
//            System.out.println("map" + c + " " + map.getOrDefault(c, 0) + 1);
        }
        map.forEach((key, value) -> System.out.println(key + " " + value));

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < order.length(); j++) {
            char o = order.charAt(j);
            if (map.containsKey(o)) {
                int val = map.get(o);
                while (val > 0) {
                    sb.append(o);
                    System.out.print("Above"+o);
                    val--;
                }
                map.put(o, 0);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) > 0) {
                sb.append(s.charAt(i));
                System.out.println(" b"+s.charAt(i));
            }
        }

        return sb.toString();
    }
}
