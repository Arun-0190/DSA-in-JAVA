public class SelectionSort {

    public static void selectsort(int[] arr){

        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            int min = i;
            for(int j = i+1; j < n; j++) {

                if (arr[j] < arr[min]){
                    min = j;                        //assigning the min to the lower number index for swapping
                }

            }
            //swaps the minimum to index i
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;

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
        selectsort(matrix);
        System.out.println();
        print(matrix);

    }

}
