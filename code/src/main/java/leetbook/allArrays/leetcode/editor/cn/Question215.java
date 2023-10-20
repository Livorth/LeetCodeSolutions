package leetbook.allArrays.leetcode.editor.cn;

import java.util.*;

public class Question215 {
    public static void main(String[] args) {
        Solution solution = new Question215().new Solution();
        int[] arr = {3,2,3,1,2,4,5,5,6};
        int kthLargest = solution.findKthLargest(arr, 4);
        System.out.println(kthLargest);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // k-1是因为从下标0算起
            return quickSelect(0, nums.length - 1, k - 1, nums);
        }

        private int quickSelect(int left, int right, int k, int[] arr) {
            // 只有一个的时候直接返回
            if (left == right) return arr[left];

            // 以中间的数为基准
           int index = partition(left, right, arr);

            if (k == index) {
                return arr[index];
            }
            // 大于k则在左边找
            if (k < index) {
                return quickSelect(left, index - 1, k, arr);
            }
            // 小于k则在右边找
            return quickSelect(index + 1, right, k, arr);

        }

        // 单指针从前往后遍历
        int partition(int left, int right, int[] arr) {
            // 直接选择最后一位为基数
            int pivot = arr[right];
            int save = left;

            // [0,save]即为比pivot小的数，还可以使用双指针遍历，但是这种方法更简单
            for (int i = left; i <= right; i++) {
                if (arr[i] > pivot) {
                    swap(arr, save, i);
                    save++;
                }
            }

            // 将基数和save所指的数据交换
            swap(arr, save, right);
            return save;
        }

        // 双指针往中间遍历
        int partition1(int left, int right, int[] arr) {
            int pivot = arr[left];
            int l = left + 1;
            int r = right;
            while (l <= r) {
                while (l <= r && arr[l] >= pivot) l++; // 从左边找到第一个小于nums[pivot]的数
                while (l <= r && arr[r] <= pivot) r--; // 从右边找到第一个大于nums[pivot]的数
                if (l <= r && arr[l] < pivot && arr[r] > pivot) {
                    swap(arr, l, r);
                }
            }
            //交换pivot到它所属的最终位置，也就是在r的位置，因为此时r的左边都比r大，右边都比r小
            swap(arr, left, r);
            return r;
        }


        private void swap(int[] arr, int a, int b) {
            int temp = arr[b];
            arr[b] = arr[a];
            arr[a] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}


