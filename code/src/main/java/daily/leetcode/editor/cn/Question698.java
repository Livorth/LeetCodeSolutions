package daily.leetcode.editor.cn;

import java.util.Arrays;

public class Question698 {
    public static void main(String[] args) {
        Solution solution = new Question698().new Solution();
        int[] ints = new int[]{4, 3, 2, 3, 5, 2, 1};
        solution.canPartitionKSubsets(ints, 4);

    }

    //leetcode submit region begin(Prohibit modification and deletion)


    /**
     * 	执行耗时:19 ms,击败了67.55% 的Java用户
     * 	内存消耗:40.7 MB,击败了29.86% 的Java用户
     */
    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            // 先求总和和每个子集的大小
            int sum = Arrays.stream(nums).sum();
            if (sum % k != 0) return false;
            int[] buckets = new int[k];
            // 升序排列
            Arrays.sort(nums);
            // 搜索
            boolean[] dp = new boolean[1 << nums.length];
            Arrays.fill(dp, true);
            return dfs((1 << nums.length) - 1, 0, dp, nums, sum / k);
        }

        public boolean dfs(int state, int count, boolean[] dp, int[] nums, int per) {
            // 状态中的每一个数字都为0，即都被选择过，完成搜索
            if (state == 0) return true;
            // 当前状态已经搜索过
            if (!dp[state]) return dp[state];
            // 将当前状态记录为false
            dp[state] = false;
            for (int i = 0; i < nums.length; i++) {
                // 如果当前的数超过了per，则break，后面的也会更大
                if (nums[i] + count > per) break;
                // 继续选择数字，往下遍历
                if (((state >> i) & 1) != 0) {
                    // (count + nums[i]) % per == 0，则说明当前子满了，要到下一个
                    if (dfs(state ^ (1 << i), (count + nums[i]) % per, dp, nums, per)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    class Solution1 {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            // 先求总和和每个子集的大小
            int sum = Arrays.stream(nums).sum();
            if (sum % k != 0) return false;
            int[] buckets = new int[k];
            // 降序排列
            Arrays.sort(nums);
            for (int i = 0; i < nums.length / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = temp;
            }
            // 搜索
            return dfs(nums, 0, buckets, sum / k);
        }

        public boolean dfs(int[] nums, int index, int[] buckets, int total) {
            if (index == nums.length) {
                // 如果能把所有的数都放进去，说明肯定能成功
                return true;
            }
            // 给每个子集都尝试放第index个数
            for (int i = 0; i < buckets.length; i++) {
                // 剪枝：两个子集目前和相同
                if (i != 0 && buckets[i] == buckets[i - 1]) continue;
                // 超过上限
                if (buckets[i] + nums[index] > total) continue;

                // 放，如果到底没问题就返回true，有问题则回溯
                buckets[i] += nums[index];
                if (dfs(nums, index + 1, buckets, total)) return true;
                buckets[i] -= nums[index];
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}