class Solution {
    public int compareVersion(String version1, String version2) {
        String arr1[] = version1.split("\\.");
        String arr2[] = version2.split("\\.");
        
        int i = 0, j = 0;
        
        while (i < arr1.length && j < arr2.length) {
            int n = Integer.parseInt(arr1[i]);
            int m = Integer.parseInt(arr2[j]);
            
            if (n < m) return -1;
            else if (n > m) return 1;
            
            i++;
            j++;
        }
        
        while (i < arr1.length) {
            int n = Integer.parseInt(arr1[i]);
            if (n > 0) return 1;
            i++;
        }
        
        while (j < arr2.length) {
            int m = Integer.parseInt(arr2[j]);
            if (m > 0) return -1;
            j++;
        }
        
        return 0;
    }
}
