public class searchin2d {

    public static void search(int[][] matrix, int n, int x){
                            //if we use an object in main class then we don't need to use static
        int i = 0;
        int j = n-1;

        while(i < n && j >= 0){

            if(matrix[i][j] == x){
                System.out.println("Key found at: matrix["+(i+1)+","+(j+1)+"]");
                return;
            }
            if(matrix[i][j] > x){
                j--;
            }else{
                i++;
            }

        }
        System.out.println("Key not found");

    }

    public static void main(String[] args) {

        int[][] array1 = {  {11,21,31,41},
                            {20,30,40,50},
                            {30,40,50,60},
                            {40,50,60,69}};
        int n = array1.length;
        search(array1,n,69);
        //searchin2d sm = new searchin2d();
        //sm.search(array1,array1.length,69);

    }

}
