package daily.leetcode.editor.cn;

public class Question1206 {

    //leetcode submit region begin(Prohibit modification and deletion)

    static class Skiplist {
        /**
         * 最大层数
         */
        private static int DEFAULT_MAX_LEVEL = 32;
        /**
         * 随机层数概率，也就是随机出的层数，在 第1层以上(不包括第一层)的概率，层数不超过maxLevel，层数的起始号为1
         */
        private static double DEFAULT_P_FACTOR = 0.25;

        Node head = new Node(null,DEFAULT_MAX_LEVEL); //头节点

        int currentLevel = 1; //表示当前nodes的实际层数，它从1开始


        public Skiplist() {
        }

        /**
         * 在跳表中进行搜索
         * @param target 待搜索的值
         * @return
         */
        public boolean search(int target) {
            Node searchNode = head;
            // 遍历每一层
            for (int i = currentLevel-1; i >=0; i--) {
                // 注意这里都是从searchNode开始往后进行的遍历
                searchNode = findClosest(searchNode, i, target);
                // 如果出现了searchNode的后驱节点的值为target，则说明成功找到
                if (searchNode.next[i] != null && searchNode.next[i].value == target){
                    return true;
                }
            }
            return false;
        }

        /**
         * 在跳表中添加值
         * @param num 待添加的值，后续转为 value
         */
        public void add(int num) {
            int level = randomLevel();
            Node updateNode = head;
            Node newNode = new Node(num, level);
            // 计算出当前 num 索引的实际层数，从该层开始添加索引
            for (int i = currentLevel - 1; i >= 0; i--) {
                // 找到本层最近离num最近的list
                updateNode = findClosest(updateNode, i, num);
                // 插入节点
                if (i < level){
                    // 后驱节点为空，直接加入
                    if (updateNode.next[i]==null){
                        updateNode.next[i] = newNode;
                    }
                    // 后驱节点不为空，则需要插入节点
                    else{
                        Node temp = updateNode.next[i];
                        updateNode.next[i] = newNode;
                        newNode.next[i] = temp;
                    }
                }
            }
            // 如果随机出来的层数比当前的层数还大，那么超过currentLevel的head 直接指向newNode
            if (level > currentLevel){
                for (int i = currentLevel; i < level; i++) {
                    head.next[i] = newNode;
                }
                // 更新currentLevel
                currentLevel = level;
            }

        }

        /**
         * 在跳表中移除值
         * @param num 待移除的值
         * @return
         */
        public boolean erase(int num) {
            // 记录值是否存在
            boolean flag = false;
            Node searchNode = head;
            // 遍历每一层
            for (int i = currentLevel - 1; i >= 0; i--) {
                // 注意这里都是从searchNode开始往后进行的遍历
                searchNode = findClosest(searchNode, i, num);
                // 如果出现了searchNode的后驱节点的值为num，则说明成功找到
                if (searchNode.next[i] != null && searchNode.next[i].value == num){
                    // 将节点移除
                    searchNode.next[i] = searchNode.next[i].next[i];
                    flag = true;
                    // 需要将每一层的num节点都移除，所以这里不能用break
                    continue;
                }
            }
            return flag;
        }

        /**
         * 找到 level层 value 大于 node 的节点
         * @param node 搜索的起始节点
         * @param levelIndex 层数
         * @param value 所需要搜索的值
         * @return
         */
        private Node findClosest(Node node, int levelIndex, int value){
            // 结束条件：后驱节点为空 或者 搜索值比节点值更小
            while ((node.next[levelIndex]) != null && value > node.next[levelIndex].value){
                node = node.next[levelIndex];
            }
            return node;
        }

        /**
         * 随机一个层数
         * @return 获取到的层数
         */
        private static int randomLevel(){
            int level = 1;
            // 以 DEFAULT_P_FACTOR 的概率增加level
            while (Math.random() < DEFAULT_P_FACTOR && level < DEFAULT_MAX_LEVEL){
                level ++ ;
            }
            return level;
        }

        /**
         * 自定义 Node 类存储跳表节点
         */
        class Node{
            // 记录值
            Integer value;
            // 记录后驱节点
            Node[] next;
            public Node(Integer value,int size) {
                this.value = value;
                this.next = new Node[size];
            }
            public String toString() {
                return String.valueOf(value);
            }
        }

    }

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
//leetcode submit region end(Prohibit modification and deletion)

}