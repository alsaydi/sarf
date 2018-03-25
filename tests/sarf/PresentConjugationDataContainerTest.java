package sarf;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import sarf.util.ArabCharUtil;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

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

    @Test
    void UnaugmentedTrilateralRoot_getDpr2_returnsحركة_عين_الفعل() throws Exception{
        تأكد_من_حركة_عين_الفعل("1", ArabCharUtil.DAMMA);
        تأكد_من_حركة_عين_الفعل("2", ArabCharUtil.KASRA);
        تأكد_من_حركة_عين_الفعل("3", ArabCharUtil.FATHA);
        تأكد_من_حركة_عين_الفعل("4", ArabCharUtil.FATHA);
        تأكد_من_حركة_عين_الفعل("5", ArabCharUtil.DAMMA);
        تأكد_من_حركة_عين_الفعل("6", ArabCharUtil.KASRA);
    }

    @Test
    void pronounIndex_getCp_returnsPresentLetter() throws Exception{
        assertEquals("أ", sut.getCp(0));
        assertEquals("ن", sut.getCp(1));
        assertEquals("ت", sut.getCp(2));
        assertEquals("ت", sut.getCp(3));
        assertEquals("ت", sut.getCp(4));
        assertEquals("ت", sut.getCp(5));
        assertEquals("ت", sut.getCp(6));
        assertEquals("ي", sut.getCp(7));
        assertEquals("ت", sut.getCp(8));
        assertEquals("ي", sut.getCp(9));
        assertEquals("ت", sut.getCp(10));
        assertEquals("ي", sut.getCp(11));
        assertEquals("ي", sut.getCp(12));
    }

    void تأكد_من_حركة_عين_الفعل(String باب_الصرف, String المتوقع){
        UnaugmentedTrilateralRoot root = new UnaugmentedTrilateralRoot();
        root.setConjugation(باب_الصرف);

        String actual = sut.getDpr2(root);

        assertEquals(المتوقع, actual);
    }
}
