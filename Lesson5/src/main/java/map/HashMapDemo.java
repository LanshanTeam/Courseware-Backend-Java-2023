package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author 70ash
 * @Date 2023/11/23 23:33
 */
public class HashMapDemo {
    public static void main(String[] args) {
        // 创建一个HashMap对象
        Map<String, Integer> map = new HashMap<>();
        // 向map中添加键值对
        map.put("key", 1);
        // 从map中获取键为"key"的值，赋值给value变量
        int value = map.get("key");
        // 检查map中是否存在键为"key"的元素，如果存在返回true，否则返回false
        boolean exists = map.containsKey("key");
        // 获取map中所有的键，返回一个Set集合
        Set<String> keys = map.keySet();
        // 获取map中所有的值，返回一个Collection集合
        Collection<Integer> values = map.values();
        // 获取map中所有的键值对，返回一个Collection集合
        Collection<Map.Entry<String, Integer>> entries = map.entrySet();
        // 获取map中第一个键，返回一个String类型的字符串
        String key = map.keySet().toArray(new String[1])[0];
        // 从map中移除键为"key"的元素
        map.remove("key");
        // 清空map中的所有元素
        map.clear();
        // 获取map中元素的个数，返回一个int类型的整数
        int size = map.size();
        // 检查map是否为空，如果为空返回true，否则返回false
        boolean isEmpty = map.isEmpty();

    }
}
