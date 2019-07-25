package sarf.noun.trilateral.augmented.modifier.passiveparticiple.vocalizer;

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
public class Ajwaf2Vocalizer extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Ajwaf2Vocalizer() {
        substitutions.add(new InfixSubstitution("ْيَ","َا"));// EX: (مُبادٌ، مُستَقَالٌ)
        substitutions.add(new InfixSubstitution("َيَ","َا"));// EX: (مُنْهالٌ، مُكْتالٌ)
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

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
