package swordOffer.leetcode.editor.cn;

import java.util.*;

public class Question1640 {
    public static void main(String[] args) {
        Solution solution = new Question1640().new Solution();
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFormArray(int[] arr, int[][] pieces) {
            return search(0, arr, pieces);
        }

        public boolean search(int index, int[] arr, int[][] pieces) {
            // 以arr[index]为基准，遍历每个price看是否首位相等
            for (int[] piece : pieces) {
                if (piece[0] == arr[index]) {
                    index++;
                    for (int i = 1 ;i < piece.length; i++) {
                        if (arr[index++] != piece[i]) return false;
                    }
                    // 到结尾了
                    if (index == arr.length) return true;
                    // 继续判断下一个位置的index
                    return search(index, arr, pieces);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}