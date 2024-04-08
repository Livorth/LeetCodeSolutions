package daily.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question1600 {
    public static void main(String[] args) {
//        Solution solution = new Question1600().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 执行耗时:266 ms,击败了90.32% 的Java用户
     * 内存消耗:102 MB,击败了70.97% 的Java用户
     */
    class ThroneInheritance {

        Person head = new Person("");
        Map<String, Person> map = new HashMap<>();

        public ThroneInheritance(String kingName) {
            Person king = new Person(kingName);
            head.next = king;
            map.put(kingName, king);
        }

        public void birth(String parentName, String childName) {
            Person child = new Person(childName);
            map.put(childName, child);

            Person parent = map.get(parentName);
            Person temP = parent;
            // 寻找插入的位置，爹当前最后一个儿子的最后一个子代
            while (temP.lastSon != null) {
                temP = temP.lastSon;
            }
            child.next = temP.next;
            temP.next = child;
            parent.lastSon = child;
        }

        public void death(String name) {
            Person person = map.get(name);
            person.died = true;
        }

        public List<String> getInheritanceOrder() {
            List<String> res = new ArrayList<>();
            Person temP = head.next;

            while (temP != null) {
                if (!temP.died) {
                    res.add(temP.name);
                }
                temP = temP.next;
            }
            return res;
        }

        class Person {
            String name;
            Person next;
            Person lastSon;

            Boolean died = false;

            Person(String name) {
                this.name = name;
            }

        }
    }

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
//leetcode submit region end(Prohibit modification and deletion)

}