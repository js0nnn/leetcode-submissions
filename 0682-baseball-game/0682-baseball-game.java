class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for(String op : ops) {
            char ch = op.charAt(0);
            if(Character.isDigit(ch) || ch == '-')
                stack.push(Integer.parseInt(op));
            else {
                switch(ch) {
                    case '+':
                        int num1 = stack.pop();
                        int num2 = stack.peek();
                        stack.push(num1);
                        stack.push(num1 + num2);
                    break;
                    case 'D':
                        stack.push(stack.peek() * 2);
                    break;
                    case 'C':
                        stack.pop();
                    break;
                }
            }
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}