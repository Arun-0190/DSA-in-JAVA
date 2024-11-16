import java.util.EmptyStackException;

public class Stacks {

    //instance variables
    private ListNode top;
    private int length;

    private static class ListNode{

        private final int data;
        private ListNode next;

        public ListNode(int data){

            this.data = data;

        }
    }

    public Stacks(){

        top = null;
        length = 0;

    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){

        return length == 0;

    }

    //inserting or pushing a value

    public void push (int value){

        ListNode temp = new ListNode(value);
        temp.next = top;
        top = temp;
        length++;

    }

    //deleting or popping the value

    public int pop(){

        int value = top.data;
        top = top.next;
        length--;

        return value;

    }

    //peeking or seeing the top element

    public int peek(){

        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;

    }

    //printing the stack

    public void display(){

        System.out.println("Stack is: ");
        while(top.next != null){

            System.out.print(top.data+"-->");
            top = top.next;

        }

        System.out.print(top.data);
        System.out.println();

    }

    public static void main(String[] args) {

        Stacks stack = new Stacks();

        //pushing the values
        stack.push(1);
        stack.push(3);
        stack.push(56);
        stack.push(69);
        stack.push(99);
        stack.push(101);

        System.out.println("Top element: " + stack.peek());

        //popping the cherry
        System.out.println("Element removed (popped): " + stack.pop());

        System.out.println("Top element: " + stack.peek());

        stack.display();

    }


}
