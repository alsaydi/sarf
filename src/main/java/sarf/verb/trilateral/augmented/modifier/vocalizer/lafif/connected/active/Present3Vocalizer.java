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
public class Present3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Present3Vocalizer() {
        substitutions.add(new SuffixSubstitution("يُ", "ا")); // EX: (يَتَحَايَا، يَتَحَيَّا)
        substitutions.add(new SuffixSubstitution("َيَ","َا"));// EX: (لن يَتَحَايَا، لن يتَحَيَّا)
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (لم يَتَحَايَ، لم يَتَحَيَّ)
        substitutions.add(new InfixSubstitution("يِي", "يْ")); // EX: (أنتِ تَتَحَايَيْنَ، تَتَحَيَّيْنَ)
        substitutions.add(new InfixSubstitution("يُو", "وْ")); // EX: (أنتم تَتَحايَوْنَ، تَتَحَيَّوْنَ)
        substitutions.add(new InfixSubstitution("يُن", "وُن")); // EX: (أنتم تَتَحايَوُنَّ، تَتَحَيَّوُنَّ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();
        var root = triAugmentedConjugationResult.getRoot();
        return root.getC2() == root.getC3() && root.getC3() == 'ي' && kov == KindOfVerb.Lafeef_Maqroon && (formulaNo == 7 || formulaNo == 8);
    }
}
