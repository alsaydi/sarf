package sarf.verb.trilateral.unaugmented;

import sarf.util.*;


/**
 * فعل الأمر الثلاثي المجرد
 * <p>Title: Sarf</p>
 * <p>Description: برنامج التصريف</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ImperativeVerb {
    private final UnaugmentedTrilateralRoot root;

    //حرف الأمر
    private final static String ci = "ا";

    //حركة فاء الفعل وهي السكون دائماً
    private static final String dim1 = ArabCharUtil.SKOON;

    //حركة عين الفعل حسب باب التصريف
    //وهي نفسها في المضارع
    private final String dpr2;

    //حركة لام الفعل حسب الضمير
    private final String lastDim;

    //ضمير الرفع المتصل
    private final String connectedPronoun;

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
