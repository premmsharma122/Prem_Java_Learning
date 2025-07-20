import java.util.*;
public class Array_list_intro {
    public static void main(String[] args) {
        // Syntax

        ArrayList<Integer> a1 = new ArrayList<>(); // Here integer is a class for int values.
        // // Differnet Types of Lists.
        // ArrayList<String> a2 = new ArrayList<>();
        // ArrayList<Boolean> a3 = new ArrayList<>();

        // Adding elements in integer List.
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(4);

        // here we can pass index with add eg.
        a1.add(1, 100); // 100 will come on index 1 and previous value at index 1 will shiftt back.
        //Printing the list.
        System.out.println(a1);

        // Getting element from any indexes in Integer List.
        System.out.println(a1.get(1)); // here we pass index of List.

        //delet element from any index
        a1.remove(2); // here we pass index.
        System.out.println(a1);

        // set OR update value at index.
        a1.set(1, 10); // here -> (index, value)
        System.out.println(a1);

        //checking existence of a value
        System.out.println(a1.contains(23)); // false bcoz a1 list does not containes 23 value.
        System.out.println(a1);

        //Find size of list
        System.out.println(a1.size()); //4

        //printing all elements w/o a list formate

        for(int i=0; i<a1.size(); i++){
            System.out.print(a1.get(i)+" "); // formate -> 1 10 3 4 
        }
    }

}
