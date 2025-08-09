import java.util.*;
class Solution {
    public int romanToDecimal(String s) {
        // code her int I= 1,V=5,X=10,L=50,C=100,D=500,M=1000;
        HashMap <Character,Integer> map = new HashMap <>();
        map.put('I',1);
         map.put('V',5); 
         map.put('X',10);
         map.put('L',50);
         map.put('C',100);
         map.put('D',500);
         map.put('M',1000);
        int sum =0;
        for(int i =0;i<s.length()-1;i++){
            char ch = s.charAt(i);
            char next = s.charAt(i+1);
            if(map.get(ch)<map.get(next)){
                sum -=map.get(ch);
            }else{
                sum += map.get(ch);
            }
        }
        sum +=map.get(s.charAt(s.length()-1));
        return sum;
    }
}