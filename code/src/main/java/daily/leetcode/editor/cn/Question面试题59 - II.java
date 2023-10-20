//package daily.leetcode.editor.cn;
//
//import java.util.Deque;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Question面试题59 -II{
//
////    public static void main(String[] args) {
////        Solution solution = new Question面试题59 - II().new Solution();
////
////
////
////    }
////leetcode submit region begin(Prohibit modification and deletion)
//class MaxQueue {
//    // 队列存储当前的全部数据
//    Queue<Integer> queue;
//    // 双端队列存储当前的最大值，在push的时候遵从单调栈的加入方式
//    Deque<Integer> deque;
//
//    public MaxQueue() {
//        // 初始化
//        queue = new LinkedList<>();
//        deque = new LinkedList<>();
//    }
//
//    public int max_value() {
//        // 从双端队列中去找
//        return deque.isEmpty() ? -1 : deque.peekFirst();
//    }
//
//    public void push_back(int value) {
//        queue.offer(value);
//        // push操作需要对双端队列进行入栈操作，遵从单调栈的加入方式
//        // 遇到比value更小的值则出栈
//        while (!deque.isEmpty() && deque.peekLast() < value) {
//            deque.pollLast();
//        }
//        deque.offerLast(value);
//    }
//
//    public int pop_front() {
//        if (queue.isEmpty()) return -1;
//        // 如果出队的元素等于最大值，这个最大值也要出队
//        // 这里也不用担心多个相同最大值的情况，因为相同的值也在队里
//        if (queue.peek().equals(deque.peekFirst())) {
//            deque.pollFirst();
//        }
//        return queue.poll();
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//}