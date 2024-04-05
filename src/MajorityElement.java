import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {

//        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
//        System.out.println(fib(0));
//        System.out.println(minSubArrayLen2(15,new int[]{5,1,3,5,10,7,4,9,2,8}));
//        System.out.println(search(new int[]{4,5,6,7,0,1,2},4));
//        System.out.println(Arrays.toString(sortedSquares(new int[]{-7,-3,2,3,11})));
        System.out.println(removeDuplicates(new int[]{1,1,2}));
    }

    public static int majorityElement(int[] nums) {

        HashMap<Integer,Integer> map =new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() >nums.length/2){
                return entry.getKey();
            }
        }
        return -1;
    }

    public static int fib(int n) {

        if (n==0)
            return 0;
        int temp =0;
        int total=1;
        int temp2=0;
        for (int i = 1; i < n; i++) {
            temp2 =total;
            total =total+temp;
            temp =temp2;

        }

        return total;
    }

    public static int minSubArrayLen(int target, int[] nums) {

//    11    1,2,3,4,5
    int minValue =Integer.MAX_VALUE;
    int total=0;
    int count=0;
        for (int i = 0; i < nums.length; i++) {

            for (int j = i; j < nums.length; j++) {

                total=total+nums[j];
                count++;
                if (total>=target){
                    minValue =  Math.min(minValue,count);
                }

            }
            count=0;
            total=0;
        }
         if(minValue==Integer.MAX_VALUE){
             return 0;
        }else{
             return minValue;
         }
    }

    public static int minSubArrayLen2(int target, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int start = 0,  end = 0,  sum = 0,  minLength = Integer.MAX_VALUE;

        while (end < nums.length) {
            sum += nums[end++];

            while (sum >= target) {
                minLength = Math.min(minLength, end - start);
                sum -= nums[start++];
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static int search(int[] nums, int target) {

        Arrays.sort(nums);
        int start=0,end=nums.length-1,mid=(start+end)/2;

       while (start<=end){

           if (nums[mid]==target){
               return mid;
           }

           if (target<nums[mid]){
               end=mid-1;

           }

           if (target>nums[mid]){
               start=mid+1;
           }

           mid=(start+end)/2;
       }

       return -1;
    }

    public static int[] sortedSquares(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            nums[i] *=nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public static int removeDuplicates(int[] nums) {

        ArrayList<Integer> list =new ArrayList<>();
        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
            }
        }
        Arrays.fill(nums,0);
        for (int i = 0; i < list.size(); i++) {
            nums[i]=list.get(i);
        }
    return list.size();
    }
}
