import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {

    

        Integer[] temp = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i]; // auto-boxing happens here
        }

        Arrays.sort(temp, (a, b) -> {
            int bitCompare = Integer.bitCount(a) - Integer.bitCount(b);

            if (bitCompare == 0) {
                return a - b; // If same bit count, sort by value
            }

            return bitCompare;
        });

        // Convert back to int[]
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }

        return arr;
    }
}