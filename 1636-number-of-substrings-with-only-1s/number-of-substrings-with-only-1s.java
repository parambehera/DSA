class Solution {
    public int numSub(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        int mod = 1000000007;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                list.add(count);
                count = 0;
            }
            if (ch == '1') {
                count++;
            }
        }

        list.add(count);

        long total = 0; // use long to avoid overflow
        for (int i = 0; i < list.size(); i++) {
            long len = list.get(i);
            long t = (len * (len + 1)) / 2;
            total = (total + t) % mod;
        }

        return (int) total;
    }
}
