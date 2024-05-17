package daily.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question2589 {
    public static void main(String[] args) {
        Solution solution = new Question2589().new Solution();
        solution.findMinimumTime(new int[][]{
                {2, 3, 1},
                {4, 5, 1},
                {1, 5, 2}
        });

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 贪心：
     * 按照右边界从小到大排序
     * 对于排序后的时间段，则优先从后往前取
     * 因为在其后面的时间段，要么与其没有交集，要么有交集交集也是与其最后这段相连的
     * <p>
     * 执行耗时:30 ms,击败了20.41% 的Java用户
     * 内存消耗:44.2 MB,击败了38.78% 的Java用户
     */
    class Solution1 {
        public int findMinimumTime(int[][] tasks) {
            int res = 0;
            // 右边界从小到大排序
            Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
            // 求出右边界的最大值
            int max = tasks[tasks.length - 1][1];
            boolean[] visited = new boolean[max + 1];
            for (int[] task : tasks) {
                // 去掉已经运行过的部分
                for (int i = task[0]; i <= task[1]; i++) {
                    if (visited[i]) task[2]--;
                }
                // 贪心：从后往前选择时间点开始运行
                for (int i = task[1]; task[2] > 0; i--) {
                    if (!visited[i]) {
                        visited[i] = true;
                        task[2]--;
                        res++;
                    }
                }
            }
            return res;
        }
    }


    /**
     * 贪心+栈+二分查找优化：
     * 由于每次都是从后往前取，其实也就是相当于将左侧的不连续的小区间合并成大区间
     * 所以这里使用栈来进行优化，栈中存储左侧的各个小区间的端点位置
     * 同时使用二分查找获取到有多少小区间在当前的范围内，方便快速去除已经运行中的节点
     * <p>
     * 执行耗时:8 ms,击败了98.67% 的Java用户
     * 内存消耗:44.1 MB,击败了46.88% 的Java用户
     */
    class Solution {
        public int findMinimumTime(int[][] tasks) {
            Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
            // 栈存不连续的小区间：左端点、右端点、从最开始到当前右端点运行的节点数量
            List<int[]> stack = new ArrayList<>();
            // 添加哨兵
            stack.add(new int[]{-10086, -10086, 0});
            for (int[] task : tasks) {
                int left = task[0];
                int right = task[1];
                int target = task[2];
                int[] mostLeft = stack.get(lowerBound(stack, left) - 1);
                // 去掉被包含的完整小区间
                target -= stack.get(stack.size() - 1)[2] - mostLeft[2];
                // 去掉left落在的区间中的后半截
                if (left <= mostLeft[1]) {
                    target -= mostLeft[1] - left + 1;
                }
                if (target <= 0) continue;
                // 区间合并，直到栈顶区间右端点到target之前
                while (right - stack.get(stack.size() - 1)[1] <= target) {
                    mostLeft = stack.remove(stack.size() - 1);
                    // 已经运作中的部分要继续加上
                    target += mostLeft[1] - mostLeft[0] + 1;
                }
                // 小区间合并成大区间
                stack.add(new int[]{right - target + 1, right, stack.get(stack.size() - 1)[2] + target});

            }
            return stack.get(stack.size() - 1)[2];
        }

        private int lowerBound(List<int[]> stack, int target) {
            int left = 0, right = stack.size();
            while (left < right) {
                int mid = (left + right) >>> 1;
                // mid的左端点比目标值更大，则落在左侧
                if (stack.get(mid)[0] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}