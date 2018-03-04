package sarf.noun.trilateral.augmented.modifier.passiveparticiple.vocalizer;

import java.util.*;

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

    private List substitutions = new LinkedList();

    public Ajwaf1Vocalizer() {
        substitutions.add(new InfixSubstitution("˙ÊÛ","Û«"));// EX: („ıﬁ«„Ò° „ı”˙ Ûœ«—Ò)
        substitutions.add(new InfixSubstitution("ÛÊÛ","Û«"));// EX: („ı‰˙ﬁ«œÒ° „ıﬁ˙ «œÒ)
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        switch (kov) {
        case 15:
            switch (formulaNo) {
            case 4:
            case 5:
            case 9:
                return true;
            }

        case 16:
            switch (formulaNo) {
            case 1:
            case 5:
            case 9:
                return true;
            }

        case 17:
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

    public List getSubstitutions() {
        return substitutions;
    }
}
