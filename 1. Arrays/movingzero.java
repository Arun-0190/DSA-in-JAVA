public class movingzero {
    
    public static void move_zero(int[] arr){
        int j = 0;
        int x = arr.length;
        for(int i =0; i<x; i++){
            if(arr[i]!=0 && arr[j]==0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(arr[j]!=0){
                j++;
            }
        }
    }

    public static void printArray(int[] array1){
        int n = array1.length;
        for(int i = 0; i<n;i++){
            System.out.print(array1[i]+"  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        int[] bro_move = {1,2,56,0,45,0,99,0};
        System.out.print("Original Array: ");
        printArray(bro_move);
        move_zero(bro_move);
        System.out.print("Moved zeroes array: ");
        printArray(bro_move);
        
    }
}
