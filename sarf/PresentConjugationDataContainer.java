package sarf;

import java.util.*;

import sarf.util.*;
import sarf.verb.trilateral.*;
import sarf.verb.trilateral.unaugmented.*;

/**
 * ÌÕ ÊÌ ⁄·Ï  «·„⁄·Ê„«   «·’—›Ì… «·„ÿ·Ê»… · ’—Ì› «·√›⁄«·  ›Ì «·„÷«—⁄
 * <p>Title: Sarf</p>
 * <p>Description: »—‰«„Ã «· ’—Ì›</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class PresentConjugationDataContainer {
    //√Õ—› «·„÷«—⁄… Õ”» «·÷„Ì—
    private List cpList = new ArrayList(13);
    //ﬁ«∆„… Õ—ﬂ«  ⁄Ì‰ «·›⁄· Õ”» »«» «· ’—Ì›
    private List dpr2List = new ArrayList(6);

    //ﬁ«∆„…  Õ—ﬂ«  ·«„ «·›⁄· Õ”» ÷„Ì— «·—›⁄
    //„—›Ê⁄
    private List nominativeLastDprList = new ArrayList(13);
    //„‰’Ê»
    private List accusativeLastDprList = new ArrayList(13);
    //„Ã“Ê„
    private List jussiveLastDprList = new ArrayList(13);
    //„ƒﬂœ
    private List emphasizedLastDprList = new ArrayList(13);

    //ﬁ«∆„… ÷„«∆— «·—›⁄ «·„ ’·…
    //„—›Ê⁄
    private List nominativeConnectedPronounList = new ArrayList(13);
    //„‰’Ê»
    private List accusativeConnectedPronounList = new ArrayList(13);
    //„Ã“Ê„
    private List jussiveConnectedPronounList = new ArrayList(13);
    //„ƒﬂœ
    private List emphasizedConnectedPronounList = new ArrayList(13);

    private static PresentConjugationDataContainer instance = new PresentConjugationDataContainer();

    public static PresentConjugationDataContainer getInstance() {
        return instance;
    }

    public List getNominativeLastDprList() {
        return nominativeLastDprList;
    }

    public List getNominativeConnectedPronounList() {
        return nominativeConnectedPronounList;
    }

    public List getEmphasizedLastDprList() {
        return emphasizedLastDprList;
    }

    public List getEmphasizedConnectedPronounList() {
        return emphasizedConnectedPronounList;
    }

    public List getJussiveLastDprList() {
        return jussiveLastDprList;
    }

    public List getJussiveConnectedPronounList() {
        return jussiveConnectedPronounList;
    }

    public List getAccusativeLastDprList() {
        return accusativeLastDprList;
    }

    public List getAccusativeConnectedPronounList() {
        return accusativeConnectedPronounList;
    }

    private PresentConjugationDataContainer() {
        // ÂÌ∆… «·ﬁÌ„
        dpr2List.add(ArabCharUtil.DAMMA);
        dpr2List.add(ArabCharUtil.KASRA);
        dpr2List.add(ArabCharUtil.FATHA);
        dpr2List.add(ArabCharUtil.FATHA);
        dpr2List.add(ArabCharUtil.DAMMA);
        dpr2List.add(ArabCharUtil.KASRA);

        cpList.add("√");
        cpList.add("‰");
        cpList.add(" ");
        cpList.add(" ");
        cpList.add(" ");
        cpList.add(" ");
        cpList.add(" ");
        cpList.add("Ì");
        cpList.add(" ");
        cpList.add("Ì");
        cpList.add(" ");
        cpList.add("Ì");
        cpList.add("Ì");

        nominativeLastDprList.add(ArabCharUtil.DAMMA);
        nominativeLastDprList.add(ArabCharUtil.DAMMA);
        nominativeLastDprList.add(ArabCharUtil.DAMMA);
        nominativeLastDprList.add(ArabCharUtil.KASRA);
        nominativeLastDprList.add(ArabCharUtil.FATHA);
        nominativeLastDprList.add(ArabCharUtil.DAMMA);
        nominativeLastDprList.add(ArabCharUtil.SKOON);
        nominativeLastDprList.add(ArabCharUtil.DAMMA);
        nominativeLastDprList.add(ArabCharUtil.DAMMA);
        nominativeLastDprList.add(ArabCharUtil.FATHA);
        nominativeLastDprList.add(ArabCharUtil.FATHA);
        nominativeLastDprList.add(ArabCharUtil.DAMMA);
        nominativeLastDprList.add(ArabCharUtil.SKOON);

        nominativeConnectedPronounList.add("");
        nominativeConnectedPronounList.add("");
        nominativeConnectedPronounList.add("");
        nominativeConnectedPronounList.add("Ì‰Û");
        nominativeConnectedPronounList.add("«‰ˆ");
        nominativeConnectedPronounList.add("Ê‰Û");
        nominativeConnectedPronounList.add("‰Û");
        nominativeConnectedPronounList.add("");
        nominativeConnectedPronounList.add("");
        nominativeConnectedPronounList.add("«‰ˆ");
        nominativeConnectedPronounList.add("«‰ˆ");
        nominativeConnectedPronounList.add("Ê‰Û");
        nominativeConnectedPronounList.add("‰Û");

        accusativeLastDprList.add(ArabCharUtil.FATHA);
        accusativeLastDprList.add(ArabCharUtil.FATHA);
        accusativeLastDprList.add(ArabCharUtil.FATHA);
        accusativeLastDprList.add(ArabCharUtil.KASRA);
        accusativeLastDprList.add(ArabCharUtil.FATHA);
        accusativeLastDprList.add(ArabCharUtil.DAMMA);
        accusativeLastDprList.add(ArabCharUtil.SKOON);
        accusativeLastDprList.add(ArabCharUtil.FATHA);
        accusativeLastDprList.add(ArabCharUtil.FATHA);
        accusativeLastDprList.add(ArabCharUtil.FATHA);
        accusativeLastDprList.add(ArabCharUtil.FATHA);
        accusativeLastDprList.add(ArabCharUtil.DAMMA);
        accusativeLastDprList.add(ArabCharUtil.SKOON);

        accusativeConnectedPronounList.add("");
        accusativeConnectedPronounList.add("");
        accusativeConnectedPronounList.add("");
        accusativeConnectedPronounList.add("Ì");
        accusativeConnectedPronounList.add("«");
        accusativeConnectedPronounList.add("Ê«");
        accusativeConnectedPronounList.add("‰Û");
        accusativeConnectedPronounList.add("");
        accusativeConnectedPronounList.add("");
        accusativeConnectedPronounList.add("«");
        accusativeConnectedPronounList.add("«");
        accusativeConnectedPronounList.add("Ê«");
        accusativeConnectedPronounList.add("‰Û");

        jussiveLastDprList.add(ArabCharUtil.SKOON);
        jussiveLastDprList.add(ArabCharUtil.SKOON);
        jussiveLastDprList.add(ArabCharUtil.SKOON);
        jussiveLastDprList.add(ArabCharUtil.KASRA);
        jussiveLastDprList.add(ArabCharUtil.FATHA);
        jussiveLastDprList.add(ArabCharUtil.DAMMA);
        jussiveLastDprList.add(ArabCharUtil.SKOON);
        jussiveLastDprList.add(ArabCharUtil.SKOON);
        jussiveLastDprList.add(ArabCharUtil.SKOON);
        jussiveLastDprList.add(ArabCharUtil.FATHA);
        jussiveLastDprList.add(ArabCharUtil.FATHA);
        jussiveLastDprList.add(ArabCharUtil.DAMMA);
        jussiveLastDprList.add(ArabCharUtil.SKOON);

        jussiveConnectedPronounList.add("");
        jussiveConnectedPronounList.add("");
        jussiveConnectedPronounList.add("");
        jussiveConnectedPronounList.add("Ì");
        jussiveConnectedPronounList.add("«");
        jussiveConnectedPronounList.add("Ê«");
        jussiveConnectedPronounList.add("‰Û");
        jussiveConnectedPronounList.add("");
        jussiveConnectedPronounList.add("");
        jussiveConnectedPronounList.add("«");
        jussiveConnectedPronounList.add("«");
        jussiveConnectedPronounList.add("Ê«");
        jussiveConnectedPronounList.add("‰Û");

        emphasizedLastDprList.add(ArabCharUtil.FATHA);
        emphasizedLastDprList.add(ArabCharUtil.FATHA);
        emphasizedLastDprList.add(ArabCharUtil.FATHA);
        emphasizedLastDprList.add(ArabCharUtil.KASRA);
        emphasizedLastDprList.add(ArabCharUtil.FATHA);
        emphasizedLastDprList.add(ArabCharUtil.DAMMA);
        emphasizedLastDprList.add(ArabCharUtil.SKOON);
        emphasizedLastDprList.add(ArabCharUtil.FATHA);
        emphasizedLastDprList.add(ArabCharUtil.FATHA);
        emphasizedLastDprList.add(ArabCharUtil.FATHA);
        emphasizedLastDprList.add(ArabCharUtil.FATHA);
        emphasizedLastDprList.add(ArabCharUtil.DAMMA);
        emphasizedLastDprList.add(ArabCharUtil.SKOON);

        emphasizedConnectedPronounList.add("‰¯Û");
        emphasizedConnectedPronounList.add("‰¯Û");
        emphasizedConnectedPronounList.add("‰¯Û");
        emphasizedConnectedPronounList.add("‰¯Û");
        emphasizedConnectedPronounList.add("«‰¯ˆ");
        emphasizedConnectedPronounList.add("‰¯Û");
        emphasizedConnectedPronounList.add("‰Û«‰¯ˆ");
        emphasizedConnectedPronounList.add("‰¯Û");
        emphasizedConnectedPronounList.add("‰¯Û");
        emphasizedConnectedPronounList.add("«‰¯ˆ");
        emphasizedConnectedPronounList.add("«‰¯ˆ");
        emphasizedConnectedPronounList.add("‰¯Û");
        emphasizedConnectedPronounList.add("‰Û«‰¯ˆ");
    }

    /**
     * «·Õ’Ê·  ⁄·Ï Õ—ﬂ… ⁄Ì‰ «·›⁄· Õ”» »«»  ’—Ì› «·›⁄·
     * @param root TripleVerb
     * @return String
     */
    public String getDpr2(UnaugmentedTrilateralRoot root) {
        //»”»» √‰  —ﬁÌ„ «·»«» «· ’—Ì›Ì Ì»œ√ „‰ «·Ê«Õœ ⁄·Ï ÕÌ‰ √‰ «·ﬁ«∆„…  »œ√ „‰ «·’›— Ã—Ï ÿ—Õ «·⁄œœ Ê«Õœ
        return (String) dpr2List.get((Integer.parseInt(root.getConjugation()) - 1));
    }


    /**
     * «·Õ’Ê·  ⁄·Ï Õ—› «·„÷«—⁄ Õ”» «·÷„Ì—
     * @param pronounIndex int
     * @return String
     */
    public String getCp(int pronounIndex) {
        return (String) cpList.get(pronounIndex);
    }
}
