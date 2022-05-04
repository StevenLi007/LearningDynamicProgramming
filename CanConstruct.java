import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CanConstruct {
    public boolean recCanConstruct(String target, ArrayList<String> words) {
        if (target.equals("")) {
            return true;
        }
        for (String str : words) {
            if (target.indexOf(str) == 0) {
                // checks if str is a prefix of target
                String suffix = target.substring(str.length());
                if (recCanConstruct(suffix, words)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean memCanConstruct(String target, ArrayList<String> words, HashMap<String, Boolean> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if (target.equals("")) {
            return true;
        }
        
        for (String str : words) {
            if (target.indexOf(str) == 0) {
                // checks if str is a prefix of target
                String suffix = target.substring(str.length());
                if (memCanConstruct(suffix, words, memo)) {
                    memo.put(target, true);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean tabCanConstruct(String target, ArrayList<String> words) {
        // create table of size target.length() + 1
        ArrayList<Boolean> canConstr = new ArrayList<>();
        // init w/ F but set the 0th elem to T (empty str)
        for (int i = 0; i <= target.length(); i++) {
            canConstr.add(false);
        }
        canConstr.set(0, true);
        // iter thru the table, if word in words is valid prefix, set the corresponding elem to true
        for (int i = 0; i < canConstr.size(); i++) {
            if (canConstr.get(i)) {
                for (String word : words) {
                    if (target.substring(i).indexOf(word) == 0 && i + word.length() < canConstr.size()) {
                        canConstr.set(i + word.length(), true);
                    }
                }
            }
        }
        // return the val of the last elem
        return canConstr.get(target.length());
    }

    public static void main(String[] args) {
        CanConstruct obj = new CanConstruct(); 
        ArrayList<String> words = new ArrayList<>(Arrays.asList("e", "ee", "eee", "eeee"));
        HashMap<String, Boolean> memo = new HashMap<>();

        // words.add("ab");
        // words.add("abc");
        // words.add("cd");
        // words.add("def");
        // words.add("abcd");

        // System.out.println(obj.memCanConstruct("abcdef", words, memo));
        System.out.println(obj.tabCanConstruct("eeeeeeeeeeeef", words));
    }
}