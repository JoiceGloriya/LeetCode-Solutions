class MinStack {
    Stack<Long> stk;
    long mini;

    public MinStack() {
        stk = new Stack<>();
        mini = Long.MAX_VALUE;
    }

    public void push(int value) {
        long valuee = value;
        if (valuee < mini) {
            long modVal = (2L * valuee) - mini;
            stk.push(modVal);
            mini = valuee;
        } else
            stk.push(valuee);
    }

    public void pop() {
        long val = stk.pop(); //value == modVal
        if (val < mini) {
            mini = (2L * mini) - val;
        }
    }

    public int top() {
        long val = stk.peek();
        if (val < mini) {
            return (int) mini;
        }
        return (int) val;
    }

    public int getMin() {
        return (int) mini;
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