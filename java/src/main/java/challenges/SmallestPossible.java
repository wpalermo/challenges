package challenges;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * An array of size n (with n large enough) of positive integers was given.
 *
 * 1) Given an integer k, create a function that searches if k belongs to the array.
 * Example) [6, 2, 1, 7] (2) --> true
 *
 *
 * 2) Find the smallest positive integer that is not in the array.
 * Example) [6, 2, 1, 7] --> 3
 *     [4, 2, 5, 9] --> 1
 *     [4, 2, 1, 3] --> 5
 *
 */
public class SmallestPossible
{
    public static void main( String[] args )
    {
        System.out.println(smallestPositive(new ArrayList<>(List.of(5, 4, 3, 6, 7))));
        System.out.println(exists(List.of(5, 4, 3, 6, 7), 3));
    }


    //O(n)
    public static boolean exists(List<Integer> nums, Integer k) {
        for(Integer num : nums) {
            if(num == k) {
                return true;
            }
        }

        return false;
    }

    //O(n)
    public static int smallestPositive(List<Integer> nums) {
        nums.sort(Comparator.naturalOrder());
        if(nums.get(0) > 1) {
            return 1;
        }


        for(int i = 0; i < nums.size() - 1; i++) {
            if(nums.get(i + 1) - nums.get(i) > 1) {
                return nums.get(i) + 1;
            }
        }

        return nums.get(nums.size() - 1) + 1;
    }
}
