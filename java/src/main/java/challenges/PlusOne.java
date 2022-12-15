package challenges;

import org.junit.Test;

public class PlusOne {

    @Test
    public void test() {
        int[] nums1 = new int[]{8,9,9,9};
        plusOne(nums1);
    }

    public int[] plusOne(int[] digits) {

        int move = 0;
        int[] result = new int[digits.length];

        int index = digits.length - 1;
        boolean oneAdded = false;


        while(index >= 0) {
            int res = digits[index]  + move;

            if(!oneAdded) {
                res++;
                oneAdded = true;
            }

            if(res >= 10) {
                move = res / 10;
                result[index] = res % 10;
            } else {
                result[index] = res;
                move = 0;
            }

            index--;
        }

        if(move > 0) {

            int[] result2 = new int[result.length + 1];
            result2[0] = move;
            for(int i = 0; i < result.length; i++) {
                result2[i + 1] = result[i];
            }

            return result2;

        }

        return result;
    }
}
