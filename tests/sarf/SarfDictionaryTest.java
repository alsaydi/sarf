package sarf;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;

class SarfDictionaryTest {

	@Test
	void getInstance_returnsInstance() throws Exception {
		assertNotNull(SarfDictionary.getInstance());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"نصر", "وعد", "قول", "سعي","وفي", "طوي"})
	void rootText_getAugmentedTrilateralRoot_returnsRoot(String candiate) throws Exception {
		AugmentedTrilateralRoot sut = SarfDictionary.getInstance().getAugmentedTrilateralRoot(candiate);
		
		assertNotNull(sut);
		assertEquals(candiate.charAt(0), sut.getC1());
		assertEquals(candiate.charAt(1), sut.getC2());
		assertEquals(candiate.charAt(2), sut.getC3());
		assertNotNull(sut.getAugmentationList());
		assertTrue(sut.getAugmentationList().size()>0);
	}
	
	@Test
	void noRoot_getAugmentedTrilateralRoot_returnsNull() throws Exception {
		assertNull(SarfDictionary.getInstance().getAugmentedTrilateralRoot("ككك"));
	}
}
