class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        Map<String, Integer> priority = Map.of(
            "electronics", 0,
            "grocery", 1,
            "pharmacy", 2,
            "restaurant", 3
        );

        class Coupon {
            String c;
            String bl;
            Coupon(String c, String bl) { this.c = c; this.bl = bl; }
        }

        List<Coupon> list = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (isActive[i] 
                && priority.containsKey(businessLine[i]) 
                && isValidCode(code[i])) {

                list.add(new Coupon(code[i], businessLine[i]));
            }
        }

        // Sort by category priority, then lexicographically
        list.sort((x, y) -> {
            int p1 = priority.get(x.bl);
            int p2 = priority.get(y.bl);
            if (p1 != p2) return p1 - p2;
            return x.c.compareTo(y.c);
        });

        List<String> result = new ArrayList<>();
        for (Coupon cp : list) result.add(cp.c);

        return result;
    }

    public boolean isValidCode(String s) {
        if (s == null || s.length() == 0) return false;
        for (char ch : s.toCharArray()) {
            if (!(Character.isLetterOrDigit(ch) || ch == '_'))
                return false;
        }
        return true;
    }
}
