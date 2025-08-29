class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fivec=0;
        int tenc =0;
        for(int i =0;i<bills.length;i++){
            if(bills[i]==5){
                fivec++;
            }
            else if(bills[i]==10){
                if(fivec>0){
                    fivec--;
                    tenc ++;
                }else{
                    return false;
                }
            }
            else if(bills[i]==20){
                if(tenc>0 && fivec>0){
                    tenc--;
                    fivec--;
                }else if(fivec>=3){
                   fivec -=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}