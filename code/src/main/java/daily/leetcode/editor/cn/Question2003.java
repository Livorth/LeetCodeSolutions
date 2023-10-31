package daily.leetcode.editor.cn;

import java.util.*;

public class Question2003 {
    public static void main(String[] args) {
        Solution solution = new Question2003().new Solution();
        int[] ints = solution.smallestMissingValueSubtree(new int[]{-1, 0, 0, 2}, new int[]{-1, 0, 0, 2});
        int[] ints1 = solution.smallestMissingValueSubtree(new int[]{-1, 0, 1, 0, 3, 3}, new int[]{5, 4, 6, 2, 1, 3});
        int[] ints2 = solution.smallestMissingValueSubtree(new int[]{-1, 2, 3, 0, 2, 4, 1}, new int[]{2, 3, 4, 5, 6, 7, 8});
        System.out.printf("?");
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:95 ms,击败了61.90% 的Java用户
     * 内存消耗:75.5 MB,击败了76.19% 的Java用户
     */
    class Solution {
        private List<Integer>[] graph;
        Set<Integer> vis;
        private int[] nums;
        private int[] res;

        public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
            int length = parents.length;

            res = new int[length];
            Arrays.fill(res, 1);
            // 从基因为1的点开始往上遍历
            int node = -1;
            for (int i = 0; i < length; i++) {
                if (nums[i] == 1) {
                    node = i; // 出发点
                    break;
                }
            }
            // 没有基因为1的点，那所有点都少1
            if (node < 0) {
                return res;
            }

            // 构建树，记录每个节点的子节点
            graph = new List[length];
            Arrays.setAll(graph, e -> new ArrayList<>());
            for (int i = 0; i < length; i++) {
                if (parents[i] == -1) continue;
                this.graph[parents[i]].add(i);
            }
            this.nums = nums;
            vis = new HashSet<>();
            int min = 2;
            // 从基因为1的节点出发，计算沿途的res
            while (node >= 0) {
                dfs(node);
                while (vis.contains(min)) {
                    min++;
                }
                res[node] = min;
                // 节点往上走
                node = parents[node];
            }
            dfs(0);
            return res;
        }

        private void dfs(int i) {
            vis.add(nums[i]);
            for (Integer child : graph[i]) {
                if (!vis.contains(nums[child]))
                    dfs(child);
            }
        }
    }

    /**
     * Time Limit Exceeded
     */
    class SolutionTimeOut {
        private List<Integer>[] graph;
        private Set<Integer>[] sets;
        private int[] nums;
        private int[] res;

        public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
            int length = parents.length;
            graph = new List[length];
            sets = new Set[length];
            Arrays.setAll(graph, e -> new ArrayList<>());
            for (int i = 0; i < length; i++) {
                if (parents[i] == -1) continue;
                this.graph[parents[i]].add(i);
            }
            this.nums = nums;
            res = new int[length];
            // 自顶向下遍历并计算每一个节点的值
            dfs(0);
            return res;
        }

        private void dfs(int i) {
            if (sets[i] == null) {
                sets[i] = new HashSet<>();
                sets[i].add(nums[i]);
                for (Integer child : graph[i]) {
                    dfs(child);
                    sets[i].addAll(sets[child]);
                }
            }
            getMin(i);
        }

        private void getMin(int i) {
            if (res[i] != 0) return;
            int min = 1;
            while (sets[i].contains(min)) { // node 子树包含这个基因值
                min++;
            }
            res[i] = min;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}