class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        Set<List<Integer>> res = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j = i + 1; j < nums.length; j++) {
                int need = target - (nums[i] + nums[j]);

                if(map.containsKey(need)) {
                    int arr[] = {nums[i], nums[j], need};
                    Arrays.sort(arr);
                    List<Integer> list = new ArrayList<>();
                    for(int num : arr) {
                        list.add(num);
                    }
                    res.add(list);
                } else {
                    map.put(nums[j], j);
                }
            }
        }

        return new ArrayList<>(res);
    }
}