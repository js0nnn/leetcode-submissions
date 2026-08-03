class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int i = 0;
        int j = nums.length-1;

        while(i <= j) {
            int cur = nums[i] + nums[j];

            if(cur == target) break;

            if(cur > target) {
                j--;
            } else {
                i++;
            }
        }

        return new int[]{i+1,j+1};
    }
}