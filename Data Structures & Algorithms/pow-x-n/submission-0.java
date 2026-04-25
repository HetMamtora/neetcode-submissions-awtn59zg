class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        } else if(n < 0){
            return 1/myPow(x, -n);
        }

        if(n%2 == 0){
            double half = myPow(x, n/2);
            return half * half;
        } else {
            double half = myPow(x, n/2);
            return half * half * x;
        }
    }
}
