package sarf.gerund.modifier.trilateral.augmented.standard.geminator;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;
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
public class Geminator3 extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Geminator3() {
        substitutions.add(new InfixSubstitution("ÊúÊ","Êø"));// EX: (ÇÊøöÈÇÚñ¡ ÇÊøöÂã)
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return conjugationResult.getRoot().getC1() == 'Ê' && (kov == 1 || kov == 6) && formulaNo == 5;
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
