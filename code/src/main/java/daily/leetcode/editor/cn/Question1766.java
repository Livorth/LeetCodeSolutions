package daily.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question1766 {
    public static void main(String[] args) {
        Solution solution = new Question1766().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 预处理 + dfs
     * 执行耗时:103 ms,击败了51.35% 的Java用户
     * 内存消耗:98.4 MB,击败了37.84% 的Java用户
     */
    class Solution {

        List<Integer>[] map;
        // 存储与i互质的list集合
        List<Integer>[] gcd = new List[51];
        // 值为i的最近祖先的编号，没有则为-1
        int[] pre = new int[51];
        // 每个节点对应的深度
        int[] dep;
        int[] res;

        public int[] getCoprimes(int[] nums, int[][] edges) {
            int n = nums.length;
            map = new List[n];
            res = new int[n];
            dep = new int[n];
            Arrays.setAll(map, i -> new ArrayList<>());
            Arrays.setAll(gcd, i -> new ArrayList<>());
            Arrays.fill(res, -1);
            Arrays.fill(pre, -1);

            // 临接表
            for (int[] edge : edges) {
                map[edge[0]].add(edge[1]);
                map[edge[1]].add(edge[0]);
            }
            // 预处理出50位里边每个数的互质数
            for (int i = 1; i <= 50; i++) {
                for (int j = 1; j <= 50; j++) {
                    if (gcd(i, j) == 1) gcd[i].add(j);
                }
            }

            dfs(nums, 0, -1);
            return res;
        }

        private void dfs(int[] nums, int x, int pa) {
            int val = nums[x];
            // 枚举所有可以与val互质的值
            for (int i : gcd[val]) {
                // 还未存在过值为i的祖宗
                if (pre[i] == -1) continue;
                // 如果还没找到最近的点，就先随便找个祖宗用着
                // 如果找到现在用的祖宗深度很小，则需要换深度更大的祖宗，更亲一点
                if (res[x] == -1 || dep[res[x]] < dep[pre[i]]) {
                    res[x] = pre[i];
                }
            }
            // 暂存一下，让自己也进pre
            int tmp = pre[val];
            pre[val] = x;

            // 遍历x的儿子
            for (int i : map[x]) {
                if (i == pa) continue;
                dep[i] = dep[x] + 1;
                dfs(nums, i, x);
            }
            // 回溯
            pre[val] = tmp;
        }

        private int gcd(int a, int b) {
            if (a < b) {
                int t = a;
                a = b;
                b = t;
            }
            return b == 0 ? a : gcd(b, a % b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}