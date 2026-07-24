class Solution {
    public String removeDigit(String number, char digit) {
        int last = -1;

        for (int i = 0; i < number.length(); i++) {

            if (number.charAt(i) == digit) {

                last = i;

                // Greedy condition
                if (i < number.length() - 1 &&
                    number.charAt(i) < number.charAt(i + 1)) {

                    return number.substring(0, i)
                         + number.substring(i + 1);
                }
            }
        }

        // If no better position found, remove the last occurrence
        return number.substring(0, last)
             + number.substring(last + 1);
    }
}