//package swordOffer.leetcode.editor.cn;
//
//public class Question剑指 Offer 36{
//public static void main(String[]args){
//        Solution solution=new Question剑指 Offer 36().new Solution();
//
//
//        }
//
//class Node {
//    public int val;
//    public Node left;
//    public Node right;
//
//    public Node() {
//    }
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, Node _left, Node _right) {
//        val = _val;
//        left = _left;
//        right = _right;
//    }
//};
//
////leetcode submit region begin(Prohibit modification and deletion)
//
//
//class Solution {
//    // head记录头结点，pre记录前驱节点
//    Node head, pre;
//
//    public Node treeToDoublyList(Node root) {
//        if (root == null) return null;
//        dfs(root);
//        // 遍历完后再最后进行一下出来，形成环
//        pre.right = head;
//        head.left = pre;
//
//        return head;
//    }
//
//    // 中序遍历
//    public void dfs(Node cur) {
//        if (cur == null) return;
//        dfs(cur.left);
//
//        // 当还没有前驱节点的时候，说明当前节点为头节点
//        if (pre == null) head = cur;
//            // 当已经有前驱节点的时候，接在后面即可
//        else pre.right = cur;
//        // 指向前驱节点
//        cur.left = pre;
//        // 前驱节点后移
//        pre = cur;
//        dfs(cur.right);
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//
//}
//
//
//
//
//
//
