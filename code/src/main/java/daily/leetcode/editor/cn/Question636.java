package daily.leetcode.editor.cn;

import java.util.*;

public class Question636 {
    public static void main(String[] args) {
        Solution solution = new Question636().new Solution();
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        // 使用数组存储每个线程的消耗时间
        int[] ans = new int[n];
        // 使用双端队列模拟栈
        Deque<Integer> stack = new ArrayDeque<>();
        // 记录上一个线程操作的位置
        int lastPos = 0;
        for (String log : logs) {
            String[] ss = log.split(":");
            // 线程的编号
            int index = Integer.parseInt(ss[0]);
            // 当前线程操作的位置
            int cur = Integer.parseInt(ss[2]);


            if (ss[1].equals("start")) {
                // 栈不为空，则说明上一个线程中断，需要更新时长
                if (!stack.isEmpty()){
                    ans[stack.peekLast()] += cur - lastPos;
                }
                // 新线程入栈
                stack.addLast(index);
                lastPos = cur;
            }
            else {
                // 线程结束，出栈，并更新时长
                int idx = stack.pollLast();
                ans[idx] += cur - lastPos + 1;
                lastPos = cur + 1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
