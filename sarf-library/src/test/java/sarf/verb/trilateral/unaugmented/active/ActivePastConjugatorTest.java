package sarf.verb.trilateral.unaugmented.active;
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