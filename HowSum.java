import java.util.ArrayList;
import java.util.HashMap;

public class HowSum {
    public ArrayList<Integer> recHowSum(int targetSum, ArrayList<Integer> numbers) {
        if (targetSum == 0) {
            return new ArrayList<Integer>();
        }
        if (targetSum < 0) {
            return null;
        }
        for (Integer num : numbers) {
            ArrayList<Integer> result = recHowSum(targetSum, numbers);
            if (result != null) {
                result.add(num);
                return result;
            }
        }
        return null;
    }

    public ArrayList<Integer> memHowSum(int targetSum, ArrayList<Integer> numbers, HashMap<Integer, ArrayList<Integer>> memo) {
        if (targetSum == 0) {
            return new ArrayList<Integer>();
        }
        if (targetSum < 0) {
            return null;
        }
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        for (Integer num : numbers) {
            ArrayList<Integer> result = memHowSum(targetSum - num, numbers, memo);
            if (result != null) {
                result.add(num);
                memo.put(targetSum, result);
                return memo.get(targetSum);
            }
        }
        memo.put(targetSum, null);
        return null;
    }
    public static void main(String[] args) {
        HowSum obj = new HowSum();
        ArrayList<Integer> numbers = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> memo = new HashMap<>();
        numbers.add(7);
        numbers.add(14);
        System.out.println(obj.memHowSum(300, numbers, memo));
    }
}