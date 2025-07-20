import java.util.*;

public class Array_list_Practice {
    public static void swap(ArrayList<Integer> arr, int idx1, int idx2){
        int temp = arr.get(idx1);

        arr.set(idx1, arr.get(idx2));
        arr.set(idx2, temp);

    }
    public static void main(String args[]){
        ArrayList<Integer> a1 = new ArrayList<>();
        
        a1.add(8);
        a1.add(3);
        a1.add(7);
        a1.add(9);
        a1.add(2);

        //Print Revesre list

        // for(int i=a1.size()-1; i>=0; i--){
        //     System.out.print(a1.get(i)+" ");
        // }

        //find maximum element

        // int max = Integer.MIN_VALUE;
        // for(int i=0; i<a1.size(); i++){
        //     if(max < a1.get(i)){
        //         max  = a1.get(i);
        //     }
        // }
        // System.out.println("Max Element: "+ max);

        //Swap to number of List

        // int idx1 = 1;
        // int idx2 = 2;
        // swap(a1, idx1, idx2);
        // System.out.println(a1);

        // Sort a list 
        System.out.println(a1);
        Collections.sort(a1); // sort in ascending order
        System.out.println("In Ascending order:"+a1);
        Collections.sort(a1, Collections.reverseOrder()); // sort in desending oredr.
        System.out.println("In Descending oredr:"+a1);


        
    }
}
