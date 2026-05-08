class Solution {

    public int minJumps(int[] nums) {

        int max = Integer.MIN_VALUE;

        int n = nums.length;

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // value -> indexes
        for (int i = 0; i < n; i++) {

            int num = nums[i];

            map.putIfAbsent(num, new ArrayList<>());

            map.get(num).add(i);

            max = Math.max(num, max);
        }

        HashSet<Integer> set = new HashSet<>();

        boolean isPrime[] = new boolean[max + 1];

        seiv(isPrime, max);

        boolean visited[] = new boolean[n];

        visited[0] = true;

        Queue<Integer> q = new LinkedList<>();

        q.add(0);

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int idx = q.poll();

                if (idx == n - 1) {
                    return steps;
                }

                // right
                if (idx + 1 <= n - 1 && !visited[idx + 1]) {

                    visited[idx + 1] = true;

                    q.add(idx + 1);
                }

                // left
                if (idx - 1 >= 0 && !visited[idx - 1]) {

                    visited[idx - 1] = true;

                    q.add(idx - 1);
                }

                // not prime
                if (!isPrime[nums[idx]]) {
                    continue;
                }

                // already used this prime teleport
                if (set.contains(nums[idx])) {
                    continue;
                }

                // teleport
                for (int d = nums[idx]; d <= max; d += nums[idx]) {

                    if (map.containsKey(d)) {

                        List<Integer> list = map.get(d);

                        for (int i : list) {

                            if (!visited[i]) {

                                visited[i] = true;

                                q.add(i);
                            }
                        }
                    }
                }

                set.add(nums[idx]);
            }

            steps++;
        }

        return -1;
    }

    void seiv(boolean isPrime[], int max) {

        Arrays.fill(isPrime, true);

        if (max >= 0) isPrime[0] = false;

        if (max >= 1) isPrime[1] = false;

        for (int i = 2; i * i <= max; i++) {

            if (isPrime[i]) {

                for (int j = i * i; j <= max; j += i) {

                    isPrime[j] = false;
                }
            }
        }
    }
}