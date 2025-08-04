class Solution {
    public int totalFruit(int[] fruits) {
    //   HashSet <Integer> set = new HashSet<>();
    //   int maxLength = 0;
    //   for(int i =0;i<fruits.length;i++){
    //     for(int j=i;j<fruits.length;j++){
    //          set.add(fruits[j]);
    //         if(set.size()<=2){
    //             maxLength = Math.max(maxLength,j-i+1);
    //         }else{
    //             set.clear();
    //             break;
    //         }
    //     }
    //   }
    //   return maxLength;


    // HashMap<Integer, Integer> map = new HashMap<>();
    //     int left = 0, right = 0, maxLength = 0;

    //     for (right = 0; right < fruits.length; right++) {
    //         map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
    //         while (map.size() > 2) {
    //             if (map.get(fruits[left]) > 1) {
    //                 map.put(fruits[left], map.get(fruits[left]) - 1);
    //             } else {
    //                 map.remove(fruits[left]); // Remove if frequency reaches 0
    //             }
    //             left++; // Shrink the window from the left
    //         }

    //         maxLength = Math.max(maxLength, right - left + 1);
    //     }
        
    //     return maxLength;


   HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxLength = 0;
        for (right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
           if(map.size()>2){
               if (map.get(fruits[left]) > 1) {
                    map.put(fruits[left], map.get(fruits[left]) - 1);
                } else {
                    map.remove(fruits[left]); // Remove if frequency reaches 0
                }
                left++; 
           }
           if(map.size()<=2){
             maxLength = Math.max(maxLength, right - left + 1);
           }
        }
        
        return maxLength;
    }
}