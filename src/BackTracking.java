import java.util.*;

 class BackTracking {




    public static void main(String[] args) {

     Student s=new Student();
//        System.out.println(combine(4,2));

        String a ="dca";

//        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
//        System.out.println(combinationSum(new int[]{2,5,2,1,2},5));
//        printPermutation("abc","",0);
//        int[][] maze = {
//                {1,0,0,0},
//                {1,1,0,0},
//                {1,1,1,0},
//                {1,1,1,1}
//        };
//        int row =4;
//        int col=4;
//        int newX=0;
//        int newY=0;
//        String output="";
//        printPermutation(maze,row,col,newX,newY,output,new boolean[4][4]);

        System.out.println(search(new int[]{3,1},1));

    }


//    public static List<List<Integer>> subsets(int[] nums) {
//
//        List<List<Integer>> result =new ArrayList<>();
//
//        backTrack(result,new ArrayList<Integer>(),nums,0);
//
//        return result;
//    }

//    private static void backTrack(List<List<Integer>> resultSet, ArrayList<Integer> tempSet, int[] nums, int i) {
//
//        if (!resultSet.contains(tempSet)){
//            resultSet.add(new ArrayList<>(tempSet));
//        }
//        for (int j = i; j < nums.length; j++) {
//            tempSet.add(nums[j]);
//            backTrack(resultSet,tempSet,nums,j+1);
//            tempSet.remove(tempSet.size()-1);
//        }
//    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result =new ArrayList<>();

        backTrack(result,new ArrayList<Integer>(),n,1,k);
        return result;
    }

    private static void backTrack(List<List<Integer>> resultSet, ArrayList<Integer> tempSet, int n, int i,int k) {

        if (tempSet.size()==k){
            resultSet.add(new ArrayList<>(tempSet));
            return;
        }
        for (int j = i; j <= n; j++) {
            tempSet.add(j);
            backTrack(resultSet,tempSet,n,j+1,k);
            tempSet.remove(tempSet.size()-1);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result=new ArrayList<>();
        Set<List<String>> set = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {

            set.add(Arrays.asList(strs[i]));
            for (int j = i+1; j < strs.length; j++) {

              char[] b=strs[j].toCharArray();
                Arrays.sort(b);

            }
            result.addAll(set);
            set.clear();
        }
       return result;
    }

    private static void backTrackSum(Set<List<Integer>> resultSetSet, ArrayList<Integer> tempSet, int total,int target,int[] candidates,int i,int previous) {
        Arrays.sort(candidates);
        if (total==target){
            resultSetSet.add(new ArrayList<>(tempSet));
            return;
        }
        if (total>target){
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            tempSet.add(candidates[j]);
            backTrackSum(resultSetSet,tempSet,total+candidates[j],target,candidates,j+1,j);
            tempSet.remove(tempSet.size()-1);
        }
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultSet = new ArrayList<>();
        Set<List<Integer>> resultSetSet = new HashSet<>();
        backTrackSum(resultSetSet,new ArrayList<Integer>(),0,target,candidates,0,-1);
        resultSet.addAll(resultSetSet);
        return resultSet;
    }

   static void printPermutation(int maze[][],int row,int col,int scrX,int scrY, String output,boolean[][] isVisted) {
    if (scrX==row-1 && scrY==col-1){
        System.out.println(output);
    }
//    UP
       int newX=scrX-1;
       int newY=scrY;

       if (isSafe(scrX,scrY,newX,newY,maze,row,col,isVisted)){
           isVisted[newX][newY]=true;
           printPermutation(maze,row,col,newX,newY,output+"U",isVisted);
           isVisted[newX][newY]=false;
       }

//       RIGHT
        newX=scrX;
        newY=scrY+1;
       if (isSafe(scrX,scrY,newX,newY,maze,row,col,isVisted)){
           isVisted[newX][newY]=true;
           printPermutation(maze,row,col,newX,newY,output+"R",isVisted);
           isVisted[newX][newY]=false;
       }

//       DOWN
       newX=scrX+1;
       newY=scrY;
       if (isSafe(scrX,scrY,newX,newY,maze,row,col,isVisted)){
           isVisted[newX][newY]=true;
           printPermutation(maze,row,col,newX,newY,output+"D",isVisted);
           isVisted[newX][newY]=false;
       }

//       LEFT
       newX=scrX;
       newY=scrY-1;
       if (isSafe(scrX,scrY,newX,newY,maze,row,col,isVisted)){
           isVisted[newX][newY]=true;
           printPermutation(maze,row,col,newX,newY,output+"L",isVisted);
           isVisted[newX][newY]=false;
       }

   }

   static boolean isSafe(int scrX,int srcY,int newx,int newY,int maze[][],int row,int col,boolean[][] visited){
       return (newx >= 0 && newx < row) && (newY >= 0 && newY < col) && maze[newx][newY] == 1 && !visited[newx][newY];
   }

    public static int rob(int[] nums) {

       return solve(nums,0,nums.length-1);
    }
    public static int solve (int[] nums,int i,int size){
        if (i>=size){
            return 0;
        }

        int option1= nums[i]+solve(nums,i+2,size);

        int option2 = 0+solve(nums, i + 1, size);


        return Math.max(option1,option2);
    }

    public static int search(int[] nums, int target) {
//        if (nums.length==0){
//            return -1;
//        }
        int pivot =0;
        for (int i = 0; i < nums.length && i+1<nums.length; i++) {
            if (nums[i]>nums[i+1]){
                pivot =i+1;
                break;
            }
        }

        int start=0, end =pivot;
        int mid =start+((end-start)/2);
        while (start<=end){
            if (nums[mid]==target){
                return mid;
            }else if (target>nums[mid]){
                start =mid+1;
            }else {
                end =mid-1;
            }
            mid = (start+end)/2;
        }

        start =pivot;
        end =nums.length-1;

         mid =(start+((end-start))/2);
        while (start<=end){
            if (nums[mid]==target){
                return mid;
            }else if (target>nums[mid]){
                start =mid+1;
            }else {
                end =mid-1;
            }
            mid = (start+end)/2;
        }
        return -1;
    }
}
