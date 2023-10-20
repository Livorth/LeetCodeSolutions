package daily.leetcode.editor.cn;

import java.util.*;

public class Question1282 {
    public static void main(String[] args) {
        Solution solution = new Question1282().new Solution();
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            // 以所在组好为key，list中放下标
            for (int i = 0; i < groupSizes.length; i++) {
                List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<>());
                list.add(i);
                map.put(groupSizes[i], list);
            }
            List<List<Integer>> ans = new ArrayList<>();
            // 遍历每个可能的大小
            for (Integer t : map.keySet()) {
                List<Integer> list = map.get(t);
                List<Integer> cur = new ArrayList<>();
                for (Integer i : list) {
                    cur.add(i);
                    // 如果当前数组超过了t个，则需要新建一个继续放
                    if (cur.size() == t) {
                        ans.add(cur);
                        cur = new ArrayList<>();
                    }

                }
            }
            return ans;
        }

        public List<List<Integer>> groupThePeople1(int[] groupSizes) {
            List<List<Integer>> ret = new ArrayList<>();
            int n = groupSizes.length;
            // 使用ArrayList模拟HashMap，其中组的大小为key
            ArrayList<Integer>[] hashArray = new ArrayList[n + 1];
            for (int i = 0; i < n; i++) {
                int key = groupSizes[i];
                // 如果该key没有链表则创建一个
                if (hashArray[key] == null) {
                    ArrayList<Integer> list = new ArrayList<>();
                    hashArray[key] = list;
                }
                // 将当前下标添加进对应的List
                hashArray[key].add(i);
                // 当链表的长度达到key，将之前的分组计入结果，然后清空链
                if (hashArray[key].size() == key) {
                    ret.add(new ArrayList(hashArray[key]));
                    hashArray[key].clear();
                }
            }
            return ret;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)
}