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
import sarf.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

class PastConjugationDataContainerTest {

	private PastConjugationDataContainer sut = new PastConjugationDataContainer();//.getInstance();
	
	@Test
	void getDpa2_dependsOnConjugationOfRoot() throws Exception {
		assertEquals(ArabCharUtil.FATHA, sut.getDpa2(getRootWithConjugation(Conjugation.First)));
		assertEquals(ArabCharUtil.FATHA, sut.getDpa2(getRootWithConjugation(Conjugation.Second)));
		assertEquals(ArabCharUtil.FATHA, sut.getDpa2(getRootWithConjugation(Conjugation.Third)));
		assertEquals(ArabCharUtil.KASRA, sut.getDpa2(getRootWithConjugation(Conjugation.Forth)));
		assertEquals(ArabCharUtil.DAMMA, sut.getDpa2(getRootWithConjugation(Conjugation.Fifth)));
		assertEquals(ArabCharUtil.KASRA, sut.getDpa2(getRootWithConjugation(Conjugation.Sixth)));
	}

	private UnaugmentedTrilateralRoot getRootWithConjugation(Conjugation باب_التصريف) throws IllegalArgumentException {
		UnaugmentedTrilateralRoot root = new UnaugmentedTrilateralRoot();
		root.setConjugation(باب_التصريف);
		return root;
	}
}
