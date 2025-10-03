class Solution {
     ArrayList <String> list = new ArrayList <>();
    public ArrayList<String> possibleWords(int[] arr) {
        // code here
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        int n= arr.length;
        String s[]= new String [n];
        for(int i =0;i<n;i++){
            s[i] = map.get(arr[i]);
        }
        StringBuilder sb = new StringBuilder("");
        if(n==0) return list;
        helper(s,sb,0);
        return list;
    }
    public void helper(String s[],StringBuilder sb,int idx ){
        if(idx==s.length){
            list.add(sb.toString());
            return;
        }
    
        String curr = s[idx];
        if(curr==null) helper(s,sb,idx+1);
        else{
            for(int i=0;i<curr.length();i++){
            sb.append(curr.charAt(i));
            helper(s,sb,idx+1);
            sb.deleteCharAt(sb.length() - 1); // must undo
        }
        }
        
    }
}