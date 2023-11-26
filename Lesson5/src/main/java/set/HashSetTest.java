package set;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author 70ash
 * @Date 2023/11/24 20:09
 * @Description:
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashMap set = new HashMap();
        for (int i = 0; i < 30; i++) {
            set.put("key"+i,i);
        }
    }
}
