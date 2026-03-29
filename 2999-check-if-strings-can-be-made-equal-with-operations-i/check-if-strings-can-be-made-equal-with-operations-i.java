class Solution {
    public boolean canBeEqual(String s1, String s2) {
    String s1G[] = new String [4];
    String s2G[]= new String[4];
    char s1Ch []= new char[4];
    char s2Ch []= new char[4];
    s1Ch = s1.toCharArray();
    s2Ch = s2.toCharArray();
    s1G [0] = s1;
    swap(s1G,s1Ch,0,2,1);
    swap(s1G,s1Ch,1,3,3);
    s1Ch = s1.toCharArray();
    swap(s1G,s1Ch,1,3,2);

    s2G [0] = s2;
    swap(s2G,s2Ch,0,2,1);
    swap(s2G,s2Ch,1,3,3);
    s2Ch = s2.toCharArray();
    swap(s2G,s2Ch,1,3,2);

    for(int i=0;i<4;i++){
        for(int j=0;j<4;j++){
            if(s1G[i].equals(s2G[j])){
                return true;
            }
        }
    }
    return false;
    
    }
    void swap (String sG[],char ch[],int i,int j,int idx){
    char temp = ch[i];
    ch[i] =ch[j];
    ch[j] =  temp;
   sG[idx] = new String(ch);
    }

}