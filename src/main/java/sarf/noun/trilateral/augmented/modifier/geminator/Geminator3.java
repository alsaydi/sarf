package sarf.noun.trilateral.augmented.modifier.geminator;

import java.util.*;

import sarf.KindOfVerb;
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
    private final List<Substitution> substitutions = new ArrayList<>();

    public Geminator3() {
        substitutions.add(new InfixSubstitution("تْت","تّ"));// EX: (مُتَّبِعٌ، مُتَّئِمٌ)
    }

    public boolean isApplied(TriAugmentedConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        return triAugmentedConjugationResult.getRoot().getC1() == 'ت' && (kov == KindOfVerb.Salim || kov == KindOfVerb.Mahmouz_Ain) && formulaNo == 5;
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
