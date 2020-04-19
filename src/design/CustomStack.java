package design;

class CustomStack {
    int[] node;
    int curr;
    int maxSize;
    public CustomStack(int maxSize) {
        node = new int[maxSize];
        curr = -1;
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (curr+1 >= maxSize) {
            return;
        }
        node[++curr] = x;
    }

    public int pop() {
        if (curr < 0) {
            return -1;
        }
        return node[curr--];
    }

    public void increment(int k, int val) {
        for (int i = 0; i < k && i<=curr; i++) {
            node[i] += val;
        }
    }

}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
