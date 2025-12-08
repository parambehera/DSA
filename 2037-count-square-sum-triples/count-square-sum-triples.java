class Solution {
    public int countTriples(int n) {
        int cnt =0;
        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                double c = Math.pow(i,2)+Math.pow(j,2);
                       double f = Math.sqrt(c);
                       int d = (int) Math.ceil(f);
                       if(f==d && d<=n){
                        cnt++;
                       }
            }
        }
        return cnt;
    }
}