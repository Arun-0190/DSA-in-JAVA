import java.util.Stack;

public class Reversestring {

    public static String reverse(String str){

        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();

        //traversing
        for(char c : chars ){
            stack.push(c);          //push c in stack

        }

        //reversing using pop
        for(int i = 0; i<str.length(); i++){

            chars[i] = stack.pop();

        }

        return new String(chars);

    }

    public static void main(String[] args) {

        String original = "Arun";
        System.out.println("Original string is: "+original);
        System.out.print("Reversed string is: ");
        System.out.println(reverse(original));
    }

}
