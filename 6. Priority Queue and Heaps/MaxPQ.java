public class MaxPQ {
    //we can use private if we want
    Integer[] heap;                 //declaring a heap array
    int n;

    public MaxPQ(int capacity){
        heap = new Integer[capacity+1];             //declaring an array of size 1 larger than given
        n = 0;
    }

    //for emptiness
    public boolean isEmpty(){
        return n == 0;
    }

    //for the size of array
    public int size(){
        return n;
    }

    //inserting in it
    public void insert(int x){

        //if the heap is full
        if(n == heap.length-1){
            resize(2*heap.length);
        }
        n++;                    //the start of the array adding the one place for null too
        heap[n] = x;
        swim(n);

    }

    //swimming and inserting at right place bottom up
    private void swim(int k){

        while(k > 1 && heap[k/2] < heap[k]){

            int temp = heap[k/2];
            heap[k/2] = heap[k];
            heap[k] = temp;
            k = k/2;
        }

    }

    //resizing the heap if needed
    @SuppressWarnings("ManualArrayCopy")
    private void resize(int capacity) {

        Integer[] temp = new Integer[capacity];                 //initializing according to the given capacity since we have only one array as heap we don't need to specify the array name we need to resize
        for(int i = 0; i < heap.length; i++){
            temp[i] = heap[i];
        }
        heap = temp;
    }

    //printing the heap array
    public void printMaxheap(){

        for(int i = 1; i <= n; i++){
            System.out.print(heap[i]+"  ");
        }

    }


    //delete max in max heap
    public int deleteMax(){

        int max = heap[1];      //assigning max to maximum value of heap
        //swapping it to last element
        swap(1,n);
        n--;                //shortening the size of heap, removing the maximum element
        sink(1);
        heap[n+1] = null;

        //
        if(n > 0 && (n == (heap.length - 1)/4)){                //when many of the elements in heap is deleted so it resizes the array to free up the space
            resize(heap.length/2);
        }

        return max;

    }

    //sink method in max heap
    private void sink(int k) {

        while(2*k <= n){
            //going to the left chile with j
            int j = 2*k;
            //checking if right child is there or not if yes then is it greater
            if(j < n && heap[j] < heap[j+1]){
                j++;
            }
            if(heap[k] >= heap[j]){
                break;                          //break out of loop if remaining is in order
            }
            swap(k,j);              //swapping if we get something if not break
            k = j;                  //reassigning k to it's child

        }

    }

    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }


    public static void main(String[] args) {

        MaxPQ pq = new MaxPQ(5);
        System.out.println(pq.size());
        System.out.println(pq.isEmpty());

        pq.insert(5);
        pq.insert(9);
        pq.insert(8);
        pq.insert(10);
        pq.insert(69);
        pq.insert(7);
        pq.insert(4);
        pq.insert(1);
        pq.insert(89);
        pq.insert(2);

        System.out.println(pq.size());

        pq.printMaxheap();
        System.out.println();
        pq.deleteMax();
        pq.printMaxheap();
        System.out.println();
        pq.deleteMax();
        pq.printMaxheap();

    }

}
