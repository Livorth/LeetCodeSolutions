package daily.leetcode.editor.cn;

public class Question854 {
    public static void main(String[] args) {
        Solution solution = new Question854().new Solution();
        solution.kSimilarity("abc", "cab");

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution1 {
        int ans;

        public int kSimilarity(String s1, String s2) {
            StringBuilder str1 = new StringBuilder();
            StringBuilder str2 = new StringBuilder();
            // 剔除不需要交换的部分
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    str1.append(s1.charAt(i));
                    str2.append(s2.charAt(i));
                }
            }
            // 完全相等了，则不需要进行交换，返回0
            if (str1.length() == 0) {
                return 0;
            }
            ans = str1.length() - 1;
            dfs(0, 0, str1.length(), str1, str2);
            return ans;
        }

        public void dfs(int index, int cost, int len, StringBuilder str1, StringBuilder str2) {
            // 当前交换次数已经超过ans，没必要再算了
            if (cost > ans) {
                return;
            }
            // 当前位置的对应字母已经相等了，不需要进行交换
            while (index < str1.length() && str1.charAt(index) == str2.charAt(index)) {
                index++;
            }
            // 成功到底了，更新ans
            if (index == str1.length()) {
                ans = Math.min(ans, cost);
                return;
            }
            // 当前状态的交换次数下限大于等于当前的最小交换次数，也没必要再算了
            if (cost + minSwap(str1, str2, index) >= ans) {
                return;
            }
            // 遍历每个位置的字母，尝试每种可能性
            for (int i = index + 1; i < str1.length(); i++) {
                if (str1.charAt(i) == str2.charAt(index)) {
                    StringBuilder str1Next = swap(str1, i, index);
                    dfs(index + 1, cost + 1, len, str1Next, str2);
                }
            }
        }

        public int minSwap(StringBuilder s1, StringBuilder s2, int pos) {
            int tot = 0;
            for (int i = pos; i < s1.length(); i++) {
                tot += s1.charAt(i) != s2.charAt(i) ? 1 : 0;
            }
            return (tot + 1) / 2;
        }

        public StringBuilder swap(StringBuilder cur, int i, int j) {
            char c = cur.charAt(i);
            cur.setCharAt(i, cur.charAt(j));
            cur.setCharAt(j, c);
            return cur;
        }


    }

    class Solution2 {
        int result = Integer.MAX_VALUE;

        public int kSimilarity(String s1, String s2) {
            return execute(s1.toCharArray(), s2.toCharArray(), 0, 0);
        }

        public int execute(char[] sc1, char[] sc2, int start, int current) {
            if (current >= result) return result; // 如果交换次数已经超过"目前最小交换次数result"，终止递归
            if (start == sc1.length - 1) return result = Math.min(current, result);

            for (int i = start; i < sc1.length; i++) {
                if (sc1[i] != sc2[i]) {
                    for (int j = i + 1; j < sc2.length; j++) {
                        if (sc2[j] == sc1[i]) {
                            swap(sc2, i, j); // 交换
                            execute(sc1, sc2, i + 1, current + 1);
                            swap(sc2, i, j); // 回溯
                        }
                    }
                    return result;
                }
            }
            return result = Math.min(current, result);
        }

        public void swap(char[] sc, int i, int j) {
            char temp = sc[i];
            sc[i] = sc[j];
            sc[j] = temp;
        }
    }


    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.4 MB,击败了86.21% 的Java用户
     */
    class Solution {
        int n;

        public int kSimilarity(String s1, String s2) {
            n = s1.length();

            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();

            int preProcess = preProcess(c1, c2);

            int process = dfs(0, c1, c2);
            return preProcess + process;
        }

        private int dfs(int index, char[] c1, char[] c2) {
            // 到底，直接返回0
            if (index == n) {
                return 0;
            }

            // 如果直接就相等了，跳过，继续往下遍历
            if (c1[index] == c2[index]) {
                return dfs(index + 1, c1, c2);
            }

            int min = Integer.MAX_VALUE;
            // 遍历每个位置的字母，尝试每种可能性
            for (int i = index + 1; i < n; ++i) {
                if (c1[i] != c2[i] && c1[i] == c2[index]) {
                    swap(c1, i, index);
                    int res = dfs(index + 1, c1, c2);
                    if (res < min) {
                        min = res;
                    }
                    // 回溯
                    swap(c1, i, index);
                }
            }
            // 虽然回溯了，但是还是进行了一次交换的
            return min + 1;
        }

        private int preProcess(char[] c1, char[] c2) {
            int res = 0;
            for (int i = 0; i < n; ++i) {
                if (c1[i] == c2[i]) {
                    continue;
                }
                // 能直接两两互换的直接交换的
                for (int j = i + 1; j < n; ++j) {
                    if (c1[i] == c2[j] && c1[j] == c2[i]) {
                        swap(c1, i, j);
                        res++;
                        break;
                    }
                }
            }
            return res;
        }

        private void swap(char[] c, int i, int j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}