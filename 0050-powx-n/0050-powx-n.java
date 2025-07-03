class Solution {
    double findPower(double x, long n) {
        if (n == 0)
            return 1; //anything power 0 is 1

        double half = findPower(x, n / 2);
        if (n % 2 == 0)
            return half * half;
        else
            return half * half * x;

    }

    public double myPow(double x, int n) {
        // TC -> O(log N)
        // if (x == 1 || x == 0)
        //     return x;
        // double ans = 1.0;
        // long nn = n;
        // if (nn < 0)
        //     nn = -1 * nn;
        // while (nn > 0) {
        //     if (nn % 2 == 1) {
        //         ans = ans * x;           
        //     } 
        //     x = x * x;
        //     nn = nn / 2;  
        // }
        // if (n < 0)
        //     ans = (double) (1.0) / (ans);
        // return ans;
        long nn = (long) n;
        if (n < 0)
            return 1 / findPower(x, -1 * nn);
        return findPower(x, nn);

    }
}