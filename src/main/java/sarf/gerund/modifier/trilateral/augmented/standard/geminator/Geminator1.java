package sarf.gerund.modifier.trilateral.augmented.standard.geminator;

import java.util.*;

import sarf.KindOfVerb;
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
public class Geminator1 extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new LinkedList<>();

    public Geminator1() {
        substitutions.add(new InfixSubstitution("ْتَاتَتَ", "ْتَاتَتَ"));// EX: (إحتاتتا)
        substitutions.add(new InfixSubstitution("ِتَاتَتَ", "ِتَاتَتَ"));// EX: (انبتاتتان)
        substitutions.add(new ExpressionInfixSubstitution("اC3َC3", "اC3ّ"));// EX: (مُحاجَّة)
        substitutions.add(new ExpressionInfixSubstitution("اC3ُC3", "اC3ّ"));// EX: (تصامٌّ)
    }

    public boolean isApplied(TriAugmentedConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        if (kov == KindOfVerb.Mudaaf) {
            switch (formulaNo) {
                case 1:
                case 3:
                case 4:
                case 5:
                case 7:
                case 9:
                    return true;
            }
            return false;
        } else if (kov == KindOfVerb.Mahmouz_Faa_Mudaaf) {
            switch (formulaNo) {
                case 3:
                case 5:
                case 7:
                case 9:
                    return true;
            }
            return false;
        } else if (kov == KindOfVerb.Mithal_Wawi_Mudaaf) {
            return formulaNo == 3 || formulaNo == 7;
        }
        return false;
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
