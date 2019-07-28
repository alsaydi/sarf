package sarf.gerund.quadrilateral.unaugmented;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import sarf.SystemConstants;
import sarf.verb.quadriliteral.unaugmented.UnaugmentedQuadrilateralRoot;

import java.text.Collator;
import java.util.Locale;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class QuadrilateralUnaugmentedGerundConjugatorTest {
    @Test
    void createGerundListTestForm1() {
        Locale syLocale = new java.util.Locale("ar", "SY", "");
        var collator = Collator.getInstance(syLocale);
        collator.setStrength(Collator.NO_DECOMPOSITION);

        var sut = QuadrilateralUnaugmentedGerundConjugator.getInstance();
        sut.setListener(new FakeQuadrilateralGerundFormSelector(1));
        var root = new UnaugmentedQuadrilateralRoot();
        root.setC1('د');
        root.setC2('ح');
        root.setC3('ر');
        root.setC4('ج');

        var actual = sut.createGerundList(root);

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(SystemConstants.NOUN_POSSIBLE_STATES);
        assertThat(actual.stream().allMatch(g -> g.getClass() == QuadrilateralGerund.class)).isTrue();

        assertThat(actual.stream().filter(g -> !g.toString().equals("")).count()).isEqualTo(9);
        assertThat(collator.compare(actual.get(1).toString(),"دحرجة")).isEqualTo(0);
        assertThat(collator.compare(actual.get(3).toString(),"دحرجتان")).isEqualTo(0);
        assertThat(collator.compare(actual.get(5).toString(),"دحرجات")).isEqualTo(0);

        assertThat(collator.compare(actual.get(7).toString(),"دحرجة")).isEqualTo(0);
        assertThat(collator.compare(actual.get(9).toString(),"دحرجتين")).isEqualTo(0);
        assertThat(collator.compare(actual.get(11).toString(),"دحرجات")).isEqualTo(0);

        assertThat(collator.compare(actual.get(13).toString(),"دحرجة")).isEqualTo(0);
        assertThat(collator.compare(actual.get(15).toString(),"دحرجتين")).isEqualTo(0);
        assertThat(collator.compare(actual.get(17).toString(),"دحرجات")).isEqualTo(0);
    }

    @Test
    void createGerundListTestForm2() {
        Locale syLocale = new java.util.Locale("ar", "SY", "");
        var collator = Collator.getInstance(syLocale);
        collator.setStrength(Collator.NO_DECOMPOSITION);

        var sut = QuadrilateralUnaugmentedGerundConjugator.getInstance();
        sut.setListener(new FakeQuadrilateralGerundFormSelector(2));
        var root = new UnaugmentedQuadrilateralRoot();
        root.setC1('ز');
        root.setC2('ل');
        root.setC3('ز');
        root.setC4('ل');

        var actual = sut.createGerundList(root);

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(SystemConstants.NOUN_POSSIBLE_STATES);
        assertThat(actual.stream().allMatch(g -> g.getClass() == QuadrilateralGerund.class)).isTrue();

        // private final int[] form2IndexList = {1, 3, 6, 7, 9, 12, 13, 15, 18};
        assertThat(actual.stream().filter(g -> !g.toString().equals("")).count()).isEqualTo(9);
        assertThat(collator.compare(actual.get(0).toString(),"زلزال")).isEqualTo(0);
        assertThat(collator.compare(actual.get(2).toString(),"زلزالان")).isEqualTo(0);
        assertThat(collator.compare(actual.get(5).toString(),"زلزالات")).isEqualTo(0);

        assertThat(collator.compare(actual.get(6).toString(),"زلزالا")).isEqualTo(0);
        assertThat(collator.compare(actual.get(8).toString(),"زلزالين")).isEqualTo(0);
        assertThat(collator.compare(actual.get(11).toString(),"زلزالات")).isEqualTo(0);

        assertThat(collator.compare(actual.get(12).toString(),"زلزال")).isEqualTo(0);
        assertThat(collator.compare(actual.get(14).toString(),"زلزالين")).isEqualTo(0);
        assertThat(collator.compare(actual.get(17).toString(),"زلزالات")).isEqualTo(0);
    }

    private static class FakeQuadrilateralGerundFormSelector implements QuadrilateralUnaugmentedGerundConjugatorListener {
        private final int form;
        FakeQuadrilateralGerundFormSelector(int form){
            this.form = form;
        }
        @Override
        public int selectFormNo() {
            return form;
        }
    }
}