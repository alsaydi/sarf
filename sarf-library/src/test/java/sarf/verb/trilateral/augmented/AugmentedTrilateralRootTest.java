package sarf.verb.trilateral.augmented;
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
import java.util.Collection;
import org.junit.jupiter.api.Test;
import sarf.AugmentationFormula;

public class AugmentedTrilateralRootTest {

	@Test
	void addAugmentationFormula_augFormulaAdded() throws Exception {
		AugmentedTrilateralRoot sut = new AugmentedTrilateralRoot();
		AugmentationFormula expected = new AugmentationFormula();
		
		sut.addAugmentationFormula(expected);
		
		AugmentationFormula actual = sut.getAugmentationFormula(0);
		
		assertSame(expected, actual);
	}
	
	@Test
	void augmentationForumlas_getAugmentationList_returnsList() throws Exception {
		AugmentedTrilateralRoot sut = new AugmentedTrilateralRoot();
		AugmentationFormula f1 = new AugmentationFormula();
		AugmentationFormula f2 = new AugmentationFormula();
		AugmentationFormula f3 = new AugmentationFormula();
		f1.setFormulaNo(1);
		f2.setFormulaNo(2);
		f3.setFormulaNo(3);
				
		sut.addAugmentationFormula(f1);
		sut.addAugmentationFormula(f2);
		sut.addAugmentationFormula(f3);
		
		Collection<AugmentationFormula> actual = sut.getAugmentationList();
		
		assertEquals(3, actual.size());
		assertSame(f1, actual.toArray()[0]);
		assertSame(f2, actual.toArray()[1]);
		assertSame(f3, actual.toArray()[2]);
	}
	
	@Test
	void roots_chars() throws Exception {
		AugmentedTrilateralRoot sut = new AugmentedTrilateralRoot();
		sut.setC1('أ');
		sut.setC2('ب');
		sut.setC3('ت');
		
		assertEquals('أ', sut.getC1());
		assertEquals('ب', sut.getC2());
		assertEquals('ت', sut.getC3());
	}
}
