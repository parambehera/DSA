class Solution {
    public String reverseWords(String s) {
        String str[] = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        int n = str.length;
        for(int i=n-1;i>=0;i--){
            String st = str[i];
            sb.append(st);
            if(i!=0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}