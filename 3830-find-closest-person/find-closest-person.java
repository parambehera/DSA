class Solution {
    public int findClosest(int x, int y, int z) {
        int stp1 = Math.abs(x-z);
        int stp2  = Math.abs(y-z);
        if(stp1==stp2) return 0;
        if(stp1<stp2)return 1;
        return 2;
    }
}