package daily.leetcode.editor.cn;

public class Question264 {
    public static void main(String[] args) {
        Solution solution = new Question264().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            int[] arr = new int[n + 1];
            arr[1] = 1;
            int p2 = 1, p3 = 1, p5 = 1;
            for (int i = 2; i <= n; i++) {
                // 让arr数组中的每一个数，都有机会乘以3/5/7
                int num3 = arr[p2] * 2, num5 = arr[p3] * 3, num7 = arr[p5] * 5;
                // 找到其中最小的一个数，添加进数组
                arr[i] = Math.min(Math.min(num3, num5), num7);
                // 并将p往后移
                if (arr[i] == num3) {
                    p2++;
                }
                if (arr[i] == num5) {
                    p3++;
                }
                if (arr[i] == num7) {
                    p5++;
                }
            }
            return arr[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)



}