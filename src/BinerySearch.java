public class BinerySearch {


    public static void main(String[] args) {
        int[] a = {1,3,5,6,10};

        System.out.println(bookAllocation(a, 3));
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

}

