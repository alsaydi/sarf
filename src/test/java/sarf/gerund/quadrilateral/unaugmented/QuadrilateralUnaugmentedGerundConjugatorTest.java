package sarf.gerund.quadrilateral.unaugmented;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sarf.SystemConstants;
import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.quadriliteral.unaugmented.UnaugmentedQuadrilateralRoot;

import java.text.Collator;
import java.util.Locale;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class QuadrilateralUnaugmentedGerundConjugatorTest {

    @Mock
    private GenericNounSuffixContainer genericNounSuffixContainer;

    @InjectMocks
    private QuadrilateralUnaugmentedGerundConjugator sut;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void createGerundListTestForm1() {
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
        verify(genericNounSuffixContainer, times(9)).getPrefix();
        verify(genericNounSuffixContainer, times(9)).get(anyInt());
    }

    @Test
    void createGerundListTestForm2() {
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
        verify(genericNounSuffixContainer, times(9)).getPrefix();
        verify(genericNounSuffixContainer, times(9)).get(anyInt());
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