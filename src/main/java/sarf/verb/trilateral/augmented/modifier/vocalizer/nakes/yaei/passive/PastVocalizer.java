package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.yaei.passive;

import java.util.*;

import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.ConjugationResult;
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
public class PastVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public PastVocalizer() {
        substitutions.add(new InfixSubstitution("يْ", "ي")); // EX: (أنا أُهْدِيتُ، رُقِّيتُ، جُوريتُ، انثُنيت، اكتُفِيتُ، تُنُوسِيتُ، استُغْنِيتُ، اعْرُوُرِيتُ، اجؤُوِّيتُ)
        substitutions.add(new InfixSubstitution("ِيُ", "ُ")); // EX: (هم أُهْدُوا، جُورُوا، انثُنُوا، اكتُفُوا، تُنوسُوا، استُغْنُوا، اعْرُورُوا)
        substitutions.add(new InfixSubstitution("ِّيُ", "ُّ")); // EX: (هم رُقُّوا، تُرُقُّوا، اجؤُوُّوا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        if (kov == KindOfVerb.Naqis_Yaee_Mahmouz_Faa) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
            }


            switch (formulaNo) {
                case 4:
                case 11:
                    return true;
            }


            return formulaNo == 10;
        } else if (kov == KindOfVerb.Naqis_Yaee_Mahmouz_Ain) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 9:
                case 11:
                    return true;
            }


            return formulaNo == 10;
        } else if (kov == KindOfVerb.Naqis_Yaee) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return true;
            }
        }
        return false;
    }
}
