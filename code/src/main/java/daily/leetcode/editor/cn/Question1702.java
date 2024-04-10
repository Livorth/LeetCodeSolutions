package daily.leetcode.editor.cn;

public class Question1702 {
    public static void main(String[] args) {
        Solution solution = new Question1702().new Solution();

        solution.maximumBinaryString("00000");
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 模拟+贪心
     * 执行耗时:37 ms,击败了43.64% 的Java用户
     * 内存消耗:44.4 MB,击败了89.09% 的Java用户
     */
    class Solution0 {
        public String maximumBinaryString(String binary) {
            char[] bis = binary.toCharArray();
            int n = bis.length;
            int r = 0;
            for (int i = 0; i < n; i++) {
                // 遇到0则找到其之后的第一个0
                if (bis[i] == '0') {
                    while (r <= i || r < n && bis[r] == '1') r++;
                    // 通过操作2将0前移，构成"00"，然后通过操作1转成"10"
                    if (r < n) {
                        bis[r] = '1';
                        bis[i] = '1';
                        bis[i + 1] = '0';
                    }
                }
            }
            return new String(bis);
        }
    }

    /**
     * 直接构建，只要剩下的字符串中有两个0，那么久一定能凑到一起然后被消除
     * 执行耗时:35 ms,击败了50.91% 的Java用户
     * 内存消耗:44.5 MB,击败了85.45% 的Java用户
     */
    class Solution {
        public String maximumBinaryString(String binary) {
            char[] bis = binary.toCharArray();
            int n = bis.length;
            // 统计0出现的总次数和第一次出现的位置
            int count = 0;
            int first = -1;
            for (int i = 0; i < n; i++) {
                if (bis[i] == '0') {
                    count++;
                    if (first == -1) first = i;
                }
            }
            // 没有0则直接返回binary
            if (count == 0) return binary;
            // 将第一个出现的0后移count-1位，而其他0则都变成了1
            for (int i = 0; i < n; i++) {
                if (i == first + count - 1) {
                    bis[i] = '0';
                } else {
                    bis[i] = '1';
                }
            }
            return new String(bis);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}