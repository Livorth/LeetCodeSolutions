package daily.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

public class Question1331 {
    public static void main(String[] args) {
        Solution solution = new Question1331().new Solution();
        int[] arr = {40,10,20,30};
        int[] ints = solution.arrayRankTransform(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // 辅助HashMap，用于存储元素与其排序后的对应关系
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] cloneArr = arr.clone();
        Arrays.sort(cloneArr);

        int count = 1;
        for (int i : cloneArr) {
            if(!map.containsKey(i)){
                map.put(i, count++);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
