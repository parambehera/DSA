// User function Template for Java

class GFG {
    ArrayList<Integer> find(int arr[], int x) {
        // code here
       ArrayList <Integer> list = new  ArrayList <>();
       int n = arr.length;
       int lb =lowerBound(arr,x);
       int ub =upperBound(arr,x);
       if(lb==n || arr[lb]!=x){
          lb =-1;
          list.add(-1);
          list.add(-1);
          return list;
       }
      
       list.add(lb);
       list.add(ub-1);
       return list;
       
    }
    int lowerBound(int[] arr, int x) {
        // code here
        int low = 0;
        int high = arr.length-1;
        int res=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>=x){
                res =mid;
                high =mid-1;
            }else{
                low= mid+1;
            }
        }
        return res==-1 ? arr.length:res ;
    }
     int upperBound(int[] arr, int x) {
        // code here
        int low =0;
        int high = arr.length-1;
        int res =-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>x){
                res =mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return res==-1?arr.length:res;
    }
}
