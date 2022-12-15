package challenges;

import org.junit.Assert;
import org.junit.Test;

public class JumpGame {


    /**
     * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
     *
     * Return true if you can reach the last index, or false otherwise.
     */

    @Test
    public void test() {
        //2,3,1,1,4
        //3,2,1,0,4
        Assert.assertTrue(canJump2(new int[] {2,3,0,1,4, 2,2,6,4,67,3,4,65,4,54,3,1, 1,1,1,1,1,1}));

    }

    private void jumpGame(int[] nums) {

    }

    public boolean canJump(int[] nums) {
        int last = nums.length - 1;
        int i;
        for(i = last - 1; i >= 0; i--){
            if(i + nums[i] >= last)
                last = i;
        }
        return last <= 0;
    }

    public boolean canJump2(int[] nums) {

        int n= nums.length;
         int result=0;

        for(int i=0;i<n;i++)
        {
            if(result<i)
            {
                return false;
            }
            result=Math.max(result,i+nums[i]);
        }
        return true;
    }
}
