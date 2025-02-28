package daily.leetcode.editor.cn;

import java.util.*;

public class Question2411 {
    public static void main(String[] args) {
//        Solution solution = new Question2411().new Solution();
        HashMap<Object, Object> map = new HashMap<>();
        AbstractMap map1 = (AbstractMap) map;

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 超时
     */
    class Solution0 {
        public int[] smallestSubarrays(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = 1;
                for (int j = i + 1; j < n; j++) {
                    int tpm = nums[i];
                    nums[i] |= nums[j];
                    if (nums[i] > tpm) res[i] = j - i + 1;
                }
            }
            return res;
        }
    }

    /**
     * 执行耗时:4 ms,击败了99.38% 的Java用户
     * 内存消耗:60 MB,击败了71.25% 的Java用户
     */
    class Solution1 {
        public int[] smallestSubarrays(int[] nums) {
            int n = nums.length;
            int[] len = new int[n];
            // 从左到右枚举右端点
            for (int j = 0; j < n; j++) {
                len[j] = 1;
                // 从右往左遍历，判断nums[j]中是否还能容下nums[j]
                for (int i = j - 1; i >= 0 && (nums[i] | nums[j]) != nums[i]; i--) {
                    nums[i] |= nums[j];
                    len[i] = j - i + 1;
                }
            }
            return len;
        }
    }

    class Solution2 {
        public int[] smallestSubarrays(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            List<int[]> steps = new ArrayList<>(); // [阶梯的值 or 子数组的值, 阶梯的左端点 or 对应子数组的右端点的最小值]
            // 从后往前遍历遍历节点
            for (int i = n - 1; i >= 0; --i) {
                // 将nums[i]作为一个单独的阶梯进行插入，但先记值为0
                steps.add(new int[]{0, i});
                int k = 0;
                // 让每一个or都拿去更nums[i]与一下
                for (int[] step : steps) {
                    // 不管是与还是别的操作，只要是能有类似效果的操作就都行
                    step[0] |= nums[i];
                    // 与了之后发现按位或的值不变，则更新下标，使其保持最小
                    if (steps.get(k)[0] == step[0])
                        steps.get(k)[1] = step[1];
                        // 如果出现不同则往后加（尾插法）
                    else steps.set(++k, step);
                }
                // 原地去重，不同的都通过k重新加过一遍了，后边重复的部分则去掉
                steps.subList(k + 1, steps.size()).clear();
                // 本题只用到了 steps[0]，如果题目改成任意给定数值，可以在 steps 中查找
                ans[i] = steps.get(0)[1] - i + 1;
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}