class Solution {
    public int findContentChildren(int[] g, int[] s) {
     Arrays.sort(g);
     Arrays.sort(s);
     int m  = g.length;
     int n = s.length;
     int i=0;
     int j=0;
     int cnt=0;
     while(i<n && j<m){
        if(s[i]>=g[j]){
           i++;
           j++;
           cnt++;
        }
        else{
            i++;
        }
     }
     return cnt;
    }
}