class Solution {
    public int divide(int dividend, int divisor) {
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long q = 0;
        while(a>=b){
            long mul = b;
            long count = 1;
            while((mul << 1) <= a){
                mul <<= 1;
                count <<= 1;
            }
            a -= mul;
            q += count;
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