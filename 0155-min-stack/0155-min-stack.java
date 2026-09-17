// gap strategy
class MinStack {
    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
        min = 0;
    }

    public void push(int val) {
        long value = val;

        if (st.isEmpty()) {
            st.push(0L);
            min = value;
        } else {
            st.push(value - min);
            min = Math.min(min, value);
        }
    }
    public void pop() {
        long rem = st.pop();
        if (rem < 0) {
            min = min - rem;
        }
    }

    public int top() {
        long rem = st.peek();

        if (rem < 0) {
            return (int)min;
        }
        return (int)(min + rem);
        
    }
    public int getMin() {
        return (int) min;
    }
}