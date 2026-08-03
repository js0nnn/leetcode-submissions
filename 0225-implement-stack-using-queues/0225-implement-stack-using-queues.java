class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    public int pop() {
        int prev = 0;
        int size = q1.size();
        for(int i = 0; i < size - 1; i++) {
            q2.offer(q1.poll());
        }

        int pop = q1.poll();

        for(int i = 0; i < size - 1; i++) {
            q1.offer(q2.poll());
        }

        return pop;
    }
    
    public int top() {
        int prev = 0;
        int size = q1.size();
        for(int i = 0; i < size; i++) {
            prev = q1.poll();
            q2.offer(prev);
        }

        for(int i = 0; i < size; i++) {
            q1.offer(q2.poll());
        }

        return prev;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */