class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         Arrays.sort(candidates); // ✅ sort first
        List<List<Integer>> list = new ArrayList<>();
        helper(candidates, list, new ArrayList<>(), 0, target);
        return list;
    }
    public void helper(int []candidates,List<List<Integer>>list,List<Integer> ans,int idx,int target ){
       int n = candidates.length;
      if(target==0){
        list.add(new ArrayList <>(ans));
      }
       int i = idx;
       
       for(i=idx;i<n && target >0 ;i++){
        if (i > idx && candidates[i] == candidates[i - 1]) continue;
        if (candidates[i] > target) break;
          ans.add(candidates[i]);
          helper(candidates,list,ans,i+1,target-candidates[i]);
          ans.remove(ans.size()-1);
       }
    }
}