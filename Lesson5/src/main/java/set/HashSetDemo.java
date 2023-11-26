package set;

import java.util.*;

/**
 * @Author 70ash
 * @Date 2023/11/23 23:04
 * @Description:
 */
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        // 添加元素
        set.add("apple");
        set.add("banana");
        set.add("orange");
        // 删除元素
        set.remove("banana");
        // 查看是否包含元素 contains()
        System.out.println(set.contains("apple")); // 输出：true
        System.out.println(set.contains("banana")); // 输出：false
        // 长度
        System.out.println(set.size()); // 输出：2
        // 遍历元素。使用迭代器
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // 使用增强for循环
        // 清空集合元素
        set.clear();
        System.out.println(set.size()); // 输出：0
    }

}
