public class minvalue {
    
    public static int min_value(int[] arr){
        int min = arr[0];
        int x = arr.length;
        for(int i =1;i<x;i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }

    public static void print_Array(int[] array1){
        int n = array1.length;
        for(int i = 0; i<n;i++){
            System.out.print(array1[i]+"  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int [] dinging = {90,67,56,45,89,901,3,0,-1};
        System.out.println("Array is: ");
        print_Array(dinging);
        System.out.print("Minimum value is: ");
        //min_value(dinging);
        //needs the function to print

        System.out.println(min_value(dinging));
        
    }
}
