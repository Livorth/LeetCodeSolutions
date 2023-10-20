//package swordOffer.leetcode.editor.cn;
//
//public class Question剑指 Offer 33{
//public static void main(String[]args){
//        Solution solution=new Question剑指 Offer 33().new Solution();
//
//
//        }
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public boolean verifyPostorder(int[] postorder) {
//        return recur(postorder, 0, postorder.length - 1);
//    }
//
//    boolean recur(int[] postorder, int i, int j) {
//        if (i >= j) return true;
//        int p = i;
//        while (postorder[p] < postorder[j]) p++;
//        int m = p;
//        while (postorder[p] > postorder[j]) p++;
//        // 数组分为两段，前一段所有的元素小于数组中最后一个元素，后一段所有的元素大于数组中最后一个元素（后续遍历）
//        // 有且只有这两段，所以p==j
//        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//}