class Solution {
    public int countPrimes(int n) {
        // SC -> O(N + 1)
        int[] prime = new int[n + 1];
        // TC -> O(N)
        Arrays.fill(prime, 1);
        // Sieve Of Eratosthenes: TC -> O(Nlog(logN))
        for(int i = 2; i * i <= n; i ++) {
            if(prime[i] == 1) {
                for(int j = i * i; j <= n; j += i)
                    prime[j] = 0;
            }
        }
        int ct = 0;
        // TC -> O(N)
        for(int i = 2; i < n; i ++)
            if(prime[i] == 1) ct++;
        return ct;
    }
}