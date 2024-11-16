
import java.util.Scanner;

public class SinglyLinkedList {
    
private ListNode head;

    //initialization of structure for data and next
    
    private static class ListNode{
        private final int data;             //can directly be said "private int data;", final is used to ignore the yellow underline...
        private ListNode next;
    
        public ListNode(int data){
            
            this.data = data;
            this.next = null; 
    
        }
                
    }


    //displaying the linked list

    void display(){
        ListNode current = head;
        while (current != null){

            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }


    //counting the no. of elements


    public int counting(){

        //count for empty list

        if(head == null){
            return 0;
        }

        int count = 0;
        ListNode current = head;
        while(current != null){

            count++;
            current = current.next;
        }
        return count;
    }



    //insertion 

        //1. at beginning 

        public void insertbeginning(int a){

            ListNode newnode = new ListNode(a);
            newnode.next = head;
            head = newnode;

        }


        //2. at end

        public void insertend(int x){

            ListNode newnode = new ListNode(x);
            
            //comparing in an empty

            if(head==null){
                head = newnode;
                return;
            }

            ListNode current = head;

            //traversing till the null or end

            while(current.next != null){
                current = current.next;
            }
            current.next = newnode;
        }


        //3. Insertion in anywhere in between linked list

        public void insertmid(int value, int position){

            //make a new node
            ListNode node = new ListNode(value);

            if(position == 1){
                node.next = head;
                head = node;
            }
            else{

                ListNode previous = head;                           //assigning the head for previous
                int count = 1;

                while(count < position-1){

                    previous = previous.next;                       //next value
                    count++;                                        //traverse

                }

                //assigning the next node to a new current node
                ListNode current = previous.next;                       //initial value of previos.next will be stored in current node

                //assigning the next pointer of node to current
                node.next = current;

                //pointing the previous.next to newer node
                previous.next = node;

            }

        }


    //Deletion in a Linked List

        //1. Deletion at beginning

        ListNode deletefirst(){

            //comparing for the empty list

            if(head == null){
                return null;
            }

            //for non-empty

            ListNode temp = head;

            // can't write this it will delete the remaining nodes head.next = head;
            
            head = head.next;
            temp.next = null;

            return temp;
        }

        //2. Deletion at the end or last

        ListNode deletelast(){
            
            if(head==null || head.next == null){                //comparing the first to null if it is only one element or not

                return head;

            }

            ListNode current = head;
            ListNode previous = null;

            while(current.next != null){
                previous = current;
                current = current.next;
            }

            previous.next = null;
            return current;

        }


        //3. Delete a node from a given position (in middle)

        public void deletemid(int position){

            //compares the first position and deletes

            if(position ==1){
                head = head.next;
            }

            //any other position in the linked list

            else{

                //assigns a pointer 

                ListNode previous = head;
                int count = 1;

                //traverses to the position needs to be deleted

                while(count < position-1){

                    previous = previous.next;                   //traverses forward
                    count++;
                }

                //assigns next of previous to current named temporary node

                ListNode current = previous.next;
                
                //assigns the next node of current to the link the next value of previous and then current gets removed from list
                previous.next = current.next;
            }
        }


    // Searching in the Linked list

        //1.

        public boolean search(int x){
            
            //assigning to the head a temporary node address

            ListNode current = head;

            // iterating
            while(current != null){

                if(current.data == x){

                    return true;
                }

                //traversing
                current = current.next;

            }

            return false;                   // searched value isn't in linked list

        }


    // Reversing the linked list
        //executed in diffenrent file named linkedlistreversed

        ListNode reverselist(ListNode head){
        
            ListNode current = head;
            ListNode previous = null;
            ListNode next=null;

         while(current != null){

                next = current.next;                          // next value of head
                current.next = previous;                     //null
                previous = current;                         // assigning previous to current
                current = next;                            // assigning current to next

            }

            return previous;                                //returning the previous node

        }


    // searching nth node from last of the linked list

        ListNode lastsearch(int n){

            if(head == null){

                return null;                            // if list is empty

            }

            if(n <= 0){
                throw new IllegalArgumentException("Invalid value n = "+n);             // if n is less than 0
            }
        
            ListNode mainptr = head;                //initialising a main ptr 
            ListNode refptr = head;                 //intialising a reference pointer

            int count = 0;

            while(count<n){

                if(refptr == null){

                    throw new IllegalArgumentException(n + " is greater than the number of nodes!!");      // entered n is larger than the number of nodes in list 

                }

                refptr = refptr.next;
                count++;

            }

            while(refptr != null){

                mainptr = mainptr.next;
                refptr = refptr.next;

            }

            return mainptr;

        }

    // Deleting the duplicates from the sorted linked list

        public void duplicates(){

            ListNode current = head;

            while(current != null && current.next != null){

                if(current.data == current.next.data){

                    current.next = current.next.next;
                }

                else {
                    current = current.next;
                }
            }
        }

    //Inserting a node in a sorted linked list

        //executed in different file maybe second one

        ListNode insertinsorted(int value){
            
            ListNode newnode = new ListNode(value);
            
            //if there is an empty list
            if(head == null){

                return newnode;

            }

            ListNode current = head;
            ListNode temp = null;

            while (current != null && current.data < newnode.data){

                temp = current;
                current = current.next;

            }

            newnode.next = current;
            temp.next = newnode;
            
            return head;

        }

    
    //deleting a given key from the linked list

        public void removekey(int value){

            ListNode current  = head;
            ListNode temp = null;

            //if it is first key

            if(current != null && current.data == value){

                head  = current.next;
                return;

            }

            //traversing to the key

            while(current != null && current.data != value){

                temp = current;
                current = current.next;

            }

            //if it is last key

            if(current == null) {
             
                return;
            
            }

            temp.next = current.next;

        }

    //Checking the loop in a linked list

        public boolean checkloop(){
            
            ListNode fastptr = head;    //traverses two values at a time
            ListNode slowptr = head;   //traverses only one value at a time

            // going in a loop

            while(fastptr != null && fastptr.next != null){

                fastptr = fastptr.next.next;
                slowptr = slowptr.next;

                //check the condition

                if(slowptr == fastptr){

                    return true;

                }

            }
            //exit the loop
            
            return false;

        }


    //get the start node of the loop
    //done and executed in the second code thanku


        public ListNode getstartloop(){

            ListNode fastptr = head;    //traverses two values at a time
            ListNode slowptr = head;   //traverses only one value at a time

            // going in a loop

            while(fastptr != null && fastptr.next != null){

                fastptr = fastptr.next.next;
                slowptr = slowptr.next;

                //check the condition

                if(slowptr == fastptr){

                    return getstartnode(slowptr);

                }

            }
            //exit the loop
        
            return null;

        }

        //Floyd's cycle detection algorithm

        ListNode getstartnode(ListNode slowptr){
            
            ListNode temp = head;
            
            //traverse the loop
        
            while(temp != slowptr){
            
                temp = temp.next;       // temp moving and getting the value
                slowptr = slowptr.next;
            
            }
            
            return temp;
        
        }

    
    //Removing the loop from the linked list

        //getting the loop
        //executed and run in secondary list

        public ListNode Removingloop(){

            ListNode fastptr = head;    //traverses two values at a time
            ListNode slowptr = head;   //traverses only one value at a time

            // going in a loop

            while(fastptr != null && fastptr.next != null){

                fastptr = fastptr.next.next;
                slowptr = slowptr.next;

                //check the condition

                if(slowptr == fastptr){

                    return getstartnode(slowptr);

                }

            }
            //exit the loop
    
            return null;

        }

        //removing the loop

        public void removeloop(ListNode slowptr){
            ListNode temp = head;

            //traverse
            while(slowptr.next != temp.next){

                temp = temp.next;
                slowptr = slowptr.next;

            }

            slowptr.next = null;
        }
    
    
    // Merging two sorted linked list together
    //would be run and executed in other list

        ListNode merge(ListNode a, ListNode b){

            // initialize tail and dummy

            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;

            //traversing and comparing in the node

            while(a != null && b != null){

                //if list a's element is smaller than

                if(a.data <= b.data){

                 //adding behind the tail in the dummy list
                    tail.next = a;
                 //upadating or the a linked list forward to next pointer that is a now
                    a = a.next;

                }

               //if list b's is smaller

               else{

                   tail.next = b;
                   b = b.next;

                }

                //moving tail to the next pointer in the dummy node that is now a or b

                tail = tail.next;

            }

            //after reaching the null in any list

            //if it's in a

            if(a == null){

               tail.next = b;

            }
            else{

               tail.next = a;

            }

            return dummy.next;
        }

    // adding the two singly linked list (traverses in reverse okay?)1->2->3->null+2->3->4->null = 321+432
        //code executed in merging lists file
        
        ListNode add(ListNode a, ListNode b){

            //initialize tail and dummy list nodes
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            
            //variable for carry
            int carry = 0;

            //traversing in loop till null
            while(a != null || b != null){

                //if a is not null then a's value similar with b else 0
                
                int x = (a != null)? a.data :0;
                int y = (b != null)? b.data :0;

                //doing the sum 
                int sum = carry+x+y;

                //calculating the carry
                carry = sum/10;

                //updating the dummylist by sum%10 
                tail.next = new ListNode(sum%10);

                //traversing tail to next pointer
                tail = tail.next;

                //updating a and b
                if(a != null) a = a.next;
                if(b != null) b = b.next;


            }
            //if the carry is still at the end then add it in new node
            if(carry>0){

                tail.next = new ListNode(carry);

            }
            //returning the dummy.next for eleminating 0 at start
            return dummy.next;
            
        }

    //main code here below

    public static void main (String[] args) {
        
        //declaration of new linked list

        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(10);    
        ListNode second = new ListNode(1);     
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);
    
        //connecting them together in a chain
    
        sll.head.next = second;         //10 -->1
        second.next = third;            // 10 --> 1 --> 8
        third.next = fourth;            // 10 --> 1 --> 8 -->11 -->null

        //insertion at beginning function calling

        sll.insertbeginning(100);
        sll.insertbeginning(105);
        sll.insertbeginning(105);
        sll.insertbeginning(100);

        //insertion at end function calling

        sll.insertend(45);
        sll.insertend(78);
        sll.insertend(105);
        sll.insertend(105);
        sll.insertend(49);
        sll.insertend(12);

        //insertion in the beginning function calling buddy

        sll.insertmid(39, 4);
        sll.insertmid(69, 7);
        sll.insertmid(001,1);
        sll.insertmid(99, 12);
        sll.insertmid(105,6);

        //calling the function insertinsorted it should add 101 in between 100 and 105 nodes

        sll.insertinsorted(11); // this will get inserted at the beginning
        sll.insertinsorted(101);// //this should do the job

        //this function has been applied and worked perfectly in the secondary program of singly linked list

        //deleting in the beginning function calling

        /*
        System.out.println();                               //making just spacings
        sll.deletefirst();
        System.out.println("First node has been deleted !!");
        */
        //to make everything at one use .data
        System.out.println("Deleted first node is: "+sll.deletefirst().data);

        //deletion at last function calling 

        System.out.println("Deleted last node is: "+sll.deletelast().data);
        System.out.println("Deleted last node is: "+sll.deletelast().data);

        //deletion in middle function calling
        sll.deletemid(4);


        //printing
        System.out.println();                       //just for better view in output
        System.out.println("The linked list is: ");
        sll.display();
        System.out.println();
        
        //printing number of elements

        System.out.println("Length of Linked List is: "+sll.counting());
        System.out.println();

        //taking user input for searching
        Scanner x = new Scanner(System.in);
        System.out.print("Enter a number for searching: ");
        int y = x.nextInt();

        //calling the searching function

        // System.out.println(sll.search(y));                   //can call like this

        if(sll.search(y)){

            System.out.println("Search key found!!");

        }
        else{
            System.out.println("Search key not found!!");
        }

        //searching nth node from last

        System.out.print("Enter the number of node from last for searching: ");

        int z = x.nextInt();

        System.out.println(z+"th node from end is: "+sll.lastsearch(z).data);

        sll.duplicates();
        sll.display();

        sll.removekey(45);      //removed the node 45 from the list
        sll.display();
        System.out.println("Loop exists: "+ sll.checkloop());
        
    
    }

}
