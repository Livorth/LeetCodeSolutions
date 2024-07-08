package daily.leetcode.editor.cn;

public class Question2385 {
    public static void main(String[] args) {
        Solution solution = new Question2385().new Solution();


    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 单次dfs，直接在dfs计算出两种情况
     * 执行耗时:12 ms,击败了79.17% 的Java用户
     * 内存消耗:77.8 MB,击败了69.17% 的Java用户
     */
    class Solution1 {
        int res = 0;
        int depth = -1;

        public int amountOfTime(TreeNode root, int start) {
            dfs(root, 0, start);
            return res;
        }

        /**
         * @param node
         * @param level 当前深度
         * @param start
         * @return 后边还有多深
         */
        private int dfs(TreeNode node, int level, int start) {
            if (node == null) return 0;
            // 记录start的深度
            if (node.val == start) this.depth = level;

            int ldpt = dfs(node.left, level + 1, start);
            // start是否在左子树，如果不在那肯定就在右边
            boolean inL = this.depth != -1 ? true : false;
            int rdpt = dfs(node.right, level + 1, start);
            // 1. 计算以当前节点为根节点的树所需要的时间
            if (inL) {
                // 从start出发到node的距离 + node另一侧子树的深度
                this.res = Math.max(res, depth - level + rdpt);
            } else {
                this.res = Math.max(res, depth - level + ldpt);
            }
            // 2. 当前点就是start，而且最深路径就在start子树中
            if (node.val == start) {
                res = Math.max(res, Math.max(ldpt, rdpt));
            }
            return Math.max(ldpt, rdpt) + 1;
        }


        int dfs1(TreeNode root, int level, int start) {
            if (root == null) return 0;
            if (root.val == start) depth = level;                       // 当前节点即起始节点
            int l = dfs(root.left, level + 1, start);                   // 左子树的树高
            boolean inLeft = depth != -1;                               // 起始节点是否在左子树上
            int r = dfs(root.right, level + 1, start);                  // 右子树的树高
            if (root.val == start) res = Math.max(res, Math.max(l, r)); // 情况1：感染以 start 为根结点的树所需时间
            if (inLeft) res = Math.max(res, depth - level + r);         // 情况2：感染以 root 为根结点的树所需时间
            else res = Math.max(res, depth - level + l);
            return Math.max(l, r) + 1;                                  // 返回树高
        }
    }

    /**
     * 单次dfs
     * 执行耗时:12 ms,击败了87.75% 的Java用户
     * 内存消耗:77.3 MB,击败了80.15% 的Java用户
     */
    class Solution {
        int res = 0;
        int sd = -1;

        public int amountOfTime(TreeNode root, int start) {
            dfs(root, 0, start);
            return res;
        }

        private int dfs(TreeNode root, int depth, int start) {
            if (root == null) return 0;
            if (root.val == start) sd = depth;
            int left = dfs(root.left, depth + 1, start);
            boolean inLeft = sd != -1;
            int right = dfs(root.right, depth + 1, start);
            // start往下出发的情况，即start的两颗子树的深度
            if (root.val == start) {
                res = Math.max(res, Math.max(left, right));
            }
            // start往上出发的情况，即start的每个父节点的另一棵子树的情况
            if (inLeft) {
                res = Math.max(res, right + sd - depth);
            } else {
                res = Math.max(res, left + sd - depth);
            }
            // 返回root节点的树高
            return Math.max(left, right) + 1;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}