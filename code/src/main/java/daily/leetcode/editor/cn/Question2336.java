package daily.leetcode.editor.cn;

import java.util.*;

public class Question2336 {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 这种在pop的时候时间复杂度为O(n)
     * 用TreeSet时间复杂度能到O(logn)
     * 执行耗时:13 ms,击败了54.72% 的Java用户
     * 内存消耗:43.3 MB,击败了64.05% 的Java用户
     */
    class SmallestInfiniteSet {
        Set<Integer> outs = new HashSet<>();
        int min;

        public SmallestInfiniteSet() {
            this.min = 1;
        }

        public int popSmallest() {
            int res = min;
            outs.add(res);
            while (outs.contains(min)) {
                min++;
            }

            return res;
        }

        public void addBack(int num) {
            if (num < min) min = num;
            outs.remove(num);
        }
    }

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
//leetcode submit region end(Prohibit modification and deletion)

}