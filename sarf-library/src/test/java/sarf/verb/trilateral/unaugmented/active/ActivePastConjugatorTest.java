package sarf.verb.trilateral.unaugmented.active;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sarf.PastConjugationDataContainer;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ActivePastConjugatorTest {

    @InjectMocks
    private ActivePastConjugator sut;

    @Mock
    private PastConjugationDataContainer pastConjugationDataContainer;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createVerb() {
        var root = new UnaugmentedTrilateralRoot();
        root.setTransitive("");
        var actual = sut.createVerb(0, root);

        assertThat(actual).isNotNull();
        verify(pastConjugationDataContainer, times(1)).getDpa2(root);
        verify(pastConjugationDataContainer, times(1)).getLastDpa(0);
        verify(pastConjugationDataContainer, times(1)).getConnectedPronoun(0);
    }

    @Test
    void createVerbList() {
        var root = new UnaugmentedTrilateralRoot();
        root.setTransitive("");
        var actual = sut.createVerbList(root);

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(13);
    }
}