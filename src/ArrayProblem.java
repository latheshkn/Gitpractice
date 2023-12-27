import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayProblem {


    public static void main(String[] args) {
//        int a = 23;
//
//        int b=15%2;
//        System.out.println(b);

//        binaryCount();
        int[] a ={2,7,11,15};
        System.out.println(Arrays.toString(binarySearch(a,9)));
    }

    private static void binaryCount() {
        int[] a =new int[3];
        a[0]=0;
        for (int i = 1; i <= 2; i++) {
            a[i]  = calculate(i);
        }
        System.out.println(Arrays.toString(a));
    }

    private static int calculate(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 ==1) {
                count++;
            }
//            System.out.print(n%2);
            n = n / 2;
        }


        return count;
    }

    private static int[] binarySearch(int[] a,int target){

        Map<Integer, Integer> numMap = new HashMap<>();
        int n = a.length;

        for (int i = 0; i < n; i++) {
      int complement = target - a[i];
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(a[i], i);
        }

        return new int[]{};
    }


}
