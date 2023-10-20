package daily.leetcode.editor.cn;

import java.util.*;

public class Question792 {
    public static void main(String[] args) {
        Solution solution = new Question792().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            // 分桶
            ArrayDeque<Node>[] buckets = new ArrayDeque[26];
            for (int i = 0; i < 26; i++) {
                buckets[i] = new ArrayDeque<>();
            }
            int sLen = s.length();
            for (String word : words) {
                if (word.length() > sLen) {
                    continue;
                }
                // 将遍历到的word根据首字母进行分组
                int index = word.charAt(0) - 'a';
                ArrayDeque<Node> queue = buckets[index];
                queue.add(new Node(word, 0));
            }

            int ans = 0;
            for (char ch : s.toCharArray()) {
                ArrayDeque<Node> bucket = buckets[ch - 'a'];
                int size = bucket.size();
                // 遍历当前桶里的每个字符串
                for (int i = 0; i < size; i++) {
                    Node cur = bucket.poll();
                    // 指针后移，去头
                    cur.index++;
                    // 如果已经全部去完了，则说明确实是子序列
                    if (cur.index == cur.word.length()) {
                        ans++;
                    } else {
                        // 移到新桶
                        char newFirstChar = cur.word.charAt(cur.index);
                        buckets[newFirstChar - 'a'].add(cur);
                    }
                }
            }
            return ans;
        }

        class Node {
            String word;
            // 从当前位置开始直到结尾才是当前字符串剩余的长度
            int index;

            public Node(String w, int i) {
                word = w;
                index = i;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}