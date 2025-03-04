package daily.leetcode.editor.cn;

import java.util.*;

public class Question307 {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {
        int[] tr;

        int lowbit(int x) {
            return x & -x;
        }

        void add(int x, int u) {
            for (int i = x; i <= n; i += lowbit(i)) tr[i] += u;
        }

        int query(int x) {
            int ans = 0;
            for (int i = x; i > 0; i -= lowbit(i)) ans += tr[i];
            return ans;
        }

        int[] nums;
        int n;

        public NumArray(int[] _nums) {
            nums = _nums;
            n = nums.length;
            tr = new int[n + 10];
            for (int i = 0; i < n; i++) add(i + 1, nums[i]);
        }

        public void update(int index, int val) {
            add(index + 1, val - nums[index]);
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            return query(right + 1) - query(left);
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}