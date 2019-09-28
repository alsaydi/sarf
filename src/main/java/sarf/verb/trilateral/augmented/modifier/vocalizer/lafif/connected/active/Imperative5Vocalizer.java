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
public class Imperative5Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Imperative5Vocalizer() {
        substitutions.add(new SuffixSubstitution("وْ", "")); // EX: (سَوِّ، احْوَوِّ)
        substitutions.add(new InfixSubstitution("ِّوِ", "ِّ")); // EX: (أنتِ سَوِّي، احْوَوِّي)
        substitutions.add(new InfixSubstitution("ِّوَ", "ِّيَ")); // EX: (أنتما سَوِّيا، احْوَوِّيا)
        substitutions.add(new InfixSubstitution("ِّوُ", "ُّ")); // EX: (أنتم سَوُّوا، احْوَوُّوا)
        substitutions.add(new InfixSubstitution("ِّوْ", "ِّي")); // EX: (أنتن سَوِّينَ، احْوَوِّينَ)
    }


    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();
        var root = triAugmentedConjugationResult.getRoot();
        return root.getC2() == root.getC3() && root.getC3() == 'و' &&  kov == KindOfVerb.Lafeef_Maqroon && (formulaNo == 2 || formulaNo == 11);

    }
}
