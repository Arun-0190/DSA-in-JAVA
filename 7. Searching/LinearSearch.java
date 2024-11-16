public class LinearSearch {

    public static int search(int[] arr, int n, int x){

        for(int i = 0; i < n; i++){
            if(arr[i] == x){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] matrix = {23,4,5,2,7,8,19,80};
        System.out.println("Found the element at " + search(matrix, matrix.length, 19)+"th index in the array!!");
    }

}
