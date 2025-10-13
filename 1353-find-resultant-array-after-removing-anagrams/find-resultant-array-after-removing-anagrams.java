class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> list = new ArrayList<>();
        int n  = words.length;
        int i =n-1;
        while(i>=1){
          String curr = words[i];
          String prev = words[i-1];
          if(isAnagram(curr,prev)){
            words[i] = "";
          }
          i--;
        }
        for(int j =0;j<n;j++){
            if(words[j]!="")list.add(words[j]);
        }
        return list;
    }

    public boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        for (int i = 0; i < n; i++) {
            char ch = s2.charAt(i);
            if(map.containsKey(ch)){
               map.put(ch, map.get(ch) - 1);
               if (map.get(ch) == 0)
                 map.remove(ch);
            }
        }
        return map.size() ==0;

    }
}