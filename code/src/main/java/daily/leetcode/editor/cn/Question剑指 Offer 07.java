//package swordOffer.leetcode.editor.cn;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Question剑指 Offer 07{
//public static void main(String[]args){
//        Solution solution=new Question剑指 Offer 07().new Solution();
//
//
//        }
//
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}
////leetcode submit region begin(Prohibit modification and deletion)
//
//
//public class Solution {
//
//    // 使用全局变量是为了让递归方法少传一些参数，不一定非要这么做
//
//    private Map<Integer, Integer> reverses;
//    private int[] preorder;
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int preLen = preorder.length;
//        int inLen = inorder.length;
//
//        // 可以不做判断，因为题目中给出的数据都是有效的
//        if (preLen != inLen) {
//            return null;
//        }
//
//        this.preorder = preorder;
//
//        // 以空间换时间，否则，找根结点在中序遍历中的位置需要遍历
//        reverses = new HashMap<>(inLen);
//        for (int i = 0; i < inLen; i++) {
//            reverses.put(inorder[i], i);
//        }
//
//        return buildTree(0, preLen - 1, 0, inLen - 1);
//    }
//
//    private TreeNode buildTree(int preL, int preR, int inL, int inR) {
//        if (preL > preR || inL > inR) {
//            return null;
//        }
//        // 构建的新二叉树的根结点一定是前序遍历数组的第 1 个元素
//        int pivot = preorder[preL];
//        TreeNode root = new TreeNode(pivot);
//
//        int pivotIndex = reverses.get(pivot);
//
//        // pivotIndex - inL为左树的节点个数
//        root.left = buildTree(preL + 1, preL + (pivotIndex - inL), inL, pivotIndex - 1);
//        root.right = buildTree(preL + (pivotIndex - inL) + 1, preR, pivotIndex + 1, inR);
//        return root;
//    }
//}
//
////leetcode submit region end(Prohibit modification and deletion)
//
//}