package sarf.gerund.quadrilateral.unaugmented;

import org.junit.jupiter.api.Test;
import sarf.SystemConstants;
import sarf.gerund.quadrilateral.augmented.nomen.QuadrilateralAugmentedNomenGerundConjugator;
import sarf.verb.quadriliteral.unaugmented.UnaugmentedQuadrilateralRoot;

import java.text.Collator;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class QuadrilateralUnaugmentedNomenGerundConjugatorTest {

    @Test
    void createGerundListTest() {
        Locale syLocale = new java.util.Locale("ar", "SY", "");
        var collator = Collator.getInstance(syLocale);
        collator.setStrength(Collator.NO_DECOMPOSITION);

        var sut = QuadrilateralUnaugmentedNomenGerundConjugator.getInstance();
        var root = new UnaugmentedQuadrilateralRoot();
        root.setC1('س');
        root.setC2('م');
        root.setC3('ع');
        root.setC4('ل');

        var actual = sut.createGerundList(root);

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(SystemConstants.NOUN_POSSIBLE_STATES);
        assertThat(actual.stream().allMatch(g -> g.getClass() == QuadrilateralGerund.class)).isTrue();
        //final int[] indexList = {2, 4, 6, 8, 10, 12, 14, 16, 18};

        assertThat(actual.stream().filter(g -> !g.toString().equals("")).count()).isEqualTo(9);
        assertThat(collator.compare(actual.get(1).toString(),"سمعلة")).isEqualTo(0);
        assertThat(collator.compare(actual.get(3).toString(),"سمعلتان")).isEqualTo(0);
        assertThat(collator.compare(actual.get(5).toString(),"سمعلات")).isEqualTo(0);

        assertThat(collator.compare(actual.get(7).toString(),"سمعلة")).isEqualTo(0);
        assertThat(collator.compare(actual.get(9).toString(),"سمعلتين")).isEqualTo(0);
        assertThat(collator.compare(actual.get(11).toString(),"سمعلات")).isEqualTo(0);

        assertThat(collator.compare(actual.get(13).toString(),"سمعلة")).isEqualTo(0);
        assertThat(collator.compare(actual.get(15).toString(),"سمعلتين")).isEqualTo(0);
        assertThat(collator.compare(actual.get(17).toString(),"سمعلات")).isEqualTo(0);
    }
}