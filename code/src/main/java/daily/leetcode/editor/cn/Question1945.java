package daily.leetcode.editor.cn;

public class Question1945 {
    public static void main(String[] args) {
        Solution solution = new Question1945().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getLucky(String s, int k) {
            int ans = 0;
            // 第一步转化+第二步转换，做两步是减小数字的大小
            for (char c : s.toCharArray()) {
                int x = c - 'a' + 1;
                ans += x % 10 + x / 10;
            }
            // 针对数字的转换
            for (int j = 1; j < k; j++) {
                int temp = ans;
                ans = 0;
                // 进行一个逐位计算
                while (temp != 0) {
                    ans += temp % 10;
                    temp /= 10;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}