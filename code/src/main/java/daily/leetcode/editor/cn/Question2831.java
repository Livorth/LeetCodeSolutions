package daily.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question2831 {
    public static void main(String[] args) {
        Solution solution = new Question2831().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 将相同值的下标存入同一个列表，再通过滑动窗口判断在某一个范围内不同的元素是否多于k
     * 执行耗时:112 ms,击败了15.53% 的Java用户
     * 内存消耗:69 MB,击败了7.77% 的Java用户
     */
    class Solution1 {
        public int longestEqualSubarray(List<Integer> nums, int k) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.size(); i++) {
                int x = nums.get(i);
                map.putIfAbsent(x, new ArrayList<>());
                map.get(x).add(i);
                // 可改成如下，因为在后边的比较式中本身也要减去一次下标
                // map.get(x).add(i - map.get(x).size());
            }
            int res = 0;
            for (List<Integer> value : map.values()) {
                for (int right = 0, left = 0; right < value.size(); right++) {
                    while (value.get(right) - value.get(left) - (right - left) > k) {
                        left++;
                    }
                    res = Math.max(res, right - left + 1);
                }
            }
            return res;
        }
    }

    /**
     * 直接在nums上进行滑动窗口
     * 执行耗时:10 ms,击败了100.00% 的Java用户
     * 内存消耗:62.6 MB,击败了82.19% 的Java用户
     */
    class Solution {
        public int longestEqualSubarray(List<Integer> nums, int k) {
            int n = nums.size();
            // 统计nums[i]在前滑动窗口中出现了多少次
            int[] count = new int[n + 1];
            int res = 0;
            int left = 0;
            int right = 0;
            while (right < n) {
                int x = nums.get(right++);
                // 当前滑动窗口中x的出现次数
                res = Math.max(res, ++count[x]);
                // 维持窗口的大小为res+k
                if (right - left - res > k) {
                    count[nums.get(left)]--;
                    left++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}