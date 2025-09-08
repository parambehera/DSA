class Solution {
    public int[] getNoZeroIntegers(int n) {
        int i =1;
        int res []= new int [2];
        while(true){
            int a = i;
            int b = n-i;
            if(ni(a)&&ni(b)){
                res[0] = a;
                res[1] = b;
                return res;
            }
            i++;
        }
    }
    public boolean ni(int num){
      while(num!=0){
        int r  =num%10;
        if(r==0)return false;
        num = num/10;
      }
      return true;
    }
}