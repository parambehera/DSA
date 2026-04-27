class Solution {
    public int firstUniqChar(String s) {
        HashMap <Character,Integer> map= new HashMap<>();
        char arr []= s.toCharArray();
        int n = arr.length;
        for(int i=0;i<n;i++){
            char ch = arr[i];
            map.put(arr[i],map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<n;i++){
            char ch = arr[i];
            if(map.get(ch)==1){
                return i;
            }
        }
        return -1;
    }
}