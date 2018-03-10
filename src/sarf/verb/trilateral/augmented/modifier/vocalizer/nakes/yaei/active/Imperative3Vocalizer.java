package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.yaei.active;

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
        substitutions.add(new SuffixSubstitution("يْ", "")); // EX: (رَقِّ، اجْأوِّ)
        substitutions.add(new InfixSubstitution("يِي", "ي")); // EX: (أنتِ رَقِّي، اجْأوِّي)
        substitutions.add(new InfixSubstitution("يِن", "ن")); // EX: (أنتِ رَقِّنَّ، اجْأوِّنَّ)
        substitutions.add(new InfixSubstitution("يْن", "ين")); // EX: (أنتن رَقِّينَ، اجْأوِّينَ)
        substitutions.add(new InfixSubstitution("ِّيُ", "ُّ")); // EX: (أنتم رَقُّوا، اجْأوُّوا)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return ((kov == 26 || kov == 24) && formulaNo == 2) || (kov == 25 && (formulaNo == 2 || formulaNo == 11));
    }
}
