package daily.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Question895 {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FreqStack {
        Map<Integer, Integer> map;
        LinkedList<Integer>[] st;
        int max;

        public FreqStack() {
            // 存储数字以及其出现的次数
            map = new HashMap();
            // 存储出现次数为time的数字（每个都出现一次，那么最大值就是2*10^4个）
            st = new LinkedList[2 * (int) 1e4];
            max = 0; // 当前最大出现次数
        }

        public void push(int val) {
            int times = map.getOrDefault(val, 0) + 1;
            map.put(val, times);
            // 如果不存在出现次数为times的数字的时候则新建
            if (st[times] == null) st[times] = new LinkedList();
            // 将数字val放到以times为key的value集合中
            st[times].add(val);
            // 更新最大值
            max = Math.max(max, times);
        }

        public int pop() {
            // 待出栈数字
            int result = -1;
            while (max > 0) {
                // 出现次数为max的数字集合为空的情况，即数字集合中的数字全部出栈的情况，max--
                if (st[max].size() == 0) max--;
                else {
                    // 移除出现times次的数字集合中“末尾”的数字result
                    result = st[max].removeLast();
                    break;
                }
            }
            // 将数字result的出现次数-1
            map.put(result, map.getOrDefault(result, 0) - 1);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}