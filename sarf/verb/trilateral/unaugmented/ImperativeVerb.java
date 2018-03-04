package sarf.verb.trilateral.unaugmented;

import sarf.util.*;


/**
 * İÚá ÇáÃãÑ ÇáËáÇËí ÇáãÌÑÏ
 * <p>Title: Sarf</p>
 * <p>Description: ÈÑäÇãÌ ÇáÊÕÑíİ</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ImperativeVerb {
    private UnaugmentedTrilateralRoot root;

    //ÍÑİ ÇáÃãÑ
    private final static String ci = "Ç";

    //ÍÑßÉ İÇÁ ÇáİÚá æåí ÇáÓßæä ÏÇÆãÇğ
    private static final String dim1 = ArabCharUtil.SKOON;

    //ÍÑßÉ Úíä ÇáİÚá ÍÓÈ ÈÇÈ ÇáÊÕÑíİ
    //æåí äİÓåÇ İí ÇáãÖÇÑÚ
    private String dpr2;

    //ÍÑßÉ áÇã ÇáİÚá ÍÓÈ ÇáÖãíÑ
    private String lastDim;

    //ÖãíÑ ÇáÑİÚ ÇáãÊÕá
    private String connectedPronoun;

    public ImperativeVerb(UnaugmentedTrilateralRoot root, String dpr2, String lastDim, String connectedPronoun) {
        this.root = root;
        this.dpr2 = dpr2;
        this.lastDim = lastDim;
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

    public String getlastDim() {
        return lastDim;
    }

    public String getCi() {
        return ci;
    }

    public String toString() {
        return ci+root.getC1()+dim1+root.getC2()+dpr2+root.getC3()+lastDim+connectedPronoun;
    }

}
