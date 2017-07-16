/*
*   Kadane's Algorithm
*/

class Kadane {
    public static int kadane(int[] a) {
        int size = a.length, globalMax = 0, localMax = 0;
        for(int i = 0; i < size; i++) {
            localMax = localMax + a[i];
            if(localMax < 0) {
                localMax = 0;
            } else if(globalMax < localMax) {
                globalMax = localMax;
            }
        }
        return globalMax;
    }
    public static void main(String args[]) {
        int [] a = { 3, 4, -1, -2, 3};
        System.out.println("Max Sub-Array is " + kadane(a));
    }
}
