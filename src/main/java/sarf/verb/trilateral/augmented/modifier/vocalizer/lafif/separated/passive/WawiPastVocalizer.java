package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.separated.passive;

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
public class WawiPastVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public WawiPastVocalizer() {
        substitutions.add(new InfixSubstitution("ِيْ","ِي"));// EX: (أنا أُوصِيتُ، وُفِّيتُ، وُولِيتُ، اتُّقِيتُ، تُوُوريتُ، تُوُلِّيتُ، استُوفِيتُ)
        substitutions.add(new InfixSubstitution("ِيُ","ُ"));// EX: (هم أُوصُوا، وُولُوا، اتُّقُوا، تُوُورُوا، استُوفُوا)
        substitutions.add(new InfixSubstitution("ِّيُ","ُّ"));// EX: (هم وُفُّوا، تُوُلُّوا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC1() != 'و')
            return false;

        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        if (kov == KindOfVerb.Lafeef_Mafrooq_Mahmouz_Ain) {
            switch (formulaNo) {
                case 5:
                case 7:
                case 9:
                    return true;
            }


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
        } else if (kov == KindOfVerb.Lafeef_Mafrooq ) {
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
        }
        return false;
    }
}
