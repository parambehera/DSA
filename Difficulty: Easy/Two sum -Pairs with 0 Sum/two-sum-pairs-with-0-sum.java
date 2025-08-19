class Solution {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        Arrays.sort(arr); 
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0) cnt++;
        }

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int ele:arr) set.add(ele);

        // handle (0,0) only once
        if(cnt >= 2){
            ArrayList<Integer> p = new ArrayList<>();
            p.add(0); p.add(0);
            list.add(p);
            set.remove(0);
        }

        for(int ele:arr){
            if(ele==0) continue;
            if(set.contains(ele) && set.contains(-ele)){
                ArrayList<Integer> p = new ArrayList<>();
                // ensure sorted order in the pair
                p.add(Math.min(ele, -ele));
                p.add(Math.max(ele, -ele));
                list.add(p);

                set.remove(ele);
                set.remove(-ele);
            }
        }
         
         
           list.sort((a, b) -> a.get(0) - b.get(0));
        return list;
    }
}
