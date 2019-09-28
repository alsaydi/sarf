package sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.yaei.active;

import java.util.*;

import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
import sarf.ConjugationResult;
import sarf.verb.trilateral.augmented.modifier.*;

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
public class Past2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Past2Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("َيَC3ْ", "َC3ْ"));// EX: (انْهَلْتُ، اكتلتُ)
        substitutions.add(new ExpressionInfixSubstitution("َيَC3ّ", "َC3ّ"));// EX: (اختَتّ)
        substitutions.add(new ExpressionInfixSubstitution("َيَC3َ", "َاC3َ"));// EX: (انْهالَ، اكتال)
        substitutions.add(new ExpressionInfixSubstitution("َيَC3ُ", "َاC3ُ"));// EX: (انهالوا، اكتالوا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        return (kov == KindOfVerb.Ajwaf_Yaee  && formulaNo == 4) || ((kov == KindOfVerb.Ajwaf_Yaee || kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Faa) && formulaNo == 5);
    }
}
