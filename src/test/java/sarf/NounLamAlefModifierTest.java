package sarf;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sarf.substitution.Substitution;

class NounLamAlefModifierTest {

	private NounLamAlefModifier sut;

	@BeforeEach
	void setup(){
		sut = new NounLamAlefModifier();
	}

	@Test
	void getSubstitutions_returnsExpected() {
		List<Substitution> actual = sut.getSubstitutions();
		
		assertNotNull(actual);
		assertEquals(4, actual.size());		
	}
	
	@Test
	void assertApplied() {
		assertEquals(18, NounLamAlefModifier.appliedPronounsIndexes.size());
	}
}
