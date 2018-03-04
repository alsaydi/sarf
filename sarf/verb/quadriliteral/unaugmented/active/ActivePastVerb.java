package sarf.verb.quadriliteral.unaugmented.active;

import sarf.*;
import sarf.util.ArabCharUtil;
import sarf.verb.quadriliteral.*;
import sarf.verb.quadriliteral.unaugmented.*;


/**
 *  «·›⁄· «·„«÷Ì  «·—»«⁄Ì «·„Ã—œ
 * <p>Title: Sarf</p>
 * <p>Description: »—‰«„Ã «· ’—Ì›</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ActivePastVerb {
    private UnaugmentedQuadriliteralRoot root;

    //Õ—ﬂ… ·«„ «·›⁄· Õ”» «·÷„Ì—
    private String lastDpa;

    //÷„Ì— «·—›⁄ «·„ ’·
    private String connectedPronoun;

    public ActivePastVerb(UnaugmentedQuadriliteralRoot root, String lastDpa, String connectedPronoun) {
        this.root = root;
        this.lastDpa = lastDpa;
        this.connectedPronoun = connectedPronoun;
    }

    public String getConnectedPronoun() {
        return connectedPronoun;
    }

    public UnaugmentedQuadriliteralRoot getRoot() {
        return root;
    }

    public String getLastDpa() {
        return lastDpa;
    }

    public String toString() {
        return root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.SKOON+root.getC3()+ArabCharUtil.FATHA+root.getC4()+lastDpa+connectedPronoun;
    }

}
