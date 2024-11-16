public class BinarySearch {

    public static int search(int[] arr, int key){

        int n = arr.length;
        int low = 0;                //first element
        int high = n-1;             //last element

        while(low <= high){
            int mid = (high + low)/2;
            if(arr[mid] == key){
                return mid;
            }
            if(arr[mid] < key){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }

        }

        return -1;

    }

    public static void main(String[] args) {
        int [] matrix = {2,4,7,19,56,57,78,90,99};
        System.out.println(search(matrix, 56));
    }

}
