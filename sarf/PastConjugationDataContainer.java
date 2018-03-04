package sarf;

import java.util.*;
import sarf.*;
import sarf.util.ArabCharUtil;
import sarf.verb.trilateral.*;
import sarf.verb.trilateral.unaugmented.*;

/**
 * íÍÊæí Úáì  ÇáãÚáæãÇÊ  ÇáÕÑİíÉ ÇáãØáæÈÉ áÊÕÑíİ ÇáÃİÚÇá  İí ÇáãÇÖí
 * <p>Title: Sarf</p>
 * <p>Description: ÈÑäÇãÌ ÇáÊÕÑíİ</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class PastConjugationDataContainer {
    //ŞÇÆãÉ ÍÑßÇÊ Úíä ÇáİÚá ÍÓÈ ÈÇÈ ÇáÊÕÑíİ
    private List dpa2List = new ArrayList(6);
    //ŞÇÆãÉ  ÍÑßÇÊ áÇã ÇáİÚá ÍÓÈ ÖãíÑ ÇáÑİÚ
    private List lastDpaList = new ArrayList(13);
    //ŞÇÆãÉ ÖãÇÆÑ ÇáÑİÚ ÇáãÊÕáÉ
    private List connectedPronounsList = new ArrayList(13);

    private static PastConjugationDataContainer instance = new PastConjugationDataContainer();

    public static PastConjugationDataContainer getInstance() {
        return instance;
    }

    private PastConjugationDataContainer() {
        //ÊåíÆÉ ÇáŞíã
        dpa2List.add(ArabCharUtil.FATHA);
        dpa2List.add(ArabCharUtil.FATHA);
        dpa2List.add(ArabCharUtil.FATHA);
        dpa2List.add(ArabCharUtil.KASRA);
        dpa2List.add(ArabCharUtil.DAMMA);
        dpa2List.add(ArabCharUtil.KASRA);

        lastDpaList.add(ArabCharUtil.SKOON);
        lastDpaList.add(ArabCharUtil.SKOON);
        lastDpaList.add(ArabCharUtil.SKOON);
        lastDpaList.add(ArabCharUtil.SKOON);
        lastDpaList.add(ArabCharUtil.SKOON);
        lastDpaList.add(ArabCharUtil.SKOON);
        lastDpaList.add(ArabCharUtil.SKOON);
        lastDpaList.add(ArabCharUtil.FATHA);
        lastDpaList.add(ArabCharUtil.FATHA);
        lastDpaList.add(ArabCharUtil.FATHA);
        lastDpaList.add(ArabCharUtil.FATHA);
        lastDpaList.add(ArabCharUtil.DAMMA);
        lastDpaList.add(ArabCharUtil.SKOON);

        connectedPronounsList.add("Êõ");
        connectedPronounsList.add("äóÇ");
        connectedPronounsList.add("Êó");
        connectedPronounsList.add("Êö");
        connectedPronounsList.add("ÊõãóÇ");
        connectedPronounsList.add("Êõãú");
        connectedPronounsList.add("Êõäøó");
        connectedPronounsList.add("");
        connectedPronounsList.add("Êú");
        connectedPronounsList.add("Ç");
        connectedPronounsList.add("ÊóÇ");
        connectedPronounsList.add("æÇ");
        connectedPronounsList.add("äó");
        connectedPronounsList.add("Êõ");
    }

    /**
     * ÇáÍÕæá  Úáì ÍÑßÉ Úíä ÇáİÚá ÍÓÈ ÈÇÈ ÊÕÑíİ ÇáİÚá
     * @param root TripleVerb
     * @return String
     */
    public String getDpa2(UnaugmentedTrilateralRoot root) {
        //ÈÓÈÈ Ãä ÊÑŞíã ÇáÈÇÈ ÇáÊÕÑíİí íÈÏÃ ãä ÇáæÇÍÏ Úáì Ííä Ãä ÇáŞÇÆãÉ ÊÈÏÃ ãä ÇáÕİÑ ÌÑì ØÑÍ ÇáÚÏÏ æÇÍÏ
        return (String) dpa2List.get((Integer.parseInt(root.getConjugation())-1));
    }

    /**
     *  ÇáÍÕæá  Úáì  ÍÑßÉ áÇã ÇáİÚá ÍÓÈ ÇáÖãíÑ
     * @param pronounIndex int
     * @return String
     */
    public String getLastDpa(int pronounIndex) {
        return (String) lastDpaList.get(pronounIndex);
    }

    /**
     *ÇáÍÕæá Úáì ÖãÇÆÑ ÇáÑİÚ ÇáãÊÕáÉ
     * @param pronounIndex int
     * @return String
     */
    public String getConnectedPronoun(int pronounIndex) {
        return (String) connectedPronounsList.get(pronounIndex);
    }

}
