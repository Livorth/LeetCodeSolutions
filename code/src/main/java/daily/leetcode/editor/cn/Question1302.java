package daily.leetcode.editor.cn;

import java.util.*;

public class Question1302 {
    public static void main(String[] args) {
        Solution solution = new Question1302().new Solution();
        
        
        
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
        int ans = 0;
        int maxDepth = 0;
        public int deepestLeavesSum(TreeNode root) {
            dfs(root, 0);
            return ans;
        }


        void dfs(TreeNode node, int depth){
            if (node == null){
                return;
            }
            if (node.left == null && node.right == null){
                // 是目前的最大层
                if (depth == maxDepth){
                    ans += node.val;
                }
                // 是更大层，更新结果
                else if (depth > maxDepth){
                    maxDepth = depth;
                    ans = node.val;
                }
            }
            dfs(node.left,depth+1);
            dfs(node.right,depth+1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}