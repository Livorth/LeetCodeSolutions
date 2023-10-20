package daily.leetcode.editor.cn;

import java.util.*;

public class Question1619 {
    public static void main(String[] args) {
        Solution solution = new Question1619().new Solution();
        
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int sum = 0;
        for (int i = n / 20; i < n - n / 20; i++) {
            sum += arr[i];
        }
        return (sum * 1.0) / (n * 0.9);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}