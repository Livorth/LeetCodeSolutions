package daily.leetcode.editor.cn;

import java.math.BigDecimal;

public class Question1620 {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] bestCoordinate(int[][] towers, int radius) {
            int[] ans = new int[2];
            double max = 0;
            int re2 = radius * radius;

            // 寻找到能覆盖到所有塔的矩形范围
            int minx = Integer.MAX_VALUE;
            int miny = Integer.MAX_VALUE;
            int maxx = 0;
            int maxy = 0;
            for (int i = 0; i < towers.length; i++) {
                minx = Math.min(towers[i][0], minx);
                miny = Math.min(towers[i][1], miny);
                maxx = Math.max(towers[i][0], maxx);
                maxy = Math.max(towers[i][1], maxy);
            }

            // 遍历这个范围内的每一个点
            for (int i = minx; i <= maxx; i++) {
                for (int j = miny; j <= maxy; j++) {
                    int power = 0;
                    // 遍历每一个塔获取到当前点的信号强度
                    for (int k = 0; k < towers.length; k++) {
                        int dis = (towers[k][0] - i) * (towers[k][0] - i) + (towers[k][1] - j) * (towers[k][1] - j);
                        if (dis <= re2) {
                            power += towers[k][2] / (1 + Math.sqrt(dis));
                        }
                    }
                    // 更新结果
                    if (power > max) {
                        max = power;
                        ans[0] = i;
                        ans[1] = j;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}