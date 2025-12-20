class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int len = strs[0].length();
        int cnt=0;
        for(int i=0;i<len;i++){
            for(int j=0;j<n-1;j++){
                if(strs[j].charAt(i)>strs[j+1].charAt(i)){
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
}