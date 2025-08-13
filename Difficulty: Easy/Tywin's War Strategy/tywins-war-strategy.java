

class Solution {
   
    public long minSoldiers(int[] arr, int k) {
        
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int n = arr.length;
        ArrayList<Integer> costs = new ArrayList<>();

      
        for (int soldiers : arr) {
            int remainder = soldiers % k;
            if (remainder == 0) {
                costs.add(0); 
            } else {
                costs.add(k - remainder);
            }
        }

       
        Collections.sort(costs);
        int requiredLuckyTroops = (n + 1) / 2;
        long totalSoldiersToAdd = 0;
        for (int i = 0; i < requiredLuckyTroops; i++) {
            totalSoldiersToAdd += costs.get(i);
        }

        return totalSoldiersToAdd;
    }
}