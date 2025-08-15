class Solution {
    public int minDeletions(String s) {
        HashMap <Character,Integer> map = new HashMap <>();
        int n = s.length();
        for(int i =0;i<n;i++){
            char ch = s.charAt(i);
          map.put(ch,map.getOrDefault(ch,0)+1);
        }
        ArrayList <Integer> freq = new ArrayList <>();
        HashSet <Integer> set = new HashSet<>();
       for (int val : map.values()) {
    freq.add(val);
}
        // Collections.sort(freq);
        int cnt =0;
        for(int i=0;i<freq.size();i++){
            int currFreq = freq.get(i);
            while(set.contains(currFreq)){
                cnt++;
                currFreq--;
            }
            if(currFreq!=0){
                set.add(currFreq);
            }
        }
        return cnt;
    }
}