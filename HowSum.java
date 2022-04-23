import java.util.ArrayList;
import java.util.HashMap;

public class HowSum {
    public ArrayList<Integer> recHowSum(int targetSum, ArrayList<Integer> numbers) {
        if (targetSum == 0) {
            return new ArrayList<Integer>(); //how to do this in Java? if i return new array list every time it wouldnt get passed down
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
    public static void main(String[] args) {
        HowSum obj = new HowSum();
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(2);
        numbers.add(2);
        System.out.println(obj.recHowSum(7, numbers));
    }
}