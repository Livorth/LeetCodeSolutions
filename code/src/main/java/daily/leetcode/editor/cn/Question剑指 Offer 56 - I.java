//package swordOffer.leetcode.editor.cn;
//
//public class Question剑指 Offer 56-I{
//public static void main(String[]args){
//        Solution solution=new Question剑指 Offer 56-I().new Solution();
//
//
//        }
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int[] singleNumbers(int[] nums) {
//        int x = 0, y = 0, n = 0, m = 1;
//        // 全部异或获取到x^y的结果
//        for (int num : nums) {
//            n ^= num;
//        }
//        // 循环左移，找到两数第一位不相等的地方
//        while ((n & m) == 0) {
//            m <<= 1;
//        }
//        // 分组，m位为0的一组，为1的一直
//        for (int num : nums) {
//            if ((num & m) != 0) {
//                x ^= num;
//            } else {
//                y ^= num;
//            }
//        }
//        return new int[]{x, y};
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//}