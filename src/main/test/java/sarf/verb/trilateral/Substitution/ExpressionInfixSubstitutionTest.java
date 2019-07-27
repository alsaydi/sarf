package sarf.verb.trilateral.Substitution;

import org.junit.jupiter.api.Test;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionInfixSubstitutionTest {

    @Test
    void wordIsEmptyRegardlessOfRoot_apply_returnsNull() {
        var sut = new ExpressionInfixSubstitution("C2C3", "C3ّ");

        var actual = sut.apply("", null);

        assertNull(actual);
    }

    @Test
    void wordIsNullRegardlessOfRoot_apply_returnsNull() {
        var sut = new ExpressionInfixSubstitution("C2C3", "C3ّ");

        var actual = sut.apply(null, null);

        assertNull(actual);
    }

    @Test
    void applyTest(){
        var sut = new ExpressionInfixSubstitution("C3C3", "C3ّ");

        var root = new UnaugmentedTrilateralRoot();
        root.setC1('ح');
        root.setC2('ب');
        root.setC3('ب');

        var actual = sut.apply("أحبب", root);

        assertEquals("أحبّ" , actual);
    }
}