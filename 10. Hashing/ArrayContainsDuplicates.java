import java.util.HashSet;
import java.util.Set;

public class ArrayContainsDuplicates {

    //Function to check if an integer array contains duplicates or not? If it contains return true; if not then false
    public static boolean ContainsDuplicates(int[] nums){

        Set<Integer> set = new HashSet<>();

        //iterate over the array
        for (int i : nums) {

            if (set.contains(i)) {
                return true;                        //if found in hash set
            }

            set.add(i);                       //add the current index if not present

        }

        return false;

    }


    public static void main(String[] args) {

        int[] numbers = {24,35,67,82,12,31,4,2,90,9,67,44,5,2,1};
        int[] number = {24,35,67,82,12,31,4,2,90,9,44,5,1};
        System.out.println("Is there the duplicates: "+ContainsDuplicates(numbers));
        System.out.println("Is there the duplicates: "+ContainsDuplicates(number));

    }

}
