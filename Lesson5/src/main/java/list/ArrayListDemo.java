package list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 70ash
 * @Date 2023/11/23 19:41
 * @Description:
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        List arrayList = new ArrayList<>();
        // 添加元素 add();
        arrayList.add(20);
        arrayList.add("A");
        arrayList.add("B");
        // 替换元素 set()。传入一个int值作为索引和要添加的值，替换索引处元素。如果索引超过了集合的最大索引，会报错。
        for (int i = 0; i < 30; i++) {
            arrayList.add(i);
        }
        arrayList.set(1,"C");
        // 得到元素 get()
        Object o = arrayList.get(1);
        System.out.println(o);
        // 删除元素 remove()
        arrayList.remove("B");
        // 得到某一元素的索引,如果没有该元素就返回-1
        int b = arrayList.indexOf("B");
        System.out.println("B的索引为" + b);
        // 长度 size()
        System.out.println("集合的长度为" + arrayList.size());
        // 清空列表 clear()
        arrayList.clear();
        System.out.println("集合的长度为" + arrayList.size());
    }
}
