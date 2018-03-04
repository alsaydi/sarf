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
public class Geminator0 extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Geminator0() {
        substitutions.add(new InfixSubstitution("úíöííó","öíøó"));// EX: (ÊÍíøóÉ)
    }

    public boolean isApplied(ConjugationResult conjugationResult) {

        return conjugationResult.getFormulaNo() == 2 && conjugationResult.getRoot().getC2() == 'í' && conjugationResult.getRoot().getC3() == 'í';
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
