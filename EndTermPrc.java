import java.util.*;

public class EndTermPrc {
    public static boolean palin(String s){
        int i=0, j=s.length()-1;
        while(i<j){
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i< j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
    public static String reverseWords(String s ){
        String str[] = s.split(" ");
        String a = "";
        for(int i=str.length-1; i>=0; i--){
            a+=str[i]+" ";
        }
        a = a.trim();
        return a;
    }   
    public static int homogenous(String s ){
        int res =0;
        int j=0;
        for(int i=1; i<s.length(); i++){
            res++;
            if(s.charAt(i) != s.charAt(j)){
                j=i;
            }else{
                int st = i-j;
                res+= (res+st);
            }
        }
        return res;
    }
    public static List<List<Integer>> pascal(int n){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j=1; j<i; j++){
                int val = ans.get(i-1).get(j-1) + ans.get(i-1).get(j);
                row.add(val);
            }
            if(i>0) row.add(1);
            ans.add(row);
        }
        return ans;
    }
    public static boolean typeName(String real, String fake){
        int i=0, j=0;
        while(j<fake.length()){
        if(i<real.length() && real.charAt(i) == fake.charAt(j)){
            i++;
        }else if(j==0 || fake.charAt(j) != fake.charAt(j-1)){
            return false;
        }
        j++;
        }
        return i==real.length();
    }
    public static void main(String[] args) {
        String s = "My name is Prem Sharma";
      //  System.out.println(reverseWords(s));
        // System.out.println(pascal(5));

        System.out.println(typeName("Prem","Premmm"));
    }
}
