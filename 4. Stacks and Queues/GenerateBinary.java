import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenerateBinary {

    //generating n binary numbers string
    public static String[] generateBinarynumbers(int n){

        //initialise the string array
        String[] result = new String[n];

        //initializing queue of strings
        Queue <String> q = new LinkedList<>();

        //offer = enqueue and poll = dequeue
        q.offer("1");

        //traversing and updating the result
        for( int i = 0; i<n; i++){

            result[i] = q.poll();

            //enqueuing new values in queue to update
            String n1 = result[i] + "0";
            String n2 = result[i] + "1";

            //enqueue
            q.offer(n1);
            q.offer(n2);
        }

        return result;

    }

    public static void main(String[] args) {

        System.out.println();
        System.out.print("Enter the number of digits you want as binary: ");
        Scanner s = new Scanner(System.in);
        int x  = s.nextInt();
        System.out.println(Arrays.toString(generateBinarynumbers(x)));

    }

}
