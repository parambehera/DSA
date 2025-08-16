import java.util.*;

class Solution {
    static int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr); // sort arrival times
        Arrays.sort(dep); // sort departure times
        
        int i = 0, j = 0; // pointers for arr & dep
        int platforms = 0; // current platforms in use
        int maxPlatforms = 0; // maximum platforms required

        while (i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) { 
                platforms++;
                maxPlatforms = Math.max(maxPlatforms, platforms);
                i++;
            } else {
                platforms--;
                j++;
            }
        }
        return maxPlatforms;
    }
}
