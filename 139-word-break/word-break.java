class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int dp[]= new int[s.length()];
        Arrays.fill(dp,-1);
        HashSet <String> set = new HashSet<>();
        for(int i =0;i<wordDict.size();i++){
            set.add(wordDict.get(i));
        } 
    return wb(s,set,0,dp);
    }
    public boolean wb(String s,HashSet <String> set ,int i,int dp[]){
        if(i==s.length()){
            return true;
        }
        if(dp[i]!=-1) {
            return dp[i]==0?true:false;
        }
        StringBuilder sb = new StringBuilder("");
        for(int j =i;j<s.length();j++){
            sb.append(s.charAt(j));
            if(set.contains(sb.toString())){
              if(wb(s,set,j+1,dp)) {
                dp[i] = 0;
                return true;
              }
            }
        }
        dp[i] = 1;
        return false;
    }
}