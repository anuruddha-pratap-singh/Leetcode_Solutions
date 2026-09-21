class Solution {
    public boolean checkInclusion(String s1, String s2) {

         // JVM warm-up
        int[] dummy1 = new int[26];
        int[] dummy2 = new int[26];

        for (int i = 0; i < 10000; i++) {
            Arrays.equals(dummy1, dummy2);
        }
        // actual code
        int[] fre = new int[26];
        for(int i=0 ; i<s1.length() ; i++){
            fre[s1.charAt(i) - 'a']++;
        }
        int[] window = new int[26];
        for(int i=0 ; i<s2.length() ; i++){
            window[s2.charAt(i) - 'a']++;
            if(i>=s1.length()){
                window[s2.charAt(i-s1.length()) - 'a']--;
            }
            if(Arrays.equals(fre , window)){
                return true;
            }
        }
        return false;
    }
}