class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
         int cnt =numBottles;
         int empty =numBottles ;
        while(empty>=numExchange){
           cnt +=empty/numExchange; 
           int curempty = empty/numExchange;
           empty =curempty+(empty%numExchange);
        }
        return cnt;

    }
}