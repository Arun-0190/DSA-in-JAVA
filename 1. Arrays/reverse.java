public class reverse {
    public static void reverse_array(int[] nums, int start,int end){
        while(start<end){
            int temp = nums[start];                 //swapping the terms 
            nums[start] = nums[end];
            nums[end] = temp;
            start++;                                //traversing forward for start change
            end--;                                  //traversing backward for end change
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
        int[] hehe = {1,34,25,67,29,01,90};
        System.out.println("Original array is: ");
        printArray(hehe);
        int x = hehe.length;
        reverse_array(hehe, 0, x-1);            //traversing from 0 to n-1 in legth n
        System.out.println("Reverse array is: ");
        printArray(hehe);
    }
}
