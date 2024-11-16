public class InsertionSort {

    public static void insertionsort(int[] arr){

        int n = arr.length;
        for(int i = 1; i < n; i++){                 //iterating from 1st place to last place

            int temp = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > temp){                 //traversing and comparing in the sorted algo

                arr[j + 1] = arr[j];
                j--;

            }
            arr[j+1] = temp;                            //assigning the place it deserves

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
        insertionsort(matrix);
        System.out.println();
        print(matrix);

    }

}
