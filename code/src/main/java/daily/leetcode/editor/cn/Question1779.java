package daily.leetcode.editor.cn;

public class Question1779 {
    public static void main(String[] args) {
        Solution solution = new Question1779().new Solution();
        int[][] p = {{4, 4},{2, 4}};
        solution.nearestValidPoint(3, 4, p);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nearestValidPoint(int x, int y, int[][] points) {
            int n = points.length;
            // 分别记录最小的距离与其对应的id
            int minDist = Integer.MAX_VALUE;
            int id = -1;
            for (int i = 0; i < n; ++i) {
                int px = points[i][0], py = points[i][1];
                if (x == px || y == py) {
                    int dist = Math.abs(x + y - px - py);
                    if (dist < minDist) {
                        minDist = dist;
                        id = i;
                    }
                }
            }
            return id;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}