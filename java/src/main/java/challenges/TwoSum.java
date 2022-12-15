package challenges;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * You can return the answer in any order.
     */

    @Test
    public void test() {
        //Assert.assertArrayEquals(new int[]{0,1}, twoSumBruteForce(new int[] {2,7,11,15}, 9));
        //Assert.assertArrayEquals(new int[]{0,1}, twoSumHashMap(new int[] {2,7,11,15}, 9));
        Assert.assertArrayEquals(new int[]{0,1}, twoSumTwoPointer(new int[] {2,7,11,15}, 9));

        Map map = new HashMap();map.entrySet();
    }

    public int[] twoSumBruteForce(int[] nums, int target) {
        for(int i =0; i < nums.length; i++) {
            for(int j =0; j < nums.length; j++) {
                if(i == j) {
                    continue;
                }

                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }

        }
        return null;
    }

    public int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int difference = target - num;

            if(map.containsKey(difference)) {
                return new int[]{i, map.get(difference)};
            }
        }
        return null;
    }

    public int[] twoSumTwoPointer(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int sum = nums[lo] + nums[hi];

            if(sum == target) {
                return new int[]{lo, hi};
            }

            if(sum > target) {
                hi--;
            } else {
                lo++;
            }

        }

        return null;
    }

}
