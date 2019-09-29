package sarf.verb.trilateral.Substitution;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import sarf.Word;
import sarf.WordPresenter;
import sarf.substitution.InfixSubstitution;

class InfixSubstitutionTest {

	@Test
	void apply_doesSubstitution	() {
		InfixSubstitution sut = new InfixSubstitution("SEGMENT", "result");
		assertEquals(WordPresenter.fromText("word result here"), sut.apply(WordPresenter.fromText("word SEGMENT here"), null));
	}
	
	@Test
	void wordDoesNotContainSegment_apply_returnsNull() throws Exception {
		InfixSubstitution sut = new InfixSubstitution("SEGMENT", "result");
		assertNull(sut.apply(WordPresenter.fromText("word does not contain segment"), null));
	}
}
