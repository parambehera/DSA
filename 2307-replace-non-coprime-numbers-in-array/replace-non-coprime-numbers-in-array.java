class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int x : nums) {
            list.add(x);
            // Keep merging until last two are coprime
            while (list.size() > 1) {
                int a = list.get(list.size() - 1);
                int b = list.get(list.size() - 2);
                int gcd = GCD(a, b);
                if (gcd > 1) {
                    list.remove(list.size() - 1);
                    list.remove(list.size() - 1);
                    long lcm = (1L * a * b) / gcd; // use long to avoid overflow
                    list.add((int) lcm);
                } else {
                    break;
                }
            }
        }
        return list;
    }

    public int GCD(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
