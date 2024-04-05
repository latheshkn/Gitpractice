import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Recursion {
    public static void main(String[] args) {
        int[] a = {0};
        int[] b={1,2,3,4,5};
//        System.out.println(Arrays.toString(mergeTwoArray(a,b,1,5)));
//        System.out.println(sellStock(a));
//        System.out.println(Arrays.toString(twoSum(a,6)));
//        moveZero(a);
//        System.out.println(maxProfit(b));
//        System.out.println(sellStock(b));
//        System.out.println(Arrays.toString(runningSome(new int[]{3,1,2,10,1})));
        System.out.println(pivotIndex(new int[]{2,1,-1}));
    }


    private static int stairClimb(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return stairClimb(n - 1) + stairClimb(n - 2);

    }


    private static int sellStock(int[] prices) {


        int profit = 0;
        for(int i=1;i<prices.length;i++) {
            if(prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }

    private static int[] mergeTwoArray(int[]  nums1,int[] nums2,int m,int n){

        int i =0;
        int j =0;

        while(i<m && j<n){

            if (nums2[j]<nums1[i]){
                insertElement(nums1,nums2[j],i);
                j++;
            }
            i++;
        }

        for (int k = j; k < nums2.length; k++) {
            if (nums2[k]<nums1[k]){
                insertElement(nums1,nums2[j],k);
                j++;
            }

        }

        if (m==0){
            nums1 =nums2;
        }
        return nums1;
    }

    private static void insertElement(int[] a,int element,int position){
        int temp1;
        for (int i = position; i < a.length; i++) {
            temp1=a[i];
            a[i]=element;
            element=temp1;

        }

    }
    private static int[] twoSum(int[] a,int target){

        HashMap<Integer,Integer> map =new HashMap<>();
        for (int i = 0; i < a.length; i++) {

            int key = target-a[i];

            if (map.containsKey(key)){

                return new int[] {map.get(key),i};
            }
            map.put(a[i],i);
        }
        return new int[]{};
    }

    private static void moveZero(int[] nums){

        int j=0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] !=0){
                nums[j]=nums[i];
                j++;
            }
        }
        for (int i = j; i <nums.length ; i++) {

            nums[i]=0;
        }
        System.out.println(Arrays.toString(nums));
    }

    private static int[] runningSome(int[] nums){
        int[] runningSome =new int[nums.length];

        int total =0;
        for (int i = 0; i < nums.length; i++) {

            total =total+nums[i];
            runningSome[i]=total;
        }

        return runningSome;

    }

    public static int pivotIndex(int[] nums) {

//        1,7,3,6,5,6

        int[] prefixSum=new int[nums.length];
        int[] sufixSum =new int[nums.length];

        int prefix=0;
        for (int i = 0; i <nums.length ; i++) {
            prefix=prefix+nums[i];
            prefixSum[i]=prefix;
        }
        prefix=0;
        for (int i = nums.length-1; i >=0 ; i--) {
            prefix=prefix+nums[i];
            sufixSum[i]=prefix;
        }

        for (int i = 0; i < nums.length; i++) {

           if (prefixSum[i]==sufixSum[i]){
               return i;
           }

        }
        return -1;
    }



}





