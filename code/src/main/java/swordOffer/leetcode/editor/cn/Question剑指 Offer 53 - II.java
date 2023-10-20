//package swordOffer.leetcode.editor.cn;
//
//public class Question剑指 Offer 53-II{
//public static void main(String[]args){
//        Solution solution=new Question剑指 Offer 53-II().new Solution();
//
//
//        }
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int missingNumber(int[] nums) {
//        int left = 0, right = nums.length - 1;
//        // 通过二分查找找到对应的位置
//        while (left < right) {
//            int mid = left + right + 1 >> 1;
//            if (nums[mid] == mid) {
//                left = mid;
//            }
//            else {
//                right = mid - 1;
//            }
//        }
//        // 可能出现不缺的情况
//        return nums[right] != right ? right : right + 1;
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//}