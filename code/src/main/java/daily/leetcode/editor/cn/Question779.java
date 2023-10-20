package daily.leetcode.editor.cn;

public class Question779 {
    public static void main(String[] args) {
        Solution solution = new Question779().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthGrammar(int n, int k) {
            if (n == 1) return 0;
            // 找他的爹是什么数
            int ret = kthGrammar(n - 1, (k + 1) / 2);
            // 如果k为奇，那么ta跟爹一个数，反之则取异或
            return k % 2 == 1 ? ret : 1 ^ ret;

            // 简写成一行
//        return n==1?0:(1^(k%2))^kthGrammar(n-1,(k+1)/2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}