class Solution {
    public long gcdSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int prefixGcd []= new int [n];
        for(int i=0;i<n;i++){
            int num = nums[i];
             max = Math.max(num,max);
             int GCD = -1;
             if(max%num==0){
                 GCD = num;
             }
             GCD = gcd(max,num);
             prefixGcd[i]= GCD;

        }
        Arrays.sort(prefixGcd);
        long res= 0;
        for(int i =0,j=n-1;i<j;i++,j--){
            int sm = prefixGcd[i];
            int lg = prefixGcd[j];
            int GCD = gcd(lg,sm);
            res +=GCD;
        }
        return res;

    }
    
    public int gcd(int a,int b){
        while(b!=0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}