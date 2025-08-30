

class Solution {
    public int celebrity(int mat[][]) {
        // code here
        int idx = -1;
        for(int i =0;i<mat.length;i++){
            int cnt =0;
            for(int j= 0;j<mat.length;j++){
                idx = i;
                if(mat[j][i]==1 && mat[i][j]==0){
                    cnt++;
                }
            }
            if(cnt == mat.length-1){
                return idx;
            }
        }
        return -1;
    }
}