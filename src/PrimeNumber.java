import java.util.Arrays;

public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println(primeCount(21));
    }

    private static int primeCount(int n) {

        if(n<2){
            return 0 ;
        }
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime , true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i=2 ; i*i<=n ; i++){
            for(int j = 2*i;j<=n;j+=i){
                isPrime[j] = false;
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(isPrime[i]){
                count++;
            }
        }
        return count;
    }
}
