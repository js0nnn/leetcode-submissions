class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        int max = 0;

        for(int num : set) {
            if(set.contains(num-1)) continue;

            int ctr = 1;
            while(set.contains(num+ctr))
                ctr++;

            max = Math.max(max, ctr);
        }

        return max;
    }
}