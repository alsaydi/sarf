package sarf.noun.quadriliteral.modifier.passiveparticiple;

import com.google.inject.Inject;
import sarf.KindOfVerb;
import sarf.NounLamAlefModifier;
import sarf.NounSunLamModifier;
import sarf.noun.quadriliteral.augmented.AugmentedQuadrilateralNoun;
import sarf.verb.quadriliteral.ConjugationResult;
import sarf.verb.quadriliteral.QuadrilateralRoot;

import java.util.List;

public class PassiveParticipleModifier {
    private final Geminator geminator = new Geminator();
    private final Vocalizer vocalizer = new Vocalizer();
    private final InternalMahmouz internalMahmouz = new InternalMahmouz();
    private final EndedMahmouz endedMahmouz = new EndedMahmouz();
    private final NounLamAlefModifier nounLamAlefModifier;
    private final NounSunLamModifier nounSunLamModifier;

    @Inject
    public PassiveParticipleModifier(NounLamAlefModifier nounLamAlefModifier, NounSunLamModifier nounSunLamModifier) {
        this.nounLamAlefModifier = nounLamAlefModifier;
        this.nounSunLamModifier = nounSunLamModifier;
    }

    /**
     * اخراج قائمة الأفعال بعد التعديلات
     *
     * @param root         UnaugmentedTrilateralRoot
     * @param conjugations List
     * @param tense        String (From SystemConstans class the values are stored)  ماضي أو مضارع او أمر
     * @return ConjugationResult
     */
    public ConjugationResult build(QuadrilateralRoot root, int formulaNo, KindOfVerb kov, List<AugmentedQuadrilateralNoun> conjugations) {
        var conjResult = new ConjugationResult<>(formulaNo, kov, root, conjugations);
        if (geminator.isApplied(conjResult))
            geminator.apply(conjResult.getFinalResult(), conjResult.getRoot());
        if (vocalizer.isApplied(conjResult))
            vocalizer.apply(conjResult.getFinalResult(), conjResult.getRoot());
        if (internalMahmouz.isApplied(conjResult))
            internalMahmouz.apply(conjResult.getFinalResult(), conjResult.getRoot());
        if (endedMahmouz.isApplied(conjResult))
            endedMahmouz.apply(conjResult.getFinalResult(), conjResult.getRoot());

        nounLamAlefModifier.apply(conjResult);
        nounSunLamModifier.apply(conjResult);
        return conjResult;
    }
}
