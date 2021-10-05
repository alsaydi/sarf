package sarf.noun.quadriliteral.unaugmented;
/*
 *
 * MIT License
 *
 * Copyright (c) 2021 Abdalaziz Alsaydi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
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