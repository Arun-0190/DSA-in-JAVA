public class print {
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
    }
}
