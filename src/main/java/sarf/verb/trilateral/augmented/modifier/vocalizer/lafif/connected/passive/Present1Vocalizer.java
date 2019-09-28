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
public class Present1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Present1Vocalizer() {
        substitutions.add(new SuffixSubstitution("َيُ","َا"));// EX: (يُحْيَا، يحيَّا، يحايَا، يزديَا، يتحَايَا، يتحيَّا، يُستحيَا)
        substitutions.add(new SuffixSubstitution("َيَ","َا"));// EX: (لن يُحْيَا، يحيَّا، يحايَا، يزديَا، يتحَايَا، يتحيَّا، يُستحيَا)
        substitutions.add(new SuffixSubstitution("يْ",""));// EX: (لم يُحْيَ، يحيَّ، يحايَ، يزديَ، يتحَايَ، يتحيَّ، يُستحيَ)
        substitutions.add(new InfixSubstitution("يِي","يْ"));// EX: (أنتِ تُحْيَيْنَ، تُحَيَّيْنَ، تحايَيْنَ، تزديَيْنَ، تتحايَيْنَ، تتحيَّيْنَ، تستحيَيْنَ)
        substitutions.add(new InfixSubstitution("يُو","وْ"));// EX: (أنتم تُحْيَوْنَ، تُحَيَّوْنَ، تُحايَوْنَ، تزدَيَوْنَ، تتحايَوْنَ، تتحيَّوْنَ، تستحيَوْنَ)
        substitutions.add(new InfixSubstitution("يُن","وُن"));// EX: (أنتم تُحْيَوُنَّ، تُحَيَّوُنَّ، تحايَوُنَّ تزديَوُنَّ، تُتَحَايَوُنَّ، تُتَحَيَّوُنَّ، تستحيَوُنَّ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();
        var root = triAugmentedConjugationResult.getRoot();
        if (root.getC2() == root.getC3() && root.getC3() == 'ي' && kov == KindOfVerb.Lafeef_Maqroon) {
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
