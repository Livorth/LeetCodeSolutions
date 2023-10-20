package daily.leetcode.editor.cn;

import java.util.*;

public class Question622 {
    public static void main(String[] args) {
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularQueue {

        //　采用数组模拟循环队列
        private int[] data;
        private int front, rear;

        public MyCircularQueue(int k) {
            this.data = new int[k + 1];
            this.front = 0;
            this.rear = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            data[rear] = value;
            // 尾指针后移一位
            rear = (rear + 1) % data.length;;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            // 首指针后移一位
            front = (front + 1) % data.length;;
            return true;
        }

        // 首指针指向的地址
        public int Front() {
            return isEmpty() ? -1 : data[front];
        }

        // 尾指针指向地址的前一个地址
        public int Rear() {
            return isEmpty() ? -1 : data[(rear + data.length - 1) % data.length];
        }

        // 首尾指针指向同一个地址
        public boolean isEmpty() {
            return front == rear;
        }

        // 尾指针后一个就是首指针
        public boolean isFull() {
            return  (rear + 1) % data.length == front;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
