import java.util.ArrayList;
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

    public int tabFib(int idx) {
        ArrayList<Integer> fib = new ArrayList<>();
        for (int i = 0; i <= idx; i++) {
            fib.add(0);
        }
        fib.set(1, 1);
        for (int i = 0; i < idx - 1; i++) {
            fib.set(i + 1, fib.get(i + 1) + fib.get(i));
            fib.set(i + 2, fib.get(i + 2) + fib.get(i));
        }
        fib.set(idx, fib.get(idx) + fib.get(idx - 1));
        return fib.get(idx);
    }

    public static void main(String[] args) {
        // System.out.println(Integer.MAX_VALUE);

        Fib obj = new Fib();
        // System.out.println(obj.recFib(6);

        HashMap<Integer, Integer> memo = new HashMap<>();
        System.out.println(obj.memFib(6, memo));

        System.out.println(obj.tabFib(6));
    }
}