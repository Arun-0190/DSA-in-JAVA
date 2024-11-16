import java.util.NoSuchElementException;

public class Queue {

    //instance variables

    private ListNode front;
    private ListNode rear;
    private int length;

    //making list node for linked list
    private static class ListNode{

        private final int data;
        private ListNode next;

        ListNode(int data){

            this.data = data;
            this.next = null;
        }
    }

    //length of queue
    public int length(){

        return length;

    }

    //empty function
    public boolean isEmpty(){

        return length == 0;

    }

    //inserting in queue (Enqueue)
    public void enqueue(int value){

        ListNode temp = new ListNode(value);

        if(isEmpty()){

            front = temp;

        }
        else{
            rear.next = temp;                   //enqueuing at the end
        }
        rear = temp;
        length++;

    }

    //displaying the queue
    public void display(){

        System.out.println();
        System.out.print("Queue is: ");
        if(isEmpty()){
            return;
        }

        ListNode current = front;

        while(current != null){

            System.out.print(current.data+"-->");
            current = current.next;

        }

        System.out.println("null");

    }

    //deleting in queue
    public int dequeue(){

        if(isEmpty()){

            //throw new RuntimeException("Queue is Underflow!!!");  OR
            throw new NoSuchElementException("Queue is Empty!!");

        }

        int value = front.data;
        front = front.next;

        //for real if needed
        if(front == null){
            rear = null;
        }
        length--;
        System.out.print("Deleted value is: ");
        return value;

    }

    //seeing the first element in queue
    public int first(){

        if(isEmpty()){

            //throw new RuntimeException("Queue is Underflow!!!");  OR
            throw new NoSuchElementException("Queue is Empty!!");

        }

        System.out.print("First element is: ");
        return front.data;
    }

    //seeing the last element
    public int last(){

        if(isEmpty()){

            //throw new RuntimeException("Queue is Underflow!!!");  OR
            throw new NoSuchElementException("Queue is Empty!!");

        }

        System.out.print("Last element is: ");
        return rear.data;
    }


    public static void main(String[] args) {

        Queue queue = new Queue();
        queue.display();
        //queue.dequeue();              //showed exception
        //queue.first();
        //queue.last();

        //enqueue the elements
        queue.enqueue(79);
        queue.enqueue(89);
        queue.enqueue(69);
        queue.display();

        //dequeue the element
        System.out.print(queue.dequeue());
        queue.display();

        //seeing first and last elements
        System.out.println(queue.first());
        System.out.println(queue.last());
        System.out.println(queue.length());         //OR            System.out.println(queue.length);


    }

}
