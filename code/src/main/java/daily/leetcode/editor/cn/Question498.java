package daily.leetcode.editor.cn;

public class Question498 {
    public static void main(String[] args) {
        Solution solution = new Question498().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            int[] res = new int[m * n];
            int index = 0;
            // 单向遍历的次数只与m+n-1有关，例如在宽上有m条线，在长上有n条，其中有一条是重复的
            for (int i = 0; i < m + n - 1; i++) {
                // 奇数，示例中的黄线
                if (i % 2 == 1) {
                    // 在小于n的时候就是没跨过右上顶点的线，x则从0开始，y则从i开始
                    // 反之，x则需要往下走几格，y则从n-1开始
                    int x = i < n ? 0 : i - n + 1;
                    int y = i < n ? i : n - 1;
                    while (x < m && y >= 0) {
                        res[index++] = mat[x++][y--];
                    }
                }
                // 偶数，示例中的红线
                // 红线的同理，不再赘述
                else {
                    int x = i < m ? i : m - 1;
                    int y = i < m ? 0 : i - m + 1;
                    while (x >= 0 && y < n) {
                        res[index++] = mat[x--][y++];
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}