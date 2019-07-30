package sarf.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

public class OrderedMapTest {

	@Test
	public void getOrderedKeys_returnsKeys() {
		OrderedMap<String, String> sut = new OrderedMap<>();
		sut.put("مفتاح", "قيمة");
		List<String> keys = sut.getOrderedKeys();
		assertEquals(1, keys.size());
		assertEquals("مفتاح", keys.get(0));
	}
	
	@Test 
	public void KeyAndValuesOfDiffernetTypes() {
		OrderedMap<Integer, String> sut = new OrderedMap<>();
		sut.put(1,"هنا لو كان");
		List<Integer> keys = sut.getOrderedKeys();
		assertEquals(1, keys.size());
		assertEquals(new Integer(1), keys.get(0));
	}
	
	@Test
	void removeKey_keyIsRemoved() throws Exception {
		OrderedMap<String, String> sut = new OrderedMap<>();
		sut.put("م","هنا لو كان");
		List<String> keys = sut.getOrderedKeys();
		assertEquals(1, keys.size());
		
		sut.remove("م");
		keys = sut.getOrderedKeys();
		assertEquals(0, keys.size());
	}
	
}
