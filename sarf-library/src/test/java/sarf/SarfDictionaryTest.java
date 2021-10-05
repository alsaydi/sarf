package sarf;
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
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

class SarfDictionaryTest {
	//TODO: We now can mock these dependencies.
	private SarfDictionary sarfDictionary = new SarfDictionary(new DatabaseManager());

	@Test
	void getInstance_returnsInstance() {
		assertNotNull(sarfDictionary);
	}

	@ParameterizedTest
	@ValueSource(strings = {"نصر", "وعد", "قول", "سعي","وفي", "طوي"})
	void rootText_getAugmentedTrilateralRoot_returnsRoot(String candidate) throws Exception {
		AugmentedTrilateralRoot sut = sarfDictionary.getAugmentedTrilateralRoot(candidate);

		assertNotNull(sut);
		assertEquals(candidate.charAt(0), sut.getC1());
		assertEquals(candidate.charAt(1), sut.getC2());
		assertEquals(candidate.charAt(2), sut.getC3());
		assertNotNull(sut.getAugmentationList());
		assertTrue(sut.getAugmentationList().size()>0);
	}

	@Test
	void noRoot_getAugmentedTrilateralRoot_returnsNull() throws Exception {
		assertNull(sarfDictionary.getAugmentedTrilateralRoot("ككك"));
	}

	@Test
	void getUnaugmentedTrilateralRoots_returnsAllMatchingRoots() throws Exception {
		List<UnaugmentedTrilateralRoot> sut = sarfDictionary.getUnaugmentedTrilateralRoots("فطم");
		assertEquals(1, sut.size());

		sut = sarfDictionary.getUnaugmentedTrilateralRoots("فكر");
		assertEquals(2, sut.size());
	}

	@Test
	void noRoot_getAugmentedTrilateralRoot_returnsEmptyList() throws Exception {
		List<UnaugmentedTrilateralRoot> sut = sarfDictionary.getUnaugmentedTrilateralRoots("ببب");
		assertEquals(0, sut.size());
	}
}
