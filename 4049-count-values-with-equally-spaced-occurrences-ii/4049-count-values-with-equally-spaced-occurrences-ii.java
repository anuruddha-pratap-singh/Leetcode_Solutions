class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer , int[]> map = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++){
            int val = nums[i];
            if(!map.containsKey(val)){
                // array format = {count , lastIndex , gap , valid};
                map.put(val , new int[]{1 , i , -1 , 1});
            }else{
                int[] a = map.get(val);
                int currentGap = i - a[1];
                if(a[0] == 1){
                    a[2] = currentGap;
                }else if(currentGap != a[2]){
                    a[3] = 0;
                }
                a[0]++;
                a[1] = i;
            }
        }
        int ans = 0;
        for(int[] a : map.values()){
            if(a[0]>=3 && a[3]==1){
                ans++;
            }
        }
        return ans;
    }
}