package sarf.verb.quadriliteral.unaugmented;

import sarf.Word;
import sarf.util.*;


/**
 * فعل الأمر الرباعي المجرد
 * <p>Title: Sarf</p>
 * <p>Description: برنامج التصريف</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ImperativeVerb extends Word {
    private final UnaugmentedQuadrilateralRoot root;

    //حركة لام الفعل حسب الضمير
    private final String lastDim;

    //ضمير الرفع المتصل
    private final String connectedPronoun;

    ImperativeVerb(UnaugmentedQuadrilateralRoot root, String lastDim, String connectedPronoun) {
        this.root = root;
        this.lastDim = lastDim;
        this.connectedPronoun = connectedPronoun;
    }

    public String getConnectedPronoun() {
        return connectedPronoun;
    }

    public UnaugmentedQuadrilateralRoot getRoot() {
        return root;
    }

    public String getlastDim() {
        return lastDim;
    }

    public String toString() {
        return root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.SKOON+root.getC3()+ArabCharUtil.KASRA+root.getC4()+lastDim+connectedPronoun;
    }

}
