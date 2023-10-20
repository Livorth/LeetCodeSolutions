package daily.leetcode.editor.cn;

public class Question795 {
    public static void main(String[] args) {
        Solution solution = new Question795().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution1 {
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {
            // 最大元素比right更小的子数组个数-最大元素比left-1更小的子数组个数
            return getCount(nums, right) - getCount(nums, left - 1);
        }

        private int getCount(int[] nums, int tag) {
            // count记录子数组总个数
            // t记录以当前元素为结尾并满足题目条件的子数组个数
            int count = 0, t = 0;
            for (int num : nums) {
                // 如果大于tag则置0，反之则加一
                t = num > tag ? 0 : t + 1;
                // 进行累加
                count += t;
            }
            return count;
        }
    }

    class Solution {
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {
            int n = nums.length, ans = 0, i0 = -1, i1 = -1;
            for (int i = 0; i < n; ++i) {
                // 更新最近一个大于区间的元素
                if (nums[i] > right) i0 = i;
                // 更新最近一个在区间内的元素
                if (nums[i] >= left) i1 = i;
                // 1. 当前元素就是大于区间的元素，则不能以当前元素结尾
                // 2. 当前元素就是最近的在区间内的元素，那么从i0开始到当前位置都能成为区间的左边界，最终的子数组个数为i-i0个
                // 3. 当前元素还达不到区间的最小值，那么要满足子数组的最大值在区间内
                // 那么一定内包含i1位置的元素，那么i1到i这个范围内的元素一定会被选中，最终的个数就是i1-i0个
                ans += i1 - i0;
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}