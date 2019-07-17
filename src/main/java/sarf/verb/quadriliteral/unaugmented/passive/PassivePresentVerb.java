package sarf.verb.quadriliteral.unaugmented.passive;

import sarf.util.*;
import sarf.verb.quadriliteral.unaugmented.*;


/**
 * الفعل المضارع الرباعي المجرد المبني للمجهول
 * <p>Title: Sarf</p>
 * <p>Description: برنامج التصريف</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class PassivePresentVerb {
    private UnaugmentedQuadrilateralRoot root;

    //حرف المضارع
    private String cp;

    //حركة لام الفعل حسب الضمير
    private String lastDpr;

    //الأحرف المضافة لنهاية الفعل حسب الضمير
    private String connectedPronoun;

    public PassivePresentVerb(UnaugmentedQuadrilateralRoot root, String cp, String lastDpr, String connectedPronoun) {
        this.root = root;
        this.cp = cp;
        this.lastDpr = lastDpr;
        this.connectedPronoun = connectedPronoun;
    }

    public String getConnectedPronoun() {
        return connectedPronoun;
    }

    public UnaugmentedQuadrilateralRoot getRoot() {
        return root;
    }

    public String getlastDpr() {
        return lastDpr;
    }

    public String getCp() {
        return cp;
    }

    public String toString() {
        return cp+ArabCharUtil.DAMMA+root.getC1()+ArabCharUtil.FATHA+root.getC2()+ArabCharUtil.SKOON+root.getC3()+ArabCharUtil.FATHA+root.getC4()+lastDpr+connectedPronoun;
    }

}
