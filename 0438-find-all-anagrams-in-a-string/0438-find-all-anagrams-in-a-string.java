class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] fre = new int[26];
        for(int i=0 ; i<p.length() ; i++){
            fre[p.charAt(i) - 'a']++;
        }
        int[] window = new int[26];
        for(int i=0 ; i<s.length() ; i++){
            window[s.charAt(i) - 'a']++;
            if(i>=p.length()){
                window[s.charAt(i-p.length()) - 'a']--;
            }
            if(Arrays.equals(fre , window)){
                ans.add(i-(p.length()-1));
            }
        }
        return ans;
    }
}