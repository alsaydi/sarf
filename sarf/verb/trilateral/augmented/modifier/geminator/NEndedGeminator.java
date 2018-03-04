package sarf.verb.trilateral.augmented.modifier.geminator;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.*;
import sarf.verb.trilateral.augmented.modifier.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: «·–Ì Ì‰ ÂÌ »«·‰Ê‰    </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class NEndedGeminator extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public NEndedGeminator() {
        substitutions.add(new InfixSubstitution("‰˙‰","‰¯"));// EX: (‰Õ‰ ”Ûﬂ¯Û‰¯Û«° Â‰¯Û ”Ûﬂ¯Û‰¯Û)
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        if (conjugationResult.getRoot().getC3() != '‰') return false;
        switch (formulaNo) {
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
            switch (kov) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 11:
            case 14:
            case 15:
            case 17:
            case 18:
            case 20:
                return true;
            }
        }

        return false;
    }

    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        apply(conjResult.getFinalResult(), conjResult.getRoot());
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
