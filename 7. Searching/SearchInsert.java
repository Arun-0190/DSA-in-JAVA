public class SearchInsert {

    public static int searchinsert(int[] arr, int key){

        int low = 0;
        int high = arr.length - 1;
        //using binary search for  O(log(n)) time complexity
        while(low <= high){

            int mid = low + (high - low)/2;
            if(arr[mid] == key){
                return mid;
            }
            if(arr[mid] > key){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }

        }
        return low;

    }


    public static void main(String[] args) {
        int [] matrix = {2,4,7,19,56,57,78,90,99};
        System.out.println(searchinsert(matrix, 100));
    }
}
