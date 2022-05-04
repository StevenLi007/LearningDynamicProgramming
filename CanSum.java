import java.util.ArrayList;
import java.util.HashMap;

public class CanSum {
    public boolean recCanSum(int targetSum, ArrayList<Integer> numbers) {
        if (targetSum == 0) {
            return true;
        }
        if (targetSum < 0) {
            return false;
        }
        for (Integer num : numbers) {
            if (recCanSum(targetSum - num, numbers)) {
                return true;
            }
        }
        return false;
    }

    public boolean memCanSum(int targetSum, ArrayList<Integer> numbers, HashMap<Integer, Boolean> memo) {
        if (targetSum == 0) {
            return true;
        }
        if (targetSum < 0) {
            return false;
        }
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        for (Integer num : numbers) {
            if (memCanSum(targetSum - num, numbers, memo)) {
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }

    public boolean tabCanSum(int target, ArrayList<Integer> numbers) {
        // create the table and initialize with false
        ArrayList<Boolean> canSum = new ArrayList<>();
        for (int i = 0; i <= target; i++) {
            canSum.add(false);
        }
        // initialize seed value
        canSum.set(0, true);
        // go through the table and set the elements whose index can be summed to true
        for (int i = 0; i < canSum.size() - 1; i++) {
            if (canSum.get(i)) {
                for (Integer number : numbers) {
                    if (i + number < canSum.size()) {
                        canSum.set(i + number, true);
                    }
                }
            }
        }
        // the answer is stored in the element of target index
        System.out.println(canSum);
        return canSum.get(target);
    }

    public static void main(String[] args) {
        CanSum obj = new CanSum();
        ArrayList<Integer> numbers = new ArrayList<>();
        HashMap<Integer, Boolean> memo = new HashMap<>();
        numbers.add(2);
        numbers.add(1);
        // System.out.println(obj.memCanSum(300, numbers, memo));
        System.out.println(obj.tabCanSum(4, numbers));
    }
}