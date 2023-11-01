public class paters {


    public static void main(String[] args) {
        int[] a = {3, 4, 5, 6, 11, 13, 14, 15, 56, 70};
        System.out.println(exponentialSearch(a,13));
    }

    private static int exponentialSearch(int[] a, int x) {
        int i = 1;
        int j = a.length - 1;
        if (a[0] == x) {
            return 0;
        }

        while (i <= j && a[i] <= x) {
            i = i * 2;
        }

      return bs(a,i/2,Math.min(i,j),13);
    }

    private static int bs(int[] a, int start, int end, int x) {
        int mid = (start + end) / 2;
        while (start <= end) {
            if (a[mid]==x){
                return mid;
            }else if(x<a[mid]){
                end =mid -1;
            } else {
                start =mid+1;
            }
            mid = (start + end) / 2;
        }
        return -1;
    }
}

