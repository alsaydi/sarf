package sarf.verb.trilateral.augmented.modifier.geminator;

import sarf.verb.trilateral.augmented.ConjugationResult;
import sarf.verb.trilateral.augmented.*;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;
import sarf.*;
import java.util.*;
import sarf.verb.trilateral.Substitution.InfixSubstitution;
import sarf.verb.trilateral.Substitution.SubstitutionsApplier;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: «·–Ì Ì‰ ÂÌ »«· «¡  </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class TStartedGeminator extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public TStartedGeminator() {
        substitutions.add(new InfixSubstitution(" ˙ "," ¯"));// EX: (« ¯Û»Û⁄Û)
    }

    public List getSubstitutions() {
        return substitutions;
    }


    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        if (conjugationResult.getRoot().getC1() == ' ' && (kov == 1 || kov == 6) && (formulaNo == 5))
            return true;

        return false;
    }

    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        apply(conjResult.getFinalResult(), conjResult.getRoot());
    }
}
