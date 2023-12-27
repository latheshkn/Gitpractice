public class MathematicsForDsa {
    public static void main(String[] args) {

//        int[] a = {10, 20, 30, 40, 50, 60, 70, 80};
//        printArray(a, a.length - 1);
//        System.out.println(findMin(a, 0));
//        printIndex(a, 10, 0);
//        printDigit(4215);
//        System.out.println(checkArraySorted(a, 1));
//        int mid = a.length / 2;
//        System.out.println(findTarget(a, 80, 0, a.length - 1, (a.length - 1) / 2));

//        System.out.println(maximizeTheCuts(5,5,3,2));
        int[] a = {2, 7, 9, 3, 1};
//        System.out.println(rob(a, 0, a.length - 1));
//        sorting(a, a.length);
//        System.out.println(Arrays.toString(a));

//        System.out.println(findLastOccur("g", 'g', 0))
//        System.out.println(reverseStringRecursion("lathesh", 0))

//        System.out.println(addTwoString("11","123"));
        ;
        char current = 'c';
        System.out.println((char) ('C' + ('a' - 'A')));

    }

    private static int fibonacci(int n) {

        int pre = 0;
        int total = 1;
        int temp = 1;
        for (int i = 0; i < n; i++) {
            temp = total;
            total = pre + total;
            pre = temp;
        }
        return total;
    }

    private static int fibonacciRecursion(int n, int pre, int total) {
        int temp = total;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        total = pre + fibonacciRecursion(n - 1, temp, total);
        return total;
    }

    private static int fibonacciRecursion(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int ans = fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
        return ans;
    }


    private static void printArray(int[] a, int n) {
        if (n < 0) return;
        printArray(a, n - 1);
        System.out.print("" + a[n]);
    }


    private static boolean findElement(int[] a, int target, int n) {
        if (n > a.length - 1) {
            return false;
        }
        if (a[n] == target) {
            return true;
        }
        return findElement(a, target, n + 1);
    }

    private static int findMin(int[] a, int n) {
        if (n >= a.length - 1) {
            return a[n];
        }
        return Math.min(a[n], findMin(a, n + 1));
    }

    private static void printIndex(int[] a, int target, int n) {
        if (n > a.length - 1) {
            return;
        }
        if (a[n] == target) {
            System.out.println(n);
        }
        printIndex(a, target, n + 1);
    }

    private static void printDigit(int num) {

        if (num % 10 == 0) {
            return;
        }
        printDigit(num / 10);
        System.out.println(num % 10);
    }

    private static boolean checkArraySorted(int[] a, int n) {

        if (n > a.length - 1) {
            return true;
        }
        if (a[n] < a[n - 1]) {
            return false;
        }
        return checkArraySorted(a, n + 1);
    }

    private static int findTarget(int[] a, int target, int start, int end, int mid) {
        if (start > end) {
            return -1;
        }

        if (a[mid] == target) {
            return mid;
        }

        if (target > a[mid]) {
            start = mid + 1;
        }
        if (target < a[mid]) {
            end = mid - 1;
        }

        mid = (start + end) / 2;

        return findTarget(a, target, start, end, mid);
    }

    private static int maximizeTheCuts(int n, int x, int y, int z) {

        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return Integer.MIN_VALUE;
        }

        int option1 = 1 + maximizeTheCuts(n - x, x, y, z);
        int option2 = 1 + maximizeTheCuts(n - y, x, y, z);
        int option3 = 1 + maximizeTheCuts(n - z, x, y, z);

        int finalAns = Math.max(option1, Math.max(option2, option3));
        return finalAns;
    }

    public static int maximizeCuts(int n, int x, int y, int z) {
        //Your code here
        int[] arr = new int[n + 1];
        arr[0] = 0;
        if (x <= n) arr[x] = 1;
        if (y <= n) arr[y] = 1;
        if (z <= n) arr[z] = 1;
        for (int i = 1; i <= n; i++) {
            int k = arr[i];
            if (i - x >= 0 && arr[i - x] != 0) {
                k = Math.max(k, 1 + arr[i - x]);

            }
            if (i - y >= 0 && arr[i - y] != 0) {
                k = Math.max(k, 1 + arr[i - y]);

            }
            if (i - z >= 0 && arr[i - z] != 0) {
                k = Math.max(k, 1 + arr[i - z]);

            }
            arr[i] = k;
        }
        return arr[n];
    }


    private static int coinMin(int[] a, int amount) {

        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        int ans = Integer.MAX_VALUE;
        int mini = 0;
        for (int i = 0; i < a.length; i++) {
            int coin = a[i];
            if (coin <= amount) {
                int recAns = coinMin(a, amount - coin);
//                if (recAns != Integer.MAX_VALUE) {
//                   int  ans = 1 + recAns;
//                }
            }
            mini = Math.min(mini, ans);

        }
        return mini;
    }

    static int coinCount(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        int minCoins = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int ans = coinCount(coins, amount - coins[i]);

            if (ans != Integer.MAX_VALUE) {
                //we have returned 0 in ans, so now we are updating the ans count
                //hence 1 + ans
                minCoins = Math.min(minCoins, 1 + ans);
            }
        }
        return minCoins;
    }

    private static int coinChange(int[] coins, int amount) {
        int ans = coinCount(coins, amount);

        if (ans == Integer.MAX_VALUE) {
            return -1;
        } else {
            return ans;
        }
    }

    private static int rob(int[] a, int i, int size) {
        if (i > size) {
            return 0;
        }
        int option1 = a[i] + rob(a, i + 2, size);

        int option2 = rob(a, i + 1, size);
        return Math.max(option1, option2);
    }


    private static void sorting(int[] a, int n) {

        if (n <= 1) {
            return;
        }
        for (int i = 0; i <= a.length - 1; i++) {
            for (int j = 0; j <= a.length - 1 && i != j; j++) {
                int temp = a[j];
                if (a[j] > a[i]) {
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }

        sorting(a, n - 1);

    }


    private static int findLastOccur(String toFindLast, char d, int index) {
        int position = -1;
        if (index > toFindLast.length() - 1) {
            return -1;
        }
        if (toFindLast.charAt(index) == d) {
            position = index;
        }
        int res = findLastOccur(toFindLast, d, index + 1);
        return Math.max(res, position);
    }

    private static String reverseStringRecursion(String name, int index) {
        if (index > name.length() - 1) {
            return "";
        }
        char a = name.charAt(index);
        return reverseStringRecursion(name, index + 1) + a;
    }

    private static String addTwoString(String one, String two) {
        int i = two.length() - 1;
        int j = one.length() - 1;
        String sum = "";
        while (i >= 0 && j >= 0) {
            int digit1 = two.charAt(i--) - '0';
            int digit2 = one.charAt(j--) - '0';
            sum = String.valueOf(one.charAt(j) + two.charAt(i));
            i--;
            j--;
        }
        if (i >= 0) {
            for (int l = i; l >= 0; l--) {
                sum = two.charAt(l) + sum;
            }
        }
        if (j >= 0) {
            for (int k = j; k >= 0; k--) {
                sum = one.charAt(k) + sum;
            }
        }
        return sum;
    }
    public static String convertToLowerCase(String inputStr) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < inputStr.length(); i++) {
            char currentChar = inputStr.charAt(i);
            // Check if the character is an uppercase letter
            if ('A' <= currentChar && currentChar <= 'Z') {
                // Convert to lowercase by adding the Unicode offset
                result.append((char) (currentChar + ('a' - 'A')));
            } else {
                // Keep non-uppercase letters unchanged
                result.append(currentChar);
            }
        }
        return result.toString();
    }
}
