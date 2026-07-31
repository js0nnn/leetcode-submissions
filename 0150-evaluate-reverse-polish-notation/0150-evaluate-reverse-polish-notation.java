class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens) {
            if(token.length() == 1 && !Character.isDigit(token.charAt(0))) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int res = 0;
                switch(token.charAt(0)) {
                    case '+':
                        res = num2 + num1;
                        break;
                    case '-':
                        res = num2 - num1;
                        break;
                    case '*':
                        res = num2 * num1;
                        break;
                    case '/':
                        res = num2 / num1;
                        break;
                }
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}