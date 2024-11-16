public class SpiralPrint {

    //suppresses my data flow warnings etc.
    @SuppressWarnings("DataFlowIssue")
    public static void spiralprint(int[][] matrix, int r, int c){

        int i,k = 0, l = 0;             // i will be used for iterations, k will be for rows handling and l for columns handling

        //iterating until we complete
        while(k < r && l < c){

            //printing the first row(initial as marked by k)
            for(i = k; i<c; i++){

                System.out.print(matrix[k][i] + "  ");      //kth row and ith column going left to right

            }
            k++;                                //initial row printed so k increases

            for(i = k; i < r; i++){                 //prints from given kth row to last row with same column

                System.out.print(matrix[i][c-1] + "  ");          //prints the last (given) column

            }
            c--;                            //given column gets printed

            if(k < r){          //checks if we are printing the already printed row or not going right to left

                for(i = c-1; i >= l; i--){                  //printing the last(given) row to the assigned l value

                    System.out.print(matrix[r-1][i] + "  ");

                }
                r--;                    //printed the given row so decrease it

            }

            if(l < c){                  //same with column

                for(i = r-1; i >= k; i--){

                    System.out.print(matrix[i][l] + "  ");

                }
                l++;

            }

        }

    }


    public static void main(String[] args) {

        int[][] matrix1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        spiralprint(matrix1, 4, 4);

    }

}
