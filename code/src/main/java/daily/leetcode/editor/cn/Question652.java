package daily.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.*;

public class Question652 {
    public static void main(String[] args) {
        Solution solution = new Question652().new Solution();


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
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        private Map<String, Integer> map = new HashMap<>();
        private List<TreeNode> res = new LinkedList<>();

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            dfs(root);
            return res;
        }

        // 使用DFS求出所有子树
        private StringBuilder dfs(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            // 子树为空则返回空串
            if (root == null){
                return sb;
            }

            // 当前节点加上左树节点加上右树节点，其中用'/'隔开
            sb.append(root.val).append('/').append(dfs(root.left)).append('/').append(dfs(root.right));

            String s = sb.toString();
            // 如果当前子树已经存在
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
                // 添加当前树的根节点进结果集
                if (map.get(s) == 2){
                    res.add(root);
                }
            }
            else{
                map.put(s, 1);
            }
            return sb;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}