class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
           
            while (map.get(ch) > 2) {
                char lch = s.charAt(left);
                map.put(lch, map.get(lch) - 1);
                if (map.get(lch) == 0) {
                    map.remove(lch);
                }
                left++;
            }
             maxLen = Math.max(i - left+1, maxLen);
        }
        return maxLen;
    //     int sum =0;
    //     for(Map.Entry<Character,Integer> entry :map.entrySet()){
    //         if(entry.getValue()<=2){
    //             sum +=entry.getValue();
    //         }
    //    }

        // return Math.max(sum,maxLen);

    }
}