package daily.leetcode.editor.cn;

import java.util.*;

public class Question1224 {
    public static void main(String[] args) {
        Solution solution = new Question1224().new Solution();
        int[] nums = {1,1,1,2,2,2,6};
        solution.maxEqualFreq(nums);
        
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEqualFreq(int[] nums) {
        int[] count = new int[100086];
        // maxCount记录数字的最大出现次数，maxSpecies记录出现次数最多数字的种类， species记录所有数字的总种类
        int maxCount = 0, maxSpecies = 0, species = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 当前num首次出现，species++
            if(count[num]++ == 0){
                species++;
            }
            // 如果当前数字的出现次数超过maxCount，更新最大数字相关信息
            if(count[num] > maxCount){
                maxCount = count[num];
                maxSpecies = 1;
            }
            // 如果当前数字的出现次数达到maxCount，则给maxSpecies++
            else if(count[num] == maxCount){
                maxSpecies++;
            }
            // 情况1：每个数字都只有一个，即maxCount == 1
            // 情况2：当前每个数出现的次数都是maxCount，即maxCount * maxSpecies == i
            // 情况3：只有一个数的出现次数为最大，而其他每个数出现的次数都只比最大次数少一个
            if (maxCount == 1 || maxCount * maxSpecies == i || maxSpecies == 1 && (maxCount - 1) * species == i) {
                ans = i + 1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}




