package sarf;

import sarf.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

class PastConjugationDataContainerTest {

	PastConjugationDataContainer sut = PastConjugationDataContainer.getInstance();
	
	@Test
	void getDpa2_dependsOnConjugationOfRoot() throws Exception {
		assertEquals(ArabCharUtil.FATHA, sut.getDpa2(getRootWithConjugation(1)));
		assertEquals(ArabCharUtil.FATHA, sut.getDpa2(getRootWithConjugation(2)));
		assertEquals(ArabCharUtil.FATHA, sut.getDpa2(getRootWithConjugation(3)));
		assertEquals(ArabCharUtil.KASRA, sut.getDpa2(getRootWithConjugation(4)));
		assertEquals(ArabCharUtil.DAMMA, sut.getDpa2(getRootWithConjugation(5)));
		assertEquals(ArabCharUtil.KASRA, sut.getDpa2(getRootWithConjugation(6)));
	}

	private UnaugmentedTrilateralRoot getRootWithConjugation(int باب_التصريف) throws IllegalArgumentException {
		UnaugmentedTrilateralRoot root = new UnaugmentedTrilateralRoot();
		root.setConjugation(String.valueOf(باب_التصريف));
		return root;
	}
}
