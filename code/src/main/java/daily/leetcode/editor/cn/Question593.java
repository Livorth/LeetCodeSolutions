package daily.leetcode.editor.cn;

public class Question593 {
    public static void main(String[] args) {
        Solution solution = new Question593().new Solution();
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            int[] edge = {
                    dis(p1, p2),
                    dis(p1, p3),
                    dis(p1, p4),
                    dis(p2, p3),
                    dis(p2, p4),
                    dis(p3, p4)
            };
            int x = 1, y = 0;
            int dis1 = edge[0], dis2 = -1;
            for (int i = 1; i < edge.length; i++) {
                if(edge[i] <= 0) break;
                if(edge[i] == dis1){
                    x++;
                }
                else if(edge[i] != dis1 && dis2 == -1){
                    dis2 = edge[i];
                    y++;
                }
                else if(edge[i] == dis2){
                    y++;
                }
            }
            return (x == 4 && y == 2) || (x == 2 && y == 4);
        }

        // 计算a，b两点之间距离的平方
        int dis(int[] a, int[] b) {
            int dx = a[0] - b[0];
            int dy = a[1] - b[1];
            return dx * dx + dy * dy;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
