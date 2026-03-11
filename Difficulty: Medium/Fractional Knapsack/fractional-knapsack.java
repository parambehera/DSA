import java.util.*;

class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {

        ArrayList<double[]> list = new ArrayList<>();
        int n = val.length;

        for(int i = 0; i < n; i++){
            double[] arr = new double[3];
            arr[0] = val[i];
            arr[1] = wt[i];
            arr[2] = (double) val[i] / wt[i]; // value per weight

            list.add(arr);
        }

        Collections.sort(list, (a, b) -> Double.compare(b[2], a[2]));

        double max = 0;

        for(int i = 0; i < n; i++){

            double vali = list.get(i)[0];
            double wti = list.get(i)[1];

            if(wti <= capacity){
                max += vali;
                capacity -= wti;
            } 
            else{
                double fract = capacity / wti;
                max += vali * fract;
                break;
            }
        }

        return max;
    }
}