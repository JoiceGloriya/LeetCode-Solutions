class Solution {
    public double myPow(double x, int n) {
        // TC -> O(log N)
        if (x == 1 || x == 0)
            return x;
        double ans = 1.0;
        long nn = n;
        if (nn < 0)
            nn = -1 * nn;
        while (nn > 0) {
            if (nn % 2 == 1) {
                ans = ans * x;           
            } 
            x = x * x;
            nn = nn / 2;  
        }
        if (n < 0)
            ans = (double) (1.0) / (ans);
        return ans;
    }
}