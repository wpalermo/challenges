package challenges;

import org.junit.Test;

import java.util.*;

public class Intersect {

    @Test
    public void test() {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};

        intersect2(nums1, nums2);
    }


    public int[] intersect(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet();

        Map<Integer, Integer> map1 = new LinkedHashMap<>();
        Map<Integer, Integer> map2 = new LinkedHashMap();

        for(Integer i : nums1) {
            map1.put(i, map1.get(i) == null ? 1 : map1.get(i) + 1);
        }

        for(Integer i : nums2) {
            map2.put(i, map2.get(i) == null ? 1 : map2.get(i) + 1);
        }

        List<Integer> result = new ArrayList();

        for(Map.Entry<Integer, Integer> entry : map1.entrySet()) {

            if(map2.containsKey(entry.getKey())) {
               int lo = entry.getValue() < map2.get(entry.getKey()) ? entry.getValue() : map2.get(entry.getKey());
               for(int i = 0; i < lo; i++) {
                   result.add(entry.getKey());
               }
            }
        }

        int[] resultVector = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            resultVector[i] = result.get(i);
        }
        return resultVector;

    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect2(nums2, nums1);
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k] = n;
                k++;
                m.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

}
