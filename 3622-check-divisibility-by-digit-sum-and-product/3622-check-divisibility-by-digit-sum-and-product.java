class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int sum1 = 0;
        int prd = 1;
        int nn = n;
        
        while (nn > 0) {
            sum += nn % 10;
            prd *= nn % 10;
            nn /= 10;
        }
            sum1 += sum + prd;
        return (n % sum1 == 0);
    }
}