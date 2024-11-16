public class missingnumber {
    
    public static int missing_num(int[] array1){
        int x = array1.length;
        int n = x+1;
        int sum = n*(n+1)/2;

        for(int num : array1){
            sum = sum-num;
        }
        /*
         for(int i = 0; i<x ; i++){
            sum = sum - array1[i];
         }
         */

        return sum;
    }

    public static void printArray(int[] array1){
        int n = array1.length;
        for(int i = 0; i<n;i++){
            System.out.print(array1[i]+"  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        int[] hello = {1,2,3,4,5,7,8,9};
        System.out.print("Original array: ");
        printArray(hello);
        System.out.print("Missing number: "+missing_num(hello));
    }
}
