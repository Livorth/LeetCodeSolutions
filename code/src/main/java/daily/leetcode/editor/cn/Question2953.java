package daily.leetcode.editor.cn;

public class Question2953 {
    public static void main(String[] args) {
        Solution solution = new Question2953().new Solution();
        int a = solution.countCompleteSubstrings("hmfttfmhpttmpphmhthfpffphftfhthtmhthhfphfmmm", 1);
//        System.out.println(a);
    }

    //leetcode submit region begin(Prohibit modification and deletion

    /**
     * 执行耗时:380 ms,击败了12.89% 的Java用户
     * 内存消耗:47.1 MB,击败了21.78% 的Java用户
     */
    class Solution {
        public int countCompleteSubstrings(String word, int k) {
            int res = 0;
            char[] chars = word.toCharArray();

            // m为窗口中能出现多少个元素
            for (int m = 1; m <= 26; m++) {
                int[] counts = new int[26];
                int start = 0;
                for (int r = 0; r < word.length(); r++) {
                    if (r - 1 >= 0 && Math.abs(chars[r] - chars[r - 1]) > 2) {
                        counts = new int[26];
                        start = r;
                    }
                    counts[chars[r] - 'a']++;
                    int l = r + 1 - k * m;
                    if (l >= start) {
                        if (checkCounts(counts, k)) res++;
                        counts[chars[l] - 'a']--;
                    }
                }
            }
            return res;
        }

        private boolean checkCounts(int[] counts, int k) {
            boolean check = true;
            for (int i = 0; i < 26; i++) {
                if (counts[i] > 0 && counts[i] != k) {
                    check = false;
                    break;
                }
            }
            return check;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class Solution1 {
        public int countCompleteSubstrings(String word, int k) {
            int n = word.length();
            int ans = 0;
            for (int i = 0; i < n; ) {
                int st = i;
                for (i++; i < n && Math.abs(word.charAt(i) - word.charAt(i - 1)) <= 2; i++) ;
//                ans += f(word.substring(st, i), k);
                System.out.println(i);
            }
            return ans;
        }

        private int f(String S, int k) {
            char[] s = S.toCharArray();
            int res = 0;
            for (int m = 1; m <= 26 && k * m <= s.length; m++) {
                int[] cnt = new int[26];
                for (int right = 0; right < s.length; right++) {
                    cnt[s[right] - 'a']++;
                    int left = right + 1 - k * m;
                    if (left >= 0) {
                        boolean ok = true;
                        for (int i = 0; i < 26; i++) {
                            if (cnt[i] > 0 && cnt[i] != k) {
                                ok = false;
                                break;
                            }
                        }
                        if (ok) res++;
                        cnt[s[left] - 'a']--;
                    }
                }
            }
            return res;
        }
    }
}