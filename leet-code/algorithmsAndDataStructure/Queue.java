package algorithmsAndDataStructure;


public class Queue {
    ListNode left;  // front of Queue
    ListNode right; // back of Queue

    public Queue() {
        this.left  = null;
        this.right = null;
    }

    public void enqueue(int val) {
        ListNode newNode = new ListNode(val);
        if (this.right != null) {
            this.right.next = newNode;
            this.right = this.right.next;
        } else {
            this.left = newNode;
            this.right = newNode;
        }
    }

    public int dequeue() {
        if (this.left == null) {
            System.exit(0);
        }
        int val = this.left.val;
        this.left = this.left.next;
        if (this.left == null) {
            this.right = null;
        }
        return val;
    }

    public void print() {
        ListNode cur = this.left;
        while(cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println();
    }
}
