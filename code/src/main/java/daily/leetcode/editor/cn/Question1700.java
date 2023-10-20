package daily.leetcode.editor.cn;

public class Question1700 {
    public static void main(String[] args) {
        Solution solution = new Question1700().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countStudents(int[] students, int[] sandwiches) {
            int[] count = new int[2];
            // 获取学生喜欢不同三明治的数量
            for (int t : students) ++count[t];
            for (int t : sandwiches) {
                // 从左往右遍历，遍历到喜欢某一种三明治的学生为空，这样当前到后面的三明治就都吃不到了
                if (count[t]-- == 0) {
                    return count[t ^ 1];
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}