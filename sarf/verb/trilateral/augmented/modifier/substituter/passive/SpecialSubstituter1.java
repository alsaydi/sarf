package sarf.verb.trilateral.augmented.modifier.substituter.passive;

import java.util.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.substituter.*;
import sarf.verb.trilateral.augmented.ConjugationResult;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

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
public class SpecialSubstituter1 extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private List substitutions = new LinkedList();

    public SpecialSubstituter1() {
        substitutions.add(new InfixSubstitution("æúÊ","Êø"));// EX: (ÇÊøõÕöáó ¡ ÇÊøõŞöíó¡ ÇÊøõÆöíó)
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        return conjugationResult.getRoot().getC1() == 'æ' && formulaNo == 5 && (kov == 9 || kov == 10 || kov == 11 || kov == 29 || kov == 30);
    }
}
