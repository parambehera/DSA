class Solution {
    static int minJumps(int[] arr) {
        int n = arr.length;
        
        // 1. Base and Edge Cases
        if (n <= 1) return 0; // If the array has 1 or 0 elements, we're already at the end. 0 jumps needed.
        if (arr[0] == 0) return -1; // If the first element is 0, we can't move anywhere. It's impossible.

        int jumps = 0; // The total number of jumps taken.
        int i = 0;     // Our current position in the array.
        
        // 2. Main Loop: This loop continues as long as we haven't reached the end.
        // Each iteration of this while loop represents one jump.
        while(i < n){ 
            int st = arr[i]; // 'st' is the number of steps we can take from our current position 'i'.
            
            // If we land on a 0 (and it's not the last element), we are stuck.
            if(st == 0) return -1; 
            
            // 3. The Greedy Choice: Find the best next position to jump to.
            // We want to find the next index that gives us the maximum reach.
            int nexIndx = i + 1;  // 'nexIndx' will store the best index to jump to. Initialize to the next spot.
            int dis = arr[i + 1]; // 'dis' stores the maximum reach (index + value) found so far.
                                  // Initialize with the reach from the next spot.
            
            // Iterate through all possible landing spots from the current position 'i'.
            for(int j = i + 1; j <= i + st; j++){
                
                // If a potential landing spot 'j' allows us to reach the end, take this jump and return.
                // This is a crucial optimization.
                if(j >= n - 1){
                    jumps++;
                    return jumps;
                }
                
                // This is the core greedy logic. We check if jumping to 'j' gives us a better
                // future reach ('arr[j] + j') than what we've found so far ('dis').
                if(j < n && arr[j] + j >= dis){
                    nexIndx = j;        // If so, update our chosen next index.
                    dis = arr[j] + j;   // And update the best reach found.
                }
            }
            
            // 4. Perform the jump
            i = nexIndx; // Move our current position to the best next index we found.
            jumps++;     // Increment the jump counter.
        }
        
        // This return is technically reachable if the while loop condition is met in a specific way,
        // but the logic inside the loop (especially the `j >= n-1` check) ensures a return happens before this.
        return jumps;
    }
}