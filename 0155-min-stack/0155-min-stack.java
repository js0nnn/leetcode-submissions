class MinStack {
    int top;
    List<Integer> stack;
    List<Integer> min;


    public MinStack() {
        this.top = -1;
        this.stack = new ArrayList<>();
        this.min = new ArrayList<>();
    }
    
    public void push(int value) {
        if(min.isEmpty())
            min.add(value);
        else
            min.add(Math.min(min.get(top), value));
        stack.add(value);
        top++;
    }
    
    public void pop() {
        stack.remove(top);
        min.remove(top);
        top--;
    }
    
    public int top() {
        return stack.get(top);
    }
    
    public int getMin() {
        return min.get(top);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */