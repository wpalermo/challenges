package challenges;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PagBank {

    @Test
    public void testMinNum() {
        this.minNum(4, 5, 1);
    }

    @Test
    public void testPerfectTeam() {
        this.perfectTeam("pcmpp");
    }

    @Test
    public void testIsPossible() {
        this.isPossible2(1, 4, 5, 9);
    }


    public static String isPossible(int a, int b, int c, int d) {

        int resA = a;
        int resB = b;

        while(resA < c) {
            resA += b;
        }

        if(resA == c) {
            if(b == d) {
                return "Yes";
            }
            while(resB < d) {
                resB += resA;
            }

            if(resB == d) {
                return "Yes";
            }
        }

        while(resB < d) {
            resB += a;
        }

        if(resB == d) {
            if(a == c) {
                return "Yes";
            }
            while(resA < c) {
                resA += resB;
            }

            if(resA == c) {
                return "Yes";
            }
        }

        return "No";

    }

    public static String isPossible2(int a, int b, int c, int d) {
        String aStatus = "No";
        String bStatus = "No";

        aStatus = isPossible2(a + b, b, c, d);
        bStatus = isPossible2(a, b + a, c, d);


        bStatus = isPossible2(a, b + a, c, d);
        if(bStatus.equals("No")){
            return "No";
        }

        return "Yes";
    }

    public static int perfectTeam(String skills) {

        Map<Character, Integer> skillMap = new HashMap<>();

        for (int i = 0; i < skills.length(); i++) {
            skillMap.put(skills.charAt(i), skillMap.getOrDefault(skills.charAt(i), 0) + 1);
        }

        if (skillMap.size() < 5) {
            return 0;
        }

        int lowest = Integer.MAX_VALUE;
        for (Character key : skillMap.keySet()) {
            if (skillMap.get(key) < lowest) {
                lowest = skillMap.get(key);
            }
        }

        return lowest;
    }

    public static int minNum(int samDaily, int kellyDaily, int difference) {

        int samSolved = samDaily + difference;
        int kellySolved = kellyDaily;

        if (kellyDaily <= samDaily) {
            return -1;
        }

        int days = 1;
        while (kellySolved <= samSolved) {
            samSolved += samDaily;
            kellySolved += kellyDaily;
            days++;
        }

        return days;
    }
}
