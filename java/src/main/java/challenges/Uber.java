package challenges;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Uber {


    @Test
    public void test() {

        canConverge(0, 9);
        findConverge(new ArrayList<>(List.of(2, 1, 0, 0, 2, 2, 1)));
    }

    public int findConverge(List<Integer> nums) {

        nums.sort(Comparator.comparing(integer -> integer));

        int isConvergable = -1;
        List<Map<Integer, Integer>> foo = new ArrayList<>();
        for (int i = 0; i < nums.size() - 1; i++) {
            Map<Integer, Integer> res  = canConverge(nums.get(i + 1), nums.get(i));
            foo.add(res);

            if (isConvergable == -1) {
                return -1;
            }
        }

        return isConvergable;
    }

    public Map<Integer, Integer> canConverge(Integer num1, Integer num2) {

        for (int i = -1; i <= 1; i++) {
            int mod1 = (num1 + 10 + i) % 10;

            for (int j = -1; j <= 1; j++) {
                int mod2 = (num2 + 10 + j) % 10;
                if (mod1 == mod2) {
                    return Map.of(num1, i, num2, j);
                }
            }
        }

        return null;
    }
}
