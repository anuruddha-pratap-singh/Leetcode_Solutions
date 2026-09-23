class Solution {
    public int divide(int dividend, int divisor) {
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long q = 0;

        for(int i=31 ; i>=0 ; i--){
            if((b << i) <= a){
                a -= (b << i);
                q += (1L << i);
            }
        }

        if((dividend < 0)^(divisor < 0)){
            q = -q;
        }

        if(q > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)q;
    }
}