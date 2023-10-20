package daily.leetcode.editor.cn;

public class Question1775 {
    public static void main(String[] args) {
        Solution solution = new Question1775().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums1, int[] nums2) {
            if (6 * nums1.length < nums2.length || 6 * nums2.length < nums1.length) return -1;
            // 获取两数组直接的距离差
            int diff = 0;
            for (int i : nums2) {
                diff += i;
            }
            for (int i : nums1) {
                diff -= i;
            }
            // 保证nums1中存的数组总是更大的那一个
            if (diff < 0) {
                diff = -diff;
                int[] t = nums1;
                nums1 = nums2;
                nums2 = t;
            }



            // 统计每个数组中的每一个元素能使值靠拢的贡献度
            int[] count = new int[6];
            for (int i : nums1) {
                ++count[6 - i];
            }
            for (int i : nums2) {
                ++count[i - 1];
            }
            // 枚举从大到小的贡献度
            for (int i = 5, ans = 0; ; --i) {
                // 如果当前档位的贡献度能超过需要的值，则返回
                if (i * count[i] >= diff) {
                    return ans + (diff + i - 1) / i;
                }
                // 抵消贡献度，并统计操作次数
                ans += count[i];
                diff -= i * count[i];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}