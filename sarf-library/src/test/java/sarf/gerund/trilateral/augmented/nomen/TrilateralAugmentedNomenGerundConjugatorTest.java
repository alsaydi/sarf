package sarf.gerund.trilateral.augmented.nomen;
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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPattern1;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPattern10;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPattern11;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPattern12;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPattern2;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPattern3;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPattern4;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPattern5;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPattern6;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPattern7;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPattern8;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPattern9;
import sarf.gerund.trilateral.augmented.nomen.pattern.GerundPatternEmpty;
import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class TrilateralAugmentedNomenGerundConjugatorTest {

	@Mock
	private GenericNounSuffixContainer genericNounSuffixContainer;

	@InjectMocks
	private TrilateralAugmentedNomenGerundConjugator sut;

	private static Stream<Arguments> getCreateListTestParameters() {
		return Stream.of(
				Arguments.of(1, GerundPattern1.class),
				Arguments.of(2, GerundPattern2.class),
				Arguments.of(3, GerundPattern3.class),
				Arguments.of(4, GerundPattern4.class),
				Arguments.of(5, GerundPattern5.class),
				Arguments.of(6, GerundPattern6.class),
				Arguments.of(7, GerundPattern7.class),
				Arguments.of(8, GerundPattern8.class),
				Arguments.of(9, GerundPattern9.class),
				Arguments.of(10, GerundPattern10.class),
				Arguments.of(11, GerundPattern11.class),
				Arguments.of(12, GerundPattern12.class)
		);
	}

	@BeforeEach
	void setup(){
		MockitoAnnotations.initMocks(this);
		when(genericNounSuffixContainer.getPrefix()).thenReturn("");
		when(genericNounSuffixContainer.get(anyInt())).thenReturn("");
	}
	
	@ParameterizedTest(name = "مصدر المرة الثلاثي المزيد {1}")
	@MethodSource("getCreateListTestParameters")
	void root_createGerundList_returnsList(int formula, Class expected) {
		var verb = "برد".toCharArray();
		var root = new AugmentedTrilateralRoot(verb[0],verb[1],verb[2]);
		
		var list = sut.createGerundList(root, formula);
		
		assertNotNull(list);
		assertEquals(18, list.size());

		for(var i=0;i<list.size();i+=2){
			assertThat(list.get(i).getClass()).isEqualTo(GerundPatternEmpty.class);
		}

		for(var i=1;i<list.size();i+=2){
			assertThat(list.get(i).getClass()).isEqualTo(expected);
		}
	}
}
