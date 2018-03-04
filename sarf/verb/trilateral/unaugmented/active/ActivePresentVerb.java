package sarf.verb.trilateral.unaugmented.active;

import sarf.util.*;
import sarf.verb.trilateral.unaugmented.*;


/**
 * íãËá åĞÇ ÇáÕİ ÇáİÚá İí ÕíÛÉ ÇáãÖÇÑÚ ãÊÖãäÇğ ÇáÃÍÑİ ÇáËáÇËÉ
 * æÍÑßÇÊåÇ ãÚ ÇáÃÍÑİ ÇáÃÎíÑÉ ÇáãÖÇİÉ ááİÚá ÍÓÈ ÇáÖãíÑ
 * <p>Title: Sarf</p>
 * <p>Description: ÈÑäÇãÌ ÇáÊÕÑíİ</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ActivePresentVerb {
    private UnaugmentedTrilateralRoot root;

    //ÍÑİ ÇáãÖÇÑÚ
    private String cp;

    //ÍÑßÉ ÍÑİ ÇáãÖÇÑÚ æåí ÏÇÆãÇğğ  İÊÍÉ
    private static final String vcp = ArabCharUtil.FATHA;

    //ÍÑßÉ İÇÁ ÇáİÚá æåí ÏÇÆãÇğ ËÇÈÊÉ Óßæä
    private static final String dpr1 = ArabCharUtil.SKOON;

    //ÍÑßÉ Úíä ÇáİÚá ÍÓÈ ÈÇÈ ÇáÊÕÑíİ
    private String dpr2;

    //ÍÑßÉ áÇã ÇáİÚá ÍÓÈ ÇáÖãíÑ
    private String lastDpr;

    //ÇáÃÍÑİ ÇáãÖÇİÉ áäåÇíÉ ÇáİÚá ÍÓÈ ÇáÖãíÑ
    private String connectedPronoun;

    public ActivePresentVerb(UnaugmentedTrilateralRoot root, String cp, String dpr2, String lastDpr, String connectedPronoun) {
        this.root = root;
        this.cp = cp;
        this.dpr2 = dpr2;
        this.lastDpr = lastDpr;
        this.connectedPronoun = connectedPronoun;
    }

    public String getConnectedPronoun() {
        return connectedPronoun;
    }

    public String getdpr2() {
        return dpr2;
    }

    public UnaugmentedTrilateralRoot getRoot() {
        return root;
    }

    public String getlastDpr() {
        return lastDpr;
    }

    public String getCp() {
        return cp;
    }

    public String toString() {
        return cp+vcp+root.getC1()+dpr1+root.getC2()+dpr2+root.getC3()+lastDpr+connectedPronoun;
    }

}
