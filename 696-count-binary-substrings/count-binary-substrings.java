class Solution {
    public int countBinarySubstrings(String s) {
         ArrayList <Integer> list = new ArrayList <>();
         int n = s.length();
         int zerocnt =0;
         int onecnt=0;
         for(int i=0;i<n;i++){
              char ch = s.charAt(i);
             if(ch=='0'){
                if(onecnt!=0){
                    list.add(onecnt);
                }
                zerocnt++;
                onecnt=0;
             }
             if(ch=='1'){
                if(zerocnt!=0){
                    list.add(zerocnt);
                }
                onecnt++;
                zerocnt =0;
             }
             
         }
         if(zerocnt != 0) {
            list.add(zerocnt);
        }
        if(onecnt != 0) {
            list.add(onecnt);
        }
         int sum=0;
         for(int i=0;i<list.size()-1;i++){
            sum +=Math.min(list.get(i),list.get(i+1));
         }
         return sum;

    }
}