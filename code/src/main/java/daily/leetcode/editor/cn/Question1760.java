package daily.leetcode.editor.cn;

public class Question1760 {
    public static void main(String[] args) {
        Solution solution = new Question1760().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumSize(int[] nums, int maxOperations) {
            int left = 1, right = (int) 1e9;
            // min即为单个袋子里球数目的最大值
            while (left < right) {
                int mid = (left + right) >>> 1;
                // 计算出当前最大球数所需要进行的操作
                long count = 0;
                for (int num : nums) {
                    count += (num - 1) / mid;
                }
                // 判断操作次数与maxOperations的关系
                if (count <= maxOperations) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}