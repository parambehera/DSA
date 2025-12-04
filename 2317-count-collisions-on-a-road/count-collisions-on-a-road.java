class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int collisions = 0;

        // 1️⃣ Ignore all leading L cars (they move left forever)
        int i = 0;
        while (i < n && directions.charAt(i) == 'L') {
            i++;
        }

        // 2️⃣ Ignore all trailing R cars (they move right forever)
        int j = n - 1;
        while (j >= 0 && directions.charAt(j) == 'R') {
            j--;
        }

        // 3️⃣ Now count all cars between i and j that are not S
        //    Because every R or L in this middle section WILL collide
        for (int k = i; k <= j; k++) {
            if (directions.charAt(k) != 'S') {
                collisions++;
            }
        }

        return collisions;
    }
}
