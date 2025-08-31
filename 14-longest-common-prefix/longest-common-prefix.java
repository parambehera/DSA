class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            minLen = Math.min(minLen,strs[i].length());
        }
        StringBuilder sb = new StringBuilder("");
        for(int i =0;i<minLen;i++){
            boolean isPresnt = true;
            for(int j=0;j<strs.length-1;j++){
                if(strs[j].charAt(i)!=strs[j+1].charAt(i)){
                  isPresnt =false;
                }
            }
            if(isPresnt){
                sb.append(strs[0].charAt(i));
            }else{
                break;
            }
        }
        return sb.toString();
    }
}