class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        int n = start.length;
        // add your code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<start.length;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(start[i]);
            temp.add(end[i]);
            list.add(temp);
        }

        Collections.sort(list, (a,b) -> a.get(1) - b.get(1));
        
         int cnt=1;
         int prevEnd = list.get(0).get(1);
        for(int i=1;i<n;i++){
           int currStart = list.get(i).get(0);
            if(currStart>prevEnd){
                prevEnd= list.get(i).get(1);
                cnt++;
            }
        }
        return cnt;
    }
}
