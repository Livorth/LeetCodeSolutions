package daily.leetcode.editor.cn;

public class Question17_19 {
    public static void main(String[] args) {
        Solution solution = new Question17_19().new Solution();

        String s = "<a target='_blank' href='http://ksm.kingdee.com:8000/ccsp/feedBack!lookFeedBack.action?feedBackId=E32F3998EF309E65E0539BCAA8C0E234'>R20220707-1065</a>";
        s = s.split("<")[1].split(">")[1];


        solution.missingTwo(new int[]{
                3
        });


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] missingTwo(int[] nums) {
            int n = nums.length + 2;
            int sum = ((1 + n) * n) / 2;
            // 找到缺失的两数之和
            for (int num : nums) {
                sum -= num;
            }
            // 其中一个数必然是在[1,sum/2]中产生
            int t = sum / 2;
            // 先求出[1,sum/2]的理论和，再求出[1,sum/2]的实际和，相减就能得到缺失的其中一个数
            int cur = ((1 + t) * t) / 2;
            for (int num : nums) {
                if (num <= t) cur -= num;
            }
            return new int[]{cur, sum - cur};
        }
    }

    class Solution1 {
        public int[] missingTwo(int[] nums) {
            int n = nums.length + 2, cur = n * (1 + n) / 2;
            for (int x : nums) cur -= x;
            int sum = cur, t = cur / 2;
            cur = t * (1 + t) / 2;
            for (int x : nums) {
                if (x <= t) cur -= x;
            }
            return new int[]{cur, sum - cur};
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}