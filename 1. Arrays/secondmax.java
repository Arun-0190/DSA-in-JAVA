public class secondmax {

    public static int Second_Max(int [] arr){
        int max = Integer.MIN_VALUE;
        int second_max = Integer.MIN_VALUE;             //sets minimum value for max and second max
        int x = arr.length;

        for(int i = 0; i<x; i++){               //traverses in array
            if(arr[i]>max){                 //compares to max and updates the max and second max
                second_max = max;
                max = arr[i];
            }
            else if(arr[i]>second_max && arr[i] != max){
                second_max = arr[i];                        //compares to second max
            }
        }
        return second_max;
    }

    public static void printArray(int[] array1){
        int n = array1.length;
        for(int i = 0; i<n;i++){
            System.out.print(array1[i]+"  ");                   //prints array
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int [] arun = {91, 90, -1, 89, 9999, 89, 67, 9999, 999, 9991};
        System.out.print("Original array is: ");
        printArray(arun);
        System.out.print("Second max value is: ");
        System.out.println(Second_Max(arun));
    }
    
}
