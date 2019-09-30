package sarf.verb.quadriliteral.unaugmented.passive;

import sarf.Word;
import sarf.util.*;
import sarf.verb.quadriliteral.unaugmented.*;

/**
 * الفعل الماضي الرباعي المجرد المبني للمجهول
 * <p>Title: Sarf</p>
 * <p>Description: برنامج التصريف</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class PassivePastVerb extends Word {
    private final UnaugmentedQuadrilateralRoot root;


    //حركة لام الفعل حسب الضمير
    private final String lastDpa;

    //الأحرف المضافة لنهاية الفعل حسب الضمير
    private final String connectedPronoun;

    PassivePastVerb(UnaugmentedQuadrilateralRoot root, String lastDpa, String connectedPronoun) {
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

    public String toString() {
        return root.getC1()+ArabCharUtil.DAMMA+root.getC2()+ArabCharUtil.SKOON+root.getC3()+ArabCharUtil.KASRA+root.getC4()+lastDpa+connectedPronoun;
    }

}
