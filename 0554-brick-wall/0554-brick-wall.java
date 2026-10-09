class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Long, Long> map = new HashMap<>();
        long ans = 0;
        for(List<Integer> l : wall){
            long sum = 0;
            for(int i=0 ; i<l.size()-1 ; i++){
                sum += l.get(i);
                map.put(sum , map.getOrDefault(sum , 0L)+1);
                ans = Math.max(ans , map.get(sum));
            }
        }
        
        return wall.size()-(int)ans;
    }
}