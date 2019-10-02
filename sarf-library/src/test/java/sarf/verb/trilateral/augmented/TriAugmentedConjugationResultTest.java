package sarf.verb.trilateral.augmented;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.Word;
import sarf.WordPresenter;

class TriAugmentedConjugationResultTest {

	@Test
	void newlyConstructedConjugationResult_propertiesSet() {
		AugmentedTrilateralRoot root = new AugmentedTrilateralRoot();
		List<Word> originalResult = new ArrayList<>();
		originalResult.add( Word.fromString("كلمة" ));
		
		ConjugationResult sut = new ConjugationResult(KindOfVerb.Salim, 2, root, originalResult);
		
		assertEquals(originalResult.size(), sut.getFinalResult().size());
		assertEquals(KindOfVerb.Salim, sut.getKov());
		assertEquals(2, sut.getFormulaNo());
		assertSame(root, sut.getRoot());
		assertSame(originalResult, sut.getOriginalResult());
	}
}
