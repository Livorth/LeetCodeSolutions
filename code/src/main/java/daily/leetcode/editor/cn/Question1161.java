package daily.leetcode.editor.cn;

import java.util.*;

public class Question1161 {
    public static void main(String[] args) {
        Solution solution = new Question1161().new Solution();
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE, depth = 1, ans = 0;
        // 借助队列进行BFS
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        while (!d.isEmpty()) {
            // 一次计算一层
            int sz = d.size(), cur = 0;
            // 将当前层的子节点全部加入队列，同时计算当前层的元素和
            while (sz-- > 0) {
                TreeNode t = d.pollFirst();
                if (t.left != null) d.addLast(t.left);
                if (t.right != null) d.addLast(t.right);
                cur += t.val;
            }
            if (cur > max) {
                max = cur;
                ans = depth;
            }
            depth++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


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
}