package challenges;


import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BinarySearch {

    @Test
    public void test() {
        Assert.assertEquals(5, binarySearch(List.of(10, 20, 30, 40, 60, 110, 120, 130, 170), 110));
    }


    public int binarySearch(List<Integer> arr, Integer target) {

        //arr.sort(Integer::compareTo);

        int start = 0;
        int end = arr.size();

        while (start != end) {
            int mid = (start + end) / 2;

            if(target == arr.get(mid)) {
                return mid;
            } else if (target > arr.get(mid)) {
                start = mid + 1;
            } else if (target < arr.get(mid)) {
                end = mid - 1;
            }
        }
        return -1;
    }
}
