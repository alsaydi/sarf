package sarf;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sarf.substitution.Substitution;
import sarf.NounSunLamModifier.ListedInfixSubstitution;

class NounSunLamModifierTest {

	private NounSunLamModifier sut;

	@BeforeEach
	void setup(){
		sut = new NounSunLamModifier();
	}

	@Test
	void assertAppliedPronounsIndexes() throws Exception {
		assertEquals(18, sut.getAppliedPronounsIndexes().size());
	}
	
	@Test
	void getSubstitutions_returnsListedInfixSubstitution() throws Exception {
		List<Substitution> actual = sut.getSubstitutions();
		
		assertEquals(3, actual.size());
	}

	@Test
	void listedInfixSubstitution_apply_replacesSegmentsAroundSpecifiedLettersWithDesignatedPatterns() throws Exception {
		List<String> sunLetters = new LinkedList<>();
		sunLetters.add("ت");
		
		ListedInfixSubstitution sut = new ListedInfixSubstitution(sunLetters, "سSLص", "صصSLسس");
		
		var actual = sut.apply(Word.fromText("ستصمر"), null);
		
		assertEquals(Word.fromText("صصتسسمر"), actual);
	}

	@Test
	void sunLetterNotInWord_apply_returnsNull() throws Exception {
		List<String> sunLetters = new LinkedList<>();
		sunLetters.add("ت");
		
		ListedInfixSubstitution sut = new ListedInfixSubstitution(sunLetters, "سSLص", "صصSLسس");
		
		var actual = sut.apply(Word.fromText("سصمر"), null);
		
		assertNull(actual);
	}
}
