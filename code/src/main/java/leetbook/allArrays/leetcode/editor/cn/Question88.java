package leetbook.allArrays.leetcode.editor.cn;

import java.util.*;

public class Question88 {
    public static void main(String[] args) {
        Solution solution = new Question88().new Solution();
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int a = m - 1, b = n - 1;
            int c = m + n - 1;
            // 两个数组分别从后往前遍历
            while( a >= 0 && b >= 0){
                if(nums1[a] > nums2[b]){
                    nums1[c--] = nums1[a];
                    // 因为是对数组1进行操作，当数字放到后面去之后原位置需要置为0
                    a--;
                }else{
                    nums1[c--] = nums2[b--];
                }
            }
            // 处理后续没有被处理的数
            while(a>=0)
                nums1[c--]=nums1[a--];
            while(b>=0)
                nums1[c--]=nums2[b--];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}