class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int len = words.length;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len;i++){
            String word = words[i];
            int sm=0;
            for(int j=0;j<word.length();j++){
                 int asc = (int)word.charAt(j);
                 int idx = asc-97;
                 sm+=weights[idx];
            }
            int mod = sm%26;
            char ch  = (char) (97+(25-mod)); 
            sb.append(ch);
        }
        return sb.toString();
    }
}