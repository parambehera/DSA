class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        int n = operations.length;
        for(int i=0;i<n;i++){
            String s = operations[i];
            char oper = ' ';
            if(s.charAt(0)=='-' || s.charAt(s.length()-1)=='-'){
                oper = '-';
            }else{
                oper='+';
            }
            if(oper=='+')x++;
            else x--;
        }
        return x;
    }
}