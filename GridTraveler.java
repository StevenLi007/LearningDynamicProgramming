import java.util.HashMap;
import java.util.ArrayList;

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
        String invertedKey = String.valueOf(colCnt) + "," + String.valueOf(rowCnt);
        // are the args in my memo
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (memo.containsKey(invertedKey)) {
            return memo.get(invertedKey);
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

    public int tabGridTraveler(int r, int c) {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        for (int i = 0; i <= r; i++) {
            grid.add(new ArrayList<Integer>());
            for (int j = 0; j <= c; j++) {
                grid.get(i).add(0);
            }
        }
        grid.get(1).set(1, 1);
        // System.out.println(grid);
        for (int i = 0; i <= r; i++) {
            for (int j = 0; j <= c; j++) {
                if (j + 1 <= c) {
                    grid.get(i).set(j + 1, grid.get(i).get(j + 1) + grid.get(i).get(j));
                }
                if (i + 1 <= r) {
                    grid.get(i + 1).set(j, grid.get(i + 1).get(j) + grid.get(i).get(j));
                }
            }
        }
        // System.out.println(grid);
        return grid.get(r).get(c);
    }

    public static void main(String[] args) {
        GridTraveler obj = new GridTraveler();
        HashMap<String, Integer> memo = new HashMap<>();
        // System.out.println(obj.memGridTraveler(2, 3, memo));
        // System.out.println(obj.memGridTraveler(3, 3, memo));
        // System.out.println(obj.memGridTraveler(18, 18, memo));
        System.out.println(obj.tabGridTraveler(3, 3));
    }
}