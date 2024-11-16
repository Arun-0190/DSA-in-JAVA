public class BubbleSort {

    public static void bubblesort(int[] arr){

        int n = arr.length - 1;
        boolean swapped;

        //first and outer loop for the traversing of the bubble
        for(int i = 0; i < n; i++){

            //assigning false to the swapped
            swapped = false;
            //inner loop for comparison among bubbles
            for(int j = 0; j < n-1-i; j++){
                if(arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    //if swap happened in any iteration in inner loop
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }

    }

    public static void print(int[] arr){
        System.out.print("Array is: ");
        for(int i = 0; i< arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
    }

    public static void main(String[] args) {
        int [] matrix = {23,4,5,2,7,8,19,80};
        print(matrix);
        bubblesort(matrix);
        System.out.println();
        print(matrix);

    }
}
