package sarf;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ImperativeConjugationDataContainerTest {

	@Test
	void getEmphasizedConnectedPronounList_returnsList() throws Exception {
		assertNotNull(ImperativeConjugationDataContainer.getEmphasizedConnectedPronounList());
		assertEquals(13, ImperativeConjugationDataContainer.getEmphasizedConnectedPronounList().size());
		assertTrue(ImperativeConjugationDataContainer.getEmphasizedConnectedPronounList().contains("نَّ"));
		assertTrue(ImperativeConjugationDataContainer.getEmphasizedConnectedPronounList().contains("انِّ"));
		assertTrue(ImperativeConjugationDataContainer.getEmphasizedConnectedPronounList().contains("نَانِّ"));
		assertTrue(ImperativeConjugationDataContainer.getEmphasizedConnectedPronounList().contains(""));
	}
	
	@Test
	void getLastDimList_returnsCorrectList() throws Exception {
		assertNotNull(ImperativeConjugationDataContainer.getLastDimList());
		assertEquals(13, ImperativeConjugationDataContainer.getLastDimList().size());
	}
}
