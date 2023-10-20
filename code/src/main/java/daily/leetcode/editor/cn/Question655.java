package daily.leetcode.editor.cn;

import java.util.*;

public class Question655 {
    public static void main(String[] args) {
        Solution solution = new Question655().new Solution();
        
        
        
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> printTree(TreeNode root) {
            int height = getHeight(root);
            int m = height + 1;
            int n = (1 << (height + 1)) - 1;
            ArrayList<List<String>> ans = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                List<String> row = new ArrayList<String>();
                for (int j = 0; j < n; j++) {
                    row.add("");
                }
                ans.add(row);
            }
            // 根节点放首行中间
            dfs(ans, root, 0, (n - 1) / 2, height);
            return ans;
        }

        // 获取height
        private int getHeight(TreeNode root){
            int height = 0;
            if(root.right != null){
                height = Math.max(height, getHeight(root.right) + 1);
            }
            if(root.left != null){
                height = Math.max(height, getHeight(root.left) + 1);
            }
            return height;
        }

        /**
         * 将节点放到数组中对应的位置中去
         * @param ans 结果数组
         * @param root 根节点
         * @param r 在矩阵中的y轴位置
         * @param c 在矩阵中的x轴位置
         * @param height 树的高度
         */
        public void dfs(List<List<String>> res, TreeNode root, int r, int c, int height) {
            // 放到对应的位置
            res.get(r).set(c, Integer.toString(root.val));
            // 继续遍历左右子树
            if (root.left != null) {
                dfs(res, root.left, r + 1, c - (1 << (height - r - 1)), height);
            }
            if (root.right != null) {
                dfs(res, root.right, r + 1, c + (1 << (height - r - 1)), height);
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}