package sarf.gerund.modifier.trilateral.augmented.standard.geminator;

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
        substitutions.add(new InfixSubstitution("˙ Û« Û Û","˙ Û« Û Û"));// EX: (≈Õ «  «)
        substitutions.add(new InfixSubstitution("ˆ Û« Û Û","ˆ Û« Û Û"));// EX: («‰» «  «‰)
        substitutions.add(new ExpressionInfixSubstitution("«C3ÛC3","«C3¯"));// EX: („ıÕ«Ã¯Û…)
        substitutions.add(new ExpressionInfixSubstitution("«C3ıC3","«C3¯"));// EX: ( ’«„¯Ò)
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        switch (kov) {
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
