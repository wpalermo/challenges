package challenges;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class Rotate {

    /**
     * Given an array, rotate the array to the right by k steps, where k is non-negative.
     */

    @Test
    public void test() {
        rotate(new int[] {1,2,3,4,5,6,7}, 3);
        rotateBruteForce(new int[] {1,2,3,4,5,6,7}, 3);
    }

    public void rotate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(Integer key : map.keySet()) {
            int newIndex = map.get(key);
            newIndex = newIndex + k;

            if(newIndex > nums.length - 1) {
                newIndex = newIndex % nums.length;
            }

            map.put(key, newIndex);
        }
        Set set = new HashSet();


        for(Integer key : map.keySet()) {
            nums[map.get(key)] = key;
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {

        }

        IntStream.range(0, 10).forEach(i -> {

        });
    }


    public void rotateBruteForce(int[] nums, int k) {
        // speed up the rotation
        k %= nums.length;
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
}
