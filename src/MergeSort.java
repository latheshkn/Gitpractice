import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int[] a = {2, 3, 1, 5, 7, 4};
        int size=6;
        int start=0;
        int end=size-1;
//        System.out.println(Arrays.toString(mergeSort(a, 0, a.length - 1)));

        mergeSort(a,start,end);
        System.out.println(Arrays.toString(a));

    }

    private static void mergeSort(int[] a, int start, int end) {
        if (start > end) {
            return ;
        }

        if (start==end){
            return;
        }

        int mid =(start+end)/2;

        mergeSort(a,start,mid);
        mergeSort(a,mid+1,end);

        sortedArray(a,start,end);

    }

    private static void sortedArray(int[] a, int s, int e) {

        int mid = (s + e) / 2;

        int lenLeft = mid - s + 1;
        int lenRight = e - mid;

//        creat right and left array

        int[] left = new int[lenLeft];
        int[] right = new int[lenRight];

        int k =s;
//        copying values from original array to left and right array
        for (int i = 0; i < lenLeft; i++) {
            left[i]=a[k];
            k++;
        }

        k=mid+1;

        for (int i = 0; i < lenRight; i++) {
            right[i]=a[k];
            k++;
        }

        int leftIndex=0;
        int rightIndex=0;

        int mainArrayIndex=s;

        while(leftIndex<lenLeft && rightIndex<lenRight){
            if (left[leftIndex]<right[rightIndex]){
                a[mainArrayIndex]=left[leftIndex];
                mainArrayIndex++;
                leftIndex++;
            }else{
                a[mainArrayIndex]=right[rightIndex];
                mainArrayIndex++;
                rightIndex++;
            }
        }

        while (rightIndex<lenRight){
            a[mainArrayIndex]=right[rightIndex];
            mainArrayIndex++;
            rightIndex++;
        }

        while(leftIndex<lenLeft){
            a[mainArrayIndex]=left[leftIndex];
            mainArrayIndex++;
            leftIndex++;
        }


    }
}
