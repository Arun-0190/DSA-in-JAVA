public class MergingSortedArrays {

    //Merging the arrays
    public static void MergeArrays(int[] arr1, int[] arr2){

        int n = arr1.length;
        int m = arr2.length;
        int[] result = new int[m+n];                //result array of size m+n
        int i = 0; int j = 0; int k = 0;                            //3 pointers

        while(i<n && j<m){

            if(arr1[i] < arr2[j]){

                result[k] = arr1[i];
                i++;                    //if arr1 element is lesser

            }else{
                result[k] = arr2[j];
                j++;                //if arr 2 element is lesser

            }
            k++;                    //k index also increases as the space is filled

        }

        ///if any of the array pointer goes out of bounds
        while(i < n){

            result[k] = arr1[i];
            i++;k++;

        }

        while(j < m){
            result[k] = arr2[j];
            j++;k++;
        }

        print(result);

    }


    public static void print(int[] arr){
        System.out.print("Array is: ");
        for(int i = 0; i< arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
        System.out.println();               //leaving a line
    }

    public static void main(String[] args) {
        int[] matrix1 = {7,19,35,37,49,57,69,99};
        print(matrix1);
        int[] matrix2 = {2,5,9,13,19,22,36,89};
        print(matrix2);
        System.out.print("Merged Array is: ");
        MergeArrays(matrix1, matrix2);

    }

}
