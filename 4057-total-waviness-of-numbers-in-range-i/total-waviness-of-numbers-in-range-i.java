class Solution {
    public int totalWaviness(int num1, int num2) {
        int n = num1;
        int res =0;
        while(n<=num2){
            int len = (n+"").length();
            int narr[]= new int [len];
            int num = n;
            int i=0;
            while(num!=0){
                int r = num%10;
                narr[i] = r;
                num/=10;
                i++;
            }
            int wavvy =0;
            for(int j=1;j<len-1;j++){
                if((narr[j]>narr[j-1] && narr[j] >narr[j+1]) ||(narr[j]<narr[j-1] && narr[j] <narr[j+1]) ){
                    wavvy++;
                }
            }
            res+=wavvy;
            n++;
        }
        return  res;
    }
}