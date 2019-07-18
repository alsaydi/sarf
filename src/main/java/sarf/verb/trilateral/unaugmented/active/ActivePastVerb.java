package sarf.verb.trilateral.unaugmented.active;

import sarf.*;
import sarf.util.ArabCharUtil;
import sarf.verb.trilateral.unaugmented.*;


/**
 * الفعل الماضي
 * <p>Title: Sarf</p>
 * <p>Description: برنامج التصريف</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ActivePastVerb {
    private UnaugmentedTrilateralRoot root;

    //حركة فاء الفعل وهي الفتحة دائماً
    private static final String dpa1 = ArabCharUtil.FATHA;

    //حركة عين الفعل حسب باب التصريف
    private String dpa2;

    //حركة لام الفعل حسب الضمير
    private String lastDpa;

    //ضمير الرفع المتصل
    private String connectedPronoun;

    ActivePastVerb(UnaugmentedTrilateralRoot root, String dpa2, String lastDpa, String connectedPronoun) {
        this.root = root;
        this.dpa2 = dpa2;
        this.lastDpa = lastDpa;
        this.connectedPronoun = connectedPronoun;
    }

    public String getConnectedPronoun() {
        return connectedPronoun;
    }

    public String getDpa2() {
        return dpa2;
    }

    public UnaugmentedTrilateralRoot getRoot() {
        return root;
    }

    public String getLastDpa() {
        return lastDpa;
    }

    public String toString() {
        return root.getC1()+dpa1+root.getC2()+dpa2+root.getC3()+lastDpa+connectedPronoun;
    }
}
