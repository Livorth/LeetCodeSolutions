package daily.leetcode.editor.cn;

public class Question3208 {
    public static void main(String[] args) {
        Solution solution = new Question3208().new Solution();
//        int i = solution.numberOfAlternatingGroups(new int[]{0, 1, 0, 1, 0}, 3);
        int i = solution.numberOfAlternatingGroups(new int[]{0, 1, 0}, 3);
        System.out.println(i);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfAlternatingGroups(int[] colors, int k) {
            int res = 0;
            int l = colors.length;
            int count = 0;
            for (int i = 1; i < l + k; i++) {
                if (colors[i % l] + colors[(i - 1) % l] != 1) {
                    count = 0;
                }
                count ++;
                if (count >= k) {
                    res++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}