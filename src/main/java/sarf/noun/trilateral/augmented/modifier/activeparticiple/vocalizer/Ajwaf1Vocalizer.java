package sarf.noun.trilateral.augmented.modifier.activeparticiple.vocalizer;

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
public class Ajwaf1Vocalizer extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {
    private List<Substitution> substitutions = new ArrayList<>();

    public Ajwaf1Vocalizer() {
        substitutions.add(new InfixSubstitution("ْوِ", "ِي")); // EX: (مُقِيمٌ، مُسْتَدِيرٌ)
        substitutions.add(new InfixSubstitution("َوِ", "َا")); // EX: (مُنْقادٌ، مُقْتادٌ)
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        if (kov == 15) {
            switch (formulaNo) {
                case 4:
                case 5:
                case 9:
                    return true;
            }


            switch (formulaNo) {
                case 1:
                case 5:
                case 9:
                    return true;
            }


            switch (formulaNo) {
                case 1:
                case 4:
                case 5:
                case 9:
                    return true;
            }
        } else if (kov == 16) {
            switch (formulaNo) {
                case 1:
                case 5:
                case 9:
                    return true;
            }


            switch (formulaNo) {
                case 1:
                case 4:
                case 5:
                case 9:
                    return true;
            }
        } else if (kov == 17) {
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
