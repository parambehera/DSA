class Solution {
    public ArrayList<Integer> sieve(int n) {
        // code here
     boolean  arr[]= new boolean [n+1];
     for(int i=2;i<=n;i++){
         arr[i] = true;
     }
     for(int i=2;i<=(int)Math.sqrt(n);i++){
         if(arr[i]){
             for(int j=i*i;j<=n;j+=i){
                 arr[j] = false;
             }
         }
     }
     ArrayList <Integer> list = new ArrayList <>();
     for(int i=2;i<=n;i++){
         if(arr[i]){
             list.add(i);
         }
     }
     return list;
     
    }
}