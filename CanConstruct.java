import java.util.ArrayList;

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

    public boolean memCanConstruct() {
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

    public static void main(String[] args) {
        CanConstruct obj = new CanConstruct(); 
        ArrayList<String> words = new ArrayList<>();
        words.add("ab");
        words.add("abc");
        words.add("cd");
        words.add("def");
        words.add("abcd");
        System.out.println(obj.recCanConstruct("abcdef", words));
    }
}