package daily.leetcode.editor.cn;

import java.util.*;

public class Question715 {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 直观的朴素解法
     * 执行耗时:42 ms,击败了94.57% 的Java用户
     * 内存消耗:47.7 MB,击败了93.80% 的Java用户
     */
    class RangeModule {
        // 在map中存所有的区间
        TreeMap<Integer, Integer> map = new TreeMap<>();

        public RangeModule() {
        }

        public void addRange(int s, int e) { // s: start, e: end
            // 查找重叠范围
            Map.Entry<Integer, Integer> L = map.floorEntry(s);
            Map.Entry<Integer, Integer> R = map.floorEntry(e);

            // s落在现有范围内，则更新新建范围起点
            if (L != null && L.getValue() >= s) s = L.getKey();
            // e落在现有范围内，则更新新建范围终点，这里注意一个开区间的问题
            if (R != null && R.getValue() > e) e = R.getValue();

            // 删除在当前范围内其他所有的范围
            map.subMap(s, e).clear();
            // 然后将当前范围放进去
            map.put(s, e);
        }

        public void removeRange(int s, int e) {
            // 查找重叠范围
            Map.Entry<Integer, Integer> L = map.floorEntry(s);
            Map.Entry<Integer, Integer> R = map.floorEntry(e);

            // s落在现有范围内，则将前面的那段范围右侧截去
            if (L != null && L.getValue() > s) map.put(L.getKey(), s);
            // e落在现有范围内，则将前面的那段范围左侧截去
            if (R != null && R.getValue() > e) map.put(e, R.getValue());
            // 删除在当前范围内其他所有的范围
            map.subMap(s, e).clear();
        }

        public boolean queryRange(int s, int e) {
            Map.Entry<Integer, Integer> L = map.floorEntry(s);
            // 范围知否包含
            return L != null && L.getValue() >= e;
        }
    }

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}