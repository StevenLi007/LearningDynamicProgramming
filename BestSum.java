import java.util.ArrayList;
import java.util.HashMap;

public class BestSum {
    public ArrayList<Integer> recBestSum(int targetSum, ArrayList<Integer> numbers) {
        if (targetSum == 0) {
            return new ArrayList<Integer>();
        }
        if (targetSum < 0) {
            return null;
        }
        ArrayList<Integer> shortestCombo = null;
        for (Integer num : numbers) {
            ArrayList<Integer> result = recBestSum(targetSum - num, numbers);
            if (result != null) {
                result.add(num);
                if (shortestCombo == null || result.size() < shortestCombo.size()) {
                    shortestCombo = result;
                }
            }
        }
        return shortestCombo;
    }

    public ArrayList<Integer> memBestSum(int targetSum, ArrayList<Integer> numbers, HashMap<Integer, ArrayList<Integer>> memo) {
        if (targetSum == 0) {
            return new ArrayList<Integer>();
        }
        if (targetSum < 0) {
            return null;
        }
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }

        ArrayList<Integer> shortestCombo = null;
        
        for (Integer num : numbers) {
            int remainder = targetSum - num;
            ArrayList<Integer> result = memBestSum(remainder, numbers, memo);
            if (result != null) {
                ArrayList<Integer> validCombo = result;
                validCombo.add(num);
                if (shortestCombo == null || validCombo.size() < shortestCombo.size()) {
                    shortestCombo = validCombo;
                }
            }
        }

        memo.put(targetSum, shortestCombo);
        return shortestCombo;
    }

    public static void main(String[] args) {
        BestSum obj = new BestSum();
        ArrayList<Integer> numbers = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> memo = new HashMap<>();
        numbers.add(1);
        numbers.add(2);
        // numbers.add(25);
        System.out.println(obj.memBestSum(4, numbers, memo));
    }
}