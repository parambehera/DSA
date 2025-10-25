class Solution {
    public int totalMoney(int n) {
       int week = n/7;
       int nextWeek =week+1;
       int day = n%7;
       int total  =0;
       while(week!=0){
        total += sum(week,7);
        week--;
       }
       total +=sum(nextWeek,day);
       return total;
    }
    public   int sum(int a,int n){
        double res = (n/2.0)*((2*a)+(n-1));
           return (int) res;
    }
}