package daily.leetcode.editor.cn;

public class Question1769 {
    public static void main(String[] args) {
        Solution solution = new Question1769().new Solution();
        solution.minOperations1("001011");

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] minOperations1(String boxes) {
            int n = boxes.length();
            char[] arr = (" " + boxes).toCharArray();
            int[] left = new int[n + 5], right = new int[n + 5];
            int[] ans = new int[n];
            int cnt1 = 0, cnt2 = 0;

            for (int i = 1; i <= n; i++) {
                left[i] = cnt1 + left[i - 1];
                cnt1 += (arr[i] - '0');
                right[n - i + 1] = cnt2 + right[n - i + 2];
                cnt2 += (arr[n - i + 1] - '0');
            }

            for (int i = 1; i <= n; i++) {
                ans[i - 1] = left[i] + right[i];
            }
            return ans;
        }

        public int[] minOperations(String boxes) {
            char[] cb = boxes.toCharArray();
            int n = cb.length;
            int[] ans = new int[n];
            int left = 0;
            int right = 0;
            int total = 0;

            //计算第一个盒子的操作数
            if (cb[0] == '1') {
                left++;
            }
            for (int i = 1; i < n; i++) {
                if (cb[i] == '1') {
                    right++;
                    total += i;
                }
            }
            ans[0] = total;

            //根据前一个盒子的操作数，计算下一个盒子的操作数
            for (int i = 1; i < n; i++) {
                total = total + left - right;
                if (cb[i] == '1') {
                    left++;
                    right--;
                }
                ans[i] = total;
            }

            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}