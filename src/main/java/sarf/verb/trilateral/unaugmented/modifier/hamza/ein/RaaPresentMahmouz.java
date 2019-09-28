package sarf.verb.trilateral.unaugmented.modifier.hamza.ein;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.ConjugationResult;
import sarf.verb.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier;

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
public class RaaPresentMahmouz extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public RaaPresentMahmouz() {
        substitutions.add(new InfixSubstitution("ْءَ","َ"));// EX: (يَرَى)
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        var root = conjugationResult.getRoot();
        return root.getC1() == 'ر' && root.getC2() == 'ء' && root.getC3() == 'ي';
    }
}
