package sarf.noun.trilateral.augmented.modifier.activeparticiple.vocalizer;

import java.util.*;

import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.noun.*;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
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
public class Ajwaf2Vocalizer extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Ajwaf2Vocalizer() {
        substitutions.add(new InfixSubstitution("ْيِ","ِي"));// EX: (مُبِيدٌ، مُستَقِيلٌ)
        substitutions.add(new InfixSubstitution("َيِ","َا"));// EX: (مُنْهالٌ، مُكْتالٌ)
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        if (kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Faa) {
            switch (formulaNo) {
                case 1:
                case 5:
                case 9:
                    return true;
            }
            return formulaNo == 4;
        } else if (kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Laam) {
            switch (formulaNo) {
                case 1:
                case 9:
                    return true;
            }
            switch (formulaNo) {
                case 4:
                case 5:
                    return true;
            }
        } else if (kov == KindOfVerb.Ajwaf_Yaee) {
            switch (formulaNo) {
                case 1:
                case 4:
                case 5:
                case 9:
                    return true;
            }
        }
        return false;

    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
