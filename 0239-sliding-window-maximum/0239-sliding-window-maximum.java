class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int res[] = new int[nums.length - k + 1]; 
        int ctr = 0;
        // store indices
        Deque<Integer> dq = new ArrayDeque<>();
        int r = 0;
        int l = 0;
        
        while(r < nums.length) {
            // remove smaller values
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[r]) {
                dq.removeLast();
            }
            dq.addLast(r);

            if(l > dq.getFirst()) {
                dq.removeFirst();
            }

            if(r+1 >= k) {
                res[ctr++] = nums[dq.getFirst()];
                l++;
            }
            r++;
        }

        return res;
        
    }
}