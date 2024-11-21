package stack;

class Node {
    int val;
    int incr;

    Node(int val, int incr) {
        this.val = val;
        this.incr = incr;
    }
}

class CustomStack {
    int currentSize;
    int maxSize;
    Node[] stack;

    public CustomStack(int maxSize) {
        this.stack = new Node[maxSize];
        this.maxSize = maxSize;
        this.currentSize = 0;
    }

    public void push(int val) {
        if (currentSize < maxSize) {
            stack[currentSize] = new Node(val, 0); // Set initial value and no increment
            currentSize++;
        }
    }

    public int pop() {
        if (currentSize == 0) return -1;

        int index = currentSize - 1;
        int value = stack[index].val + stack[index].incr;

        if (currentSize > 1) {
            stack[currentSize - 2].incr += stack[index].incr;
        }

        currentSize--;
        return value;
    }

    public void increment(int k, int val) {
        int limit = Math.min(k, currentSize);
        if (limit > 0) {
            stack[limit - 1].incr += val;
        }
    }
}
