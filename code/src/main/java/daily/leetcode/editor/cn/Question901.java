package daily.leetcode.editor.cn;

import java.util.ArrayList;

public class Question901 {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class StockSpanner {
        int[] stack = new int[10000];
        int[] data = new int[10000];
        int top = 0, index = 0;

        public StockSpanner() {}

        public int next(int price) {
            // 单调递减栈出栈
            while (top > 0 && data[stack[top - 1]] <= price) {
                top--;
            }
            // 将当前点入栈
            stack[top++] = index;
            // 记录当前点
            data[index++] = price;
            // 次栈顶元素到当前点之间的距离就是 “跨度”
            return top > 1 ? index - stack[top - 2] - 1: index;
        }
    }


/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
//leetcode submit region end(Prohibit modification and deletion)

}