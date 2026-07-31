class Solution {
    public int[] dailyTemperatures(int[] temp) {
        
        int res[] = new int[temp.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        for(int i = 1; i < temp.length; i++) {
            
            while(!stack.isEmpty() && temp[i] > temp[stack.peek()]) {
                res[stack.peek()] = i - stack.pop();
            }

            stack.push(i);

        }

        return res;
    }
}