package sarf.verb.quadriliteral;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import sarf.KindOfVerb;
import sarf.verb.quadriliteral.unaugmented.UnaugmentedQuadrilateralRoot;

class ConjugationResultTest {
	
	@Test
	void propertiesAreSet() throws Exception {
		QuadrilateralRoot root = new UnaugmentedQuadrilateralRoot();
		List<String> originalResult = new ArrayList<>();
		originalResult.add("Test");
		
		ConjugationResult sut = new ConjugationResult(1, KindOfVerb.Mudaaf, root, originalResult);
		
		assertEquals(1, sut.getFormulaNo());
		assertEquals(2, sut.getKov());
		assertSame(root, sut.getRoot());
		assertSame(originalResult, sut.getOriginalResult());
		assertNotSame(originalResult, sut.getFinalResult());
		assertEquals(1, sut.getFinalResult().size());
		assertLinesMatch(originalResult, sut.getFinalResult());
	}
	
}
