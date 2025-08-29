class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt=0;
        for(int i =0;i<g.length;i++){
            for(int j=0;j<s.length;j++){
                if(s[j] !=-1 && s[j]>=g[i]){
                   s[j] = -1;
                   cnt++;
                   break;
                }
            }
        }
        return cnt;
    }
}