package sarf.gerund.modifier.trilateral.augmented.standard.vocalizer;

import java.util.*;

import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.noun.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

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
public class PreSeparatedLafifVocalizer extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public PreSeparatedLafifVocalizer() {
        substitutions.add(new InfixSubstitution("تِوْ","تِي"));// EX: (استيفاء)
        substitutions.add(new InfixSubstitution("إِوْ", "إِي")); // EX: (إيصاء)
        substitutions.add(new InfixSubstitution("إِيْ", "إِي")); // EX: (إيداء)
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        return kov == KindOfVerb.Lafeef_Mafrooq  && (formulaNo == 1 || formulaNo == 9);
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
