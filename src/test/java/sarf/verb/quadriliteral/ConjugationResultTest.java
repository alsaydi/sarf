package sarf.verb.quadriliteral;

import org.junit.jupiter.api.Test;
import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.Word;
import sarf.WordPresenter;
import sarf.verb.quadriliteral.unaugmented.UnaugmentedQuadrilateralRoot;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConjugationResultTest {

    @Test
    void propertiesAreSet() {
        QuadrilateralRoot root = new UnaugmentedQuadrilateralRoot();
        List<Word> originalResult = new ArrayList<>();
        originalResult.add(Word.fromString("Test"));

        ConjugationResult sut = new ConjugationResult(KindOfVerb.Mudaaf, 1, root, originalResult);

        assertEquals(1, sut.getFormulaNo());
        assertEquals(KindOfVerb.Mudaaf, sut.getKov());
        assertSame(root, sut.getRoot());
        assertSame(originalResult, sut.getOriginalResult());
        assertNotSame(originalResult, sut.getFinalResult());
        assertEquals(1, sut.getFinalResult().size());
        assertEquals(sut.getFinalResult().get(0), WordPresenter.fromText("Test"));
    }

}
