package daily.leetcode.editor.cn;

import java.util.*;

public class Question640 {
    public static void main(String[] args) {
        Solution solution = new Question640().new Solution();
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String solveEquation(String equation) {
            // 将等号两边划分为两个部分
            String[] s = equation.split("=");
            // 分别计算k与b
            int[] res1 = compute(s[0]), res2 = compute(s[1]);
            // x = 2
            int k_l = res1[0], b_r = res1[1];
            int k_r = res2[0], b_l = res2[1];
            int real = b_r - b_l, x = k_l - k_r;
            // 除数为0的时候无意义，即无穷解
            if (x == 0) {
                if (real == 0) return "Infinite solutions";
                else return "No solution";
            } else {
                return String.format("x=%d", (-real / x));
            }
        }

        public int[] compute(String s) {
            // b代表常数项，k代表x的系数
            int k = 0, b = 0;
            char[] chs1 = s.toCharArray();

            // 进行遍历，即合并同类项
            for (int i = 0; i < chs1.length; i++) {
                // 符号位： sign = 1 表示当前值 > 0; sign = -1 表示 < 0
                int sum = 0, j = i, sign = 1;
                // 出现符号位的情况
                if (chs1[j] == '-' || chs1[j] == '+') {
                    sign = (chs1[j] == '-') ? -1 : 1;
                    j++;
                }
                // 将字符串数字转换为int数字
                while (j < chs1.length && (chs1[j] != 'x' && chs1[j] != '+' && chs1[j] != '-')) {
                    sum = sum * 10 + (chs1[j] - '0');
                    j++;
                }
                // 如果后面跟着x，则说明当前数字是x的系数
                if (j < chs1.length && chs1[j] == 'x') {
                    // 系数为1的情况进行特殊判断
                    if (j == 0 || chs1[j - 1] == '+' || chs1[j - 1] == '-') sum = 1;
                    k += sign * sum;
                    i = j;
                }
                // 反之则说明是常数项
                else {
                    b += sign * sum;
                    i = j - 1;
                }
            }
            return new int[]{k, b};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}