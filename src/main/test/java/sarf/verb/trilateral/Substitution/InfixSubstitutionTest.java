package sarf.verb.trilateral.Substitution;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InfixSubstitutionTest {

	@Test
	void apply_doesSubstitution	() throws Exception {
		InfixSubstitution sut = new InfixSubstitution("SEGMENT", "result");
		assertEquals("word result here", sut.apply("word SEGMENT here", null));
	}
	
	@Test
	void wordDoesNotContainSegment_apply_returnsNull() throws Exception {
		InfixSubstitution sut = new InfixSubstitution("SEGMENT", "result");
		assertNull(sut.apply("word does not contain segment", null));
	}
}
