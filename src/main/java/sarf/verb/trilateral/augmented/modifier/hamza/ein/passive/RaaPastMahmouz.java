package sarf.verb.trilateral.augmented.modifier.hamza.ein.passive;

import java.util.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;
import sarf.verb.trilateral.augmented.ConjugationResult;
import sarf.verb.trilateral.*;

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
    private final List substitutions = new ArrayList();

    public RaaPastMahmouz() {
        substitutions.add(new InfixSubstitution("ْءِ", "ِ")); // EX: (أُرِيتُ، أُرِيَ)
        substitutions.add(new InfixSubstitution("ْءُ", "ُ")); // EX: (أُرُوا، )
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        TrilateralRoot root = conjugationResult.getRoot();
        return conjugationResult.getFormulaNo() == 1 && root.getC1() == 'ر' && root.getC2() == 'ء' && root.getC3() == 'ي';
    }
}
