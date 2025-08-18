class Solution {
    public void rearrange(int[] arr, int x) {
     Integer[] boxed = new Integer[arr.length];
     for (int i = 0; i < arr.length; i++) {
    boxed[i] = arr[i]; // auto-boxing
}
 Arrays.sort(boxed, (a, b) -> Integer.compare(Math.abs(x - a), Math.abs(x - b)));
 for (int i = 0; i < boxed.length; i++) {
    arr[i] = boxed[i]; // unboxing
}
    }
}




