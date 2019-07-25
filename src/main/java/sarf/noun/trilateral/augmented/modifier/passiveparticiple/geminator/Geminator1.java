package sarf.noun.trilateral.augmented.modifier.passiveparticiple.geminator;

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
    private List<Substitution> substitutions = new ArrayList<>();

    public Geminator1() {
        substitutions.add(new ExpressionInfixSubstitution("ْC3َC3","َC3ّ"));// EX: (مُحَبٌّ، مُسْتَحَبٌّ)
        substitutions.add(new ExpressionInfixSubstitution("C3َC3","C3ّ"));// EX: (مُحاجٌّ، مُنْقَضٌّ، مُشْتَدٌّ، مُتَصامٌّ)
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        if (kov == 1 || kov == KindOfVerb.Ajwaf_Wawi || kov == KindOfVerb.Ajwaf_Yaee) {
            return formulaNo == 6 || formulaNo == 12;
        } else if (kov == 6) {
            return formulaNo == 6;
        } else if (kov == 11) {
            return formulaNo == 12;
        } else if (kov == 2) {
            switch (formulaNo) {
                case 1:
                case 3:
                case 4:
                case 5:
                case 7:
                case 9:
                    return true;
            }


            switch (formulaNo) {
                case 3:
                case 5:
                case 7:
                case 9:
                    return true;
            }


            return formulaNo == 3 || formulaNo == 7;
        } else if (kov == 3) {
            switch (formulaNo) {
                case 3:
                case 5:
                case 7:
                case 9:
                    return true;
            }


            return formulaNo == 3 || formulaNo == 7;
        } else if (kov == 8) {
            return formulaNo == 3 || formulaNo == 7;
        }
        return false;
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
