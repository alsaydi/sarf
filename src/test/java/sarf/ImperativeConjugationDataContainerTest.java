package sarf;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ImperativeConjugationDataContainerTest {

	@Test
	void getInstanceReturnsInstance() throws Exception {
		assertNotNull(ImperativeConjugationDataContainer.getInstance());
	}
	
	@Test
	void getEmphasizedConnectedPronounList_returnsList() throws Exception {
		assertNotNull(ImperativeConjugationDataContainer.getInstance().getEmphasizedConnectedPronounList());
		assertEquals(13, ImperativeConjugationDataContainer.getInstance().getEmphasizedConnectedPronounList().size());
		assertTrue(ImperativeConjugationDataContainer.getInstance().getEmphasizedConnectedPronounList().contains("نَّ"));
		assertTrue(ImperativeConjugationDataContainer.getInstance().getEmphasizedConnectedPronounList().contains("انِّ"));
		assertTrue(ImperativeConjugationDataContainer.getInstance().getEmphasizedConnectedPronounList().contains("نَانِّ"));
		assertTrue(ImperativeConjugationDataContainer.getInstance().getEmphasizedConnectedPronounList().contains(""));
	}
	
	@Test
	void getLastDimList_returnsCorrectList() throws Exception {
		assertNotNull(ImperativeConjugationDataContainer.getInstance().getLastDimList());
		assertEquals(13, ImperativeConjugationDataContainer.getInstance().getLastDimList().size());
	}
}
