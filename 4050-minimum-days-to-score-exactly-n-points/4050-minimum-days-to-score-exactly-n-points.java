class Solution {
    public int minDays(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp , Integer.MAX_VALUE);
        dp[0] = 0;
        for(int score = 0 ; score<=n ; score++){
            if(dp[score] == Integer.MAX_VALUE){
                continue;
            }
            for(int k=1 ; ; k++){
                int points = (k*(k+1))/2;
                if(score + points > n) break;

                dp[score+points] = Math.min(dp[score+points] , dp[score]+k+1);
            }
        }
        return dp[n]-1;
    }
}