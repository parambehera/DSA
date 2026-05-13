import java.util.*;

class Solution {

    public int maximumPopulation(int[][] logs) {

        int n = logs.length;

        // each person creates:
        // [birth, +1]
        // [death, -1]
        int[][] events = new int[n * 2][2];

        int idx = 0;

        for(int[] log : logs) {

            int birth = log[0];
            int death = log[1];

            // birth event
            events[idx][0] = birth;
            events[idx][1] = 1;
            idx++;

            // death event
            events[idx][0] = death;
            events[idx][1] = -1;
            idx++;
        }

        // sort by year
        // if same year:
        // death (-1) before birth (+1)
        Arrays.sort(events, (a, b) -> {

            if(a[0] == b[0]) {
                return a[1] - b[1];
            }

            return a[0] - b[0];
        });

        int currPopulation = 0;
        int maxPopulation = 0;
        int answerYear = 0;

        for(int[] event : events) {

            currPopulation += event[1];

            if(currPopulation > maxPopulation) {

                maxPopulation = currPopulation;

                answerYear = event[0];
            }
        }

        return answerYear;
    }
}