import java.util.ArrayList;
import java.util.HashMap;

public class BestSum {
    public boolean recBestSum(int targetSum, ArrayList<Integer> numbers) {
        // if (targetSum == 0) {
        //     return true;
        // }
        // if (targetSum < 0) {
        //     return false;
        // }
        // for (Integer num : numbers) {
        //     if (recCanSum(targetSum - num, numbers)) {
        //         return true;
        //     }
        // }
        return false;
    }

    public boolean memBestSum(int targetSum, ArrayList<Integer> numbers, HashMap<Integer, Boolean> memo) {
        // if (targetSum == 0) {
        //     return true;
        // }
        // if (targetSum < 0) {
        //     return false;
        // }
        // if (memo.containsKey(targetSum)) {
        //     return memo.get(targetSum);
        // }
        // for (Integer num : numbers) {
        //     if (memCanSum(targetSum - num, numbers, memo)) {
        //         memo.put(targetSum, true);
        //         return true;
        //     }
        // }
        // memo.put(targetSum, false);
        return false;
    }
    public static void main(String[] args) {
        BestSum obj = new BestSum();
        ArrayList<Integer> numbers = new ArrayList<>();
        HashMap<Integer, Boolean> memo = new HashMap<>();
        numbers.add(7);
        numbers.add(14);
        // System.out.println(obj.memCanSum(300, numbers, memo));
    }
}