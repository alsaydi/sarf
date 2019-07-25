package sarf.gerund.modifier.trilateral.augmented.standard.vocalizer;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;
import sarf.verb.trilateral.augmented.*;

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
public class MithalAjwaf1Vocalizer extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    private List<Substitution> substitutions = new LinkedList<>();

    public MithalAjwaf1Vocalizer() {
        substitutions.add(new InfixSubstitution("إِوْ","إِي"));// EX: (إيجابٌ)
        substitutions.add(new InfixSubstitution("تِوْ","تِي"));// EX: (استيراد)
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return (formulaNo == 1 || formulaNo == 9) && (kov == 9 || kov == 10 || kov == KindOfVerb.Mithal_Wawi);
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
