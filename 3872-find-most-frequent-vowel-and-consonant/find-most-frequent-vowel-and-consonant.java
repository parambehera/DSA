class Solution {
    public int maxFreqSum(String s) {
        HashMap <Character,Integer> map = new HashMap <>();
       for(int i=0;i<s.length();i++){
        char ch = s.charAt(i);
        map.put(ch,map.getOrDefault(ch,0)+1);
       }
       int maxv = 0;
       int maxc =0;
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' ||ch=='u'){
                maxv =Math.max(map.get(ch),maxv);
            }else{
                maxc =Math.max(map.get(ch),maxc); 
            }
        }
        return maxc+maxv;       
    }
}