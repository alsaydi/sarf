package sarf.noun.trilateral.unaugmented.modifier.instrumental;

import java.util.List;

import sarf.KindOfVerb;
import sarf.NounLamAlefModifier;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.NounSunLamModifier;

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
public class InstrumentalModifier implements IUnaugmentedTrilateralNounModifier{
    private final Geminator geminator = new Geminator();
    private final Vocalizer vocalizer = new Vocalizer();
    private final Mahmouz mahmouz = new Mahmouz();

    private InstrumentalModifier() {
    }

    private static final InstrumentalModifier instance = new InstrumentalModifier();

    public static InstrumentalModifier getInstance() {
        return instance;
    }

    public ConjugationResult build(UnaugmentedTrilateralRoot root, KindOfVerb kov, List conjugations, String formula) {
        ConjugationResult conjResult = new ConjugationResult(kov, root, conjugations, formula);
        geminator.apply(conjResult.getFinalResult(), root);
        vocalizer.apply(conjResult);
        mahmouz.apply(conjResult);
        NounLamAlefModifier.getInstance().apply(conjResult);
        NounSunLamModifier.getInstance().apply(conjResult);
        return conjResult;
    }

}
