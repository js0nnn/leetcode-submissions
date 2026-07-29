class Solution {
    public int[] productExceptSelf(int[] nums) {
        int res[] = new int[nums.length];

        int prefP = 1;

        for(int i = 0; i < nums.length; i++) {
            res[i] = prefP;
            prefP *= nums[i];
        }

        int sufP = 1;

        for(int i = nums.length-1; i >= 0; i--) {
            res[i] *= sufP;
            sufP *= nums[i];
        }

        return res;
    }
}