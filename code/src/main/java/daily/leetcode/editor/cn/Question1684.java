package daily.leetcode.editor.cn;

public class Question1684 {
    public static void main(String[] args) {
        Solution solution = new Question1684().new Solution();
        solution.countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"});

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution1 {
        public int countConsistentStrings(String allowed, String[] words) {
            // 先获取到allow中的字母出现情况
            int mask = getWords(allowed);
            int ans = 0;
            for (String w : words) {
                // 进行比对，如果相同则结果++
                if ((mask | getWords(w)) == mask) {
                    ++ans;
                }
            }
            return ans;
        }

        // 获取word中的每个字母的出现情况，通过左移存储进一个int数
        private int getWords(String word) {
            int mask = 0;
            for (int i = 0; i < word.length(); ++i) {
                mask |= 1 << (word.charAt(i) - 'a');
            }
            return mask;
        }
    }

    class Solution {
        public int countConsistentStrings(String allowed, String[] words) {
            // 使用左移将allowed中的字母出现情况存入allow
            int allow = 0;
            for (int i = 0; i < allowed.length(); i++) {
                allow |= 1 << (allowed.charAt(i) - 'a');
            }

            int ans = 0;
            for (String s : words) {
                int n = s.length();
                boolean flag = true;
                for (int i = 0; i < n; i++) {
                    // 如果出现allow中没有的字母，则说明不一致
                    if ((allow & (1 << (s.charAt(i) - 'a'))) == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) ans++;
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}