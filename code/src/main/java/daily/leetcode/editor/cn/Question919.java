package daily.leetcode.editor.cn;


import java.util.*;

public class Question919 {
    public static void main(String[] args) {

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


    class CBTInserter1 {
        private TreeNode root;
        // 采用队列的方式进行存储带有空子树的节点
        private Queue<TreeNode> queue;

        public CBTInserter1(TreeNode root) {
            this.root = root;
            queue = new ArrayDeque<>();
            // 借助队列进行广度优先搜索
            Queue<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            while(!q.isEmpty()) {
                TreeNode node = q.remove();

                if (node.right == null || node.left == null) {
                    queue.add(node);
                }

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }

        public int insert(int val) {
            TreeNode node = queue.peek();
            if (node.left == null) {
                node.left = new TreeNode(val);
                queue.add(node.left);
            }
            else {
                queue.remove();
                node.right = new TreeNode(val);
                queue.add(node.right);
            }
            return node.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }


    class CBTInserter {
        // 采用队列的方式进行存储带有空子树的节点
        Queue<TreeNode> queue;
        TreeNode r;
        public CBTInserter(TreeNode root) {
            queue = new LinkedList<TreeNode>();
            r = root;
            // 借助队列进行广度优先搜索
            Queue<TreeNode> t = new LinkedList<TreeNode>();
            t.add(r);
            while(!t.isEmpty()){
                TreeNode tn = t.poll();
                // 将当前节点的左右子树添加进辅助队列
                if(tn.left != null){
                    t.add(tn.left);
                }
                if(tn.right != null){
                    t.add(tn.right);
                }
                // 含有空子树，入队
                if(tn.left == null || tn.right == null){
                    queue.add(tn);
                }
            }

        }

        public int insert(int val) {
            TreeNode t = new TreeNode(val);
            // 进左子树
            if(queue.peek().left==null){
                queue.peek().left=t;
                queue.add(t);
                return queue.peek().val;
            }
            // 进右子树
            else{
                queue.peek().right=t;
                queue.add(t);
                //　注意当右子树有节点后需要将父节点移除
                return queue.poll().val;
            }
        }

        public TreeNode get_root() {
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}





