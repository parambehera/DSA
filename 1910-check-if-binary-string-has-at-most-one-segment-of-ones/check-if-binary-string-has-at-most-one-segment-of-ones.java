class Solution {
    public boolean checkOnesSegment(String s) {
        int cnt =0;
        int n =s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                cnt++;
            }
        }
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                cnt--;
            }
            else{
                break;
            }
        }
        return cnt==0;
    }
}