package daily.leetcode.editor.cn;

import java.util.*;

public class Question2530 {
    public static void main(String[] args) {
        Solution solution = new Question2530().new Solution();
        solution.maxKelements(new int[]{672579538, 806947365, 854095676, 815137524}, 3);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxKelements(int[] nums, int k) {
            PriorityQueue<Long> queue = new PriorityQueue<Long>((a, b) -> {
                return b.compareTo(a);
            });
            for (int num : nums) {
                queue.add(Long.valueOf(num));
            }
            long res = 0;
            for (int i = 0; i < k; i++) {
                Long poll = queue.poll();
                res += poll;
                queue.add((poll + 2) / 3);
            }
            return res;
        }


    }
    class Solution2 {
        public long maxKelements(int[] nums, int k) {
            int n = nums.length;
            long ans =0;
            while(n==1){
                ans+=nums[0];
                nums[0]=(int)Math.ceil((double)nums[0]/3);
                k--;
                if(k==0){
                    return ans;
                }
            }
            int m =k;
            int p =nums.length-1;
            Arrays.sort(nums);

            while(k>0){
                ans+=nums[p];
                nums[p]=(int)Math.ceil((double)nums[p]/3);
                k--;
                if(k==m/3){
                    Arrays.sort(nums);
                    p=n-1;
                    continue;
                }
                if(p-1==n/3){
                    Arrays.sort(nums);
                    p=n-1;
                    continue;
                }
                p--;

            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}