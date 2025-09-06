class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> set = new HashSet<>();
        char ch[] = { 'A', 'T', 'C', 'G' };
        int n = bank.length;
        for (int i = 0; i < n; i++) {
            //add here\
            set.add(bank[i]);
        }
        Queue<String> q = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();
        vis.add(startGene);
        q.add(startGene);
        int steps = 0;
        while (!q.isEmpty()) {
            int s = q.size();
            for (int k = 0; k < s; k++) {
                String curr = q.remove();
                if (curr.equals(endGene)) return steps;
                char arr[] = curr.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char org = arr[i];
                    for (int j = 0; j < 4; j++) {
                        char c = ch[j];
                        if(c== org)  continue;
                        arr[i] = c;
                        String next = new String(arr);
                        if (vis.contains(next) || !set.contains(next))  continue;
                        vis.add(next);
                        q.add(next);
                    }
                    arr[i] = org;
                }
            }
            steps++;
        }
        return -1;
    }
}