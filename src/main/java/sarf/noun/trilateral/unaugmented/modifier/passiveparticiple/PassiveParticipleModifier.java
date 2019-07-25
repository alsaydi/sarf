package sarf.noun.trilateral.unaugmented.modifier.passiveparticiple;

import java.util.List;

import sarf.KindOfVerb;
import sarf.NounLamAlefModifier;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.NounSunLamModifier;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: تطبيق المعالجة الخاصة على اسم المفعول
 * ابتداء بالاعلال واخيرا الهمزة
 * </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class PassiveParticipleModifier implements IUnaugmentedTrilateralNounModifier{
    private final Vocalizer vocalizer = new Vocalizer();
    private final Mahmouz mahmouz = new Mahmouz();

    private PassiveParticipleModifier() {
    }

    private static final PassiveParticipleModifier instance = new PassiveParticipleModifier();

    public static PassiveParticipleModifier getInstance() {
        return instance;
    }

    public ConjugationResult build(UnaugmentedTrilateralRoot root, KindOfVerb kov, List conjugations, String formula) {
        ConjugationResult conjResult = new ConjugationResult(kov, root, conjugations, formula);
        vocalizer.apply(conjResult);
        mahmouz.apply(conjResult);
        NounLamAlefModifier.getInstance().apply(conjResult);
        NounSunLamModifier.getInstance().apply(conjResult);
        return conjResult;
    }

}
