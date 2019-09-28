package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;
import sarf.substitution.SuffixSubstitution;
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
public class Imperative6Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Imperative6Vocalizer() {
        substitutions.add(new SuffixSubstitution("وْ", "")); // EX: (تَساوَ، تَسَوَّ)
        substitutions.add(new InfixSubstitution("وِي", "يْ")); // EX: (أنتِ تَساوَيْ، تَسَوَّيْ)
        substitutions.add(new InfixSubstitution("وَا", "يَا")); // EX: (أنتما تَساوَيا، تَسَوَّيا)
        substitutions.add(new InfixSubstitution("وُو", "وْ")); // EX: (أنتم تَساوَوْا، تَسَوَّوْا)
        substitutions.add(new InfixSubstitution("وْن", "يْن")); // EX: (أنتن تَساوَيْنَ، تَسَوَّيْنَ)
        substitutions.add(new InfixSubstitution("وَن", "يَن")); // EX: (أنتَ تَساوَيَنَّ، تَسَوَّيَنَّ)
        substitutions.add(new InfixSubstitution("وِن", "يِن")); // EX: (أنتِ تَساوَيِنَّ، تَسَوَّيِنَّ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();
        var root = triAugmentedConjugationResult.getRoot();
        return root.getC2() == root.getC3() && root.getC3() == 'و' &&  kov == KindOfVerb.Lafeef_Maqroon && (formulaNo == 7 || formulaNo == 8);
    }
}
