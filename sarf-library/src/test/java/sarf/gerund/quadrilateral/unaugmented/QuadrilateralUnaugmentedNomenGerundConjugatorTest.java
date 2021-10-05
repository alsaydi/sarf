package sarf.gerund.quadrilateral.unaugmented;
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
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.verification.VerificationMode;
import sarf.SystemConstants;
import sarf.gerund.quadrilateral.augmented.nomen.QuadrilateralAugmentedNomenGerundConjugator;
import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.quadriliteral.unaugmented.UnaugmentedQuadrilateralRoot;

import java.text.Collator;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class QuadrilateralUnaugmentedNomenGerundConjugatorTest {
    @Mock
    private GenericNounSuffixContainer genericNounSuffixContainer;

    @InjectMocks
    private QuadrilateralUnaugmentedNomenGerundConjugator sut;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        when(genericNounSuffixContainer.getPrefix()).thenReturn("");
        when(genericNounSuffixContainer.get(anyInt())).thenReturn("");
    }

    @Test
    void createGerundListTest() {
        Locale syLocale = new java.util.Locale("ar", "SY", "");
        var collator = Collator.getInstance(syLocale);
        collator.setStrength(Collator.NO_DECOMPOSITION);
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
        assertThat(actual.stream().filter(g -> collator.compare(g.toString(), "سمعل") == 0).count()).isEqualTo(9);
        verify(genericNounSuffixContainer, times(1)).getPrefix();
        verify(genericNounSuffixContainer, times(9)).get(anyInt());
    }
}