import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        // Maps
        HashSet<String> exactWords = new HashSet<>();
        HashMap<String, String> caseInsensitive = new HashMap<>();
        HashMap<String, String> vowelInsensitive = new HashMap<>();
        
        // Build maps
        for (String word : wordlist) {
            exactWords.add(word);
            
            // Case-insensitive map
            String lower = word.toLowerCase();
            caseInsensitive.putIfAbsent(lower, word);
            
            // Vowel-insensitive map
            String devoweled = maskVowels(lower);
            vowelInsensitive.putIfAbsent(devoweled, word);
        }
        
        String[] res = new String[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            
            if (exactWords.contains(q)) {
                res[i] = q; // exact match
            } else {
                String lower = q.toLowerCase();
                if (caseInsensitive.containsKey(lower)) {
                    res[i] = caseInsensitive.get(lower); // case-insensitive match
                } else {
                    String devoweled = maskVowels(lower);
                    res[i] = vowelInsensitive.getOrDefault(devoweled, ""); // vowel-insensitive match
                }
            }
        }
        
        return res;
    }
    
    // Replace vowels with '*'
    private String maskVowels(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
