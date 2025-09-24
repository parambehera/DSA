import java.util.*;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();

        // Handle sign
        if ((numerator < 0) ^ (denominator < 0)) {
            res.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Integer part
        res.append(num / den);
        long rem = num % den;

        if (rem == 0) {
            return res.toString();
        }

        res.append(".");
        // Fractional part
        while (rem != 0) {
            if (map.containsKey(rem)) {
                int idx = map.get(rem);
                res.insert(idx, "(");  // insert "(" at repeating index
                res.append(")");       // append ")" at end
                break;
            }
            map.put(rem, res.length());
            rem *= 10;
            res.append(rem / den);
            rem %= den;
        }

        return res.toString();
    }
}
