package daily.leetcode.editor.cn;

import java.util.*;

public class Question2910 {
    public static void main(String[] args) {
        Solution solution = new Question2910().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 	执行耗时:39 ms,击败了100.00% 的Java用户
     * 	内存消耗:58.8 MB,击败了100.00% 的Java用户
     */
    class Solution {
        public int minGroupsForValidAssignment(int[] nums) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int num : nums) {
                count.merge(num, 1, Integer::sum);
            }
            // 每组的大小初始化为数组中出现次数最少的那个数的出现次数，照这个分能分到组数最少
            int size = Integer.MAX_VALUE;
            for (Integer value : count.values()) {
                size = Math.min(size, value);
            }

            // 枚举size的每一种情况，直到达成最小条件为止
            while (size >= 0) {
                int res = 0;
                // 判断当前value是否可以按照size来分
                for (Integer value : count.values()) {
                    // 核心判断条件是看，value对size取模后的结果能否全部放到已经分好的组中
                    if (value / size < value % size) {
                        res = 0;
                        break;
                    }
                    // 如果能放下，那就按照k+1的情况下分组，毕竟差值能为1
                    res += (value + size) / (size + 1);
                    // 不直接除以size是因为[10,10,10],size=1
                    // 因为只要差值不超过1都行，那我可以先把两个10分到一组
                    // 于是可以先加一个size再除以size+1,加一个size是怕算出来直接为0了
                }
                if (res > 0) return res;
                size--;
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}