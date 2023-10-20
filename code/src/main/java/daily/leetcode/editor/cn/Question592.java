package daily.leetcode.editor.cn;

public class Question592 {
    public static void main(String[] args) {
        Solution solution = new Question592().new Solution();
        solution.fractionAddition("1/3-1/2");
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String fractionAddition(String expression) {
        // 分子与分母
        long numerator = 0, denominator = 1;
        int length = expression.length();
        // 遍历每个字符
        for (int i = 0; i < length;) {
            char ch = expression.charAt(i);
            // 首先记录正负符号
            int sign = expression.charAt(i) == '-' ? -1 : 1;

            // 遇到运算符指针后移
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                i++;
            }

            // 计算当前的分子
            long num = 0;
            while (i < length && expression.charAt(i) != '/'){
                num = 10 * num + expression.charAt(i++) - '0';
            }
            i++;

            // 计算当前的分母
            long den = 0;
            while (i < length && expression.charAt(i) != '+' && expression.charAt(i) != '-'){
                den = 10 * den + expression.charAt(i++) - '0';
            }

            // 分母不能为0，如果出现了0，说明是整数，这里分母置为1就行
            if (den == 0) {
                den++;
            }

            // 计算分母的最小公倍数
            long lcm = denominator * den / gcd(denominator, den);
            // 计算新分子
            numerator = numerator * lcm / denominator + sign * num * lcm / den;
            // 计算新分母
            denominator = lcm;

        }
        // 对最终结果进行化简
        long g = gcd(denominator, Math.abs(numerator));
        return String.format("%d/%d", numerator / g, denominator / g);

    }

    public long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

        public String fractionAddition1(String expression) {
            long numerator = 0, denominator = 1;
            for (int idx = 0, n = expression.length(); idx < n;) {
                long sign = expression.charAt(idx) == '-' ? -1 : 1, num = 0, den = 0;
                if (expression.charAt(idx) == '-' || expression.charAt(idx) == '+') {
                    idx++;
                }
                while (idx < n && expression.charAt(idx) != '/') {
                    num = 10 * num + Long.parseLong(expression.substring(idx, idx + 1));
                    idx++;
                }
                idx++;
                while (idx < n && expression.charAt(idx) != '-' && expression.charAt(idx) != '+') {
                    den = 10 * den + Long.parseLong(expression.substring(idx, idx + 1));
                    idx++;
                }
                if (den == 0) {
                    den++;
                }
                long lm = den * denominator / gcd(denominator, den);
                numerator = numerator * lm / denominator + num * sign * lm / den;
                denominator = lm;
            }
            long g = gcd(denominator, Math.abs(numerator));
            return String.format("%d/%d", numerator / g, denominator / g);
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}
