package sarf.noun.trilateral.augmented.modifier.activeparticiple.geminator;

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
public class Geminator1 extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Geminator1() {
        substitutions.add(new ExpressionInfixSubstitution("úC3öC3", "öC3ø")); // EX: (ãõÍöÈøñ¡ ãõÓúÊóÍöÈøñ)
        substitutions.add(new ExpressionInfixSubstitution("C3öC3", "C3ø")); // EX: (ãõÍÇÌøñ¡ ãõäúŞóÖøñ¡ ãõÔúÊóÏøñ¡ ãõÊóÕÇãøñ)
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        switch (kov) {
        case 1:
        case 17:
        case 20:
            return formulaNo == 6 || formulaNo == 12;

        case 6:
            return formulaNo == 6;

        case 11:
            return formulaNo == 12;

        case 2:
            switch (formulaNo) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 7:
            case 9:
                return true;
            }

        case 3:
            switch (formulaNo) {
            case 3:
            case 5:
            case 7:
            case 9:
                return true;
            }

        case 8:
            return formulaNo == 3 || formulaNo == 7;
        }
        return false;
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
