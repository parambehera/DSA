class Solution {
    int nx []= {0,1,0,-1};
    int ny []= {1,0,-1,0};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]!=color){
            helper(image,sr,sc,color,image[sr][sc]);
        }
        return image;
    }
    public void helper(int [][] image,int sr,int sc,int color,int ic){
     if(sr<0 || sr>=image.length||sc<0 || sc>=image[0].length ||image[sr][sc]!=ic){
        return;
     }
        image[sr][sc] = color;
       for(int i =0;i<4;i++){
        int dsr =sr+nx[i];
        int dsc = sc+ny[i];
        helper(image,dsr,dsc,color,ic);
       }
    }
}