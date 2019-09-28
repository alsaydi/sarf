package sarf.gerund.modifier.trilateral.unaugmented.standard;

import com.google.inject.Inject;
import sarf.KindOfVerb;
import sarf.NounLamAlefModifier;
import sarf.NounSunLamModifier;
import sarf.noun.trilateral.unaugmented.modifier.AbstractLamMahmouz;
import sarf.noun.trilateral.unaugmented.modifier.IUnaugmentedTrilateralNounModifier;
import sarf.substitution.ExpressionInfixSubstitution;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.ConjugationResult;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class UnaugmentedTrilateralStandardGerundModifier extends AbstractLamMahmouz implements IUnaugmentedTrilateralNounModifier {
    private final List<Substitution> substitutions = new ArrayList<>();
    private final String appliedCharactersString = "بتثجحخسشصضطظعغفقكلمنهي";
    private final NounLamAlefModifier nounLamAlefModifier;
    private final NounSunLamModifier nounSunLamModifier;

    @Inject
    public UnaugmentedTrilateralStandardGerundModifier(NounLamAlefModifier nounLamAlefModifier, NounSunLamModifier nounSunLamModifier) {
        this.nounLamAlefModifier = nounLamAlefModifier;
        this.nounSunLamModifier = nounSunLamModifier;
        substitutions.add(new ExpressionInfixSubstitution("C2ْءًا", "C2ْئًا"));// EX: (خِطْئًا)
        substitutions.add(new InfixSubstitution("يءًا", "يئًا"));// EX: (مَجِيئًا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public ConjugationResult build(UnaugmentedTrilateralRoot root, KindOfVerb kov, List conjugations, String formula) {
        var conjResult = new ConjugationResult(kov, root, conjugations, formula);
        if (isApplied(conjResult))
            apply(conjResult.getFinalResult(), root);
        nounLamAlefModifier.apply(conjResult);
        nounSunLamModifier.apply(conjResult);

        return conjResult;
    }

    //فحص شرط المهموز حسب KOV
    //ومن ثم فحص اذا كان الحرف مناسبا
    public boolean isApplied(ConjugationResult conjugationResult) {
        char c2 = conjugationResult.getRoot().getC2();
        return super.isApplied(conjugationResult) && appliedCharactersString.indexOf(c2) != -1;
    }
}
