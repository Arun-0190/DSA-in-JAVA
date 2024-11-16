import java.util.EmptyStackException;

public class Stackarray {

    //creating instance variables
    private int top;
    private int[] arr;
    private char[] arr2;

    public Stackarray(int capacity){

        top = -1;
        arr = new int[capacity];                //array created of given capacity

    }

    public Stackarray(){

        this(10);                       //if capacity is not given it will assume it to be defaulted at 10

    }

    //size of the stack
    public int size(){

        return top+1;

    }

    //if array stack is empty
    public boolean isEmpty() {

        return top < 0;

    }

    //if array stack is fuul
    public boolean isFull() {

        return arr.length == size();                //can be arr.length == top+1

    }

    //pushing an element
    public void push (int value){

        if(isFull()){

            throw new StackOverflowError("Stack is Full!!");

        }

        top++;                  //traversing top
        arr[top] = value;

    }

    //popping an element
    public int pop(){

        if(isEmpty()){

            throw new RuntimeException("Stack is Empty!!");

        }

        int value = arr[top];
        top--;

        return value;

    }

    //peeking an element
    public int peek(){

        if(isEmpty()){

            throw new RuntimeException("Stack is Empty!!");

        }
        return arr[top];

    }

    //print the stack

    public void display(){

        if(isEmpty()){
            throw new RuntimeException("Stack is Empty!!");
        }
        System.out.print("Stack is: [");
        for(int i = 0; i<=top; i++){
            System.out.print(" "+arr[i] + " " );
        }
        System.out.print("]");

    }

    //main func
    public static void main(String[] args) {

        Stackarray hehe = new Stackarray(8);

        hehe.push(1);
        hehe.push(3);
        hehe.push(27);

        System.out.println(hehe.peek());
        hehe.display();

        // for string reversal
        // Stackarray <character> stack = new Stackarray<>();

    }

}
