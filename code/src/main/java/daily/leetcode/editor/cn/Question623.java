package daily.leetcode.editor.cn;

import java.util.*;

public class Question623 {
    public static void main(String[] args) {
        Solution solution = new Question623().new Solution();


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
        public TreeNode addOneRowByDFS(TreeNode root, int val, int depth) {
            if(root == null){
                return null;
            }
            // depth为1的时候，成功根节点
            if (depth == 1) {
                return new TreeNode(val, root, null);
            }
            // depth为2的时候插入节点
            else if (depth == 2) {
                root.left = new TreeNode(val, root.left, null);
                root.right = new TreeNode(val, null, root.right);
                return root;
            }
            // 其他情况继续往下遍历
            else{
                root.left = addOneRow(root.left, val, depth - 1);
                root.right = addOneRow(root.right, val, depth - 1);
            }
            return root;
        }


        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            if (depth == 1) {
                return new TreeNode(val, root, null);
            }
            // 模拟队列，一次存储一层
            List<TreeNode> curLevel = new ArrayList<TreeNode>();
            curLevel.add(root);
            // 遍历每一层
            for (int i = 1; i < depth - 1; i++) {
                // 存储下一层的节点
                List<TreeNode> nextLevel = new ArrayList<TreeNode>();
                for (TreeNode node : curLevel) {
                    if (node.left != null) {
                        nextLevel.add(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.add(node.right);
                    }
                }
                curLevel = nextLevel;
            }
            // 给这一层的每一个子节点都进行替换
            for (TreeNode node : curLevel) {
                node.left = new TreeNode(val, node.left, null);
                node.right = new TreeNode(val, null, node.right);
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
