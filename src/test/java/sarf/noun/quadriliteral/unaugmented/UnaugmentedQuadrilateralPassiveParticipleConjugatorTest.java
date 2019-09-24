package sarf.noun.quadriliteral.unaugmented;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.quadriliteral.unaugmented.UnaugmentedQuadrilateralRoot;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class UnaugmentedQuadrilateralPassiveParticipleConjugatorTest {

    @InjectMocks
    private UnaugmentedQuadrilateralPassiveParticipleConjugator sut;

    @Mock
    private GenericNounSuffixContainer genericNounSuffixContainer;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createNounList() {
        var actual = sut.createNounList(new UnaugmentedQuadrilateralRoot());

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(18);
        for (var noun : actual) {
            assertThat(noun).isInstanceOf(UnaugmentedQuadrilateralPassiveParticiple.class);
        }
    }

    @Test
    void createMeemGerundNounList() {
        when(genericNounSuffixContainer.get(anyInt())).thenReturn("");
        var actual = sut.createMeemGerundNounList(new UnaugmentedQuadrilateralRoot());
        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(18);
        List<Integer> expectedIndexes = List.of(0, 6, 12);
        for (var index : expectedIndexes) {
            assertThat(actual.get(index)).isInstanceOf(UnaugmentedQuadrilateralPassiveParticiple.class);
        }

        IntStream.range(0, 18).filter(expectedIndexes::contains).forEach(i -> assertThat(actual.get(i).toString()).isEqualTo(""));
    }

    @Test
    void createTimeAndPlaceNounList() {
        when(genericNounSuffixContainer.get(anyInt())).thenReturn("");
        var actual = sut.createTimeAndPlaceNounList(new UnaugmentedQuadrilateralRoot());

        assertThat(actual).isNotNull();
        assertThat(actual.size()).isEqualTo(18);
        for (var noun : actual) {
            assertThat(noun).isInstanceOf(UnaugmentedQuadrilateralPassiveParticiple.class);
        }
    }
}