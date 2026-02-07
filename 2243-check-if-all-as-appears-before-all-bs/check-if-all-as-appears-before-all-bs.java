class Solution {
    public boolean checkString(String s) {
       boolean seen = false;
       for(int i=0;i<s.length();i++){
        char ch = s.charAt(i);
        if(ch=='b'){
            seen = true;
        }
        else if (ch=='a' && seen){
            return false;
        }
       
       } 
       return true;
    }
}