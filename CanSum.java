import java.util.ArrayList;
// import java.util.HashMap;

public class CanSum {
    public boolean recCanSum(int targetSum, ArrayList<Integer> numbers) {
        if (targetSum == 0) {
            return true;
        }
        if (targetSum < 0) {
            return false;
        }
        for (Integer num : numbers) {
            if (recCanSum(targetSum - num, numbers)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        CanSum obj = new CanSum();
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(4);
        numbers.add(3);
        System.out.println(obj.recCanSum(7, numbers));
    }
}
