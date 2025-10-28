class Solution {
    public int numberOfBeams(String[] bank) {
        int total=0;
        int n = bank.length;
        int prevCount=0;
        int currCount=0;
        for(int i=0;i<n;i++){
            String s= bank[i];
            currCount=0;
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='1'){
                    currCount++;
                }
            }
            int localcnt = currCount*prevCount;
            total +=localcnt;
            if(currCount!=0){
                prevCount = currCount;
            }
        }
        return total;
        
    }
}