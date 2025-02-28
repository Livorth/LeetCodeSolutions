package daily.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Question3365 {
    public static void main(String[] args) {
        Solution solution = new Question3365().new Solution();
        System.out.println(solution.isPossibleToRearrange("aabbcc", "bbaacc", 3));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPossibleToRearrange(String s, String t, int kk) {
            int k = s.length() / kk;
            HashMap<String, Integer> map1 = new HashMap<>();
            HashMap<String, Integer> map2 = new HashMap<>();
            for (int i = 0; i < s.length(); i += k) {
                String substring = s.substring(i, i + k);
                map1.put(substring, map1.getOrDefault(substring, 0) + 1);
                String substring2 = t.substring(i, i + k);
                map2.put(substring2, map2.getOrDefault(substring2, 0) + 1);
            }
            for (Map.Entry<String, Integer> entry : map1.entrySet()) {
                Integer value = map2.get(entry.getKey());
                if(!Objects.equals(value, entry.getValue())){
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}