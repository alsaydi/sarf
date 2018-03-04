package sarf.gerund.modifier.trilateral.augmented.standard.vocalizer;

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
public class MithalAjwaf2Vocalizer extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public MithalAjwaf2Vocalizer() {
        substitutions.add(new InfixSubstitution("≈ˆÌ˙","≈ˆÌ"));// EX: (≈Ìﬁ«Ÿ)
        substitutions.add(new InfixSubstitution(" ˆÌ˙"," ˆÌ"));// EX: («” Ìﬁ«Ÿ)
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return (formulaNo == 1 || formulaNo == 9) && (kov == 13 || kov == 14);
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
