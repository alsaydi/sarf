package sarf.noun.trilateral.augmented.modifier.activeparticiple.vocalizer;

import sarf.KindOfVerb;
import sarf.noun.TrilateralNounSubstitutionApplier;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.ConjugationResult;


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
public class Ajwaf1Vocalizer extends TrilateralNounSubstitutionApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public Ajwaf1Vocalizer() {
        substitutions.add(new InfixSubstitution("ْوِ", "ِي")); // EX: (مُقِيمٌ، مُسْتَدِيرٌ)
        substitutions.add(new InfixSubstitution("َوِ", "َا")); // EX: (مُنْقادٌ، مُقْتادٌ)
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        if (kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Faa) {
            switch (formulaNo) {
                case 4:
                case 5:
                case 9:
                    return true;
            }
            return formulaNo == 1;
        } else if (kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Laam) {
            switch (formulaNo) {
                case 1:
                case 5:
                case 9:
                    return true;
            }
            return formulaNo == 4;
        } else if (kov == KindOfVerb.Ajwaf_Wawi) {
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
