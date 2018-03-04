package sarf.verb.trilateral.augmented.modifier.pre.vocalizer;

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
public class SeparatedLafifActivePresentVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public SeparatedLafifActivePresentVocalizer() {
        substitutions.add(new InfixSubstitution("õæú", "õæ")); // EX: (íõæÕöí)
        substitutions.add(new InfixSubstitution("õíú", "õæ")); // EX: (íõæÏöí)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        if (kov == 30 && formulaNo == 1) {
            return true;
        }
        return false;
    }
}
