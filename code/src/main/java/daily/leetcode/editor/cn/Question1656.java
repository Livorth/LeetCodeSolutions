package daily.leetcode.editor.cn;

import java.util.*;

public class Question1656 {
    public static void main(String[] args) {
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class OrderedStream {
        private String[] data;
        private int ptr;

        public OrderedStream(int n) {
            this.data = new String[n];
            this.ptr = 0;
        }

        public List<String> insert(int idKey, String value) {
            data[idKey - 1] = value;
            List<String> ans = new ArrayList<>();
            // 往后遍历寻找连续的递增序列
            while (ptr < data.length && data[ptr] != null) {
                ans.add(data[ptr]);
                ptr++;
            }
            return ans;
        }

    }






/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}