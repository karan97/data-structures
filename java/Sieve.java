/*
*   Implemented Sieve of Eratosthenes
*/
import java.util.Arrays;

class Sieve {
    public static void main(String[] args) {
        boolean[] a = getPrimes(10000);
        for(int i = 0; i < a.length; i++) {
            if(a[i]) {
                System.out.print(i + " ");
            }
        }
    }
    public static boolean[] getPrimes(int n) {
        boolean[] a = new boolean[n + 1];
        Arrays.fill(a, true);
        a[0] = false;
        a[1] = false;
        for(int i = 2; i <= n; i++) {
            if(a[i]) {
                for(int j = 2; j * i <= n; j++) {
                    a[j * i] = false;
                }
            }
        }
        return a;
    }
}