import java.util.HashMap;

public class Fib {
    public int recFib(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return recFib(n - 1) + recFib(n - 2);
        }
    }

    // dynamic programming refers to overlapping subproblems
    public int memFib(int n, HashMap<Integer, Integer> memo) {
        // if value already found, return it
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        // original base case
        if (n <= 2) {
            return 1;
        }
        // else, store the results in the memo
        memo.put(n, memFib(n - 1 , memo) + memFib(n - 2, memo));
        return memo.get(n);
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);

        Fib obj = new Fib();
        // System.out.println(obj.recFib(6);

        HashMap<Integer, Integer> memo = new HashMap<>();
        System.out.println(obj.memFib(6, memo));
        System.out.println(obj.memFib(30, memo));
    }
}