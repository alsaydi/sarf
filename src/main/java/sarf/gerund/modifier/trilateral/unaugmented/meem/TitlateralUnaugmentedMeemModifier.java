package sarf.gerund.modifier.trilateral.unaugmented.meem;

import java.util.List;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: تطبيق المعالجة الخاصة على اسم الفاعل
 * ابتداء بالادغام ثم الاعلال واخيرا الهمزة
 * </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class TitlateralUnaugmentedMeemModifier implements IUnaugmentedTrilateralNounModifier{
    private final Geminator geminator = new Geminator();
    private final Vocalizer vocalizer = new Vocalizer();
    private final Mahmouz mahmouz = new Mahmouz();

    private TitlateralUnaugmentedMeemModifier() {
    }

    private static final TitlateralUnaugmentedMeemModifier instance = new TitlateralUnaugmentedMeemModifier();

    public static TitlateralUnaugmentedMeemModifier getInstance() {
        return instance;
    }

    public ConjugationResult build(UnaugmentedTrilateralRoot root, KindOfVerb kov, List conjugations, String formula) {
        ConjugationResult conjResult = new ConjugationResult(kov, root, conjugations, formula);
        if (geminator.isApplied(conjResult))
            geminator.apply(conjResult.getFinalResult(), root);
        vocalizer.apply(conjResult);
        mahmouz.apply(conjResult);
        NounLamAlefModifier.getInstance().apply(conjResult);
        NounSunLamModifier.getInstance().apply(conjResult);
        return conjResult;
    }

}
