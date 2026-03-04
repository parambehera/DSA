class Solution {
    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int rowsum[]= new int [n];
        int colsum [] = new int [m];
        for(int i=0;i<n;i++){
            int sum =0;
            for(int j =0;j<m;j++){
                sum+=mat[i][j];
            }
           rowsum[i] =sum;
        }
      
        for(int i=0;i<m;i++){
            int sum=0;
            for(int j=0;j<n;j++){
             sum+=mat[j][i];
            }
            colsum[i] =sum; 
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if( mat[i][j]==1 && rowsum[i]==1 && colsum[j]==1){
                    cnt++;
                }
            }
        }
        return cnt;

    }
}