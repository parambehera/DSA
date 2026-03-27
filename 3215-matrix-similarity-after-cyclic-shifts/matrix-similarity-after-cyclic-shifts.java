class Solution {
    public boolean areSimilar(int[][] mat, int k) {
      int col = mat[0].length;
      int mod = k%col;
      int n = mat.length;
      for(int i=0;i<n;i++){
        for(int j=0;j<col;j++){
            if(i%2==0){
                int sc = (j+mod)%col; 
                int ls = mat[i][sc];
                if(ls!=mat[i][j]){
                    return false;
                }
            }
            if(i%2!=0){
                int sc = ((j-mod)+col)%col;
                int rs =  mat[i][sc];
                if(rs!=mat[i][j]){
                    return false;
                }
            }
        }
      }
      return true;
    }
}