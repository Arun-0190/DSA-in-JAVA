
class ListNode {
    int data;
    ListNode next;

    // Constructor to initialize the node with data
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// Singly linked list class
class Singlylinkedlist {
    ListNode head;

    // Function to reverse the linked list
    public ListNode reverselist(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode next;

        while (current != null) {
            next = current.next;      // Save the next node
            current.next = previous;  // Reverse the link
            previous = current;       // Move previous ahead
            current = next;           // Move current ahead
        }
        return previous;  // Return the new head (previous)
    }

    // Function to display the linked list
    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    //insert in sorted done here

    public ListNode insertinsorted(int value){
            
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

    //checking the existence of loop

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

        public void Removingloop(){

            ListNode fastptr = head;    //traverses two values at a time
            ListNode slowptr = head;   //traverses only one value at a time

            // going in a loop

            while(fastptr != null && fastptr.next != null){

                fastptr = fastptr.next.next;
                slowptr = slowptr.next;

                //check the condition

                if(slowptr == fastptr){

                    removeloop(slowptr);
                    return;

                }

            }
            //exit the loop
    

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
    //would be run and executed in this list

    public static ListNode merging(ListNode a, ListNode b){

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

    
    
}


public class Linkedlistreversed {
    public static void main(String[] args) {
        // Create a new linked list
        Singlylinkedlist sll = new Singlylinkedlist();
        Singlylinkedlist sll2 = new Singlylinkedlist();
        sll.head = new ListNode(1);
        ListNode second = new ListNode(8);
        ListNode third = new ListNode(10);
        ListNode fourth = new ListNode(11);
        ListNode fifth = new ListNode(34);
        ListNode sixth = new ListNode(69);
        ListNode seventh = new ListNode(71);
        //ListNode eight = new ListNode(87);

        // Connect nodes together
        sll.head.next = second;   // 10 --> 1
        second.next = third;      // 10 --> 1 --> 8
        third.next = fourth;      // 10 --> 1 --> 8 --> 11 --> null
        fourth.next = fifth; 
        fifth.next = sixth; 
        sixth.next = seventh; 
        //seventh.next = eight; 
        //eight.next = fourth; 
        //inserting in a sorted list here 

        sll2.head = new ListNode(2);
        ListNode second2 = new ListNode(3);
        ListNode third2 = new ListNode(22);
        ListNode fourth2 = new ListNode(31);
        ListNode fifth2 = new ListNode(56);
        
        sll2.head.next = second2;   // 10 --> 1
        second2.next = third2;      // 10 --> 1 --> 8
        third2.next = fourth2;      // 10 --> 1 --> 8 --> 11 --> null
        fourth2.next = fifth2;
        

        //sll.insertinsorted(11);

        

        
        // Display the original linked list
        //System.out.println("The original linked list is: ");
        //sll.display(sll.head);


        // Reverse the linked list
        //ListNode reversedHead = sll.reverselist(sll.head);

        // Display the reversed linked list
        //System.out.println("The reversed linked list is: ");
        //sll.display(reversedHead);

        //calling the loop check and loop start here

        System.out.println(sll.checkloop());

        //calling method for start of loop

        //System.out.println(sll.getstartloop().data);

        //removing the loop function calling 
        
        //sll.Removingloop();
        sll.display();
        System.out.println();
        sll2.display();

        Singlylinkedlist result = new Singlylinkedlist();
        
        //result.head = merging(sll.head,sll2.head);
        //done in the other list some problems here
        
        
    }
}
