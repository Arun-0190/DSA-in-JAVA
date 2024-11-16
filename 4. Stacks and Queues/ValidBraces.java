import java.util.Stack;

public class ValidBraces {

    public static boolean isValid(String s) {


        Stack<Character> stack = new Stack<>();

        //traversing through the string
        for (char c : s.toCharArray()){

            //check the condition and fill the stack
            if(c == '(' || c == '{' || c == '[' ){

                //pushing in the stack
                stack.push(c);

            }
            else{

                //checking the condition if we don't get any opening bracket so the condition in false
                if(stack.isEmpty()){
                    return false;
                }
                //otherwise if not empty and we'll find the pair
                else{

                    //assigning the top variable to topmost of stack for easy access
                    char top = stack.peek();

                    //matching the bracket pair as well as order
                    //our c is now the closing braces as we are in loop and going to close the braces

                    if( (c == ')' && top == '(') || (c == '}' && top == '{') || (c == ']' && top == '[') ){
                        stack.pop();                //empty the stack
                    }
                    else{
                        return false;                   //if conditions not satisfied;
                    }
                }
            }
        }

        //checking if stack got completely empty or not
        return stack.isEmpty();

    }

    public static void main(String[] args) {

        String str = "{[{()}]}";
        System.out.println("Given string is: "+str);
        System.out.println("Valid braces: "+isValid(str));
    }
}
