package sarf.verb.trilateral.unaugmented.active;

import sarf.Word;
import sarf.util.ArabCharUtil;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;


/**
 * يمثل هذا الصف الفعل في صيغة المضارع متضمناً الأحرف الثلاثة
 * وحركاتها مع الأحرف الأخيرة المضافة للفعل حسب الضمير
 * <p>Title: Sarf</p>
 * <p>Description: برنامج التصريف</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ActivePresentVerb extends Word {
    private final UnaugmentedTrilateralRoot root;

    //حرف المضارع
    private final String cp;

    //حركة حرف المضارع وهي دائماًً  فتحة
    private static final String vcp = ArabCharUtil.FATHA;

    //حركة فاء الفعل وهي دائماً ثابتة سكون
    private static final String dpr1 = ArabCharUtil.SKOON;

    //حركة عين الفعل حسب باب التصريف
    private final String dpr2;

    //حركة لام الفعل حسب الضمير
    private final String lastDpr;

    //الأحرف المضافة لنهاية الفعل حسب الضمير
    private final String connectedPronoun;

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

    @Override
    public String toString() {
        return cp + vcp + root.getC1() + dpr1 + root.getC2() + dpr2 + root.getC3() + lastDpr + connectedPronoun;
    }
}
