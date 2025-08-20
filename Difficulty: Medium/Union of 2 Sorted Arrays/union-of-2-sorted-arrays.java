class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // code here
       ArrayList <Integer> list = new ArrayList <>();
       LinkedHashSet <Integer> set =new LinkedHashSet <>();
       int  i=0;
       int j =0;
       int n = a.length;
       int  m= b.length;
       while(i<n && j<m){
           if(a[i]==b[j]){
               set.add(a[i]);
               i++;j++;
           }
           else if(a[i]<b[j]){
               set.add(a[i]);
               i++;
           }else{
               set.add(b[j]);
               j++;
           }
       }
       while(i<n){
           set.add(a[i]);
           i++;
       }
       while(j<m){
           set.add(b[j]);
           j++;
       }
    list.addAll(set);
       return list;
    }
}
