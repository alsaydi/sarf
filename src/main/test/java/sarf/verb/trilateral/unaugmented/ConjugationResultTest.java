package sarf.verb.trilateral.unaugmented;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sarf.KindOfVerb;

class ConjugationResultTest{
    ConjugationResult sut;
    UnaugmentedTrilateralRoot root;
    KindOfVerb kov = KindOfVerb.Salim;
    List<String> originalResult;

    @BeforeEach
    void Setup(){

        originalResult = new ArrayList<>();
        originalResult.add(0, "Test");
        root = new UnaugmentedTrilateralRoot();
        sut = new ConjugationResult(kov, root, originalResult);
    }

    @Test
    void testProperties() throws Exception{
        assertSame(root, sut.getRoot());
        assertEquals(kov, sut.getKov());
        assertSame(originalResult, sut.getOriginalResult());
        assertNotSame(originalResult, sut.getFinalResult());
        assertEquals(originalResult.size(), sut.getFinalResult().size());
    }

}