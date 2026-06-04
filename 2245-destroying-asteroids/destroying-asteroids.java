class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long total = mass;
        for(int i=0;i<asteroids.length;i++){
            int m = asteroids[i];
            if(total>=m){
                total+=m;
            }else{
                return false;
            }
        }
        return true;
    }
}