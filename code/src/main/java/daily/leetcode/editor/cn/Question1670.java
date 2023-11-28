package daily.leetcode.editor.cn;

import java.util.*;

public class Question1670 {
    public void main(String[] args) {
        FrontMiddleBackQueue a = new FrontMiddleBackQueue();
        a.pushMiddle(1);
        a.pushMiddle(2);
        a.pushMiddle(3);
        System.out.println(a.popMiddle());
        System.out.println(a.popMiddle());
        System.out.println(a.popMiddle());
        System.out.println(a.popMiddle());

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 两个双向队列分别维护前半段和后半段
     * 执行耗时:6 ms,击败了80.50% 的Java用户
     * 内存消耗:43.3 MB,击败了22.01% 的Java用户
     */
    class FrontMiddleBackQueue1 {
        private final Deque<Integer> left = new ArrayDeque<>();
        private final Deque<Integer> right = new ArrayDeque<>();

        // 调整长度，保证 0 <= right.size() - left.size() <= 1
        // 从而保证可以在正中间插入删除元素
        private void balance() {
            if (left.size() > right.size()) {
                right.addFirst(left.pollLast());
            } else if (right.size() > left.size() + 1) {
                left.addLast(right.pollFirst());
            }
        }

        public void pushFront(int val) {
            left.addFirst(val);
            balance();
        }

        public void pushMiddle(int val) {
            if (left.size() < right.size()) {
                left.addLast(val);
            } else {
                right.addFirst(val);
            }
        }

        public void pushBack(int val) {
            right.addLast(val);
            balance();
        }

        public int popFront() {
            if (right.isEmpty()) {
                return -1;
            }
            int val = left.isEmpty() ? right.pollFirst() : left.pollFirst();
            balance();
            return val;
        }

        public int popMiddle() {
            if (right.isEmpty()) {
                return -1;
            }
            if (left.size() == right.size()) {
                return left.pollLast();
            }
            return right.pollFirst();
        }

        public int popBack() {
            if (right.isEmpty()) {
                return -1;
            }
            int val = right.pollLast();
            balance();
            return val;
        }
    }

    /**
     * 直接自定义数据结构，使用双向链表
     * 执行耗时:5 ms,击败了100.00% 的Java用户
     * 内存消耗:43.4 MB,击败了13.21% 的Java用户
     */
    class FrontMiddleBackQueue2 {
        Node head;
        Node tail;
        // count为奇数的时候mid指向正中间，count为偶数的时候mid指向count/2位置的node
        Node mid;
        int count;

        public FrontMiddleBackQueue2() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
            mid = tail;
            count = 0;
        }

        public void pushFront(int val) {
            Node node = new Node(val);
            node.next = head.next;
            node.next.pre = node;
            node.pre = head;
            head.next = node;
            if (count > 0) {
                // mid前移
                if (count % 2 == 0) {
                    mid = mid.pre;
                }
            } else {
                mid = node;
            }
            count++;
        }

        public void pushMiddle(int val) {
            if (count == 0) {
                pushFront(val);
                return;
            }
            Node node = new Node(val);
            // 在mid之前插入node
            node.pre = mid.pre;
            mid.pre.next = node;
            node.next = mid;
            mid.pre = node;
            // 偶数变奇数，mid前移
            if (count % 2 == 0) {
                mid = node;
            }
            count++;
        }

        public void pushBack(int val) {
            Node node = new Node(val);
            node.pre = tail.pre;
            node.pre.next = node;
            node.next = tail;
            tail.pre = node;
            if (count > 0) {
                // mid后移
                if (count % 2 == 1) {
                    mid = mid.next;
                }
            } else {
                mid = node;
            }
            count++;
        }

        public int popFront() {
            if (count == 0) return -1;
            int ans = head.next.val;
            head.next = head.next.next;
            head.next.pre = head;
            if (count % 2 == 1) {
                mid = mid.next;
            }
            count--;
            return ans;
        }

        public int popMiddle() {
            if (count == 0) return -1;
            int ans;
            if (count % 2 == 0) {
                ans = mid.pre.val;
                mid.pre.pre.next = mid;
                mid.pre = mid.pre.pre;
            } else {
                ans = mid.val;
                mid.pre.next = mid.next;
                mid.next.pre = mid.pre;
                mid = mid.next;
            }
            count--;
            return ans;
        }

        public int popBack() {
            if (count == 0) return -1;
            int ans = tail.pre.val;
            tail.pre = tail.pre.pre;
            tail.pre.next = tail;
            if (count % 2 == 0) {
                mid = mid.pre;
            }
            count--;
            return ans;
        }

        class Node {
            Node pre;
            Node next;
            int val;

            private Node() {

            }

            private Node(int val) {
                this.val = val;
            }
        }

    }

    /**
     * 直接自定义数据结构，使用双向链表
     * 执行耗时:5 ms,击败了100.00% 的Java用户
     * 内存消耗:43.4 MB,击败了10.69% 的Java用户
     */
    class FrontMiddleBackQueue {
        Node head;
        Node tail;
        Node mid;
        int count;

        public FrontMiddleBackQueue() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
            mid = tail;
            count = 0;
        }

        public void pushFront(int val) {
            Node node = new Node(val);
            node.next = head.next;
            node.next.pre = node;
            node.pre = head;
            head.next = node;
            if (count > 0) {
                // mid前移
                if (count % 2 == 1) {
                    mid = mid.pre;
                }
            } else {
                mid = node;
            }
            count++;
        }

        public void pushMiddle(int val) {
            if (count == 0) {
                pushFront(val);
                return;
            }
            Node node = new Node(val);
            if (count % 2 == 0) {
                node.pre = mid;
                node.next = mid.next;
                mid.next.pre = node;
                mid.next = node;
            } else {
                node.pre = mid.pre;
                node.next = mid;
                mid.pre.next = node;
                mid.pre = node;
            }
            mid = node;
            count++;
        }

        public void pushBack(int val) {
            Node node = new Node(val);
            node.pre = tail.pre;
            node.pre.next = node;
            node.next = tail;
            tail.pre = node;
            if (count > 0) {
                if (count % 2 == 0) {
                    mid = mid.next;
                }
            } else {
                mid = node;
            }
            count++;
        }

        public int popFront() {
            if (count == 0) return -1;
            int ans = head.next.val;
            head.next = head.next.next;
            head.next.pre = head;
            if (count % 2 == 0) {
                mid = mid.next;
            }
            count--;
            return ans;
        }

        public int popMiddle() {
            if (count == 0) return -1;
            int ans = mid.val;
            mid.pre.next = mid.next;
            mid.next.pre = mid.pre;
            if (count % 2 == 0) {
                mid = mid.next;
            } else {
                mid = mid.pre;
            }
            count--;
            return ans;
        }

        public int popBack() {
            if (count == 0) return -1;
            int ans = tail.pre.val;
            tail.pre = tail.pre.pre;
            tail.pre.next = tail;
            if (count % 2 == 1) {
                mid = mid.pre;
            }
            count--;
            return ans;
        }

        class Node {
            Node pre;
            Node next;
            int val;

            private Node() {

            }

            private Node(int val) {
                this.val = val;
            }
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}