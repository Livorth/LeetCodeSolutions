//package swordOffer.leetcode.editor.cn;
//
//public class Question剑指 Offer 50{
//public static void main(String[]args){
//        Solution solution=new Question剑指 Offer 50().new Solution();
//
//
//        }
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public char firstUniqChar(String s) {
//        char[] chs = new char[26], str = s.toCharArray();
//        for (int i = 0; i < str.length; i++) {
//            chs[str[i] - 'a']++;
//        }
//        for (int i = 0; i < str.length; i++) {
//            if (chs[str[i] - 'a'] == 1) {
//                return str[i];
//            }
//        }
//        return ' ';
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//}