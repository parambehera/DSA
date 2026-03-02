class Solution {
    public int minPartitions(String n) {
        int max =Integer.MIN_VALUE;
          for(char ch :n.toCharArray()){
             max = Math.max(ch-'0',max);
          }
          return max;
    }
}