package sarf.verb.trilateral.unaugmented.passive;

import sarf.util.ArabCharUtil;
import sarf.verb.trilateral.unaugmented.*;

/**
 * íãËá åĞÇ ÇáÕİ ÇáİÚá İí ÕíÛÉ ÇáãÇÖí ÇáãÈäí ááãÌåæá ãÊÖãäÇğ ÇáÃÍÑİ ÇáËáÇËÉ
 * æÍÑßÇÊåÇ ãÚ ÇáÃÍÑİ ÇáÃÎíÑÉ ÇáãÖÇİÉ ááİÚá ÍÓÈ ÇáÖãíÑ
 * <p>Title: Sarf</p>
 * <p>Description: ÈÑäÇãÌ ÇáÊÕÑíİ</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class PassivePastVerb {
    private UnaugmentedTrilateralRoot root;

    //ÍÑßÉ İÇÁ ÇáİÚá æåí ÏÇÆãÇğ  ÖãÉ
    private static final String dpa1 = ArabCharUtil.DAMMA;

    //ÍÑßÉ Úíä ÇáİÚá æåí ÏÇÆãÇğ ßÓÑÉ
    private static final String dpa2 = ArabCharUtil.KASRA;

    //ÍÑßÉ áÇã ÇáİÚá ÍÓÈ ÇáÖãíÑ
    private String lastDpa;

    //ÇáÃÍÑİ ÇáãÖÇİÉ áäåÇíÉ ÇáİÚá ÍÓÈ ÇáÖãíÑ
    private String connectedPronoun;

    public PassivePastVerb(UnaugmentedTrilateralRoot root, String lastDpa, String connectedPronoun) {
        this.root = root;
        this.lastDpa = lastDpa;
        this.connectedPronoun = connectedPronoun;
    }

    public String getConnectedPronoun() {
        return connectedPronoun;
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
