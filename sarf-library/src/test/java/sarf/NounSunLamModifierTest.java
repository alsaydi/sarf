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
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sarf.substitution.Substitution;
import sarf.NounSunLamModifier.ListedInfixSubstitution;

class NounSunLamModifierTest {

	private NounSunLamModifier sut;

	@BeforeEach
	void setup(){
		sut = new NounSunLamModifier();
	}

	@Test
	void assertAppliedPronounsIndexes() throws Exception {
		assertEquals(18, sut.getAppliedPronounsIndexes().size());
	}
	
	@Test
	void getSubstitutions_returnsListedInfixSubstitution() throws Exception {
		List<Substitution> actual = sut.getSubstitutions();
		
		assertEquals(3, actual.size());
	}

	@Test
	void listedInfixSubstitution_apply_replacesSegmentsAroundSpecifiedLettersWithDesignatedPatterns() throws Exception {
		List<String> sunLetters = new LinkedList<>();
		sunLetters.add("ت");
		
		ListedInfixSubstitution sut = new ListedInfixSubstitution(sunLetters, "سSLص", "صصSLسس");
		
		var actual = sut.apply(WordPresenter.fromText("ستصمر"), null);
		
		assertEquals(WordPresenter.fromText("صصتسسمر"), actual);
	}

	@Test
	void sunLetterNotInWord_apply_returnsNull() throws Exception {
		List<String> sunLetters = new LinkedList<>();
		sunLetters.add("ت");
		
		ListedInfixSubstitution sut = new ListedInfixSubstitution(sunLetters, "سSLص", "صصSLسس");
		
		var actual = sut.apply(WordPresenter.fromText("سصمر"), null);
		
		assertNull(actual);
	}
}
