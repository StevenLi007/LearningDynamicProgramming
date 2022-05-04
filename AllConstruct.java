import java.util.ArrayList;
import java.util.Arrays;

public class AllConstruct {
    public ArrayList<ArrayList<String>> recAllConstruct(String target, ArrayList<String> words) {
        // empty str = valid combo
        if (target.equals("")) {
            return new ArrayList<ArrayList<String>>();
        }
        // return var storing all combos
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        // try out diff paths in words
        for (String word : words) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                ArrayList<ArrayList<String>> suffixWays = recAllConstruct(suffix, words);
                for (ArrayList<String> arr : suffixWays) {
                    arr.add(word);
                    result.add(arr);
                }
            }
        }
        return result;
    }

    public ArrayList<ArrayList<String>> memAllConstruct(String target, ArrayList<String> words) {
        return null;
    }

    public static void main(String[] args) {
        AllConstruct obj = new AllConstruct();
        ArrayList<String> words = new ArrayList<>(Arrays.asList("purp", "p", "ur", "le", "purpl"));
        System.out.println(obj.recAllConstruct("purple", words));
    }
}

/**
 * why I'm stuck:
 * - implementing 2D arrays in Java and how to update it and how the references go 
 *   (i.e. if I'm updating the right array)
 */