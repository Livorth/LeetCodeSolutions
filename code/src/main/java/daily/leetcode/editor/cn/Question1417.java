package daily.leetcode.editor.cn;

import java.util.*;

public class Question1417 {
    public static void main(String[] args) {
        Solution solution = new Question1417().new Solution();
        solution.reformat("a0b1c2");
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reformat(String s) {
            char[] cs = s.toCharArray();
            int countNum = 0;
            int countLet = 0;

            for (int i = 0; i < cs.length; i++) {
                if(cs[i] >= '0' && cs[i] <= '9'){
                    countNum++;
                }
                else {
                    countLet++;
                }
            }
            // 如果两种类型的符号只差大于1，那么则无法完成间隔，返回空串
            if(Math.abs(countLet - countNum)>1){
                return "";
            }

            // i为数字开始的位置，j为字母开始的位置
            int i = 0, j = 0;
            if(countNum >= countLet){
                // 数字多则字母后移
                j++;
            }
            else {
                i++;
            }
            char[] ans = new char[cs.length];
            for (int o = 0; o < cs.length; o++) {
                if(cs[o] >= '0' && cs[o] <= '9'){
                    ans[i] = cs[o];
                    i += 2;
                }
                else{
                    ans[j] = cs[o];
                    j += 2;
                }
            }
            return new String(ans);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
