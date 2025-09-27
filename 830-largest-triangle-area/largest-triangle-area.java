class Solution {
    public double largestTriangleArea(int[][] points) {
      double max = Double.MIN_VALUE;
      int n = points.length;
      for(int i=0;i<n;i++){
        for(int j =i+1;j<n;j++){
            for(int k=j+1;k<n;k++){
                max = Math.max(max,area(points[i],points[j],points[k]));
            }
        }
      }

      return max;
    }
    public double area (int p[],int q[],int r[]){
        return .5*Math.abs((q[0]-p[0])*(r[1]-p[1])-(r[0]-p[0])*(q[1]-p[1]));
    }
}