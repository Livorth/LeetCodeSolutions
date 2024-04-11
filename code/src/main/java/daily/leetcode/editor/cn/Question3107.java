package daily.leetcode.editor.cn;

import java.util.Arrays;

public class Question3107 {
    public static void main(String[] args) {
        Solution solution = new Question3107().new Solution();
        solution.minOperationsToMakeMedianK(new int[]{
                229333782, 442606853, 138416643, 614593645, 58725648, 561655843, 638220939, 495417506, 820448215, 228641140, 674018368, 255585666, 440494863, 770296718, 402252216, 986956522, 837094359, 229974290, 217282495, 999466380, 297458727, 490298157, 368379796, 999497402, 924288070, 197178224, 848520212, 18411344, 993928967, 611203709, 284289359, 353844203, 260986435, 991762109, 507772951, 293781751, 691215793, 759629339, 579775859, 486935301, 207667234, 321753724, 397369411, 610686636, 750645317, 41625513, 848878133, 637502056, 345652404, 356156636, 186699025, 417703568, 178886157, 654176985, 730245283, 927093140, 300122738, 342665201, 793209476, 749628, 597691820, 580625883, 499384656, 314978829, 522584461, 357672512, 667351801, 459370020, 982275138, 757158174, 693052285, 538733084, 723083505, 64910281, 763884427, 286988441, 238411090, 171111839, 462364068, 251130207, 150812784, 554800999, 951275335, 961791380, 453204109, 47816648, 107105182, 416417844, 171790098, 997717319, 897231327, 179995846, 343051974, 488193699
        }, 982275138);

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:31 ms,击败了99.74% 的Java用户
     * 内存消耗:61 MB,击败了76.67% 的Java用户
     */
    class Solution {
        public long minOperationsToMakeMedianK(int[] nums, int k) {
            Arrays.sort(nums);
            int mid = nums.length / 2;
            long res = 0;
            // mid 左边的数全部都要≤k
            if (nums[mid] > k) {
                int t = mid;
                while (t >= 0 && nums[t] > k) {
                    res += nums[t--] - k;
                }
            } else if (nums[mid] < k) {
                int t = mid;
                while (t < nums.length && nums[t] < k) {
                    res += k - nums[t++];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}