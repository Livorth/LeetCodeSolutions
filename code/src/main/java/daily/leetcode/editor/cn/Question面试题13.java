//package swordOffer.leetcode.editor.cn;
//
//public class Question面试题13 {
//    public static void main(String[] args) {
//        Solution solution = new Question面试题13().new Solution();
//
//
//    }
//
//    //leetcode submit region begin(Prohibit modification and deletion)
//    class Solution {
//        // 记录地图的访问情况
//        boolean[][] visited;
//
//        public int movingCount(int m, int n, int k) {
//            visited = new boolean[m][n];
//            return dfs(0, 0, m, n, k);
//        }
//
//        public int dfs(int i, int j, int m, int n, int k) {
//            // 进行边界判断 & 进行位数和判断 & 访问性判断
//            if (i >= m || j >= n || k < getSum(i, j) || visited[i][j]) {
//                return 0;
//            }
//            // 将当前位置标记为访问过
//            visited[i][j] = true;
//            // 沿着当前位置的右边和下边继续访问
//            return 1 + dfs(i + 1, j, m, n, k) + dfs(i, j + 1, m, n, k);
//        }
//
//        // 计算两个数字的每一个位之和
//        private int getSum(int i, int j) {
//            int sum = 0;
//            while (i != 0) {
//                sum += i % 10;
//                i /= 10;
//            }
//            while (j != 0) {
//                sum += j % 10;
//                j /= 10;
//            }
//            return sum;
//        }
//    }
////leetcode submit region end(Prohibit modification and deletion)
//
//}