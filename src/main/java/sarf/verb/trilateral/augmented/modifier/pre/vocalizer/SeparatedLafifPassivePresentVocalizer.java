package sarf.verb.trilateral.augmented.modifier.pre.vocalizer;

import java.util.*;

import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.*;
import sarf.verb.trilateral.augmented.ConjugationResult;

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
public class SeparatedLafifPassivePresentVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private List<Substitution> substitutions = new ArrayList<>();

    public SeparatedLafifPassivePresentVocalizer() {
        substitutions.add(new InfixSubstitution("ُوْ", "ُو"));// EX: (يُوصَى)
        substitutions.add(new InfixSubstitution("ُيْ", "ُو"));// EX: (يُودَى)ن
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        if (kov == KindOfVerb.Lafeef_Mafrooq_Mahmouz_Ain) {
            switch (formulaNo) {
                case 5:
                case 9:
                    return true;
            }


            switch (formulaNo) {
                case 1:
                case 3:
                case 5:
                case 9:
                    return true;
            }
        } else if (kov == KindOfVerb.Lafeef_Mafrooq ) {
            switch (formulaNo) {
                case 1:
                case 3:
                case 5:
                case 9:
                    return true;
            }
        }
        return false;
    }
}
