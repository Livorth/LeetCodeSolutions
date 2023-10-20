package daily.leetcode.editor.cn;

import java.util.ArrayDeque;

public class Question907 {
    public static void main(String[] args) {
        Solution solution = new Question907().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    private static final long MOD = (long) 1e9 + 7;

    /**
     * 采用三次遍历的方法
     * 执行耗时:21 ms,击败了70.51% 的Java用户
     * 内存消耗:48.7 MB,击败了68.27% 的Java用户
     */
    public int sumSubarrayMins3(int[] arr) {
        long ans = 0L;
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        ArrayDeque<Integer> st = new ArrayDeque<Integer>();
        st.push(-1);
        for (int i = 0; i < n; ++i) {
            while (st.size() > 1 && arr[st.peek()] >= arr[i])
                st.pop();
            left[i] = st.peek();
            st.push(i);
        }


        st.clear();
        st.push(n);
        for (int i = n - 1; i >= 0; --i) {
            while (st.size() > 1 && arr[st.peek()] > arr[i])
                st.pop();
            right[i] = st.peek();
            st.push(i);
        }


        for (int i = 0; i < n; ++i)
            ans += (long) arr[i] * (i - left[i]) * (right[i] - i);
        return (int) (ans % MOD);
    }

    /**
     * 采用两次遍历的方法
     * 执行耗时:5 ms,击败了99.77% 的Java用户
     * 内存消耗:49.5 MB,击败了5.18% 的Java用户
     */
    public int sumSubarrayMins2(int[] arr) {
        long ans = 0L;
        int n = arr.length;
        int[] st = new int[n + 1];
        int top = 0;
        // 分别存储锚定值左右两边最小的值
        int[] left = new int[n];
        int[] right = new int[n];

        // 相当于在数组前设置一个值为-1的哨兵，确保栈中所有元素都能出栈
        st[top++] = -1;
        for (int i = 0; i < n; ++i) {
            // 右边界默认为数组最右侧
            right[i] = n;
            while (top > 1 && arr[st[top - 1]] >= arr[i]) {
                // i恰好比每一个出栈的元素小，由此作为出栈元素的右边界
                right[st[--top]] = i;
            }
            // 更新i的左边界
            left[i] = st[top - 1];
            st[top++] = i;
        }

        // 通过辅助数组获取每个锚定值的左右边界并计算出贡献值
        for (int i = 0; i < n; ++i)
            ans += (long) arr[i] * (i - left[i]) * (right[i] - i);
        return (int) (ans % MOD);
    }

    /**
     * 采用一次遍历的方法
     * 执行耗时:5 ms,击败了99.77% 的Java用户
     * 内存消耗:42 MB,击败了96.60% 的Java用户
     */
    public int sumSubarrayMins1(int[] arr) {
        long ans = 0L;
        int n = arr.length;
        int[] st = new int[n + 1];
        int top = 0;
        // 相当于在数组前设置一个值为-1的哨兵，确保栈中所有元素都能出栈
        st[top++] = -1;
        for (int r = 0; r <= n; ++r) {
            // 尾部哨兵，同样确保栈中所有元素都能出栈
            int x = r < n ? arr[r] : -1;
            // 单调递增栈
            while (top > 1 && arr[st[top - 1]] >= x) {
                // i即为当前锚定的值
                int i = st[--top];
                // st新的栈顶元素即左边界，r即为右边界，中间的部分则是i的势力范围
                ans += (long) arr[i] * (i - st[top - 1]) * (r - i);
            }
            st[top++] = r;
        }
        return (int) (ans % MOD);
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}

