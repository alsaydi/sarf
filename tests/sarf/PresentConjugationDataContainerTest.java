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

    @Test
    void getEmphasizedLastDprList_returnsList() throws Exception{
        List<String> actual = sut.getEmphasizedLastDprList();

        assertNotNull(actual);
        assertEquals(13, actual.size());
    }

    @Test
    void getEmphasizedConnectedPronounList_returnsList() throws Exception{
        List<String> actual = sut.getEmphasizedConnectedPronounList();

        assertNotNull(actual);
        assertEquals(13, actual.size());
    }

    @Test
    void getJussiveLastDprList_returnsList() throws Exception{
        List<String> actual = sut.getJussiveLastDprList();

        assertNotNull(actual);
        assertEquals(13, actual.size());
    }

    @Test
    void getJussiveConnectedPronounList_returnsList() throws Exception{
        List<String> actual = sut.getJussiveConnectedPronounList();

        assertNotNull(actual);
        assertEquals(13, actual.size());
    }

    @Test
    void getAccusativeLastDprList_returnsList() throws Exception{
        List<String> actual = sut.getAccusativeLastDprList();

        assertNotNull(actual);
        assertEquals(13, actual.size());
    }

    @Test
    void getAccusativeConnectedPronounList_returnsList() throws Exception{
        List<String> actual = sut.getAccusativeConnectedPronounList();

        assertNotNull(actual);
        assertEquals(13, actual.size());
    }
}
