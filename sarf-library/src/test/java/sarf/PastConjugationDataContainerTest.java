package sarf;

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
