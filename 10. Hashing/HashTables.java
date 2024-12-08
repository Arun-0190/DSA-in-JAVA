public class HashTables {

    private final HashNode[] buckets;
    private int numOfBuckets;                   //capacity
    private int size;                           //number of key value pairs in hash table(number of hash nodes)

    //making a constructor for default and another for as given
    public HashTables(){
        this (10);                      //default capacity
    }
    public HashTables(int capacity){

        this.numOfBuckets = capacity;
        buckets = new HashNode[numOfBuckets];

    }

    //making a HashNode private class
    private static class HashNode{

        private final Integer key;                    //can be of generic type
        private String value;                   //can be of generic type
        private HashNode next;

        public HashNode(Integer key, String value){

            this.key = key;
            this.value = value;

        }
    }

    //getting the size of hash table
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //here is a hash function, we'll use modular hash function here
    public int getBucketIndex(Integer key){
        return key % buckets.length;
    }


    //to insert a key-value pair in the hash table
    public void put(Integer key, String value){

        //base case
        if(key == null || value == null){
            throw new IllegalArgumentException("Key or value provided is null!!!");
        }

        int bucketindex = getBucketIndex(key);                      //getting using hash function
        HashNode head = buckets[bucketindex];

        //searching if the similar key is there or not
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;                     //increase the size
        head = buckets[bucketindex];
        HashNode node = new HashNode(key, value);                //a new node

        node.next = head;
        buckets[bucketindex] = node;                        //inserting at the beginning o the list

    }


    //to get the value of any specific key
    public String get(Integer key){

        if(key == null){
            throw new IllegalArgumentException("Key is null!!!");
        }

        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];

        //traverse and check
        while(head != null){

            //check condition
            if(head.key.equals(key)){
                return head.value;                      //return value of found the key
            }
            head = head.next;
        }

        return null;
    }


    //algo to remove a key-value pair from the hash table
    public String remove(Integer key){

        if(key == null){
            throw new IllegalArgumentException("Key is null!!!");
        }

        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        HashNode previous = null;

        //traversing
        while(head != null){

            //checking the condition
            if(head.key.equals(key)){
                break;
            }
            //traverse previous and head
            previous = head;
            head = head.next;

        }

        //if head is null means we at last key not found
        if(head == null){ return null;}

        //decrease the size
        size--;
        if (previous != null){

            previous.next = head.next;

        }else{
            buckets[bucketIndex] = head.next;                   //means previous is null and the head is first element
        }

        System.out.print("Value removed: ");
        return head.value;
    }


    //main method
    public static void main(String[] args) {

        HashTables table = new HashTables(10);
        table.put(2,"Arun");
        table.put(211,"Tom");
        table.put(13, "Ram");
        table.put(415,"Peeps");
        table.put(345, "Shyam");
        table.put(333, "Anand");

        //print the size
        System.out.println("Size is: "+table.size());

        //getting the value of specific key
        System.out.println(table.get(2));

        //removing any key-pair
        System.out.println(table.remove(333));
        System.out.println("Size is: "+table.size());

    }
}
