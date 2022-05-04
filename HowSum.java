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

    public static ArrayList<Integer> tabHowSum(int sum, ArrayList<Integer> nums) {
        // create table and init w/ null
        ArrayList<ArrayList<Integer>> howSum = new ArrayList<>();
        for (int i = 0; i <= sum; i++) {
            howSum.add(null);
        }
        // init index 0 w/ empty arr
        howSum.set(0, new ArrayList<Integer>());
        // System.out.println(howSum);

        // iterate thru the table, and for any non-null elem, use it as a base to add valid elem of nums to the local arr
        // when adding to the next elem, copy over how the smaller elem was made 
        for (int i = 0; i < howSum.size() - 1; i++) {
            if (howSum.get(i) != null) {
                for (Integer num : nums) {
                    if (i + num < howSum.size()) {
                        ArrayList<Integer> arr = new ArrayList<>();
                        for (int j = 0; j < howSum.get(i).size(); j++) {
                            arr.add(howSum.get(i).get(j));
                        }
                        arr.add(num);
                        howSum.set(i + num, arr);
                    }
                }
            }
        }
        // return the arr at the end of the table
        // System.out.println(howSum);
        return howSum.get(sum);
    }

    public static void main(String[] args) {
        HowSum obj = new HowSum();
        ArrayList<Integer> numbers = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> memo = new HashMap<>();
        numbers.add(2);
        numbers.add(1);
        // System.out.println(obj.memHowSum(300, numbers, memo));
        System.out.println(obj.tabHowSum(4, numbers));
    }
}