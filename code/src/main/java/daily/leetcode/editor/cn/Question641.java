package daily.leetcode.editor.cn;

import java.util.*;

public class Question641 {
    public static void main(String[] args) {

        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularDeque {

        private int[] elements;
        private int front;
        private int rear;
        // 最大容量，多一位可以避免在front和rear相等的时候出现无法判断空还是满的情况
        private int capacity;

        public MyCircularDeque(int k) {
            this.front = 0;
            this.rear = 0;
            this.capacity = k+1;
            this.elements = new int[k+1];
        }

        // 头插
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            front = (front - 1 + capacity) % capacity;
            elements[front] = value;
            return true;
        }

        // 尾插
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            elements[rear] = value;
            rear = (rear + 1) % capacity;
            return true;
        }

        // 头删
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            front = (front + 1) % capacity;
            return true;
        }

        // 尾删
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            rear = (rear - 1 + capacity) % capacity;
            return true;
        }

        // 获取头
        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return elements[front];
        }

        // 获取尾
        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return elements[(rear - 1 + capacity) % capacity];
        }

        // 是否空
        public boolean isEmpty() {
            return rear == front;
        }

        // 是否满
        public boolean isFull() {
            return (rear + 1) % capacity == front;
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
