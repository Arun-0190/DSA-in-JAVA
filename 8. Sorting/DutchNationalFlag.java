public class DutchNationalFlag {

    public static void DNFProblem(int[] arr){

        int i = 0;
        int j = 0;
        int k = arr.length - 1;

        //traverse
        while(i <= k){

            //for 0's
            if(arr[i] == 0){
                swap(arr, i, j);
                i++;
                j++;

            }
            else if(arr[i] == 1){
                i++;

            }
            else if(arr[i] == 2){
                swap(arr, i, k);
                k--;
            }

        }

    }

    private static void swap(int[] arr, int i, int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    //to print the array
    public static void print(int[] arr){
        System.out.print("Array is: ");
        for(int i = 0; i< arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
        System.out.println();               //leaving a line
    }


    public static void main(String[] args) {

        int[] array1 = {0,1,2,2,1,0,2,0,1,1,2,0,0,0,2,1,0,1,2};
        print(array1);          //can also use tostring method
        DNFProblem(array1);
        print(array1);

    }

}
