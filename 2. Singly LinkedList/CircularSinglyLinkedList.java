import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {

    //creating instance variables
    private ListNode last;      //get the record
    private int length;         //hold size

    private static class ListNode{

        private ListNode next;
        private final int data;

        public ListNode(int data){

            this.data = data;

        }
    }

    public CircularSinglyLinkedList(){

        last = null;
        length = 0;

    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void createlist(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(4);
        ListNode fourth = new ListNode(8);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        //can't assign static data for the list so making a contructor to resolve this issue
        last = fourth;

    }

    //printing the list
    public void display(){

        if(last == null){
            return;
        }

        ListNode first = last.next;

        while(first != last){

            System.out.print(first.data + "-->");
            first = first.next;

        }
        System.out.print(first.data);
        System.out.println();
    }

    //insertion at beginning

    public void insertatfirst(int value){

        ListNode temp = new ListNode(value);

        //if it's empty
        if(last == null){
            last = temp;
        }
        else{
            temp.next = last.next;
        }
        last.next = temp;
        length++;
    }

    //insertion at the end

    public void insertatlast(int value){

        ListNode temp = new ListNode(value);

        if(last == null){
            last = temp;
            last.next = last;
        }
        else{

            temp.next = last.next;
            last.next = temp;
            last = temp;

        }
        length++;
    }

    //deletion at beginning
    //it can be of listnode return type as well as integer return type

    int deleteatfirst(){
        if(isEmpty()){

            throw new NoSuchElementException("Circular Singly Linked List is already empty.");

        }

        ListNode temp = last.next;      //assigning value to first node
        int value = temp.data;

        if(last.next == last){
            last = null;
        }
        else{
            last.next = temp.next;
        }
        temp.next = null;
        length--;

        return value;

    }

    //deletion at last

    int deleteatlast() {
        if (isEmpty()) {

            throw new NoSuchElementException("Circular Singly Linked List is already empty.");

        }
        ListNode temp = last;
        while(last.next != temp){

            last = last.next;

        }
        last.next = temp.next;
        temp.next = null;
        length--;

        return temp.data;

    }


    public static void main(String[] args) {

        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();

        //can't assign static data for the list so making a contructor to resolve this issue

        csll.createlist();
        csll.display();

        //calling the function
        csll.insertatfirst(69);
        csll.insertatfirst(76);
        csll.display();

        //calling the fucntion
        csll.insertatlast(39);
        csll.display();

        //calling delete function
        //csll.deleteatfirst();
        System.out.println("Deleted first element that is: "+csll.deleteatfirst());
        csll.display();

        //calling the delete last function
        //csll.deleteatlast();
        System.out.println("Deleted last element that is: "+csll.deleteatlast());
        csll.display();

    }
}
