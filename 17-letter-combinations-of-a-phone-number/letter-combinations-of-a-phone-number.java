class Solution {
    List <String> list = new ArrayList <>();
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        int n= digits.length();
        String sr []= new String[n];
        for(int i =0;i<n;i++){
           int num = Character.getNumericValue(digits.charAt(i));
            sr[i] = map.get(num);
        }
        StringBuilder sb = new StringBuilder("");
        if(n==0) return list;
        bt(sr,0,sb);
        return list;
        
    }
    public void bt(String arr[],int i,StringBuilder sb){
        if(i==arr.length){
          list.add(sb.toString());
          return;
        }
        String s = arr[i];
        for(int j =0;j<s.length();j++){
          sb.append(s.charAt(j));
          bt(arr,i+1,sb);
          sb.deleteCharAt(sb.length() - 1); // must undo
        }

    }
}
