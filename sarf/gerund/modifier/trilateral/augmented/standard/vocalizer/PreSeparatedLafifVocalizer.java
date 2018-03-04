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
public class PreSeparatedLafifVocalizer extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public PreSeparatedLafifVocalizer() {
        substitutions.add(new InfixSubstitution("Êöæú","Êöí"));// EX: (ÇÓÊíİÇÁ)
        substitutions.add(new InfixSubstitution("Åöæú", "Åöí")); // EX: (ÅíÕÇÁ)
        substitutions.add(new InfixSubstitution("Åöíú", "Åöí")); // EX: (ÅíÏÇÁ)
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return kov == 30 && (formulaNo == 1 || formulaNo == 9);
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
