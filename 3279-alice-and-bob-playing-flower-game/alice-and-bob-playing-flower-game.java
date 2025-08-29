class Solution {
    public long flowerGame(int n, int m) {
      int maxSum =n+m;
    long cnt =0;
    int odd = (m%2==0?(m/2):(m/2+1));
    for(int i=1;i<=n;i++){
        if(i%2==0) cnt +=odd;
        else cnt +=m/2; 
    }
    return cnt;
    }
}