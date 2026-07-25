class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime,Collections.reverseOrder());
        Collections.sort(tasks);
        int n = processorTime.size();
        int total = 0;
        for(int i=0;i<n;i++){
            int ti = 4*(i+1)-1;
           total = Math.max(total, processorTime.get(i) + tasks.get(ti));
        }
        return total;
    }
}