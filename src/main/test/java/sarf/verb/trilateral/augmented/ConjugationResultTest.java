package sarf.verb.trilateral.augmented;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ConjugationResultTest {

	@Test
	void newlyConstructedConjugationResult_propertiesSet() throws Exception {
		AugmentedTrilateralRoot root = new AugmentedTrilateralRoot();
		List<String> originalResult = new ArrayList<String>();
		originalResult.add("كلمة");
		
		ConjugationResult sut = new ConjugationResult(1, 2, root, originalResult);
		
		assertEquals(originalResult.size(), sut.getFinalResult().size());
		assertEquals(1, sut.getKov());
		assertEquals(2, sut.getFormulaNo());
		assertSame(root, sut.getRoot());
		assertSame(originalResult, sut.getOriginalResult());
	}
}
