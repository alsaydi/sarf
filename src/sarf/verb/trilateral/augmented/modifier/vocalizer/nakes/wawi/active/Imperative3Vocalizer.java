package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.active;

import java.util.*;

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
public class Imperative3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative3Vocalizer() {
        substitutions.add(new SuffixSubstitution("وْ", "")); // EX: (سَمِّ)
        substitutions.add(new InfixSubstitution("ِّوُ", "ُّ")); // EX: (أنتم سَمُّوا)
        substitutions.add(new InfixSubstitution("وْن", "ين")); // EX: (أنتن سَمِّينَ)
        substitutions.add(new InfixSubstitution("وَ", "يَ")); // EX: (أنتما سَمِّيَا)
        substitutions.add(new InfixSubstitution("وِ", "")); // EX: (أنتِ سَمِّي)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return (kov == 21 || kov == 23) && formulaNo == 2;
    }
}
