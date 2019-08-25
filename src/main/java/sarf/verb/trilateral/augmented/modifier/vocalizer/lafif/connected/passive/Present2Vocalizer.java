package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.passive;

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
public class Present2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Present2Vocalizer() {
        substitutions.add(new SuffixSubstitution("َيُ","َى"));// EX: (يُذْوَى، يُقَوَّى، يُداوَى، يُنْزَوَى، يُحْتَوَى، يُتَدَاوَى، يُتَقَوَّى، يُسْتَهْوَى)
        substitutions.add(new SuffixSubstitution("يَ","ى"));// EX: (لن يُذْوَى، يُقَوَّى، يُداوَى، يُنْزَوَى، يُحْتَوَى، يُتَدَاوَى، يُتَقَوَّى، يُسْتَهْوَى)
        substitutions.add(new SuffixSubstitution("يْ",""));// EX: (لم يُذْوَ، يُقَوَّ، يُداوَ، يُنْزَوَ، يُحْتَوَ، يُتَدَاوَ، يُتَقَوَّ، يُسْتَهْوَ)
        substitutions.add(new InfixSubstitution("يِي","يْ"));// EX: (أنتِ تُذْوَيْنَ، تُقَوَّيْنَ، تداوَيْنَ، تنْزَوَيْنَ، تحتوين، تتداوين، تتقوين، تستهوين)
        substitutions.add(new InfixSubstitution("يُو","وْ"));// EX: (أنتم تُذْوَوْنَ، تُقَوَّوْنَ، تداوَوْنَ، تنْزَوَوْنَ، تحتوَوْنَ، تتداوَوْنَ، تتقوَّوْن، تُسْتَهْوَوْنَ)
        substitutions.add(new InfixSubstitution("يُنّ","وُنّ"));// EX: (أنتم تُذْوَوُنَّ، تُقَوَّوُنَّ، تداوَوُنَّ، تنْزَوَوُنَّ، تحتوَوُنَّ، تتداوَوُنَّ، تتقوَّوُنَّ، تُسْتَهْوَوُنَّ)
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
