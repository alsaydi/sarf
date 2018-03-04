package sarf;

import java.util.*;

import sarf.util.*;
import sarf.*;

/**
 *  ÌÕ ÊÌ ⁄·Ï  «·„⁄·Ê„«   «·’—›Ì… «·„ÿ·Ê»… · ’—Ì› «·√›⁄«·  ›Ì «·√„—
 * <p>Title: Sarf</p>
 * <p>Description: »—‰«„Ã «· ’—Ì›</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ImperativeConjugationDataContainer {

    //ﬁ«∆„… Õ—ﬂ«  ⁄Ì‰ «·›⁄· Õ”» »«» «· ’—Ì›
    //«·√„— €Ì— «·„ƒﬂœ
    private List lastDimList = new ArrayList(13);
    //«·√„— «·„ƒﬂœ
    private List emphasizedLastDimList = new ArrayList(13);

    //ﬁ«∆„… ÷„«∆— «·—›⁄ «·„ ’·…
    //«·√„— €Ì— «·„ƒﬂœ
    private List connectedPronounList = new ArrayList(13);
    //«·√„— «·„ƒﬂœ
    private List emphasizedConnectedPronounList = new ArrayList(13);

    private static ImperativeConjugationDataContainer instance = new ImperativeConjugationDataContainer();

    public static ImperativeConjugationDataContainer getInstance() {
        return instance;
    }

    public List getEmphasizedConnectedPronounList() {
        return emphasizedConnectedPronounList;
    }

    public List getEmphasizedLastDimList() {
        return emphasizedLastDimList;
    }

    public List getConnectedPronounList() {
        return connectedPronounList;
    }

    public List getLastDimList() {
        return lastDimList;
    }

    private ImperativeConjugationDataContainer() {
        lastDimList.add("");
        lastDimList.add("");
        lastDimList.add(ArabCharUtil.SKOON);
        lastDimList.add(ArabCharUtil.KASRA);
        lastDimList.add(ArabCharUtil.FATHA);
        lastDimList.add(ArabCharUtil.DAMMA);
        lastDimList.add(ArabCharUtil.SKOON);
        lastDimList.add("");
        lastDimList.add("");
        lastDimList.add("");
        lastDimList.add("");
        lastDimList.add("");
        lastDimList.add("");

        connectedPronounList.add("");
        connectedPronounList.add("");
        connectedPronounList.add("");
        connectedPronounList.add("Ì");
        connectedPronounList.add("«");
        connectedPronounList.add("Ê«");
        connectedPronounList.add("‰Û");
        connectedPronounList.add("");
        connectedPronounList.add("");
        connectedPronounList.add("");
        connectedPronounList.add("");
        connectedPronounList.add("");
        connectedPronounList.add("");

        emphasizedLastDimList.add("");
        emphasizedLastDimList.add("");
        emphasizedLastDimList.add(ArabCharUtil.FATHA);
        emphasizedLastDimList.add(ArabCharUtil.KASRA);
        emphasizedLastDimList.add(ArabCharUtil.FATHA);
        emphasizedLastDimList.add(ArabCharUtil.DAMMA);
        emphasizedLastDimList.add(ArabCharUtil.SKOON);
        emphasizedLastDimList.add("");
        emphasizedLastDimList.add("");
        emphasizedLastDimList.add("");
        emphasizedLastDimList.add("");
        emphasizedLastDimList.add("");
        emphasizedLastDimList.add("");

        emphasizedConnectedPronounList.add("");
        emphasizedConnectedPronounList.add("");
        emphasizedConnectedPronounList.add("‰¯Û");
        emphasizedConnectedPronounList.add("‰¯Û");
        emphasizedConnectedPronounList.add("«‰¯ˆ");
        emphasizedConnectedPronounList.add("‰¯Û");
        emphasizedConnectedPronounList.add("‰Û«‰¯ˆ");
        emphasizedConnectedPronounList.add("");
        emphasizedConnectedPronounList.add("");
        emphasizedConnectedPronounList.add("");
        emphasizedConnectedPronounList.add("");
        emphasizedConnectedPronounList.add("");
        emphasizedConnectedPronounList.add("");
    }

    /**
     *  «·Õ’Ê·  ⁄·Ï  Õ—ﬂ… ·«„ «·›⁄· Õ”» «·÷„Ì—
     * «·√„— €Ì— «·„ƒﬂœ
     * @param pronounIndex int
     * @return String
     */
    public String getLastDim(int pronounIndex) {
        return (String) lastDimList.get(pronounIndex);
    }

    /**
     *  «·Õ’Ê·  ⁄·Ï  Õ—ﬂ… ·«„ «·›⁄· Õ”» «·÷„Ì—
     * «·√„—  «·„ƒﬂœ
     * @param pronounIndex int
     * @return String
     */
    public String getEmphasizedLastDim(int pronounIndex) {
        return (String) emphasizedLastDimList.get(pronounIndex);
    }

    /**
     *«·Õ’Ê· ⁄·Ï ÷„«∆— «·—›⁄ «·„ ’·…
     * «·√„— €Ì— «·„ƒﬂœ
     * @param pronounIndex int
     * @return String
     */
    public String getConnectedPronoun(int pronounIndex) {
        return (String) connectedPronounList.get(pronounIndex);
    }

    /**
     *«·Õ’Ê· ⁄·Ï ÷„«∆— «·—›⁄ «·„ ’·…
     * «·√„—  «·„ƒﬂœ
     * @param pronounIndex int
     * @return String
     */
    public String getEmphasizedConnectedPronoun(int pronounIndex) {
        return (String) emphasizedConnectedPronounList.get(pronounIndex);
    }
}
