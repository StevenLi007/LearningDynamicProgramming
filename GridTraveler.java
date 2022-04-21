import java.util.HashMap;

class GridTraveler {
    public int recGridTraveler(int rowCnt, int colCnt) {
        // Try starting from small examples
        // e.g. 1x1, 1x0, 0x1
        // These are our base cases!
        if (rowCnt == 1 && colCnt == 1) {
            return 1;
        }
        if (rowCnt < 1 || colCnt < 1) {
            return 0;
        }
        // Each move we make shrinks the available area
        // If you know the problem is recursive, try visualizing it with a tree
        return recGridTraveler(rowCnt - 1, colCnt) + recGridTraveler(rowCnt, colCnt - 1);
    }
    
    public int memGridTraveler(int rowCnt, int colCnt, HashMap<String, Integer> memo) {
        String key = String.valueOf(rowCnt) + "," + String.valueOf(colCnt);
        // are the args in my memo
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (rowCnt == 1 && colCnt == 1) {
            return 1;
        }
        if (rowCnt < 1 || colCnt < 1) {
            return 0;
        }
        memo.put(key, memGridTraveler(rowCnt - 1, colCnt, memo) + memGridTraveler(rowCnt, colCnt - 1, memo));
        return memo.get(key);
    }

    public static void main(String[] args) {
        GridTraveler obj = new GridTraveler();
        System.out.println(obj.recGridTraveler(2,3));
        System.out.println(obj.recGridTraveler(3,3));
    }
}
