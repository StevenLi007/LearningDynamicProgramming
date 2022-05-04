import java.util.ArrayList;
import java.util.Arrays;
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
                ArrayList<Integer> validCombo = new ArrayList<>();
                for (int i = 0; i < result.size(); i++) {
                    validCombo.add(result.get(i));
                }
                validCombo.add(num);
                if (shortestCombo == null || validCombo.size() < shortestCombo.size()) {
                    shortestCombo = new ArrayList<>();
                    for (int j = 0; j < validCombo.size(); j++) {
                        shortestCombo.add(validCombo.get(j));
                    }
                }
            }
        }

        memo.put(targetSum, shortestCombo);
        return shortestCombo;
    }

    public ArrayList<Integer> tabBestSum(int sum, ArrayList<Integer> nums) {
        // create table and init w/ null
        ArrayList<ArrayList<Integer>> bestSum = new ArrayList<>();
        for (int i = 0; i <= sum; i++) {
            bestSum.add(null);
        }
        // init index 0 w/ empty arr
        bestSum.set(0, new ArrayList<Integer>());
        // System.out.println(bestSum);

        // iterate thru the table, and for any non-null elem, use it as a base to add valid elem of nums to the local arr
        // when adding to the next elem, copy over how the smaller elem was made 
        for (int i = 0; i < bestSum.size() - 1; i++) {
            if (bestSum.get(i) != null) {
                for (Integer num : nums) {
                    if (i + num < bestSum.size()) {
                        ArrayList<Integer> arr = new ArrayList<>();
                        for (int j = 0; j < bestSum.get(i).size(); j++) {
                            arr.add(bestSum.get(i).get(j));
                        }
                        arr.add(num);
                        if (bestSum.get(i + num) == null || bestSum.get(i + num).size() > arr.size()) {
                            bestSum.set(i + num, arr);
                        }
                    }
                }
            }
        }
        // return the arr at the end of the table
        // System.out.println(bestSum);
        return bestSum.get(sum);
    }

    public static void main(String[] args) {
        BestSum obj = new BestSum();
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(2, 15, 25));
        HashMap<Integer, ArrayList<Integer>> memo = new HashMap<>();

        System.out.println(obj.memBestSum(100, numbers, memo));
        // System.out.println(obj.recBestSum(4, numbers));
        // System.out.println(obj.tabBestSum(8, numbers));
    }
}