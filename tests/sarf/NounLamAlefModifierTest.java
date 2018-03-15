package sarf;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import sarf.verb.trilateral.Substitution.InfixSubstitution;

class NounLamAlefModifierTest {
	
	@Test
	void getInstance_returnsInstance() throws Exception {
		assertNotNull(NounLamAlefModifier.getInstance());
	}
	
	@Test
	void getSubstitutions_returnsExpected() throws Exception {
		List<InfixSubstitution> actual = NounLamAlefModifier.getInstance().getSubstitutions();
		
		assertNotNull(actual);
		assertEquals(4, actual.size());		
	}
	
	@Test
	void assertApplied() throws Exception {
		assertEquals(18, NounLamAlefModifier.appliedProunounsIndecies.size());		
	}
}
