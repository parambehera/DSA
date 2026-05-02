class Solution {

    public int rotatedDigits(int n) {

        int cnt = 0;

        for(int num = 1; num <= n; num++) {

            int p = num;

            boolean invalid = false;
            boolean changed = false;

            while(p != 0) {

                int r = p % 10;

                if(r == 3 || r == 4 || r == 7) {
                    invalid = true;
                    break;
                }

                if(r == 2 || r == 5 || r == 6 || r == 9) {
                    changed = true;
                }

                p /= 10;
            }

            if(!invalid && changed) {
                cnt++;
            }
        }

        return cnt;
    }
}