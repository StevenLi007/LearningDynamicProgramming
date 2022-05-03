import java.util.ArrayList;
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

    public static void main(String[] args) {
        CanConstruct obj = new CanConstruct(); 
        ArrayList<String> words = new ArrayList<>();
        HashMap<String, Boolean> memo = new HashMap<>();

        words.add("ab");
        words.add("abc");
        words.add("cd");
        words.add("def");
        words.add("abcd");
        System.out.println(obj.memCanConstruct("abcdef", words, memo));
    }
}