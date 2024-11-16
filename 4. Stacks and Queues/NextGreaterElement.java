import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static int[] NextGreater(int [] arr){

        //initializing a result array to store the element
        int[] result = new int[arr.length];
        //intializing a stack so that we can use it to compare and push pop easily
        Stack <Integer> stack = new Stack<>();

        //traversing from last to first
        for(int i = arr.length -1 ; i>=0 ; i--){

            //applying condition for empty and non empty stack
            if(!stack.isEmpty()){

                while(!stack.isEmpty() && stack.peek() <= arr[i]){

                    stack.pop();        //pops the top element if it's lower value

                }
            }

            if(stack.isEmpty()){

                //if it's empty that means none of the greater number is found or it's the first element
                result[i] = -1;

            }
            else{

                //if it's not empty then top of stack is the greatest next number it got
                result[i] = stack.peek();

            }

            //pushes the used value in the stack for the upcoming value comparison
            stack.push(arr[i]);

        }

        return result;

    }

    public static void main(String[] args) {

        int[] array1 = {23,45,78,21,3,5,34,89,90,32,45,56};
        System.out.println(Arrays.toString(NextGreater(array1)));
    }

}
