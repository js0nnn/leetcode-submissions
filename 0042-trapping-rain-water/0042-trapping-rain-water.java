class Solution {
    public void printArr(int nums[]) {
        for(int num : nums) {
            System.out.print(num+" ");
        }
        System.out.println();
    }
    public int trap(int[] height) {
        int leftMax[] = new int[height.length];
        int rightMax[] = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length-1] = height[height.length-1];

        for(int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
            rightMax[height.length-i-1] = Math.max(rightMax[height.length-i], height[height.length-i-1]);
        }

        // printArr(leftMax);
        // printArr(rightMax);

        int water = 0;
        for(int i = 0; i < height.length; i++) {
            int cur_water = Math.min(leftMax[i], rightMax[i]) - height[i];
            water += (cur_water < 0) ? 0 : cur_water;
        }

        return water;
    }
}