//package daily.leetcode.editor.cn;
//
//import java.util.*;
//
//public class Question剑指 Offer 44 {
////    public static void main(String[] args) {
////        Solution solution = new Question剑指 Offer 44().new Solution();
////
////
////
////    }
//    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int findNthDigit(int n) {
//        // 位数
//        int digit = 1;
//        // 当前位数的起始数字
//        long start = 1;
//        // 当前位数和，从一位的开始
//        long sum = 9;
//        // 先找到n在所在数的位数
//        while (n > sum) {
//            n -= sum;
//            digit += 1;
//            start *= 10;
//            sum = digit * start * 9;
//        }
//        // 获取n所在的数字
//        long num = start + (n - 1) / digit;
//        // n在num的 (n-1)%digit位
//        return Long.toString(num).charAt((n - 1) % digit) - '0';
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//}
