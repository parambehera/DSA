class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap <Character,Integer> map =new HashMap <>();
        int n = text.length();
        for(int i=0;i<n;i++){
            char ch = text.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int tinst = 0;
        String st = "ballon";
        if(map.containsKey('b')){
            tinst = map.get('b');
        }
        for(int i=1;i<st.length();i++){
            char ch = st.charAt(i);
            if(map.containsKey(ch)){
                int fc = map.get(ch);
                if(ch=='l' || ch=='o'){
                   int p = fc/2;
                   tinst = Math.min(p,tinst);
                }else{
                    tinst = Math.min(tinst,fc);
                }
            }else{
                return 0;
            }
        }
        return tinst;
    }
}