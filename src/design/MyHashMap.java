package design;

import java.util.HashMap;

public class MyHashMap {

//    所有的值都在 [0, 1000000]的范围内。
//    操作的总数目在[1, 10000]范围内
    class ListNode {
        int val;
        int key;
        ListNode next;
        public ListNode(int key, int val, ListNode node) {
            this.key = key;
            this.val = val;
            this.next = node;
        }
    }
    ListNode[] array = new ListNode[7777];
    /** Initialize your data structure here. */
    public MyHashMap() {

    }

    int indexOf(int val) {
        return val % 7777;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = indexOf(key);
        if(array[index] == null) {
            array[index] = new ListNode(key, value, null);
        } else {
            ListNode tmp = array[index];
            if (tmp.key == key) {
                tmp.val = value;
                return;
            }
            while (tmp.next != null) {
                if (tmp.key == key) {
                    tmp.val = value;
                    return;
                }
                tmp = tmp.next;
            }
            tmp.next = new ListNode(key, value, null);
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = indexOf(key);
        if (array[index] != null) {
            ListNode node = array[index];
            while(node != null) {
                if (node.key == key) {
                    return node.val;
                }
                node = node.next;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index= indexOf(key);
        if (array[index] == null) {
            return;
        }
        ListNode head = array[index];
        if (head.key == key) {
            array[index] = head.next;
        } else {
            while (head.next != null) {
                if (head.next.key == key) {
                    head.next = head.next.next;
                    return;
                }
                head = head.next;
            }
        }
    }


    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(3));
        hashMap.put(2, 1); // 更新已有的值
        System.out.println(hashMap.get(2));
        hashMap.remove(2);  // 删除键为2的数据
        System.out.println(hashMap.get(2));

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */


