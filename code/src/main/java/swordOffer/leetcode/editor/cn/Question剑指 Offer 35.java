//package swordOffer.leetcode.editor.cn;
//
//import java.util.HashMap;
//
//public class SwordOffer35 {
//    public static void main(String[] args) {
//        Solution solution = new SwordOffer35().new Solution();
//
//
//    }
//
//    class Node {
//        int val;
//        Node next;
//        Node random;
//
//        public Node(int val) {
//            this.val = val;
//            this.next = null;
//            this.random = null;
//        }
//    }
//
//    //leetcode submit region begin(Prohibit modification and deletion)
//
//    class Solution {
//        public Node copyRandomList(Node head) {
//            if (head == null) return null;
//            HashMap<Node, Node> map = new HashMap<>();
//            Node node = head;
//            // 将原链表复制一份，并将每个原节点与新节点关联放进HashMap
//            while (node != null) {
//                Node newNode = new Node(node.val);
//                map.put(node, newNode);
//                node = node.next;
//            }
//            node = head;
//            while (node != null) {
//                Node newNode = map.get(node);
//                // 根据原节点的next与random关系将新节点之间关系连接起来
//                if (node.next != null) {
//                    newNode.next = map.get(node.next);
//                }
//                if (node.random != null) {
//                    newNode.random = map.get(node.random);
//                }
//                node = node.next;
//            }
//            return map.get(head);
//        }
//    }
//
//    class Solution1 {
//        HashMap<Node, Node> map = new HashMap<>();
//
//        public Node copyRandomList(Node head) {
//            if (head == null) return null;
//            return dfs(head);
//        }
//
//        Node dfs(Node node) {
//            if (node == null) return null;
//            // node节点已经被访问过了,直接从哈希表hash中取出对应的复制节点返回。
//            if (map.containsKey(node)) return map.get(node);
//            // 复制节点并将节点放进HashMap
//            Node clone = new Node(node.val);
//            map.put(node, clone);
//            // 根据原节点的next与random关系将新节点之间关系连接起来,注意此时新旧节点之前的映射关系其实已经全部完成
//            clone.next = dfs(node.next);
//            clone.random = dfs(node.random);
//            return clone;
//        }
//    }
////leetcode submit region end(Prohibit modification and deletion)
//
//}