package daily.leetcode.editor.cn;

public class Question799 {
    public static void main(String[] args) {
        Solution solution = new Question799().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /*
    (0,0)

    (1,0),(1,1)

    (2,0),(2,1),(2,2)

    (3,0),(3,1),(3,2),(3,3)

    (4,0),(4,1),(4,2),(4,3),(4,4)
     */
    class Solution {
        public double champagneTower(int poured, int query_row, int query_glass) {
            double[] row = {poured};
            for (int i = 1; i <= query_row; i++) {
                // 每层多一个杯子
                double[] nextRow = new double[i + 1];
                // 计算这层中每个杯子的酒含量
                for (int j = 0; j < i; j++) {
                    double volume = row[j];
                    if (volume > 1) {
                        // 流向为正下方的和右下方的
                        nextRow[j] += (volume - 1) / 2;
                        nextRow[j + 1] += (volume - 1) / 2;
                    }
                }
                // 更新当前层
                row = nextRow;
            }
            // 最大一杯，多了倒地上了
            return Math.min(1, row[query_glass]);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}