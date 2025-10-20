class Solution {
    String smallest = "";
    
    public String findLexSmallestString(String s, int a, int b) {
       HashSet <String> set = new HashSet <>();
       smallest =s;
       dfs(s,a,b,set);
       return smallest;
    }
    public void dfs(String s,int a,int b,HashSet <String> set){
      if(set.contains(s)){
        return;
      }
      if(smallest.compareTo(s)>0){
        smallest = s;
      }
      set.add(s);
      String ad = add(s,a);
      dfs(ad,a,b,set);
      String rot = rotate(s,b);
      dfs(rot,a,b,set);
    }

    public String rotate(String s, int b) {
        // Rotate by cutting string and swapping parts
        b = b % s.length();
        String part1 = s.substring(0, s.length() - b);
        String part2 = s.substring(s.length() - b);
        return part2 + part1;
    }

    public String add(String s, int a) {
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i += 2) { // add only to odd indices
            int num = arr[i] - '0';
            num = (num + a) % 10;
            arr[i] = (char) (num + '0');
        }
        return new String(arr);
    }
}
