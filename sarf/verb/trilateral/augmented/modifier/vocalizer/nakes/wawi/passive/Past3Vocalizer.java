package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.passive;

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
public class Past3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Past3Vocalizer() {
        substitutions.add(new InfixSubstitution("æú", "í")); // EX: (ÃäÇ ÇÑÚõæöíÊõ)
        substitutions.add(new InfixSubstitution("æøó", "æöíó")); // EX: (åæ ÇÑúÚõæöíó)
        substitutions.add(new InfixSubstitution("æøõ", "æõ")); // EX: (åã ÇÑúÚõæõæÇ)

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return kov == 23 && formulaNo == 6;
    }
}
