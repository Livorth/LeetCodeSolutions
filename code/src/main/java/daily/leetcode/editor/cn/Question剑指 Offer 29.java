//package swordOffer.leetcode.editor.cn;
//
//public class Question剑指 Offer 29{
//public static void main(String[]args){
//        Solution solution=new Question剑指 Offer 29().new Solution();
//
//
//        }
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int[] spiralOrder(int[][] matrix) {
//        int[] res = new int[matrix.length * matrix[0].length];
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
//
//        int up = 0;
//        int down = matrix.length - 1;
//        int left = 0;
//        int right = matrix[0].length - 1;
//        int index = 0;
//
//        while (true) {
//            // 一个轮回是从左到右，然后往下，然后往左，最后往上，即为一圈
//            //向右移动直到最右
//            for (int i = left; i <= right; ++i)
//                res[index++] = matrix[up][i];
//            // 为什么是设定上边界呢，因为这个从左往右的遍历是遍历了最上面那条边
//            //重新设定上边界，若上边界大于下边界，则遍历遍历完成
//            if (++up > down) break;
//            //向下
//            for (int i = up; i <= down; ++i)
//                res[index++] = matrix[i][right];
//            //重新设定右边界
//            if (--right < left) break;
//            //向左
//            for (int i = right; i >= left; --i)
//                res[index++] = matrix[down][i];
//            //重新设定下边界
//            if (--down < up) break;
//            //向上
//            for (int i = down; i >= up; --i)
//                res[index++] = matrix[i][left];
//            //重新设定左边界
//            if (++left > right) break;
//        }
//        return res;
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//}