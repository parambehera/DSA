class Solution {
    public int minOperations(String s) {
        char zch ='0';
        char och ='1';
        int  n = s.length();
        int zcnt=0;
        int ocnt=0;
        for(int i=0;i<n;i++){
             char curr = s.charAt(i);
             if(curr!=zch){
                zcnt++;
             }
             if(zch=='0'){
                zch='1';
             }else{
                zch='0';
             }
             if(curr!=och){
                ocnt++;
             }
             if(och=='1'){
                och='0';
             }else{
                och='1';
             }
        }

        return Math.min(zcnt,ocnt);
    }
}