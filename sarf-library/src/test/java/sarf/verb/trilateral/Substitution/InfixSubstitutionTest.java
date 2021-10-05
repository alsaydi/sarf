package sarf.verb.trilateral.Substitution;
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

import org.junit.jupiter.api.Test;
import sarf.Word;
import sarf.WordPresenter;
import sarf.substitution.InfixSubstitution;

class InfixSubstitutionTest {

	@Test
	void apply_doesSubstitution	() {
		InfixSubstitution sut = new InfixSubstitution("SEGMENT", "result");
		assertEquals(WordPresenter.fromText("word result here"), sut.apply(WordPresenter.fromText("word SEGMENT here"), null));
	}
	
	@Test
	void wordDoesNotContainSegment_apply_returnsNull() throws Exception {
		InfixSubstitution sut = new InfixSubstitution("SEGMENT", "result");
		assertNull(sut.apply(WordPresenter.fromText("word does not contain segment"), null));
	}
}
