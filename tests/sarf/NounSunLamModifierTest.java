package sarf;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;

class NounSunLamModifierTest {
	
	@Test
	void getInstance_returnsInstance() throws Exception {
		assertNotNull(NounSunLamModifier.getInstance());
	}

	@Test
	void assertAppliedProunounsIndecies() throws Exception {
		assertEquals(18, NounSunLamModifier.getInstance().getAppliedPronounsIndecies().size());
	}
	
	@Test
	void getSubstitutions_returnsListedInfixSubstitution() throws Exception {
		NounSunLamModifier sut = NounSunLamModifier.getInstance();
		
		List actual = sut.getSubstitutions();
		
		assertEquals(3, actual.size());
	}
}
