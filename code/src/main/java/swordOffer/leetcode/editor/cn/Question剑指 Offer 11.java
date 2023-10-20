//package swordOffer.leetcode.editor.cn;
//
//public class Question剑指 Offer 11{
//public static void main(String[]args){
//        Solution solution=new Question剑指 Offer 11().new Solution();
//
//
//        }
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int minArray(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int left = 0;
//        int right = nums.length - 1;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
//                right--;
//            } else if (nums[mid] > nums[right]) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//        return nums[left];
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//}