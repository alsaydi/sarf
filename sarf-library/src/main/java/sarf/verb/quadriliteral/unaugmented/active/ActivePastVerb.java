package sarf.verb.quadriliteral.unaugmented.active;

import sarf.Word;
import sarf.util.ArabCharUtil;
import sarf.verb.quadriliteral.unaugmented.*;


/**
 *  الفعل الماضي  الرباعي المجرد
 * <p>Title: Sarf</p>
 * <p>Description: برنامج التصريف</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ActivePastVerb extends Word {
    private final UnaugmentedQuadrilateralRoot root;

    //حركة لام الفعل حسب الضمير
    private final String lastDpa;

    //ضمير الرفع المتصل
    private final String connectedPronoun;

    ActivePastVerb(UnaugmentedQuadrilateralRoot root, String lastDpa, String connectedPronoun) {
        this.root = root;
        this.lastDpa = lastDpa;
        this.connectedPronoun = connectedPronoun;
    }

    public String getConnectedPronoun() {
        return connectedPronoun;
    }

    public UnaugmentedQuadrilateralRoot getRoot() {
        return root;
    }

    public String getLastDpa() {
        return lastDpa;
    }

    @Override
    public String toString() {
        return root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.SKOON+root.getC3()+ArabCharUtil.FATHA+root.getC4()+lastDpa+connectedPronoun;
    }
}
