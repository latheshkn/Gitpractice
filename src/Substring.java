public class Substring {
    public static void main(String[] args) {

        String a="aca";
        int pol=0;
        for (int i = 0; i < a.length()-1; i++) {
            if (polindrome(a, i)) {
                pol++;
            }

        }
        if (pol>0){
            System.out.println("polindrome");
        }else{
            System.out.println("no");
        }


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
}
