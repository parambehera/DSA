class Solution {
    public String sortVowels(String s) {
        StringBuilder st = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'A' || ch == 'a' || ch == 'E' || ch == 'e' || ch == 'i' || ch == 'I' || ch == 'O' || ch == 'o'
                    || ch == 'u' || ch == 'U') {
                st.append(ch);
            }
        }
        char[] ch = st.toString().toCharArray();
        Arrays.sort(ch);
        char[] och = s.toCharArray();
        int j =0;
        for (int i = 0; i < s.length(); i++) {
            char chi = och[i];
            if (chi == 'A' || chi == 'a' || chi == 'E' || chi == 'e' || chi == 'i' || chi == 'I' || chi == 'O' || chi == 'o'
                    || chi == 'u' || chi == 'U') {
               och[i] = ch[j];
               j++;
            }
        }
        String str = String.valueOf(och);
        return str;
    }
}