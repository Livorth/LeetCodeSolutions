//package swordOffer.leetcode.editor.cn;
//
//public class Question面试题 01.02{
//public static void main(String[]args){
//        Solution solution=new Question面试题01.02().new Solution();
//
//
//        }
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public boolean CheckPermutation(String s1, String s2) {
//        if (s1.length() != s2.length()) return false;
//        int[] count = new int[26];
//        for (int i = 0; i < s1.length(); i++) {
//            count[s1.charAt(i) - 'a']++;
//            count[s2.charAt(i) - 'a']--;
//        }
//        for (int i : count) {
//            if (i != 0) return false;
//        }
//        return true;
//    }
//}
//
//
//
////leetcode submit region end(Prohibit modification and deletion)
//
//}