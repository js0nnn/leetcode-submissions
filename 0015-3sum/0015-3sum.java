class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();

        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r) {
                int cur = nums[i] + nums[l] + nums[r];
                if(cur == 0) {
                    res.add(new ArrayList<>(List.of(nums[i], nums[l], nums[r])));
                    l++; r--;
                } else if(cur < 0){
                    l++;
                } else {
                    r--;
                }
            }
        }

        return new ArrayList<>(res);
    }
}