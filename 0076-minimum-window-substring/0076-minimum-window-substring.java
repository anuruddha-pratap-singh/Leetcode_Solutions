class Solution {
    public String minWindow(String s, String t) {
        int[] fre = new int[128];
        for(char ch : t.toCharArray()){
            fre[ch]++;
        }
        int required = 0;
        for(int i=0 ; i<fre.length ; i++){
            if(fre[i]>0){
                required++;
            }
        }
        int[] have = new int[128];

        int formed = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int left = 0;

        for(int right = 0 ; right<s.length() ; right++){
            char c = s.charAt(right);
            have[c]++;

            if(fre[c] > 0 && fre[c] == have[c]){
                formed++;
            }

            while(required == formed){
                if(right - left + 1 < minLen){
                    minLen = right-left+1;
                    start = left;
                }
                char remove = s.charAt(left);
                have[remove]--;

                if(fre[remove]>0 && have[remove] < fre[remove]){
                    formed--;
                }

                left++;
            }
        }

        if(minLen == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start , start+minLen);
        
    }
}