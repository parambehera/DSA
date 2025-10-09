class Solution {
    public int lengthOfLongestSubstring(String s) {
    HashSet <Character> set = new HashSet <>();
    int n = s.length();
    int len = 0;
    int left=0;
    for(int i=0;i<n;i++){
        char ch = s.charAt(i);
        if(set.contains(ch)){
           len = Math.max(len,set.size());
           while(set.contains(ch)){
            char cl =s.charAt(left);
            set.remove(cl);
            left++;
           }
        }
        set.add(ch);
        len = Math.max(len,set.size());
    }
    return len==0 ? set.size():len;
    }
}