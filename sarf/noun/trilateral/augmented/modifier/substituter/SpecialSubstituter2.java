package sarf.noun.trilateral.augmented.modifier.substituter;

import java.util.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.substituter.*;
import sarf.verb.trilateral.augmented.ConjugationResult;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;
import sarf.noun.TrilateralNounSubstitutionApplier;

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
public class SpecialSubstituter2 extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {
    private List substitutions = new LinkedList();

    public SpecialSubstituter2() {
        substitutions.add(new InfixSubstitution("íúÊ","Êø"));// EX: (ÇÊøöÓÇÑ¡)
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        return conjugationResult.getRoot().getC1() == 'í' && formulaNo == 5 && (kov == 13 || kov == 14);
    }
}
