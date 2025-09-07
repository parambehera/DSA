class Solution {
    public int[] sumZero(int n) {
        int left= 0;
        int right =0;
        int len =n;
        ArrayList <Integer> list = new ArrayList <>();
        if(n%2!=0){
            list.add(0);
            n--;
        }
        while(n!=0){
         left--;
         right++;
         list.add(left);
         list.add(right);
         n-=2;
        }
        int res[]=new int [len];
        for(int i=0;i<len;i++){
            res[i] = list.get(i);
        }
        return res;
    }
}