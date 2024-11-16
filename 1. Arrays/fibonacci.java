public class fibonacci {

    public static int fib(int x) {
        if (x <= 0) {
            return 0;
        } else if (x == 1) {
            return 0;
        } else if (x == 2 || x == 3) {
            return 1;
        } else {
            return fib(x - 1) + fib(x - 2);
        }
    }

    public static void main(String[] args) {
        int n = 10; // Number of Fibonacci numbers to generate
        for (int i = 1; i <= n; i++) {
            int result = fib(i);
            System.out.print(result + "  ");
        }
    }

}
