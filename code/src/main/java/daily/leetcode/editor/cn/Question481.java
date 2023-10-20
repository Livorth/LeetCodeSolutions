package daily.leetcode.editor.cn;

public class Question481 {
    public static void main(String[] args) {
        Solution solution = new Question481().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int magicalString(int n) {
            if (n <= 2) return 1;
            // 使用数组存储每一位的情况
            int[] arr = new int[n];
            // 初始化 1 2 2
            arr[0] = 1;
            arr[1] = arr[2] = 2;

            // s：1  2  2 1 1  2 1  2  2 1  2  2
            // s：1 22 11 2 1 22 1 22 11 2 11 22
            // 双指针：i指向上面的s，j指向下面的s
            int i = 3, j = 3, res = 1;
            while (i <= n) {
                // 获取到s中的第i位，即表示下面需要添加几个1或2
                int count = arr[i++ - 1];
                if (count == 1) res++;
                // 获取到当前生成的最后一位数
                int last = arr[j - 1];
                // 生成数据，3^last将1,2互换
                while (j < n && count-- > 0) {
                    arr[j++] = 3 ^ last;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}