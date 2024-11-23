import java.util.Arrays;

public class SquareSortedArray {

    //we'll do square of a sorted array

    public static int[] SortedSquare(int[] arr){

        int n = arr.length;
        int[] result = new int[n];          //making an array to store squares

        //two different pointers at end and start of array
        int i = 0, j = n-1;

        //traverse and fill the array
        for(int k = n-1; k >= 0; k--){

            //compare the absolute value
            if(Math.abs(arr[i]) > Math.abs(arr[j])){
                //if bigger than square and fill with ith index and increase it
                result[k] = arr[i] * arr[i];
                i++;

            }else{
                //else do the same with jth
                result[k] = arr[j] * arr[j];
                j--;
            }
        }

        return result;

    }


    public static void main(String[] args) {
        int[] array = {-20,-13,-9,-2,0,3,5,9,13,14,16,22,30};
        int[] SquaredArray = SortedSquare(array);
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Square Array: " + Arrays.toString(SquaredArray));
    }
}
