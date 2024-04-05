import java.util.*;

public class SubArray {
    public static void main(String[] args) {

//        System.out.println(subarraySum(new int[]{1,1,1},2));
       int[][] a= {
               {1,2,3},
        {4,5,6},{7,8,9}
       };
//        System.out.println(threeSumClosest(new int[]{1, 2, 3, 4},10));

//        System.out.println(findDuplicate(new int[]{3,1,3,4,2}));
//        System.out.println(findPairs(new int[]{1,2,4,4,3,3,0,9,2,3},3));
//        System.out.println(longestCommonPrefix(new String[]{"hello", "hey", "he"}));
//        System.out.println(validPalindrome("abca"));
//        System.out.println(strStr("mississippi","issi"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int subarraySum(int[] nums, int k) {

        int sum = 0;
        int counter = 0;
        Map<Integer, Integer> stateMap = new HashMap<>();
        stateMap.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (stateMap.containsKey(sum - k)) {
                counter += stateMap.get(sum - k);
            }
            stateMap.put(sum, stateMap.getOrDefault(sum, 0) + 1);
        }
        return counter;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int i;
        List list = new ArrayList<>();
        int k=0,l=0;
        int row=matrix.length -1;
        int col=matrix[0].length-1;
        while(k<=row && l<= col) {
            for(i=l;i<=col;i++) {
                list.add(matrix[k][i]);
            }
            k++;

            for(i=k;i<=row;i++) {
                list.add(matrix[i][col]);
            }
            col--;
            if(k<= row) {
                for(i= col;i>=l;i--) {
                    list.add(matrix[row][i]);
                }
            }
            row--;
            if(l<=col) {
                for(i=row;i>=k;i--) {
                    list.add(matrix[i][l]);
                }
            }
            l++;
        }
        return list;
    }

    public static int threeSumClosest(int[] nums, int target) {

        int total=0,count=0;
        int min =Integer.MAX_VALUE;
        HashMap<Integer,Integer> map= new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            for (int j = i; j <nums.length -1 && count<= 2; j++) {
                total +=nums[j];
                count++;
            }

            if (total>=0 && count==2){
                min =Math.min(min,target-total);
                map.put(min,total);
            }
            total=0;
            count=0;
        }
        System.out.println(map.get(min));
        return min;
    }

    public static int findDuplicate(int[] nums) {

        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }
        return -1;
    }

    public static int firstMissingPositive(int[] nums) {

        HashMap<Integer,Integer> map =new HashMap<>();
        for (int num : nums) {
            map.put(num, 1);
        }

        int count=1;
        while (true){
            if (!map.containsKey(count)){
                return count;
            }
            count++;
        }
    }

    public static int findPairs(int[] nums, int k) {

        HashMap<Integer,Integer> map =new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length && i!=j; j++) {
                if (Math.abs(nums[i]-nums[j])==k){
                    map.put(nums[i],nums[j]);
                }
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());

        return 0;
    }

    public static int jump(int[] nums) {

        int j=0,count=1,min =Integer.MAX_VALUE,pos=0;
        for (int i = 0; i < nums.length; i++) {
            j=i;
            while (j>=0){
                for (int k = i; k < nums.length; k++) {
                    if (nums[k]==0){
                        min =Integer.MAX_VALUE;
                        break;
                    }
                    pos+=nums[k];
                    if (pos==nums.length-1){
                        min = Math.min(min,count);
                    }
                    count++;
                }
                j--;
            }
        }
        return min;
    }
    /*Maximum Points You Can Obtain from Cards*/

    public static int maxScore(int[] cardPoints, int k) {


        int prefic=0;
        int sufix=0;
        if (cardPoints.length==k){
            for (int cardPoint : cardPoints) {
                prefic += cardPoint;
            }
            return prefic;
        }

        for (int i = 0; i < k; i++) {
            prefic += cardPoints[i];
        }

        for (int i = cardPoints.length-1; i > (cardPoints.length-1)-k; i--) {
            sufix += cardPoints[i];
        }
        if (prefic>=sufix){
            return prefic;
        }else{
            return sufix;
        }
    }
    public static String addStrings(String num1, String num2) {

        int i =num1.length()-1,j=num2.length()-1;
String total ="";
int remainder=0;
//                                  /* 456 77*/
        while(i>=0 && j>=0){

            int a =Integer.parseInt(String.valueOf(num1.charAt(i)));
            int b= Integer.parseInt(String.valueOf(num2.charAt(j)));

            int tot =a+b;
            if (num1.length()==1 && num2.length()==1){
                return String.valueOf(tot);
            }

            total = ((remainder+tot)%10)+total;


            if (tot>=10){
                remainder =(remainder+tot)/10;
            }
            i--;
            j--;
        }

//        for (int k = j; k >=0 ; k--) {
//            if (total.length()==num2.length()){
//               total= String.valueOf(Integer.parseInt(String.valueOf(num1.charAt(k)))+Integer.parseInt(String.valueOf(total.charAt(k))));
//            }else{
////                total =
//            }
//
//        }
        for (int k = i; k >=0 ; k--) {
            total = String.valueOf(remainder+Integer.parseInt(String.valueOf(num1.charAt(k))))+total;

        }


        return total;
    }
    public static String longestCommonPrefix(String[] strs) {

        StringBuilder ans = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];
        for (int i=0; i<Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }

    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Try skipping the character on the left
                if (isPalindrome(s, left + 1, right)) {
                    return true;
                }
                // Try skipping the character on the right
                if (isPalindrome(s, left, right - 1)) {
                    return true;
                }
                // If neither case is a palindrome, return false
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    public static int strStr(String haystack, String needle) {
        int skip =needle.length();
        for (int i = 0; i < haystack.length() ;i++) {
            for (int j = i; j < haystack.length() && j+skip<=haystack.length() ;) {
                if (haystack.substring(i, i+needle.length()).equals(needle)){
                    return i;
                }
                j=j+skip;
            }

        }

        return -1;
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }

        return maxLength;
    }
}
