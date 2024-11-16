
public class merginglist {
    
        private ListNode head;
        
        // Initialization of structure for data and next
        private static class ListNode {
            private final int data;  // final used to avoid modifications
            private ListNode next;
    
            public ListNode(int data) {
                this.data = data;
                this.next = null; 
            }
        }
        
        // Displaying the linked list
        void display() {
            ListNode current = head;
            while (current != null) {
                System.out.print(current.data + " --> ");
                current = current.next;
            }
            System.out.println("null");
        }
        
        // Merging two sorted linked lists
        public static ListNode merge(ListNode a, ListNode b) {
            // Initialize dummy node and tail
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
    
            // Traversing and comparing nodes from both lists
            while (a != null && b != null) {
                if (a.data <= b.data) {
                    tail.next = a;  // Adding smaller element from list a
                    a = a.next;
                } else {
                    tail.next = b;  // Adding smaller element from list b
                    b = b.next;
                }
                tail = tail.next;  // Move the tail pointer forward
            }
    
            // Attach the remaining elements from the non-null list
            tail.next = (a != null) ? a : b;
    
            return dummy.next;
        }
        // adding the two singly linked list (traverses in reverse okay?)1->2->3->null+2->3->4->null = 321+432

        public static ListNode add(ListNode a, ListNode b){

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
                int z = sum%10;
                tail.next = new ListNode(z);

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



        public static void main(String[] args) {
            // Create a new linked list
            merginglist sll = new merginglist();
            merginglist sll2 = new merginglist();
            sll.head = new ListNode(1);
            ListNode second = new ListNode(8);
            ListNode third = new ListNode(0);
            ListNode fourth = new ListNode(1);
            ListNode fifth = new ListNode(4);
            ListNode sixth = new ListNode(6);
            ListNode seventh = new ListNode(7);
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
            ListNode third2 = new ListNode(2);
            ListNode fourth2 = new ListNode(6);
            ListNode fifth2 = new ListNode(5);
            
            sll2.head.next = second2;   // 10 --> 1
            second2.next = third2;      // 10 --> 1 --> 8
            third2.next = fourth2;      // 10 --> 1 --> 8 --> 11 --> null
            fourth2.next = fifth2;

            sll.display();
            sll2.display();

            //for adding the lists
            
            merginglist sum = new merginglist();

            sum.head = add(sll.head, sll2.head);

            sum.display();

            //for merging the list
            merginglist result = new merginglist();

            result.head = merge(sll.head,sll2.head);

            result.display();

        }


}
