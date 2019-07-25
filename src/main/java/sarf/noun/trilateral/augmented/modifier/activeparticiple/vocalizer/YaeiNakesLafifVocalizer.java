package sarf.noun.trilateral.augmented.modifier.activeparticiple.vocalizer;

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
public class YaeiNakesLafifVocalizer extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {
    private List<Substitution> substitutions = new ArrayList<>();

    public YaeiNakesLafifVocalizer() {
        substitutions.add(new SuffixSubstitution("ِيُ", "ِي")); // EX: (هذا المُهْدِي، )
        substitutions.add(new SuffixSubstitution("ِيَ", "ِيَ")); // EX: (رأيتُ المُهْدِيَ، )
        substitutions.add(new SuffixSubstitution("ِيِ", "ِي")); // EX: (مررتُ على المُهْدِي ، )
        substitutions.add(new InfixSubstitution("ِيٌ", "ٍ")); // EX: (هذا مُهْدٍ)
        substitutions.add(new InfixSubstitution("ِيٍ", "ٍ")); // EX: (مررتُ على مُهْدٍ)
        substitutions.add(new InfixSubstitution("ِيُ", "ُ")); // EX: (مُهْدُونَ، )
        substitutions.add(new InfixSubstitution("ِيِ", "ِ")); // EX: (مُهْدِينَ، )
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC3() != 'ي')
            return false;

        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        if (kov == 24 || kov == KindOfVerb.Lafeef_Mafrooq) {
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


            switch (formulaNo) {
                case 1:
                case 2:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
            }


            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
            }


            switch (formulaNo) {
                case 5:
                case 7:
                case 9:
                    return true;
            }
        } else if (kov == 25) {
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


            switch (formulaNo) {
                case 1:
                case 2:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
            }


            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
            }


            switch (formulaNo) {
                case 5:
                case 7:
                case 9:
                    return true;
            }
        } else if (kov == 26) {
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


            switch (formulaNo) {
                case 1:
                case 2:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
            }


            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
            }


            switch (formulaNo) {
                case 5:
                case 7:
                case 9:
                    return true;
            }
        } else if (kov == 27) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
            }


            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
            }


            switch (formulaNo) {
                case 5:
                case 7:
                case 9:
                    return true;
            }
        } else if (kov == 28) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
            }


            switch (formulaNo) {
                case 5:
                case 7:
                case 9:
                    return true;
            }
        } else if (kov == 29) {
            switch (formulaNo) {
                case 5:
                case 7:
                case 9:
                    return true;
            }
        }
        return false;
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
