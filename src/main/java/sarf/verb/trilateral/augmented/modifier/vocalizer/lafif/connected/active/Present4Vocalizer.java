package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.*;
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
public class Present4Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Present4Vocalizer() {
        substitutions.add(new SuffixSubstitution("ِيُ","ِي"));// EX: (يُذْوِي، يداوي، ينزوي، يحتوي، يستهوي)
        substitutions.add(new SuffixSubstitution("يْ",""));// EX: (لم يُذْوِ، لم يداوِ، لم يَنْزَوِ، لم يَحْتَوِ، لم يَسْتَهْوِ)
        substitutions.add(new InfixSubstitution("ِيِ","ِ"));// EX: (أنتِ تُذْوِينَ، تُداوِينَ، تنْزوين، تحتوين، تستهوين)
        substitutions.add(new InfixSubstitution("ِيُ","ُ"));// EX: (أنتم تُذْوُونَ، تُداوُونَ، تنْزوون، تحتوون، تستهوون)
        substitutions.add(new InfixSubstitution("ِيْ","ِي"));// EX: (أنتن تُذْوِينَ، تداوين، تنْزوين، تحتوين، تستهوين)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(TriAugmentedConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = triAugmentedConjugationResult.getRoot();
        if (root.getC2() == 'و' && root.getC3() == 'ي') {
            if (kov == KindOfVerb.Lafeef_Maqroon_Mahmouz_Faa) {
                switch (formulaNo) {
                    case 1:
                    case 5:
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
                    case 3:
                    case 4:
                    case 5:
                    case 9:
                        return true;
                }
            }
        }
        return false;
    }
}
