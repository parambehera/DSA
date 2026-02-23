class Solution {
    public boolean hasAllCodes(String s, int k) {
        int left =0;
        int right =k-1;
        int n = s.length();
        HashSet <Integer> set = new HashSet <>();
        String max = "";
        
        while(k!=0){
            max+="1";
            k--;
        }
        int maxnum = Integer.parseInt(max,2);
       int i =0;
       while(i<=maxnum){
        set.add(i);
        i++;
       }
        while(right<n){
            String sub = s.substring(left,right+1);
            int num = Integer.parseInt(sub,2);
            if(set.contains(num)){
                set.remove(num);
            }
            right++;
            left++;
        }
        return set.isEmpty();
    }
}