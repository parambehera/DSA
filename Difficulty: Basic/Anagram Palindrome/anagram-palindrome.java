class Sol {
    int isPossible(String s) {
        // your code here
        int a[]= new int [26];
        for(int i=0;i<s.length();i++){
           int idx = s.charAt(i)-'a';
           a[idx]++;
        }
        int cnt =0;
        for(int i=0;i<a.length;i++){
              if(a[i]%2!=0)cnt++;
        }
        if(cnt<=1){
            return 1;
        }else{
            return 0;
        }
    }
}