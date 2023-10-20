package daily.leetcode.editor.cn;

public class swordOffer66 {
    public static void main(String[] args) {
        Solution solution = new swordOffer66().new Solution();
        solution.constructArr(new int[]{1, 2, 3, 4, 5});


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructArr(int[] a) {
            if(a== null || a.length == 0) return a;
            int[] sum1 = new int[a.length];
            int[] sum2 = new int[a.length];

            sum1[0] = 1;
            for (int i = 1; i < a.length; i++) {
                sum1[i] = sum1[i - 1] * a[i - 1];
            }

            sum2[a.length - 1] = 1;
            for (int i = a.length - 2; i >= 0; i--) {
                sum2[i] = sum2[i + 1] * a[i + 1];
            }

            for (int i = 0; i < a.length; i++) {
                a[i] = sum1[i] * sum2[i];
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}