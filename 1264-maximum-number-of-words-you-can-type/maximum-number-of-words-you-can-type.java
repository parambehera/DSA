class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String ch[] = text.split(" ");
        int cnt = 0;
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < brokenLetters.length(); j++) {
                String s = ch[i];
                char c = brokenLetters.charAt(j);
                if (s.indexOf(c) >= 0) {
                    cnt++;
                    break;
                }
            }
        }
        return ch.length-cnt;
    }
}