public class Fib {
    public int recFib(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return recFib(n - 1) + recFib(n - 2);
        }
    }

    public static void main(String[] args) {
        Fib obj = new Fib();
        System.out.println(obj.recFib(Integer.valueOf(args[0])));
    }
}