package sarf.noun.trilateral.augmented.modifier.activeparticiple.hamza;

import sarf.noun.TrilateralNounSubstitutionApplier;
import sarf.verb.trilateral.Substitution.InfixSubstitution;
import sarf.verb.trilateral.Substitution.Substitution;
import sarf.verb.trilateral.augmented.ConjugationResult;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;

import java.util.ArrayList;
import java.util.List;

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
public class RaaEinMahmouz extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public RaaEinMahmouz() {
        substitutions.add(new InfixSubstitution("ْءٍ", "ٍ"));// EX: (مُرٍ، )
        substitutions.add(new InfixSubstitution("ْءِ", "ِ"));// EX: (مُرِيَة، )
        substitutions.add(new InfixSubstitution("ْءُ", "ُ"));// EX: (مُرُونَ، )
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        var root = triAugmentedConjugationResult.getRoot();
        return root.getC1() == 'ر' && root.getC2() == 'ء' && root.getC3() == 'ي' && triAugmentedConjugationResult.getFormulaNo() == 1;
    }
}
