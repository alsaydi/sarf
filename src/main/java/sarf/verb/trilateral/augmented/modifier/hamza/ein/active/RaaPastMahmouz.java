package sarf.verb.trilateral.augmented.modifier.hamza.ein.active;

import java.util.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.ConjugationResult;
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
public class RaaPastMahmouz extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public RaaPastMahmouz() {
        substitutions.add(new InfixSubstitution("ْءَ","َ"));// EX: (أرَيْتُ، أرَيْنا، )
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        var root = triAugmentedConjugationResult.getRoot();
        return triAugmentedConjugationResult.getFormulaNo() == 1 && root.getC1() == 'ر' && root.getC2() == 'ء' && root.getC3() == 'ي';
    }
}
