package sarf;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class PresentConjugationDataContainerTest {

    PresentConjugationDataContainer sut = PresentConjugationDataContainer.getInstance();
    @Test
    void getInstance_returnsInstance() throws Exception{
         assertNotNull(PresentConjugationDataContainer.getInstance());
    }

    @Test
    void getNominativeLastDprList_returnsNominativeLastDrpList() throws Exception{
        List<String> actual = sut.getNominativeLastDprList();

        assertNotNull(actual);
        assertEquals(13, actual.size());
    }

    @Test
    void getNominativeConnectedPronounList_returnsList() throws Exception{
        List<String> actual = sut.getNominativeConnectedPronounList();

        assertNotNull(actual);
        assertEquals(13, actual.size());
    }
}
