public class Substring {
    public static void main(String[] args) {

        String a="abc";
//        int pol=0;
//        for (int i = 0; i < a.length()-1; i++) {
//            if (polindrome(a, i)) {
//                pol++;
//            }
//
//        }
//        if (pol>0){
//            System.out.println("polindrome");
//        }else{
//            System.out.println("no");
//        }

//        System.out.println(polindrome(a));

//        System.out.println(editDistance("geek","gesek"));


        System.out.println(minDistance("ecfbefdcfca","badfcbebbf"));

    }

    private static boolean polindrome(String findPoli,int k){

        int i =0;
        int count =k;
        String pol = getSubstring(findPoli,0,count+1,count);
        int j=pol.length()-1;
        while (i<j){
            if (pol.charAt(i) !=pol.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static String getSubstring(String subString,int start,int end,int skipp){
        return subString.substring(start,skipp)+subString.substring(end,subString.length());
    }


    private static Boolean polindrome(String a){
            int i=0;
            int j =a.length()-1;
       while (i<=j){

             if (a.charAt(i) != a.charAt(j)){
                 return false;
             }
             i++;
             j--;
       }
       return true;
    }

    private static int editDistance(String s,String t){


        if (s.equals(t)){
            return 0;
        }

        return Math.abs(t.length()-s.length());
    }

    public static int minDistance(String s, String t) {
        return minDistanceRecursive(s, t, s.length(), t.length());
    }

    private static int minDistanceRecursive(String s, String t, int m, int n) {
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }

        if (s.charAt(m - 1) == t.charAt(n - 1)) {
            return minDistanceRecursive(s, t, m - 1, n - 1);
        }

        int deletion = minDistanceRecursive(s, t, m - 1, n) + 1;
        int insertion = minDistanceRecursive(s, t, m, n - 1) + 1;
        int substitution = minDistanceRecursive(s, t, m - 1, n - 1) + 1;

        return Math.min(deletion, Math.min(insertion, substitution));
    }
}

