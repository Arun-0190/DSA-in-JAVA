import java.util.Arrays;

public class QuickSort {

    public static void QSort(int[] arr, int low, int high){

        //condition for the base case
        if(low < high){

            //make a pivot p
            int p = partition(arr, low, high);          //gets the current pivot position or index
            QSort(arr, low, p-1);                 //for the left side of pivot
            QSort(arr, p+1, high);                //for the right side of pivot

        }
    }

    //making the partition method
    private static int partition(int[] arr, int low, int high){

        //getting the pivot value
        int pivot = arr[high];
        int i = low;            //lower index pointer
        int j = low;            //for the comparison and swapping pointer

        //traversing the array
        while(i <= high){

            /*comparing the ith index of array to the pivot if it's lesser than
            swap to jth index(left side of array smaller ones)*/
            if(arr[i] <= pivot){

                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                //increment the j coz jth index is filled now
                j++;

            }
            //move to the next index
            i++;
        }

        //return the index at which pivot is (which is j-1) for further recursion
        return j-1;

    }

    public static void main(String[] args) {

        int[] array = {2,24,56,-3,45,89,99,45,80,69,69,-1,-23};
        System.out.println("Original Array: " + Arrays.toString(array));
        int high = array.length - 1;
        QSort(array, 0, high);
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }

}
