class Solution {
    public int countOdds(int low, int high) {
        int num = high-low+1;
        double d = num/2.0;
        if(low%2!=0 && high%2!=0) return (int) Math.ceil(d);
        else if(low%2==0 && high==0 )  return (int) Math.floor(d);
        return (int)d;
    }
}