import java.util.*;

public class Recurssion {
    public static void main(String[] args) {

//        System.out.println(myPow( 2.00000,-2)) ;
        System.out.println(isPalindrome(-121)) ;
    }


    public static List<Integer> findDuplicates(int[] nums) {

        Arrays.sort(nums);
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums.length-1; i++) {

            if(nums[i] == nums[i+1]){
                list.add(nums[i]);
            }
        }
        return list;
    }

    public static int jump(int[] nums) {

        int n = nums.length;
        if (n == 1)
            return 0;

        int step = 1;
        int maxIdx = Math.min(nums[0], n-1);
        int currIdx = 1;
        while (currIdx < n) {
            if (maxIdx >= n - 1)
                return step;
            int nextMaxIdx = -1;
            for (int i = currIdx; i <= maxIdx; i++) {
                nextMaxIdx = Math.max(nextMaxIdx, i + nums[i]);
            }
            currIdx = maxIdx + 1;
            maxIdx = Math.min(nextMaxIdx, n-1);
            step++;
        }
        return 0;
    }

        public static int reverse(int x) {

            int reversed = 0;

            while (x != 0) {
                int digit = x % 10;
                // Check for overflow before updating reversed
                if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                    return 0; // Overflow will occur if we update reversed
                }
                if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                    return 0; // Overflow will occur if we update reversed
                }

                reversed = reversed * 10 + digit;
                x /= 10;
            }

            return reversed;
        }
//3,2,4   {6}
    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map =new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

           int  key = target -nums[i];

           if (map.containsKey(key)){
               return new int[] {map.get(key),i};
           }

           map.put(nums[i],i);
        }
        return new int[]{};
    }
/*{1,4}{4,5}*/
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int totalIntervals = intervals.length;

        int intervalStart = intervals[0][0];
        int intervalEnd = intervals[0][1];

        List<int[]> mergedList = new ArrayList<>();

        for (int i = 1; i < totalIntervals; i++) {

            if (intervals[i][0] > intervalEnd) {
                mergedList.add(new int[] {intervalStart, intervalEnd});

                intervalStart = intervals[i][0];
                intervalEnd = intervals[i][1];
            } else {
                intervalEnd = Math.max(intervalEnd, intervals[i][1]);
            }
        }
        mergedList.add(new int[] {intervalStart, intervalEnd});

        return mergedList.toArray(new int[mergedList.size()][]);
    }

    public static int numberOfPoints(List<List<Integer>> nums) {

        HashSet<Integer> set =new HashSet<>();

        for (List<Integer> points : nums) {
            for (int j = points.get(0); j <= points.get(1); j++) {
                set.add(j);
            }
        }
       return set.size();
    }


    public static List<String> invalidTransactions(String[] transactions) {

        Map<String, Transaction> map =new HashMap<>();
        Transaction transaction ;
        List<String> list=new ArrayList<>();
        ArrayList<Transaction> invalidList= new ArrayList<>();
        for (int i = 0; i < transactions.length; i++) {
            String[] item = transactions[i].split(",");
            transaction =new Transaction();
            transaction.setName(item[0]);
            transaction.setTime(item[1]);
            transaction.setAmount(item[2]);
            transaction.setPlace(item[3]);

            if (Integer.parseInt(item[2])>1000 ){
                if (map.containsKey(item[0])){
                    invalidList.add(map.get(item[0]));
                }
                invalidList.add(transaction);
            }

            if (map.containsKey(item[0]) && Integer.parseInt(item[2])<1000){
               Transaction transaction1= map.get(item[0]);
               if (Objects.equals(transaction1.getName(), item[0]) && Math.abs(Integer.parseInt(item[1])-Integer.parseInt(transaction1.getTime()))<=60){
                   if (!invalidList.contains(transaction1)){
                       invalidList.add(transaction1);
                   }
                   if (!invalidList.contains(transaction)){
                       invalidList.add(transaction);
                   }
               }
            }
            map.put(item[0],transaction);
        }
        for (Transaction value : invalidList) {
            String item = value.getName()+","+value.getTime()+","+value.getAmount()+","+value.getPlace();
            list.add(item);
        }

        return list;
    }

 static class  Transaction{
        String name;
        String time;
        String amount;

     public String getPlace() {
         return place;
     }

     public void setPlace(String place) {
         this.place = place;
     }

     String place;

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getTime() {
         return time;
     }

     public void setTime(String time) {
         this.time = time;
     }

     public String getAmount() {
         return amount;
     }

     public void setAmount(String amount) {
         this.amount = amount;
     }
 }

 private static double myPow(Double x,int n){
     if (n == 0) {
         return 1;
     }
     else if (n < 0) {
         return 1 / (x * myPow(x, -n - 1));
     }
     else if (n%2==0){
         double a = myPow(x,n/2);
         return a*a;
     }
     return x*myPow(x,n-1);
 }
    public static int mySqrt(int x) {

        if (x <= 1) {
            return x;
        }
        for (long i = 0; i <= x; i++) {
            long square = i * i;
            if (square == x) {
                return (int) i;
            } else if (square > x) {
                return (int) (i - 1);
            }
        }
        return 0;
    }

    public static boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        int original =x;
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            // Check for overflow before updating reversed
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return false; // Overflow will occur if we update reversed
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return false; // Overflow will occur if we update reversed
            }

            reversed = reversed * 10 + digit;
            x /= 10;
        }
        return reversed == original;
    }
}