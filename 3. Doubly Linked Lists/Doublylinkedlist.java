import java.util.NoSuchElementException;

public class Doublylinkedlist {

    //instance variables of head and tail
    private ListNode head;
    private ListNode tail;

    //for the length things and all
    private int length;

    private static class ListNode{

        private final int data;               //can be of public type too
        private ListNode previous;
        private ListNode next;

        public ListNode(int data){

            this.data = data;

        }

    }

    public Doublylinkedlist(){

        this.head = null;
        this.tail = null;
        this.length = 0;

    }

    public boolean isempty(){

        return length==0;   //true for 0 else false 

    }

    //length of list
        public int length(){

            return length;
        
        }

    //printing forward direction list
            public void printfor(){
                if(head == null){
                    return ;

                }
                ListNode temp = head;
                while(temp != null){

                    System.out.print(temp.data+"-->");
                    temp = temp.next;

                }
                System.out.print("null");

            }

    //print in backward direction

            public void printback(){
                if(tail == null){
                    return ;

                }
                ListNode temp = tail;
                while(temp != null){

                    System.out.print(temp.data+"-->");
                    temp = temp.previous;

                }
                System.out.print("null");
                System.out.println();

            }

    //inserting at beginning in doubly linked list

            public void insertbeg(int value){

                ListNode newnode = new ListNode(value);

                //if list is empty
                if(isempty()){
                    tail = newnode;
                }
                else{
                    head.previous = newnode;
                }
                newnode.next = head;
                head  = newnode;
                length++;

            }

    //inserting at end of the list

        public void insertend(int value){

            ListNode newnode = new ListNode(value);

            //if list is empty
            if(isempty()){
                head = newnode;
            }
            else{
                tail.next = newnode;
                newnode.previous = tail;
            }
            tail  = newnode;
            length++;

        }

    //deleting the first node
        ListNode deletefirst(){

            if(isempty()){
                throw new NoSuchElementException();
            }
            ListNode temp = head;

            if(head == tail){
                tail = null;
            }
            else{
                head.next.previous = null;
            }
            head = head.next;
            temp.next = null;
            length --;

            return temp;

        }
    //deleting the last node
        ListNode deletelast(){
            if(isempty()){
                throw new NoSuchElementException();
            }
            ListNode temp = tail;

            if(head == tail){
                head = null;

            }
            else{
                tail.previous.next = null;
            }
            tail = tail.previous;
            temp.previous = null;
            length--;

            return temp;

        }
    public static void main(String[] args) {

        Doublylinkedlist dll = new Doublylinkedlist();

        //ListNode first = new ListNode(0);

        //inserting at beginning
        dll.insertbeg(4);
        dll.insertbeg(3);
        dll.insertbeg(2);
        dll.insertbeg(1);
        dll.insertbeg(0);

        //inserting at the end of list
        dll.insertend(56);
        dll.insertend(69);
        dll.insertend(9);

        //calling the delete function
        //dll.deletefirst();                can simply be this
        //below is to make it aesthetic
        System.out.println("Deleted first node is: "+dll.deletefirst().data);

        //calling delete at last method
        //dll.deletelast();
        System.out.println("Deleted last node is: "+dll.deletelast().data);

        //printing forward and backward lists
        dll.printback();
        dll.printfor();

    }

}
