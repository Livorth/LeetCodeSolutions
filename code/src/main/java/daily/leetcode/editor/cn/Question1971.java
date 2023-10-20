package daily.leetcode.editor.cn;

import java.util.*;

public class Question1971 {
    public static void main(String[] args) {
        Solution solution = new Question1971().new Solution();
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] p;

        public boolean validPath(int n, int[][] edges, int source, int destination) {
            p = new int[n];
            // 初始化爹
            for (int i = 0; i < n; ++i) {
                p[i] = i;
            }
            // 对每一条边进行节点合并
            for (int[] e : edges) {
                p[find(e[0])] = find(e[1]);
            }
            // 看看两个目标节点是否有同一个爹
            return find(source) == find(destination);
        }

        private int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            return p[x];
        }
    }

    class Solution1 {
        private int[] root;
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            root = new int[n];
            for (int i = 0 ; i < n; i++) root[i] = i;
            for (int[] edge : edges) {
                union(edge[0], edge[1]);
                if (find(source) == find(destination)) return true;
            }
            return find(source) == find(destination);
        }

            private void union(int p, int q) {
            root[find(q)] = find(p);
        }

        private int find(int n) {
            return root[n] == n ? n : (root[n] = find(root[n]));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}