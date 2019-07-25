package sarf.util;

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
public class OrderedMap<TKey, TValue> extends HashMap<TKey, TValue> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected List<TKey> orderedKeys = new LinkedList<>();

    public OrderedMap() {
    }

    /**
     * according to the order of put method a list of keys is ccreated
     * @param key Object
     * @param value Object
     * @return Object
     */
    public TValue put(TKey key, TValue value) {
        orderedKeys.add(key);
        return super.put(key, value);
    }

    public TValue remove(Object key) {
        orderedKeys.remove(key);
        return super.remove(key);
    }


    public List<TKey> getOrderedKeys() {
        return orderedKeys;
    }

}
