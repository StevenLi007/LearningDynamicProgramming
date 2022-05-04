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

    public int tabCountConstruct(String target, ArrayList<String> words) {
        // create table and init w/ 0
        ArrayList<Integer> cnts = new ArrayList<>();
        for (int i = 0; i <= target.length(); i++) {
            cnts.add(0);
        }
        // 0th elem = 1 b/c empty string, trivial sol'n
        cnts.set(0, 1);
        // iter thru the table and check strings when elem is nonzero
        // each time a spot is reached, its val++
        for (int i = 0; i < cnts.size(); i++) {
            if (cnts.get(i) != 0) {
                for (String word : words) {
                    if (target.substring(i).indexOf(word) == 0 && i + word.length() < cnts.size()) {
                        cnts.set(i + word.length(), cnts.get(i + word.length()) + cnts.get(i));
                        System.out.println(cnts);
                    }
                }
            }
        }
        // return the val of the last elem
        return cnts.get(target.length());
    }

    public static void main(String[] args) {
        CountConstruct obj = new CountConstruct();
        ArrayList<String> words = new ArrayList<>(Arrays.asList("purp", "p", "ur", "le", "purpl"));
        HashMap<String, Integer> memo = new HashMap<>();
        System.out.println(obj.memCountConstruct("purple", words, memo));
        System.out.println(obj.tabCountConstruct("purple", words));
    }
}
