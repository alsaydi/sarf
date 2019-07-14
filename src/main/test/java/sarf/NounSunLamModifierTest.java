package sarf;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;
import sarf.verb.trilateral.Substitution.*;
import sarf.NounSunLamModifier.ListedInfixSubstitution;

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
		List<Substitution> actual = sut.getSubstitutions();
		
		assertEquals(3, actual.size());
	}
	
	
	
	@Test
	void listedInfixSubstitution_apply_replacesSegmentsAroundSpecifiedLettersWithDesignatedPatterns() throws Exception {
		List<String> sunLetters = new LinkedList<>();
		sunLetters.add("ت");
		
		ListedInfixSubstitution sut = NounSunLamModifier.getInstance().new ListedInfixSubstitution(sunLetters, "سSLص","صصSLسس");
		
		String actual = sut.apply("ستصمر", null);
		
		assertEquals("صصتسسمر", actual);
	}

	@Test
	void sunLetterNotInWord_apply_returnsNull() throws Exception {
		List<String> sunLetters = new LinkedList<>();
		sunLetters.add("ت");
		
		ListedInfixSubstitution sut = NounSunLamModifier.getInstance().new ListedInfixSubstitution(sunLetters, "سSLص","صصSLسس");
		
		String actual = sut.apply("سصمر", null);
		
		assertNull(actual);
	}
}
