package daily.leetcode.editor.cn;

public class Question1658 {
    public static void main(String[] args) {
        Solution solution = new Question1658().new Solution();
        int i = solution.minOperations(new int[]{8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309}, 134365);
        System.out.println(i);

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 正向思维，窗口内大小为x
     * 执行耗时:4 ms,击败了94.18% 的Java用户
     * 内存消耗:62.8 MB,击败了28.09% 的Java用户
     */
    class Solution0 {
        public int minOperations(int[] nums, int x) {
            int a = 0;
            int y = 0;
            int count = 0;
            int res = Integer.MAX_VALUE;
            while (y < x && a < nums.length) {
                y += nums[a++];
                count++;
            }
            if (y == x) res = count;
            if (a == nums.length && y < x) return -1;

            // 枚举滑动窗口右边界
            int b = nums.length - 1;
            for (int i = a - 1; i >= 0; i--) {
                y -= nums[i];
                count--;
                while (y < x) {
                    y += nums[b--];
                    count++;
                }
                if (y == x) res = Math.min(res, count);
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }

    /**
     * 逆向思维，窗口外为x
     * 执行耗时:4 ms,击败了94.18% 的Java用户
     * 内存消耗:62.9 MB,击败了9.23% 的Java用户
     */
    class Solution {
        public int minOperations(int[] nums, int x) {
            int y = 0;
            for (int num : nums) {
                y += num;
            }
            // 找到值为y的最长滑动窗口
            y = y - x;
            int res = -1;
            int left = 0;
            int sum = 0;
            for (int right = 0; right < nums.length; right++) {
                sum += nums[right];
                while (sum > y && left <= right) {
                    sum -= nums[left++];
                }
                if (sum == y) {
                    res = Math.max(res, right - left + 1);
                }
            }
            return res == -1 ? -1 : nums.length - res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}