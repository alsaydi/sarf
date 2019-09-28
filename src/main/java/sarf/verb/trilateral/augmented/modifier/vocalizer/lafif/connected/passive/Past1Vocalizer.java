package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.passive;

import java.util.*;

import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;
import sarf.verb.trilateral.Substitution.*;
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
public class Past1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Past1Vocalizer() {
        substitutions.add(new InfixSubstitution("ِيُ", "ُ"));// EX: (أُحْيُوا، أُذْوُوا، دُووُوا، حُويُوا، انزُوُوا، احتُوُوا، تُدُووُوا، استُهْوُوا)
        substitutions.add(new InfixSubstitution("ِّيُ", "ُّ"));// EX: (حُيُّوا، قُوُّوا، تُقُوُّوا، تُحُيُّوا)
        substitutions.add(new InfixSubstitution("يْ", "ي"));// EX: (أُحْيِيتُ، حُيِّيتُ قُوِّيتُ دُوِيتُ، انزويت، احتويتُ، تُحُيِّيتُ تدويت، استُحْيِيتُ)
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();
        var root = triAugmentedConjugationResult.getRoot();
        if ((root.getC2() == 'و' || root.getC2() == 'ي') && root.getC3() == 'ي') {
            if (kov == KindOfVerb.Lafeef_Maqroon_Mahmouz_Faa) {
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
                    case 3:
                    case 4:
                        return true;
                }
            } else if (kov == KindOfVerb.Lafeef_Maqroon) {
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
            }
        }
        return false;
    }
}
