import java.util.ArrayList;
public class MergeSort {

    public static void MSort(int [] arr, int[] temp, int low, int high){

        if(low < high) {                //base case
            //get the mid
            int mid = low + (high - low) / 2;               //to prevent the overflow of (low + high)/2

            //recursively calling the function for breaking it in two parts and then merging it
            MSort(arr, temp, low, mid);

            MSort(arr, temp, mid + 1, high);

            merge(arr, temp, low, mid, high);

        }
    }


    //to merge the array
    private static void merge(int arr[], int[] temp,int low, int mid, int high){

        //copy the element into the temp array for easier comparison
        for(int i = low; i <= high; i++){

            temp[i] = arr[i];

        }
        int i = low;            //low index in temp array
        int j = mid + 1;        //right part of comparison in the temp array
        int k = low;            //index in the original aray for comparison and placement of lower value

        //running the loop for the comparison and replace the element from temp to main
        while(i <= mid && j <= high){

            //condition for the comparison
            if(temp[i] <= temp[j]){

                arr[k] =temp[i];
                i++;                //increase the index for comparison

            }
            else{

                arr[k] = temp[j];
                j++;

            }
            k++;                //increase the index in the main array

        }

        //for the remaining elements that are left copying
        while( i <= mid){
            arr[k] = temp[i];
            i++;
            k++;

        }

    }

    public static void print(int[] arr){
        System.out.print("Array is: ");
        for(int i = 0; i< arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
        System.out.println();               //leaving a line
    }

    public static void main(String[] args) {
        int[] matrix = new int[] {7, 19, 35, 37, 49, 57, 69, 99, 2, 5, 9, 13, 19, 22, 36, 89};
        int[] temp = new int[matrix.length];
        print(matrix);
        /*
        MergeSort ms = new MergeSort();

        ms.print(matrix);
        ms.MSort(matrix, temp, 0, matrix.length );
         */
        //could be done in 2 ways again needs static functions in second
        MSort(matrix, temp, 0, matrix.length-1);                    //length - 1 so that it doesn't show out of bounds
        print(matrix);

    }
}
