package sarf.verb.trilateral.unaugmented.passive;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sarf.PastConjugationDataContainer;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PassivePastConjugatorTest {

    @Mock
    private PastConjugationDataContainer pastConjugationDataContainer;

    @InjectMocks
    private PassivePastConjugator sut;

    @Test
    void createVerbList() {
        MockitoAnnotations.initMocks(this);

        var root = new UnaugmentedTrilateralRoot();
        root.setTransitive("");

        var actual = sut.createVerbList(root);

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(13);
    }
}