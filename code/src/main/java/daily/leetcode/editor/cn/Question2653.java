package daily.leetcode.editor.cn;

public class Question2653 {
    public static void main(String[] args) {
        Solution solution = new Question2653().new Solution();
        solution.getSubarrayBeauty(new int[]{1, -1, -3, -2, 3}, 3, 2);

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 定长滑动窗口 + 计数排序
     * 执行耗时:39 ms,击败了52.63% 的Java用户
     * 内存消耗:62 MB,击败了15.04% 的Java用户
     */
    class Solution {
        public int[] getSubarrayBeauty(int[] nums, int k, int x) {
            int[] counting = new int[106];
            int[] res = new int[nums.length - k + 1];
            // 初始化
            for (int i = 0; i < k; i++) {
                counting[nums[i] + 50]++;
            }
            res[0] = getTheX(counting, x);
            for (int i = k; i < nums.length; i++) {
                counting[nums[i - k] + 50]--;
                counting[nums[i] + 50]++;
                res[i - k + 1] = getTheX(counting, x);
            }
            return res;
        }

        // 计数排序获取第x大的元素
        private int getTheX(int[] counting, int x) {
            int res = 0;
            int count = 0;
            for (int i = 0; i < counting.length; i++) {
                count += counting[i];
                if (count >= x) {
                    res = i - 50;
                    break;
                }
            }
            return Math.min(res, 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}