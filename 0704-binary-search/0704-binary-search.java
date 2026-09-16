class Solution {
    public int search(int[] nums, int target) {
        int ans = -1;
        int st = 0;
        int ed = nums.length-1;
        while(st<=ed){
            int mid = st + (ed-st)/2;
            if(nums[mid] == target){
                ans = mid;
                return ans;
            }else if(nums[mid] > target){
                ed = mid-1;
            }else{
                st = mid+1;
            }
        }
        return ans;
    }
}