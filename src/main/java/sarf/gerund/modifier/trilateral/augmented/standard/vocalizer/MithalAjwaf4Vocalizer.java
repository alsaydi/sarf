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
public class MithalAjwaf4Vocalizer extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public MithalAjwaf4Vocalizer() {
        substitutions.add(new InfixSubstitution("ْوَا","َا"));// EX: (إجابة، استجابة)
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        return (formulaNo == 1 || formulaNo == 9) && (kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Wawi);
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
