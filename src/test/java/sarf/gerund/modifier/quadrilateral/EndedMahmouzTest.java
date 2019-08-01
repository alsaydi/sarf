package sarf.gerund.modifier.quadrilateral;

import org.junit.jupiter.api.Test;
import sarf.KindOfVerb;
import sarf.verb.quadriliteral.ConjugationResult;
import sarf.verb.quadriliteral.QuadrilateralRoot;
import sarf.verb.quadriliteral.augmented.AugmentedQuadrilateralRoot;
import sarf.verb.quadriliteral.substitution.InfixSubstitution;

import java.util.Arrays;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EndedMahmouzTest {

    @Test
    void getSubstitutions() {
        var sut = new EndedMahmouz();

        var actual = sut.getSubstitutions();

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(4);
        assertThat(actual).allSatisfy(Objects::nonNull);
    }

    @Test
    void isApplied() {
        var root = new AugmentedQuadrilateralRoot();
        root.setC4('ء');
        var result = new  ConjugationResult(1, KindOfVerb.Naqis_Wawi, root, Arrays.asList(new String[]{}));

        var sut = new EndedMahmouz();

        sut.isApplied(result);

        assertThat(sut.isApplied(result)).isTrue();

        root.setC4('f');
        assertThat(sut.isApplied(result)).isFalse();
    }
}
