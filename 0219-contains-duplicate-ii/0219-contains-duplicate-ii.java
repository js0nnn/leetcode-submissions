class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int r = 0; r < nums.length; r++) {
            if(map.containsKey(nums[r])) {
                int idx = map.get(nums[r]);

                if(r-idx <= k) {
                    if(idx >= l) {
                        return true;
                    }
                } else {
                    map.put(nums[r], r);
                    l++;
                }
            } else {
                map.put(nums[r], r);
            }
        }

        return false;
    }
}