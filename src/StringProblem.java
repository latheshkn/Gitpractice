import java.util.*;

public class StringProblem {
    public static void main(String[] args) {
//        System.out.println(removeVowels("welcome to geeksforgeeks"));

//        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
//        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,4,5,6,7,8,9,9},3));
//        substring("abc");
//        separateString("@Aa123");
        System.out.println(permuteUnique("abcd"));
    }

    public static String removeVowels(String s){
        String vowels ="aeiou";
        StringBuilder builder =new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i)) ==-1 ){
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        if (strs==null || strs.length==0){
            return new ArrayList<>();
        }

        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {

            if (map.containsKey(sortString(str))) {
                map.get(sortString(str)).add(str);
            } else {

                List<String> stringList = new ArrayList<>();
                stringList.add(str);
                map.put(sortString(str), stringList);
            }
        }
       return new ArrayList<>(map.values());
    }

    public static String sortString(String strs){
        Character tempArray[]
                = new Character[strs.length()];

        for (int i = 0; i < strs.length(); i++) {
            tempArray[i] = strs.charAt(i);
        }

        Arrays.sort(tempArray, new Comparator<Character>() {

            // Method 2
            // To compare characters
            @Override
            public int compare(Character c1, Character c2)
            {
                // Ignoring case
                return Character.compare(
                        Character.toLowerCase(c1),
                        Character.toLowerCase(c2));
            }
        });
        StringBuilder sb
                = new StringBuilder(tempArray.length);

        for (Character c : tempArray)
            sb.append(c.charValue());

        return sb.toString();
    }

    private static void separateString(String s){

        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder stringBuilder3 = new StringBuilder();


        for (int i = 0; i < s.length(); i++) {

            if ((s.charAt(i)>='a' && s.charAt(i)<='z') ||(s.charAt(i)>='A' && s.charAt(i)<='Z')  ){
                stringBuilder1.append(s.charAt(i));
            }else
            if (s.charAt(i)>='0' && s.charAt(i)<='9'){
                stringBuilder2.append(s.charAt(i));
            }else{
                stringBuilder3.append(s.charAt(i));
            }
        }
        System.out.println(stringBuilder1+" "+ stringBuilder2+" "+stringBuilder3);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

       int start=0,end=1;

       while (end<nums.length){
           if (nums[start]==nums[end] && (end-start)<=k){
               return true;
           }else if (end-start ==k){
               start++;
               end=start+1;
           }else {
               end++;
           }
       }
       return false;
    }

    public static int climbStairs(int n) {

        if (n==1 ||n==2 || n<=0){
            return n;
        }

        return climbStairs(n-1)+climbStairs(n-2);
    }

    public static void substring(String s){
        int num_subs = (int)Math.pow(2,s.length());
        for (int i = 0; i < num_subs; i++) {

            String out;
            int num =i;

            while(num !=0){

                int b =(num & 1);
                System.out.print(b);
                num>>=1;
            }
            System.out.println("");

        }
    }


    public static List<String> permuteUnique(String nums) {
        List<String> result =new ArrayList<>();

        backtrack(result,"",nums);

        return result;

    }

    private static void backtrack(List<String> result, String temp, String nums) {

        if (temp.length()==nums.length()){
            result.add(temp);
            return;
        }
        for (int j = 0; j < nums.length();j++) {
            if (temp.contains(String.valueOf(nums.charAt(j)))){
                continue;
            }
            temp +=String.valueOf(nums.charAt(j));
            backtrack(result,temp,nums);
            temp=temp.substring(0, temp.length() - 1);
        }
    }
}
