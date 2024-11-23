import java.util.Arrays;

public class MaxMinForm {

    /* We'll use the formulae:
       arr[i] = arr[i] + (arr[max index] % max) * max
       arr[i] = arr[i] + (arr[min index] % max) * max
     */

    public static void arrangeMaxMin(int[] arr){

        int maxidx = arr.length-1;
        int minidx = 0;
        int max = arr[maxidx] + 1;

        //traversing the loop and applying formula in the array
        for(int  i = 0; i < arr.length; i++){

            //condition for either even or odd position
            if(i%2 == 0){
                arr[i] = arr[i] + (arr[maxidx] % max) * max;
                maxidx--;               //updates the maxidx

            }else{
                arr[i] = arr[i] + (arr[minidx] % max) * max;
                minidx++;               //updates the minidx

            }

        }

        //updating the array again accordingly according to position(even or odd)
        for(int i = 0; i< arr.length; i++){

            arr[i] = arr[i] / max;

        }

    }

    public static void main(String[] args) {
        int[] array = {2,4,5,6,11,34,39,61,69,72,90};
        System.out.println("Original Sorted Array: "+ Arrays.toString(array));
        arrangeMaxMin(array);
        System.out.println("Rearranged Sorted Array: "+ Arrays.toString(array));
    }

}
