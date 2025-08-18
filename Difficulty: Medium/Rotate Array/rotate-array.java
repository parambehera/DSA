// User function Template for Java

class Solution {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int k) {
        // add your code here
     int n = arr.length;
        k = k % n; // handle if k > n

        // Step 1: Reverse first k elements
        reverse(arr, 0, k - 1);

        // Step 2: Reverse remaining n-k elements
        reverse(arr, k, n - 1);

        // Step 3: Reverse whole array
        reverse(arr, 0, n - 1);
        
    }
    public static  void reverse(int arr[],int i,int j){
        for(int st  = i,end=j;st<=end;st++,end--){
            int temp = arr[st];
            arr[st] = arr[end];
            arr[end] = temp;
        }
    }
}