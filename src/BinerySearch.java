import java.util.*;

public class BinerySearch {


    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6, 10};


//        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
//        int[][] b ={{1,4},{4,5}};
//        merge(new int[]{0},0,new int[]{1},1);
//        System.out.println(countNegatives(new int[][]{{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}}));
//        System.out.println(isPalindrome(" "));
//        System.out.println(permute(new int[]{1,1,5}));
//        System.out.println(findWordsContaining(new String[]{"abc","bcd","aaaa","cbc"},'z'));
        System.out.println(peakIndexInMountainArray(new int[]{3,4,5,1}));
    }
    private static int bookAllocation(int[] a, int m) {

        int start = 0;
        int ans = -1;
        int end = 8;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (isPossible(a, mid, m)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;

            }
        }
        return ans;
    }



    private static boolean isPossible(int[] a, int mid, int cow) {
        int pos = a[0];
        int count = 1;
        for (int i = 1; i < a.length; i++) {
            if (Math.abs(pos - a[i]) >= mid) {
                count++;
                pos = a[i];
            }
            if (count == cow) return true;
        }
        return false;
    }

    public static void merge(int[] nums1,int m,int[] nums2,int n) {

        int i =0,j=0;
        int[] nums3 =new int[m+n];
        int count=0;
        while (i<m && j<n){

            if (nums1[i]<=nums2[j]){
                nums3[count] = nums1[i];
                i++;
            }else{
                nums3[count]=nums2[j];
                j++;
            }
            count++;
        }
        for (int k = i; k < m; k++) {
            nums3[count]=nums1[k];
            count++;
        }
        for (int k = j; k < n; k++) {
            nums3[count]=nums2[k];
            count++;
        }
        nums1 = nums3;

        System.arraycopy(nums3, 0, nums1, 0, nums3.length);

    }

    public static int[] productExceptSelf(int[] nums) {

        int[] right=new int[nums.length];
        int[] left =new int[nums.length];

        left[0]=1;
        for (int i = 1; i < nums.length; i++) {
            left[i]=left[i-1] * nums[i-1];
        }

        right[nums.length-1]=1;
        for (int i = nums.length-2; i >-1; i--) {
            right[i] =right[i+1]*nums[i+1];
        }

        int[] result =new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            result[i]=left[i]*right[i];
        }
        return result;
    }
    public static int countNegatives(int[][] grid) {

        int count=0;
        for (int[] ints : grid) {

            int start = 0;
            int end = ints.length - 1;
            int mid = (start + end) / 2;
            while (start <= end) {
                if (ints[mid] > 0) {
                    count += mid;
                    start = mid + 1;
                } else {
                    end = mid + 1;
                }

                mid = (start + end) / 2;

            }
        }

        return count;
    }

    public static boolean isPalindrome(String s) {

        StringBuilder build =new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char characterAt = s.charAt(i);

            if (characterAt >='A' && characterAt<='Z'){

                characterAt +=32;
            }
            if ((characterAt>='a' && characterAt<='z') || (characterAt>='0' && characterAt<='9')){
                build.append(characterAt);
            }
        }

        return build.toString().equals(build.reverse().toString());
    }


    public static List<Integer> permute(int[] nums) {

        List<List<Integer>> result =new ArrayList<>();

        backtrack(result,new ArrayList<>(),nums,new boolean[nums.length]);

      int index=result.indexOf(Arrays.stream(nums).boxed().toList());
        return result.get(index+1);

    }
    private static void backtrack(List<List<Integer>> result,ArrayList<Integer> temp,int[] nums,boolean[] isUsed){



        if (temp.size() == nums.length && !result.contains(temp)){
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (temp.contains(nums[i]) && isUsed[i]){
                continue;
            }
            isUsed[i]=true;
            temp.add(nums[i]);
            backtrack(result,temp,nums,isUsed);
            temp.remove(temp.size()-1);
            isUsed[i]=false;
        }
    }

    public static List<Integer> findWordsContaining(String[] words, char x) {

        ArrayList<Integer> existIndex=new ArrayList<>();
        for (int i = 0; i < words.length; i++) {

            if (words[i].contains(String.valueOf(x))){
                existIndex.add(i);
            }
        }
        return existIndex;
    }


    public static int searchInsert(int[] nums, int target) {

        if (target<nums[0]){
            return 0;
        }
        if (target>nums[nums.length-1]){
            return nums.length;
        }
        int start =0;
        int end =nums.length-1;
        int mid =start+(end-start)/2;

        while (start<end){

            if (nums[mid]==target){
                return mid;
            }
            if (target>nums[mid]){
                start =mid+1;
            }
            if (target<nums[mid]){
                end=mid;
            }

            mid = start+(end-start)/2;


        }
        return start;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int target =0;
        Arrays.sort(nums);
        Set<List<Integer>> set =new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            int j =i+1;

            int k = nums.length-1;

            while(j<k){
                int l =j+1;
                while (l<k){
                    int sum = nums[i]+nums[j]+nums[l]+nums[k];

                    if (sum==target){
                        set.add(Arrays.asList(nums[i],nums[j],nums[l],nums[k]));
                        l++;
                        k--;
                    }else if (sum<target){
                        l++;
                    }else{
                        k--;
                    }
                }
                j++;

            }
        }
        return new ArrayList<>(set);
    }

    public static void sortColors(int[] nums) {

        Map<Integer,Integer> map =new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count=0;
        for (Map.Entry<Integer,Integer> entry:map.entrySet()
             ) {

            int key =entry.getKey();
            int value =entry.getValue();

            for (int i = 0; i < value; i++) {
                nums[count]=key;
                count++;
            }
        }

    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1)
        {
            if(i >= 0)
                carry += a.charAt(i--) - '0';
            if(j >= 0)
                carry += b.charAt(j--) - '0';
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();

    }

    public static int countNegativesBinary(int[][] grid) {

        int count=0;
        for (int i = 0; i < grid.length; i++) {

            int start =0;
            int end =grid[i].length-1;

            int mid =start+(end-start)/2;

            while(start<=end){

                if (grid[i][mid]<0){
                    end=mid-1;
                }
                if (grid[i][mid]>=0){
                    start =mid+1;
                }
                 mid =start+(end-start)/2;
            }
            count +=grid[i].length-start;
        }
        return count;
    }

    public static int peakIndexInMountainArray(int[] arr) {


        int start = 0;
        int end=arr.length-1;

        int mid = start+(end-start)/2;
        while(start<=end){
            if (mid+1<arr.length && mid-1>=0 && arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }
            if ( mid-1>=0 && arr[mid]<arr[mid-1]){
                end=mid-1;
            }else{
                start =mid+1;
            }
            mid=start+(end-start)/2;

        }
        return -1;
    }
}

