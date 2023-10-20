package daily.leetcode.editor.cn;

public class Question1774 {
    public static void main(String[] args) {
        Solution solution = new Question1774().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int ans;
        private int[] toppingCosts;

        public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
            ans = Integer.MAX_VALUE;
            this.toppingCosts = toppingCosts;
            for (int baseCost : baseCosts) {
                dfs(0, target - baseCost);
            }
            return target - ans;
        }

        // start指向当前配料的位置，target指向剩余资金
        private void dfs(int start, int target) {
            if (target < 0) {
                // 如果在超过target的情况下比ans更大，则更新并返回，继续往下遍历target只会更小
                if (-target < Math.abs(ans)) ans = target;
                return;
            } else {
                // 出现更小的target，更新，继续遍历
                if (target <= Math.abs(ans)) ans = target;
            }
            // 当ans已经为0了，说明能构成target，直接返回，或者直接到结尾了，也直接返回
            if (ans == 0 || start == toppingCosts.length) return;
            // 对于当前配料：不选/选1次/选2次
            dfs(start + 1, target);
            dfs(start + 1, target - toppingCosts[start]);
            dfs(start + 1, target - toppingCosts[start] * 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}