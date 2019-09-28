package sarf.noun.trilateral.augmented.modifier.activeparticiple.vocalizer;

import java.util.*;

import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.noun.*;
import sarf.verb.trilateral.Substitution.*;
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
public class Mithal1Vocalizer extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Mithal1Vocalizer() {
        substitutions.add(new InfixSubstitution("ُوْ","ُو"));// EX: (مُوجِبٌ، )
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        return formulaNo == 1 && (kov == KindOfVerb.Mithal_Wawi_Mahmouz_Ain || kov == KindOfVerb.Mithal_Wawi_Mahmouz_Laam || kov == KindOfVerb.Mithal_Wawi);
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
