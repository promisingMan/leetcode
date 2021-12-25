package interview.bytedance;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zengjia
 * @date 2021-11-24 22:32:54
 */
public class LRUCache extends LinkedHashMap {

    public static final int INITIAL_CAPACITY = 16;

    public LRUCache() {
        super(INITIAL_CAPACITY, 0.75F, true);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > INITIAL_CAPACITY;
    }
}
