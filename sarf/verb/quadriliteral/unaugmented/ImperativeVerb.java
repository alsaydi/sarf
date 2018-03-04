package sarf.verb.quadriliteral.unaugmented;

import sarf.util.*;


/**
 * ›⁄· «·√„— «·—»«⁄Ì «·„Ã—œ
 * <p>Title: Sarf</p>
 * <p>Description: »—‰«„Ã «· ’—Ì›</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ImperativeVerb {
    private UnaugmentedQuadriliteralRoot root;

    //Õ—ﬂ… ·«„ «·›⁄· Õ”» «·÷„Ì—
    private String lastDim;

    //÷„Ì— «·—›⁄ «·„ ’·
    private String connectedPronoun;

    public ImperativeVerb(UnaugmentedQuadriliteralRoot root, String lastDim, String connectedPronoun) {
        this.root = root;
        this.lastDim = lastDim;
        this.connectedPronoun = connectedPronoun;
    }

    public String getConnectedPronoun() {
        return connectedPronoun;
    }

    public UnaugmentedQuadriliteralRoot getRoot() {
        return root;
    }

    public String getlastDim() {
        return lastDim;
    }

    public String toString() {
        return root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.SKOON+root.getC3()+ArabCharUtil.KASRA+root.getC4()+lastDim+connectedPronoun;
    }

}
