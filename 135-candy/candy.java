class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int candis []= new int [n];
        int right[]= new int [n];
        Arrays.fill(candis,1);
        for(int i=1;i<n;i++){
          if(ratings[i-1]<ratings[i]){
            candis[i] = candis[i-1]+1;
          }
        }
        Arrays.fill(right,1);
        for(int i=n-2;i>=0;i--){
         if(ratings[i+1]<ratings[i]){
            right[i] = right[i+1]+1;
         }
        }
        int sum =0;
        for(int i =0;i<n;i++){
            sum += Math.max(candis[i],right[i]);
        }
        return sum;
    }
}