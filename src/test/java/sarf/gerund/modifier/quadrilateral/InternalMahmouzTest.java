package sarf.gerund.modifier.quadrilateral;

import org.junit.jupiter.api.Test;
import sarf.KindOfVerb;
import sarf.verb.quadriliteral.ConjugationResult;
import sarf.verb.quadriliteral.augmented.AugmentedQuadrilateralRoot;

import java.util.Collections;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InternalMahmouzTest {

    @Test
    void getSubstitutions() {
        var sut = new InternalMahmouz();

        var actual = sut.getSubstitutions();

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(5);
        assertThat(actual).allSatisfy(Objects::nonNull);
    }

    @Test
    void isApplied() {
        var root = new AugmentedQuadrilateralRoot();
        root.setC2('ء');
        var result = new ConjugationResult(1, KindOfVerb.Naqis_Wawi, root, Collections.emptyList());

        var sut = new InternalMahmouz();

        assertThat(sut.isApplied(result)).isTrue();
        root.setC3('ء');
        assertThat(sut.isApplied(result)).isTrue();

        root.setC2('r');
        assertThat(sut.isApplied(result)).isTrue();

        root.setC3('f');
        assertThat(sut.isApplied(result)).isFalse();
    }
}