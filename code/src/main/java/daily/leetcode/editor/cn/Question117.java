package daily.leetcode.editor.cn;

import java.util.*;

public class Question117 {
    public static void main(String[] args) {
//        Solution solution = new Question117().new Solution();


    }

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:2 ms,击败了28.72% 的Java用户
     * 内存消耗:42.1 MB,击败了49.13% 的Java用户
     */
    class SolutionBFS1 {
        public Node connect(Node root) {
            Deque<Node> pa = new ArrayDeque<>();
            if (root != null) pa.add(root);
            while (!pa.isEmpty()) {
                Deque<Node> children = new ArrayDeque<>();
                while (!pa.isEmpty()) {
                    Node cur = pa.poll();
                    cur.next = pa.peek();
                    if (cur.left != null) children.add(cur.left);
                    if (cur.right != null) children.add(cur.right);
                }
                pa = children;
            }
            return root;
        }
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.2 MB,击败了14.17% 的Java用户
     */
    class SolutionDFS {
        Node[] heads = new Node[6001];

        public Node connect(Node root) {
            dfs(root, 0);
            return root;
        }

        private void dfs(Node node, int depth) {
            if (node == null) return;
            if (heads[depth] == null) {
                heads[depth] = node;
            } else {
                heads[depth].next = node;
                // 节点后移
                heads[depth] = heads[depth].next;
            }
            dfs(node.left, depth + 1);
            dfs(node.right, depth + 1);
        }
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.9 MB,击败了68.88% 的Java用户
     */
    class Solution {
        public Node connect(Node root) {
            Node node = root;
            // 存下一层的所有节点
            Node list = new Node();

            // 遍历每一个节点
            while (node != null) {
                list.next = null;
                Node next = list;

                // 遍历 当前层的节点
                while (node != null) {
                    if (node.left != null) {
                        next.next = node.left;
                        next = next.next;
                    }
                    if (node.right != null) {
                        next.next = node.right;
                        next = next.next;
                    }
                    // 节点后移
                    node = node.next;
                }
                // 从下一层的第一个节点开始
                node = list.next;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}