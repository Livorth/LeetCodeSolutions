package daily.leetcode.editor.cn;

import java.util.*;

public class Question421 {
    public static void main(String[] args) {
        Solution solution = new Question421().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution1 {
        public int findMaximumXOR(int[] nums) {
            int max = 0;
            for (int x : nums) {
                max = Math.max(max, x);
            }
            int highBit = 31 - Integer.numberOfLeadingZeros(max);

            int ans = 0, mask = 0;
            Set<Integer> seen = new HashSet<>();
            for (int i = highBit; i >= 0; i--) { // 从最高位开始枚举
                seen.clear();
                mask |= 1 << i;
                int newAns = ans | (1 << i); // 这个比特位可以是 1 吗？
                for (int x : nums) {
                    x &= mask; // 低于 i 的比特位置为 0
                    if (seen.contains(newAns ^ x)) {
                        ans = newAns; // 这个比特位可以是 1
                        break;
                    }
                    seen.add(x);
                }
            }
            return ans;
        }
    }

    class Solution {
        class Node {
            Node[] ns = new Node[2];
        }
        Node root = new Node();
        void add(int x) {
            Node p = root;
            for (int i = 31; i >= 0; i--) {
                int u = (x >> i) & 1;
                if (p.ns[u] == null) p.ns[u] = new Node();
                p = p.ns[u];
            }
        }
        int getVal(int x) {
            int ans = 0;
            Node p = root;
            for (int i = 31; i >= 0; i--) {
                int a = (x >> i) & 1, b = 1 - a;
                if (p.ns[b] != null) {
                    ans |= (b << i);
                    p = p.ns[b];
                } else {
                    ans |= (a << i);
                    p = p.ns[a];
                }
            }
            return ans;
        }
        public int findMaximumXOR(int[] nums) {
            int ans = 0;
            for (int i : nums) {
                add(i);
                int j = getVal(i);
                ans = Math.max(ans, i ^ j);
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}