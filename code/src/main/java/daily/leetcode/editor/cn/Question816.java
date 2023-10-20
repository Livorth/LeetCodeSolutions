package daily.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Question816 {
    public static void main(String[] args) {
        Solution solution = new Question816().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> ambiguousCoordinates(String s) {
            List<String> ans = new ArrayList();
            // 去除原有的括号
            s = s.substring(1, s.length() - 1);
            for (int i = 1; i < s.length(); i++) {
                // 分别获取到x轴与y轴可以的小数点位置对应的字符串
                List<String> xs = genNums(s.substring(0, i));
                List<String> ys = genNums(s.substring(i));
                for (String x : xs) {
                    for (String y : ys) {
                        // 将每一种情况拼接在一起
                        ans.add(new StringBuilder("(").append(x).append(", ").append(y).append(")").toString());
                    }
                }
            }
            return ans;
        }

        // 获取某段字符串中添加能添加小数点的每一种字符串情况
        private List<String> genNums(String num) {
            List<String> list = new ArrayList();
            int i = 1;
            // 枚举每一个可能的位置
            while (i <= num.length()) {
                // 分别作为整数与小数部分
                String left = num.substring(0, i);
                String right = num.substring(i++);
                if ((!left.equals("0") && left.charAt(0) == '0') || // 整数部分，不允许以0开头，除非这个整数就是0本身
                        (!right.isEmpty() && right.charAt(right.length() - 1) == '0')) continue; // 小数部分，不允许以0作为结尾
                // 在小数部分为空的情况下不能添加小数点
                if (right.isEmpty()) list.add(left);
                else list.add(new StringBuilder(left).append(".").append(right).toString());
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}