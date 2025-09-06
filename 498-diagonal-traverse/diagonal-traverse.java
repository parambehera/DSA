class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        // Step 1: Group elements by i+j
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int key = i + j; 
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(mat[i][j]);
            }
        }

        // Step 2: Traverse diagonals
        for (int i = 0; i < map.size(); i++) {
            ArrayList<Integer> list = map.get(i);
            if (i % 2 == 0) {
                // copy in reverse order
                for (int k = list.size() - 1; k >= 0; k--) {
                    res.add(list.get(k));
                }
            } else {
                // copy in normal order
                res.addAll(list);
            }
        }

        // Step 3: Convert ArrayList -> int[]
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }

        return arr;
    }
}
