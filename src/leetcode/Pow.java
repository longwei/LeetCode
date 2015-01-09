package leetcode;

/**
 * Created by longwei on 1/8/15.
 */
public class Pow {
    public double pow(double x, int n) {
        if(x == 0) return 1;
        if (n < 0){
            return 1/power(x, -n);
        } else {
            return power(x,n);
        }
    }

    public double power(double x, int n){
        if(n == 0) return 1;
        double v = power(x, n / 2);
        if(n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }
}
