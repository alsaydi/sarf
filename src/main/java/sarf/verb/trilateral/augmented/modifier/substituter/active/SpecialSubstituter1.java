package sarf.verb.trilateral.augmented.modifier.substituter.active;

import java.util.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.substituter.*;
import sarf.verb.trilateral.augmented.ConjugationResult;
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
public class SpecialSubstituter1 extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private List substitutions = new LinkedList();

    public SpecialSubstituter1() {
        substitutions.add(new InfixSubstitution("وْتَ","تَّ"));// EX: (اتَّصَلَ، يَتَّصِلُ، اتَّصِلْ)
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        return conjugationResult.getRoot().getC1() == 'و' && formulaNo == 5 && (kov == 9 || kov == 10 || kov == KindOfVerb.Mithal_Wawi || kov == KindOfVerb.Lafeef_Mafrooq_Mahmouz_Ain || kov == KindOfVerb.Lafeef_Mafrooq );
    }
}
