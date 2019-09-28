package sarf.noun.trilateral.unaugmented.modifier.exaggeration;

import java.util.List;

import com.google.inject.Inject;
import sarf.KindOfVerb;
import sarf.NounLamAlefModifier;
import sarf.verb.trilateral.augmented.ConjugationResult;
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
public class ExaggerationModifier implements IUnaugmentedTrilateralNounModifier{
    private final Vocalizer vocalizer = new Vocalizer();
    private final Mahmouz mahmouz = new Mahmouz();
    private final NounLamAlefModifier nounLamAlefModifier;
    private final NounSunLamModifier nounSunLamModifier;

    @Inject
    public ExaggerationModifier(NounLamAlefModifier nounLamAlefModifier, NounSunLamModifier nounSunLamModifier) {
        this.nounLamAlefModifier = nounLamAlefModifier;
        this.nounSunLamModifier = nounSunLamModifier;
    }

    public ConjugationResult build(UnaugmentedTrilateralRoot root, KindOfVerb kov, List conjugations, String formula) {
        var conjResult = new ConjugationResult(kov, root, conjugations, formula);
        vocalizer.apply(conjResult);
        mahmouz.apply(conjResult);
        nounLamAlefModifier.apply(conjResult);
        nounSunLamModifier.apply(conjResult);
        return conjResult;
    }

}
