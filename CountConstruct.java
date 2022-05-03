import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CountConstruct {
    public int recCountConstruct(String target, ArrayList<String> words) {
        if (target.equals("")) {
            return 1;
        }

        int total = 0;

        for (String word : words) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                int remainingWays = recCountConstruct(suffix, words);
                total += remainingWays;
            }
        }
        return total;
    }

    public int memCountConstruct(String target, ArrayList<String> words, HashMap<String, Integer> memo) {
        if (target.equals("")) {
            return 1;
        }
        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        int total = 0;
        
        for (String word : words) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                int remainingWays = memCountConstruct(suffix, words, memo);
                total += remainingWays;
            }
        }
        memo.put(target, total);
        return total;
    }

    public static void main(String[] args) {
        CountConstruct obj = new CountConstruct();
        ArrayList<String> words = new ArrayList<>(Arrays.asList("purp", "p", "ur", "le", "purpl"));
        HashMap<String, Integer> memo = new HashMap<>();
        System.out.println(obj.memCountConstruct("purple", words, memo));
    }
}
