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


    class Solution {
        int max = 0;

        private int dfs(TreeNode root, int start, int time) {
            if (root == null) return -1;
            // 如果本节点是start，那么从当前节点开始感染
            if (time == -1 && root.val == start) time = 0;

            if (time != -1) {
                dfs(root.left, start, time + 1);
                dfs(root.right, start, time + 1);
                if (time > max) max = time;
                return time + 1;
            } else {
                int tem = dfs(root.left, start, time);
                if (tem != -1) {//左子树被感染，传递到右子树
                    time = tem;
                    dfs(root.right, start, time + 1);
                } else {//右子树被感染，传递到左子树
                    tem = dfs(root.right, start, time);
                    if (tem != -1) {
                        time = tem;
                        dfs(root.left, start, time + 1);
                    }
                }
            }
            if (time > max) max = time;
            if (time != -1) return time + 1;
            return -1;
        }

        public int amountOfTime(TreeNode root, int start) {
            dfs(root, start, -1);
            return max;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}