package sarf.util;

import java.util.HashMap;
import java.util.*;

/**
 * <p>Title: Common utility</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: AWS</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class OrderedMap extends HashMap {
    protected List orderedKeys = new LinkedList();

    public OrderedMap() {
    }

    /**
     * according to the order of put method a list of keys is ccreated
     * @param key Object
     * @param value Object
     * @return Object
     */
    public Object put(Object key, Object value) {
        orderedKeys.add(key);
        return super.put(key, value);
    }

    public Object remove(Object key) {
        orderedKeys.remove(key);
        return super.remove(key);
    }


    public List getOrderedKeys() {
        return orderedKeys;
    }

}
