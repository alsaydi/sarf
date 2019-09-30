package sarf.noun.quadriliteral.unaugmented;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.quadriliteral.unaugmented.UnaugmentedQuadrilateralRoot;

import static org.assertj.core.api.Assertions.assertThat;

class UnaugmentedQuadrilateralActiveParticipleConjugatorTest {
    @Mock
    private GenericNounSuffixContainer genericNounSuffixContainer;

    @InjectMocks
    private UnaugmentedQuadrilateralActiveParticipleConjugator sut;

    @Test
    void createNounList() {
        MockitoAnnotations.initMocks(this);

        var actual = sut.createNounList(new UnaugmentedQuadrilateralRoot());

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(18);
    }
}