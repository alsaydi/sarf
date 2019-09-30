package sarf.noun.trilateral.unaugmented.modifier.elative;

import java.util.List;

import com.google.inject.Inject;
import sarf.*;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import sarf.noun.trilateral.unaugmented.modifier.*;

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
public class ElativeModifier implements IUnaugmentedTrilateralNounModifier{
    private final Geminator geminator = new Geminator();
    private final Vocalizer vocalizer = new Vocalizer();
    private final Mahmouz mahmouz = new Mahmouz();

    private final AlkhairModifier alkhairModifier = new AlkhairModifier();
    private final AlSharModifier alSharModifier = new AlSharModifier();
    private final NounLamAlefModifier nounLamAlefModifier;
    private final NounSunLamModifier nounSunLamModifier;

    @Inject
    public ElativeModifier(NounLamAlefModifier nounLamAlefModifier, NounSunLamModifier nounSunLamModifier) {
        this.nounLamAlefModifier = nounLamAlefModifier;
        this.nounSunLamModifier = nounSunLamModifier;
    }

    public ConjugationResult build(UnaugmentedTrilateralRoot root, KindOfVerb kov, List<? extends Word> conjugations, String formula) {
        var conjResult = new ConjugationResult(kov, root, conjugations, formula);
        if (alkhairModifier.isApplied(conjResult)) {
            alkhairModifier.apply(conjResult);
        }
        else if (alSharModifier.isApplied(conjResult)) {
            alSharModifier.apply(conjResult);
        }
        else {
            if (geminator.isApplied(conjResult))
                geminator.apply(conjResult.getFinalResult(), root);
            vocalizer.apply(conjResult);
            mahmouz.apply(conjResult);
            nounLamAlefModifier.apply(conjResult);
            nounSunLamModifier.apply(conjResult);
        }
        return conjResult;
    }
}
