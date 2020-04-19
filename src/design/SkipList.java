package design;

import java.util.ArrayList;
import java.util.List;

public class SkipList {
    ListNode root;
    ArrayList<ListNode> levelNodes;
    public SkipList() {
        add(1);
    }

//    public boolean search(int target) {
//
//    }

    /**
     * add num to skipList and should add from button of skipList
     * @param num
     */
    public void add(int num) {
        if (levelNodes.isEmpty()) {
            root = new ListNode(num, 0, null, null, null, null);
            levelNodes.add(root);
        } else {
            // 插入的语义；
            // 什么时候需要进行
            ListNode tmp = levelNodes.get(0);
            if (tmp.val > num) {
                addLeftRootNode(num);
                return;
            }

            while(tmp!=null) {
                // find position to insert
                if (num < tmp.val) {
//                    1->2->4  num = 3
                    // find out *tmp*
                    ListNode pre = tmp.pre;
                    ListNode newNode = new ListNode(num, tmp.level, tmp, tmp, tmp.pre, null);
                    pre.next = newNode;
                    while (throwCoin()) {
                        // add newNode to uplevel;
                        ListNode nextUpNode = findNextPreNode(newNode.pre);
                        ListNode up = nextUpNode.up;
                        //
                        ListNode listNode = new ListNode(num, up.level, up.next, newNode, up, null);
                        if (up.next!= null ){
                            up.next.pre = listNode;
                        }
                        up.next = listNode;

                    }
                    return;

                } else {
                    tmp = tmp.next;
                }
            }
        }
    }

    private ListNode findNextPreNode(ListNode start) {
        ListNode tmp = start;
        while(tmp != null) {
            if (tmp.up != null) {
                return tmp;
            }
            tmp = tmp.pre;
        }
        return null;
    }

    /**
     * add num at head
     * @param num
     */
    void addLeftRootNode(int num) {
        ListNode pre = null;
        for (ListNode node:levelNodes) {
            ListNode newNode =new ListNode(num, node.level, node, pre, null, null);
            node.pre = newNode;
            if (pre != null) {
                pre.up = newNode;
            }
            pre = newNode;
        }
    }

//    public boolean erase(int num) {
//
//    }

    boolean throwCoin() {
        return Math.random() < 0.5f;
    }



    class ListNode {
        int val;
        int level;
        ListNode next;
        ListNode down;
        ListNode pre;
        ListNode up;

        public ListNode(int val, int level, ListNode next, ListNode down, ListNode pre, ListNode up) {
            this.val = val;
            this.level = level;
            this.next = next;
            this.down = down;
            this.pre = pre;
            this.up = up;
        }
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
