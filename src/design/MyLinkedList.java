package design;

class MyLinkedList {

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    ListNode head;
    ListNode tail;



    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        ListNode root  = head;
        int i=0;
        while (root!=null && i<index) {
            i++;
            root = root.next;
        }
        return root == null ? -1 : root.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (head == null) {
            head = new ListNode(val, null);
            tail = head;
        } else {
            ListNode tmp = head;
            head = new ListNode(val, tmp);
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (tail == null) {
            ListNode root = new ListNode(val, null);
            head = root;
            tail = root;
        } else {
            tail.next = new ListNode(val, null);
            tail = tail.next;
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
        } else {
//            If index equals to the length of linked list, the node will be appended to the end of linked list.
            int i = 1;          //head  index==3;
            ListNode r = head; // 2------->3    index = 2, val =4;
            while (r != null && i < index ) {
                r = r.next;
                i++;
            }

            if (r == null) {
                return;
            }
//            else if (i < index) {
//                return;
//            }
            else {
                ListNode tmp = r.next;
                r.next = new ListNode(val, tmp);
                // the last one. should modify tail pointer.
                if (tmp == null) {
                    tail = r.next;
                }
            }

        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            if (index == 0) {
                head = null;
                tail = null;
            }
            return;
        }


        if (index == 0) {
            head = head.next;
            return;
        }

        int i = 1;               //head
        ListNode r = head;  /// 2->3->4->5 // 2
        while (r != null && i < index) {
            r = r.next;
            i++;
        }

        if (r == null || r.next == null || i != index) {
            return; // over index;
        } else if (r.next.next == null) {// modify tail;
            //
            r.next = null;
            tail = r;
        } else {
            //
            r.next = r.next.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        ListNode t = head;
        while (t!= null) {
            sb.append(t.val).append("->");
            t = t.next;
        }
        return sb.append("[head:" + (head== null ?null : head.val) + "][tail:"+ (tail== null? null : tail.val)+"]").toString();
    }

    public static void main(String[] args) {
//        ["MyLinkedList","addAtHead","addAtTail","addAtHead","addAtTail","addAtHead","addAtHead","get","addAtHead","get","get","addAtTail"]
//         [[],           [7],         [7],        [9],       [8],        [6],         [0],       [5],    [0],      [2],  [5],   [4]]
        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(7);
//        System.out.println(linkedList);
//        linkedList.addAtTail(7);
//        System.out.println(linkedList);
//        linkedList.addAtHead(9);
//        System.out.println(linkedList);
//        linkedList.addAtTail(8);
//        System.out.println(linkedList);
//        linkedList.addAtHead(6);
//        System.out.println(linkedList);
//        linkedList.addAtHead(0);
//        System.out.println(linkedList);
//        System.out.println(linkedList.get(5));
//        linkedList.addAtHead(0);
//        System.out.println(linkedList.get(2));
//        System.out.println(linkedList.get(5));
//        linkedList.addAtTail(4);
//        System.out.println(linkedList);

//        linkedList.addAtHead(1);
//        System.out.println(linkedList);
//
//        linkedList.addAtTail(3);
//        System.out.println(linkedList);
//
//        linkedList.addAtIndex(1,2); ///
//        System.out.println(linkedList);
//
//        System.out.println(linkedList.get(1));
//        linkedList.deleteAtIndex(1);
//        System.out.println(linkedList);
//        System.out.println(linkedList.get(1));
//        System.out.println(linkedList);


//        ["MyLinkedList","addAtHead","deleteAtIndex","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtTail","get","deleteAtIndex","deleteAtIndex"]
//         [[],             [2],            [1],            [2],        [7],        [3],        [2],        [5],        [5],    [5],    [6],            [4]]
        linkedList.addAtHead(2);
        System.out.println(linkedList);
        linkedList.deleteAtIndex(1);
        System.out.println(linkedList);
        linkedList.addAtHead(2);
        System.out.println(linkedList);
        linkedList.addAtHead(7);
        System.out.println(linkedList);
        linkedList.addAtHead(3);
        System.out.println(linkedList);
        linkedList.addAtHead(2);
        System.out.println(linkedList);
        linkedList.addAtHead(5);
        System.out.println(linkedList);
        linkedList.addAtTail(5);
        System.out.println(linkedList);
        System.out.println(linkedList.get(5));
        linkedList.deleteAtIndex(6);
        System.out.println(linkedList);
        linkedList.deleteAtIndex(4);
        System.out.println(linkedList);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */