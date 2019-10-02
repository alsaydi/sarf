package sarf.verb.quadriliteral.unaugmented.passive;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sarf.PastConjugationDataContainer;
import sarf.verb.quadriliteral.unaugmented.UnaugmentedQuadrilateralRoot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class QuadriUnaugmentedPassivePastConjugatorTest {

    @InjectMocks
    private QuadriUnaugmentedPassivePastConjugator sut;

    @Mock
    private PastConjugationDataContainer pastConjugationDataContainer;

    @Test
    void createVerbList() {
        MockitoAnnotations.initMocks(this);
        var root = new UnaugmentedQuadrilateralRoot();
        root.setTransitive("");
        var actual = sut.createVerbList(root);

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(13);
    }
}