package sarf.verb.trilateral.Substitution;

import org.junit.jupiter.api.Test;
import sarf.Word;
import sarf.substitution.ExpressionSuffixSubstitution;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionSuffixSubstitutionTest {

    @Test
    void nullWord_apply_returnsNull() {
        var sut = new ExpressionSuffixSubstitution("C1", "C1C1");

        var actual = sut.apply(null, new UnaugmentedTrilateralRoot());

        assertNull(actual);
    }

    @Test
    void emptyWord_apply_returnsNull() {
        var sut = new ExpressionSuffixSubstitution("C1", "C1C1");

        var actual = sut.apply(Word.Empty, new UnaugmentedTrilateralRoot());

        assertNull(actual);
    }

    @Test
    void applyTest() {
        var sut = new ExpressionSuffixSubstitution("C3", "C3C3");

        var root = new UnaugmentedTrilateralRoot();
        root.setC1('ف');
        root.setC2('ع');
        root.setC3('ل');

        var actual = sut.apply(Word.fromText("تفعل"), root);

        assertEquals(Word.fromText("تفعلل"), actual);
    }
}