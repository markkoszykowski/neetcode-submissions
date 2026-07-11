class MinStack {
    private final Deque<Integer> descending = new ArrayDeque<>();
    private final Deque<Integer> ascending = new ArrayDeque<>();
    private final Deque<Integer> stack = new ArrayDeque<>();
    
    public MinStack() {}
    
    public void push(final int val) {
        this.stack.addLast(val);
        if (this.descending.isEmpty() || val < this.descending.getLast()) {
            this.descending.addLast(val);
        } else {
            this.ascending.addLast(val);
        }
    }
    
    public void pop() {
        final int last = this.stack.removeLast();
        if (!this.ascending.isEmpty() && this.ascending.getLast() == last) {
            this.ascending.removeLast();
        } else {
            this.descending.removeLast();
        }
    }
    
    public int top() {
        return this.stack.getLast();
    }
    
    public int getMin() {
        return this.descending.getLast();
    }
}
