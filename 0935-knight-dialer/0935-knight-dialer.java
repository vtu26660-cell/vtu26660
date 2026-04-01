class Solution {
    public int knightDialer(int n) {
        int MOD = 1_000_000_007;
        
        long[] dp = new long[10];
        for (int i = 0; i < 10; i++) dp[i] = 1;

        int[][] moves = {
            {4,6},    // 0
            {6,8},    // 1
            {7,9},    // 2
            {4,8},    // 3
            {0,3,9},  // 4
            {},       // 5
            {0,1,7},  // 6
            {2,6},    // 7
            {1,3},    // 8
            {2,4}     // 9
        };

        for (int step = 2; step <= n; step++) {
            long[] newDp = new long[10];

            for (int i = 0; i < 10; i++) {
                for (int next : moves[i]) {
                    newDp[next] = (newDp[next] + dp[i]) % MOD;
                }
            }

            dp = newDp;
        }

        long sum = 0;
        for (long val : dp) sum = (sum + val) % MOD;

        return (int) sum;
    }
}