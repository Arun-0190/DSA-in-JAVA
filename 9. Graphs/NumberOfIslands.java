public class NumberOfIslands {

    //For calculating the number of islands in a 2-D matrix having 1's as lands and 0's as water (the diagonal elements won't be counted

    public int NumIslands(char[][] grid){

        int m = grid.length;                //getting the number of rows
        int n = grid[0].length;             //getting the number of columns

        //making a boolean array for keeping track of visited islands
        boolean[][] visited = new boolean[m][n];                        //same size as original grid

        //for keeping the count og number of islands
        int Num_of_Islands = 0;

        //starting the loop for visiting all the element
        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                //base case for not visiting already visited elements and 0's
                if(!visited[i][j] && grid[i][j] == '1'){

                    //passing the element for recursive dfs method for it's adjacent elements checking
                    dfs(grid, i, j, visited);

                    //incrementing the number of islands as it increased
                    Num_of_Islands++;

                }

            }

        }

        //returning the number of islands
        return Num_of_Islands;

    }


    //method for the recursive tracking of the 1's adjacent to the given key element and around it's neighbours too except diagonals
    private void dfs(char[][] grid, int row, int col, boolean[][] visited) {

        //base case to return       (row is i and column count is j)
        /*
        either row or column index is less than 0 or row or column index is greater than the length of grid
        or if it is already visited or if we find water that is 0
         */
        if( row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] == '0'){

            return;

        }

        //marking the element as visited
        visited[row][col] = true;

        //recursing the same function for the all direction checking
        dfs(grid, row, col-1, visited);                     //for left

        dfs(grid, row-1, col, visited);                     //for up

        dfs(grid, row, col+1, visited);                     //for right

        dfs(grid, row+1, col, visited);                    //for down

    }

    //for printing the char array
    public void print(char[][] grid){

        int m = grid.length;
        int n = grid[0].length;
        System.out.print("{ ");
        for(int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j]+"  ");
            }
            System.out.println();
            System.out.print("  ");
        }
        System.out.print("}");

    }


    public static void main(String[] args) {

        //sample input grid
        char[][] grid = {
                {'1', '1', '0', '0', '1'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '1', '0'},
                {'1', '1', '0', '1', '1'}
        };

        //creating an object of NumberOfIslands
        NumberOfIslands solution = new NumberOfIslands();

        //printing the grid
        System.out.println("Grid is:");
        solution.print(grid);

        //getting the number of islands
        int numOfIslands = solution.NumIslands(grid);

        //output the result
        System.out.println("\n\nNumber of Islands: " + numOfIslands);

    }

}
