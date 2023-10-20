package daily.leetcode.editor.cn;

import java.util.*;

public class Question658 {
    public static void main(String[] args) {
        Solution solution = new Question658().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            // 通过二分法获取区间左边界的位置
            int l = 0, r = arr.length - k;
            while (l < r) {
                int mid = l + (r - l) >> 1;
                // 左边界到x的差值与右边界到x的差值，看成 "x>(arr[mid]+arr[mid+k])/2"会更好理解
                if (x - arr[mid] > arr[mid + k] - x) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            // 确定左边界后往后选取k个元素
            List<Integer> res = new LinkedList<>();
            for (int i = l; i < l + k; i++) {
                res.add(arr[i]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}