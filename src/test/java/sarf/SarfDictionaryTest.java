package sarf;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

class SarfDictionaryTest {

	@Test
	void getInstance_returnsInstance() throws Exception {
		assertNotNull(SarfDictionary.getInstance());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"نصر", "وعد", "قول", "سعي","وفي", "طوي"})
	void rootText_getAugmentedTrilateralRoot_returnsRoot(String candidate) throws Exception {
		AugmentedTrilateralRoot sut = SarfDictionary.getInstance().getAugmentedTrilateralRoot(candidate);
		
		assertNotNull(sut);
		assertEquals(candidate.charAt(0), sut.getC1());
		assertEquals(candidate.charAt(1), sut.getC2());
		assertEquals(candidate.charAt(2), sut.getC3());
		assertNotNull(sut.getAugmentationList());
		assertTrue(sut.getAugmentationList().size()>0);
	}
	
	@Test
	void noRoot_getAugmentedTrilateralRoot_returnsNull() throws Exception {
		assertNull(SarfDictionary.getInstance().getAugmentedTrilateralRoot("ككك"));
	}
	
	@Test
	void getUnaugmentedTrilateralRoots_returnsAllMatchingRoots() throws Exception {
		List<UnaugmentedTrilateralRoot> sut = SarfDictionary.getInstance().getUnaugmentedTrilateralRoots("فطم");
		assertEquals(1, sut.size());
		
		sut = SarfDictionary.getInstance().getUnaugmentedTrilateralRoots("فكر");
		assertEquals(2, sut.size());
	}
	
	@Test
	void noRoot_getAugmentedTrilateralRoot_returnsEmptyList() throws Exception {
		List<UnaugmentedTrilateralRoot> sut = SarfDictionary.getInstance().getUnaugmentedTrilateralRoots("ببب");
		assertEquals(0, sut.size());
	}
}
