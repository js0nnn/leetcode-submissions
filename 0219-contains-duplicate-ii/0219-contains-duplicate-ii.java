class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int r = 0; r < nums.length; r++) {
            if(map.containsKey(nums[r]) && r-map.get(nums[r]) <= k) {
                return true;
            } 

            map.put(nums[r], r);
        }

        return false;
    }
}