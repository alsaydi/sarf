package sarf.verb.trilateral.augmented.modifier.geminator;

import java.util.*;

import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.*;
import sarf.verb.trilateral.augmented.modifier.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: الذي يبدأ بالنون    </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class NStartedGeminator extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public NStartedGeminator() {
        substitutions.add(new InfixSubstitution("نْن","نّ"));// EX: (انَّمَسَ)
    }

    public boolean isApplied(TriAugmentedConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        return (triAugmentedConjugationResult.getRoot().getC1() == 'ن') && kov == KindOfVerb.Salim && formulaNo == 4;
    }

    public void apply(String tense, boolean active, TriAugmentedConjugationResult conjResult) {
        apply(conjResult.getFinalResult(), conjResult.getRoot());
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
